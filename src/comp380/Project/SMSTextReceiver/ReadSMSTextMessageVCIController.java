package comp380.Project.SMSTextReceiver;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;

import java.util.ArrayList;

public class ReadSMSTextMessageVCIController extends UIController implements OnInitListener, RecognitionListener
{
	private TextToSpeech mTts;
	private UserInterface ui;
	private ArrayList<String> matches;
	private SpeechRecognizer m_SpeechRecognizer;
	private SMSTextMessageInfo textMessage;
	
	/**
	 * Creates a new instance of ReadSMSTextMessageVCIController given the parent user interface object
	 * 
	 * @param userInterface The parent interface for this controller
	 */
	public ReadSMSTextMessageVCIController(UserInterface userInterface)
	{
		super(userInterface);
		ui = userInterface;
		
		m_SpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(ui.getMainActivity());
		m_SpeechRecognizer.setRecognitionListener(this);
	}
	
	/**
	 * Initializes the UI controller
	 */
	@Override
	public void initializeUI()
	{
		// TODO Auto-generated method stub		
	}

	/**
	 * Shows the user interface controller
	 */
	@Override
	public void showUI()
	{
		// TODO: present the read/ignore menu
		//mTts.setOnUtteranceCompletedListener(this);
		mTts = new TextToSpeech(ui.getMainActivity(), this);
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {public void run() {startVoiceRecognitionActivity();}}, 3500);
	}

	/**
	 * Closes the UI controller
	 */
	@Override
	public void closeUI()
	{
		// TODO Auto-generated method stub
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
				// TODO: exit
				ui.getMainActivity().finish();
			case PresentTextMessage:
				// TODO: Read SMS text message aloud
				textMessage = ReadSMSTextMessageActivity.getTextMessage();
				mTts.speak(textMessage.getMessage(), TextToSpeech.QUEUE_FLUSH, null);
			case ReplayTextMessage:
				// TODO: Replay message
				textMessage = ReadSMSTextMessageActivity.getTextMessage();
				mTts.speak(textMessage.getMessage(), TextToSpeech.QUEUE_FLUSH, null);
		}
	}
	
	public void onInit(int arg0) 
	{
		// TODO Auto-generated method stub
		//speech.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "end");
		mTts.speak("New message has arrived, read or ignore?", TextToSpeech.QUEUE_FLUSH, null);
	}
	
    private void startVoiceRecognitionActivity()
    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, ui.getMainActivity().getApplication().getClass().getName());
        m_SpeechRecognizer.startListening(intent);      
    }

	public void onBeginningOfSpeech() 
	{
		// TODO Auto-generated method stub
		System.out.println("Beginning of Speech");	
	}

	public void onBufferReceived(byte[] arg0) 
	{
		// TODO Auto-generated method stub
		System.out.println("Buffer");	
	}

	public void onEndOfSpeech() 
	{
		// TODO Auto-generated method stub
		System.out.println("onEndOfSpeech");	
	}

	public void onError(int arg0) 
	{
		// TODO Auto-generated method stub
		System.out.println("onError");
	}

	public void onEvent(int arg0, Bundle arg1) 
	{
		// TODO Auto-generated method stub
		System.out.println("onEvent");	
	}

	public void onPartialResults(Bundle arg0) 
	{
		// TODO Auto-generated method stub
		System.out.println("onPartialResults");	
	}

	public void onReadyForSpeech(Bundle arg0) 
	{
		// TODO Auto-generated method stub
		System.out.println("onReadyForSpeech");	
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
	}

	public void onRmsChanged(float arg0)
	{
		System.out.println("RMS Changed");
		// TODO Auto-generated method stub
	}
	
	public void onUtteranceCompleted(String uttID) 
	{
		// TODO Auto-generated method stub
		/*if(uttID == "end")
		{
			m_SpeechRecognizer.startListening(intent2);
		}
		*/
	}
}