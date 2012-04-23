package comp380.Project.SMSTextReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SMSTextMessageReceiver extends BroadcastReceiver {

	/**
	 * The function that handles the onReceive event
	 * 
	 * @param context: The context in which the request is being handled
	 * @param receivedIntent: The intent that was sent to this receiver
	 */
	@Override
	public void onReceive(Context context, Intent receivedIntent)
	{
		Intent intent;
		Bundle bundle;
		SMSTextMessageInfo smsTextMessage;
		
		// get the data bundle and the SMS Text Message info from it
		bundle = receivedIntent.getExtras();
		smsTextMessage = createTextMessage(bundle);
		
		// create the intent object used to launch the read text message activity
		intent = new Intent("comp380.Project.SMSTextReceiver.Show_Message");
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.getExtras().putSerializable(Constants.SMS_TEXT_MESSAGE_KEY, smsTextMessage);
		
		// start the activity and abort the broadcast
		context.startActivity(intent);
		
		// make sure no other broadcast receivers handle the request
		abortBroadcast();
	}
	
	/**
	 * Creates an SMSTextMessageInfo object given the bundle of data that is sent along with the request
	 * 
	 * @param androidData: The bundle of data that contains the SMS text message info 
	 * @return The SMS text message info read from the bundle of android data
	 */
	private SMSTextMessageInfo createTextMessage(Bundle androidData)
	{
		Object[] smsExtra = (Object[]) androidData.get( "pdus" ); // "pdus" is the key
		
		if (smsExtra.length > 0)
		{
			// get SMS Text Message
			SmsMessage sms = SmsMessage.createFromPdu((byte[])smsExtra[0]);
			
			// get content and number
			String body = sms.getMessageBody();
			String address = sms.getOriginatingAddress();
	
			return new SMSTextMessageInfo(address, body);
		}
		
		return null;
	}
}