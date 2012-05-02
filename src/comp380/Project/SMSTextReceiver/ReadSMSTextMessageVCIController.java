package comp380.Project.SMSTextReceiver;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;

public class ReadSMSTextMessageVCIController extends UIController implements OnInitListener, RecognitionListener
{
	private TextToSpeech mTts;
	private UserInterface ui;
	private static final int REQUEST_CODE = 15850;		

	private SpeechRecognizer m_SpeechRecognizer;
	
	/**
	 * Creates a new instance of ReadSMSTextMessageVCIController given the parent user interface object
	 * 
	 * @param userInterface The parent interface for this controller
	 */
	public ReadSMSTextMessageVCIController(UserInterface userInterface)
	{
		super(userInterface);
		ui = userInterface;
		m_SpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(userInterface.getMainActivity().getBaseContext());
	}
	
	/**
	 * Initializes the UI controller
	 */
	@Override
	public void initializeUI()
	{
		// TODO Auto-generated method stub
		m_SpeechRecognizer.setRecognitionListener(this);
	}

	/**
	 * Shows the user interface controller
	 */
	@Override
	public void showUI()
	{
		// TODO: present the read/ignore menu
		mTts = new TextToSpeech(ui.getMainActivity(), this);
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {public void run() {startVoiceRecognitionActivity();}}, 3500);
		//startVoiceRecognitionActivity();
	}

	/**
	 * Closes the UI controller
	 */
	@Override
	public void closeUI()
	{
		// TODO Auto-generated method stub	
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
			case PresentTextMessage:
				// TODO: Read SMS text message aloud
			case ReplayTextMessage:
				// TODO: Replay message
		}
	}
	
	public void onInit(int arg0) 
	{
		// TODO Auto-generated method stub
		mTts.speak("New message has arrived, read or ignore?", TextToSpeech.QUEUE_FLUSH, null);
	}
	
    private void startVoiceRecognitionActivity()
    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak");
        ui.getMainActivity().startActivityForResult(intent, REQUEST_CODE);
    }

	public void onBeginningOfSpeech() {
		// TODO Auto-generated method stub
		
	}

	public void onBufferReceived(byte[] arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onEndOfSpeech() {
		// TODO Auto-generated method stub
		
	}

	public void onError(int arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onEvent(int arg0, Bundle arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onPartialResults(Bundle arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onReadyForSpeech(Bundle arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onResults(Bundle arg0)
	{
		arg0.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
		// TODO: match the word just read to ignore, read, or replay and create a user command based on what was matched and call userRequestReceived
		//m_UserInterface.userRequestReceived();
	}

	public void onRmsChanged(float arg0)
	{
		// TODO Auto-generated method stub
		
	}
}