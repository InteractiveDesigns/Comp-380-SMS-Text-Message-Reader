package comp380.Project.SMSTextReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SMSTextMessageReceiver extends BroadcastReceiver {

	
	@Override
	public void onReceive(Context context, Intent receivedIntent)
	{
		Intent intent;
		Bundle bundle;
		SMSTextMessageInfo smsTextMessage;
		
		intent = new Intent("comp380.Project.SMSTextReceiver.Show_Message");
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
		bundle = receivedIntent.getExtras();
		
		smsTextMessage = createTextMessage(bundle);
		
		intent.getExtras().putSerializable("SMS_Text_Message", smsTextMessage);
		
		context.startActivity(intent);
		
		abortBroadcast();
	}
	
	/**
	 * Creates an SMSTextMessageInfo object given the bundle of data that is sent along with the request
	 * 
	 * @param androidData: The bundle of data that contains the sms text message info 
	 * @return The SMS text message info read from the bundle of android data
	 */
	private SMSTextMessageInfo createTextMessage(Bundle androidData)
	{
		Object[] smsExtra = (Object[]) androidData.get( "pdus" ); // "pdus" is the key
		
		if (smsExtra.length > 0)
		{
			// get sms message
			SmsMessage sms = SmsMessage.createFromPdu((byte[])smsExtra[0]);
			
			// get content and number
			String body = sms.getMessageBody();
			String address = sms.getOriginatingAddress();
	
			return new SMSTextMessageInfo(address, body);
		}
		
		return null;
	}
}