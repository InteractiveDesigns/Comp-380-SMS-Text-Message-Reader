package comp380.Project.SMSTextReceiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ReadSMSTextMessageActivity extends Activity
{	
	

	/**
	 * The user interface for the Activity
	 */
	UserInterface m_UserInterface;
	SMSTextMessageInfo textMessage;
	private static SMSTextMessageInfo textPass;
	
	/**
     * Handles the onCreate event
	 * 
	 * @param savedInstanceState: The instance data to use for the request
	 */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		
		super.onCreate(savedInstanceState); 
		
		//Intent intent = getIntent(); // comment this part
		
		// get the Message and Address from the bundle
		SMSTextMessageInfo textMessage = getSMStextMessageInfo(savedInstanceState);
		textPass = textMessage;
		
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
	
	static public SMSTextMessageInfo getTextMessage()
	{
		return textPass;
	}
}