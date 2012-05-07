package comp380.Project.SMSTextReceiver;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;

public class ReadSMSTextMessageActivity extends Activity implements OnInitListener
{	
	/**
<<<<<<< .mine	 * The user interface for the Activity
	 */
	UserInterface m_UserInterface;
	
	/**
=======	 * The user interface for the Activity
	 */
	UserInterface m_UserInterface;
	SMSTextMessageInfo textMessage;
	private TextToSpeech mTts;
	private static final int REQUEST_CODE = 15850;	
	
	/**
>>>>>>> .theirs	 * Handles the onCreate event
	 * 
	 * @param savedInstanceState: The instance data to use for the request
	 */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		Intent intent = getIntent();
		
		// get the Message and Address from the bundle
		textMessage = getSMStextMessageInfo(intent.getExtras());
		
		// create the user interface to be used to show the SMS text message
		// 
		m_UserInterface = createUserInterface(textMessage);
		m_UserInterface.initialize();
		m_UserInterface.show();
	}
	
	/**
	 * Gets the SMS Text Message info from the bundle
	 * 
	 * @param data The bundle that contains the SMSTextMessage info
	 * @return The SMSTextMessageInfo that was sent to this activity
	 */
	private SMSTextMessageInfo getSMStextMessageInfo(Bundle data)
	{
		SMSTextMessageInfo info = (SMSTextMessageInfo)data.getSerializable(Constants.SMS_TEXT_MESSAGE_KEY);
		
		return info;
	}
	
	/**
	 * generates the user interface to be used for this activity
	 * 
	 * @return The user interface to be used for this activity
	 */
	private UserInterface createUserInterface(SMSTextMessageInfo textMessage)
	{
		return new ReadSMSTextMessageUI((Activity)this, textMessage);
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK)
        {
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                   
            if(matches.contains("read"))
            {
            	mTts = new TextToSpeech(this, this);
            }
            
            else if(matches.contains("ignore"))
            {
            	finish();
            }
        }
        
        super.onActivityResult(requestCode, resultCode, data);
    }
    
	public void onInit(int arg0) 
	{
		// TODO Auto-generated method stub
		mTts.speak(textMessage.getMessage(), TextToSpeech.QUEUE_FLUSH, null);
	}
}