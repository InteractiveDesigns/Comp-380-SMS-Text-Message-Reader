package comp380.Project.SMSTextReceiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class ReadSMSTextMessageActivity extends Activity
{	
	/**
	 * Handles the onCreate event
	 * 
	 * @param savedInstanceState: The instance data to use for the request
	 */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		Intent intent = getIntent();
		
		// get the Message and Address from the bundle
		SMSTextMessageInfo textMessage = getSMStextMessageInfo(intent.getExtras());
		
		// Set the content view
		setContentView(R.layout.text_view);
		
		// Set the text for the txtMessage control
		EditText txtMessage = (EditText)this.findViewById(R.id.txtMessage);
		txtMessage.setText(textMessage.getMessage());
		
		// Set the text for the txtPhoneNumber control
		EditText txtPhoneNumber = (EditText)this.findViewById(R.id.txtPhoneNumber);
		txtPhoneNumber.setText(textMessage.getPhoneNumber());
		
		createUserInterface();
	}
	
	/**
	 * Gets the SMS Text Message info form the bundle
	 * 
	 * @param data The bundle that contains the SMSTextMessage info
	 * @return The SMSTextMessageInfo that was sen to this activity
	 */
	private SMSTextMessageInfo getSMStextMessageInfo(Bundle data)
	{
		SMSTextMessageInfo info = (SMSTextMessageInfo)data.getSerializable(Constants.SMS_TEXT_MESSAGE_KEY);
		
		return info;
	}
	
	private UserInterface createUserInterface()
	{
		return new ReadSMSTextMessageUI();
	}
}