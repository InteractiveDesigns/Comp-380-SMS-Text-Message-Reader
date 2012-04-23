package comp380.Project.SMSTextReceiver;

import java.io.Serializable;

public class SMSTextMessageInfo implements Serializable
{

	/**
	 * The phone number that sent the text message
	 */
	private final String m_PhoneNumber;
	
	/**
	 * The textual message that was received 
	 */
	private final String m_Message;
	
	/**
	 * 
	 * @return The phone number
	 */
	public String getPhoneNumber()
	{
		return m_PhoneNumber;
		
	}
	
	public String getMessage()
	{
		return m_Message;
	}
	
	/**
	 * 
	 * 
	 * @param newAdress
	 * @param newMessage
	 */
	public  SMSTextMessageInfo(String newAdress, String newMessage)
	{
		
	}

}
