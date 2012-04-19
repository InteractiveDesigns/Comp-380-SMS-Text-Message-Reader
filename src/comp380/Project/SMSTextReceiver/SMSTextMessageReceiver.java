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
		Intent intent = new Intent("comp380.Project.SMSTextReceiver.Show_Message");
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
		Bundle extras = receivedIntent.getExtras();
		
		Object[] smsExtra = (Object[]) extras.get( "pdus" ); // "pdus" is the key
		
		if (smsExtra.length > 0)
		{
			// get sms message
			SmsMessage sms = SmsMessage.createFromPdu((byte[])smsExtra[0]);
			
			// get content and number
			String body = sms.getMessageBody();
			String address = sms.getOriginatingAddress();
			
			intent.putExtra("SMS_Body", body);
			intent.putExtra("SMS_Address", address);
			
			try
			{
				context.startActivity(intent);
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		
		abortBroadcast();
	}

}