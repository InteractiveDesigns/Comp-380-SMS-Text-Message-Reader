package comp380.Project.SMSTextReceiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class ShowMessageActivity extends Activity
{
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		Intent intent = getIntent();
		
		// get the Message and Address from the bundle
		String smsBody = intent.getExtras().getString("SMS_Body");
		String address = intent.getExtras().getString("SMS_Address");
		
		// Set the content view
		setContentView(R.layout.text_view);
		
		// Set the text for the txtMessage control
		EditText txtMessage = (EditText)this.findViewById(R.id.txtMessage);
		txtMessage.setText(smsBody);
		
		// Set the text for the txtPhoneNumber control
		EditText txtPhoneNumber = (EditText)this.findViewById(R.id.txtPhoneNumber);
		txtPhoneNumber.setText(address);
	}
}