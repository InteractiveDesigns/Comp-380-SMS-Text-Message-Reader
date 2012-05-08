package comp380.Project.SMSTextReceiver;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.speech.tts.TextToSpeech.OnUtteranceCompletedListener;

public class ReadSMSTextMessageVCIController extends UIController implements OnInitListener, RecognitionListener, OnUtteranceCompletedListener
{
	private TextToSpeech mTts;
	private ArrayList<String> matches;
	private SpeechRecognizer m_SpeechRecognizer;
	private SMSTextMessageInfo textMessage;
	private HashMap<String, String> userSpeech = new HashMap<String, String>();
	
	/**
	 * Creates a new instance of ReadSMSTextMessageVCIController given the parent user interface object
	 * 
	 * @param userInterface The parent interface for this controller
	 */
	public ReadSMSTextMessageVCIController(UserInterface userInterface)
	{
		super(userInterface);
		
		m_SpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(m_UserInterface.getMainActivity());
		m_SpeechRecognizer.setRecognitionListener(this);
	}
	
	/**
	 * Initializes the UI controller
	 */
	@Override
	public void initializeUI()
	{
			
	}

	/**
	 * Shows the user interface controller
	 */
	@Override
	public void showUI()
	{
		mTts = new TextToSpeech(m_UserInterface.getMainActivity(), this);
	}

	/**
	 * Closes the UI controller
	 */
	@Override
	public void closeUI()
	{
		mTts.stop();
		mTts.shutdown();
		m_SpeechRecognizer.cancel();
		m_SpeechRecognizer.destroy();
	}

	/**
	 * Handles update request from the main user interface
	 */
	@Override
	public void handleUpdateRequest(SystemCommand request)
	{	
		switch(request)
		{
			case IgnoreTextMessage:
				closeUI();
				break;
			case PresentTextMessage:
				textMessage = ReadSMSTextMessageActivity.getTextMessage();
				mTts.speak(textMessage.getMessage(), TextToSpeech.QUEUE_FLUSH, null);
				userSpeech.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "blank");
				mTts.speak("Message is complete, replay or ignore?", TextToSpeech.QUEUE_ADD, userSpeech);
				break;
			case ReplayTextMessage:
				textMessage = ReadSMSTextMessageActivity.getTextMessage();
				mTts.speak(textMessage.getMessage(), TextToSpeech.QUEUE_FLUSH, null);
				userSpeech.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "blank");
				mTts.speak("Message is complete, replay or ignore?", TextToSpeech.QUEUE_ADD, userSpeech);
				break;
		}
	}
	
	public void onInit(int arg0) 
	{
		mTts.setOnUtteranceCompletedListener(this);
		userSpeech.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "blank");
		mTts.speak("New message has arrived, read or ignore?", TextToSpeech.QUEUE_FLUSH, userSpeech);
	}
	
    private void startVoiceRecognitionActivity()
    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, m_UserInterface.getMainActivity().getApplication().getClass().getName());   
        m_SpeechRecognizer.startListening(intent);      
    }

	public void onBeginningOfSpeech() 
	{
		System.out.println("Start");
	}

	public void onBufferReceived(byte[] arg0) 
	{

	}

	public void onEndOfSpeech() 
	{
	
	}

	public void onError(int arg0) 
	{
		userSpeech.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "blank");
		mTts.speak("Command not recognized, please repeat.", TextToSpeech.QUEUE_FLUSH, userSpeech);
	}

	public void onEvent(int arg0, Bundle arg1) 
	{
	
	}

	public void onPartialResults(Bundle arg0) 
	{
	
	}

	public void onReadyForSpeech(Bundle arg0) 
	{
	
	}

	public void onResults(Bundle results)
	{
		matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
		System.out.println(matches.get(0));
		
		if(matches.contains("read"))
		{
			m_UserInterface.userRequestReceived(UserCommand.ReadTextMessage);
		}
		
		else if(matches.contains("ignore"))
		{
			m_UserInterface.userRequestReceived(UserCommand.IgnoreTextMessage);
		}
		
		else if(matches.contains("replay"))
		{
			m_UserInterface.userRequestReceived(UserCommand.ReplayTextMessage);
		}
		
		else
		{
			userSpeech.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "blank");
			mTts.speak("Command not recognized, please repeat.", TextToSpeech.QUEUE_FLUSH, userSpeech);
		}
	}

	public void onRmsChanged(float arg0)
	{
		
	}
	
	public void onUtteranceCompleted(String uttID) 
	{
		m_UserInterface.getMainActivity().runOnUiThread(new Runnable() 
		{
			public void run() 
			{
				startVoiceRecognitionActivity();			
			}
		});
	}
}
