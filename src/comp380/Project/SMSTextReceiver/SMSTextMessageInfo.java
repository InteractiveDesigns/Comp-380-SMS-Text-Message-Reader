package comp380.Project.SMSTextReceiver;

import java.io.Serializable;

public class SMSTextMessageInfo implements Serializable
{
	/**
	 * The serial version UID used to identify this class
	 * when serializing objects of this type
	 */
	private static final long serialVersionUID = 1L;

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
	 * Creates a new instance of SMSTextMessageInfo
	 * 
	 * @param phoneNumber: The phone number of the text message
	 * @param textualMessage: The textual message sent
	 */
	public SMSTextMessageInfo(String phoneNumber, String textualMessage)
	{
		m_PhoneNumber = phoneNumber;
		m_Message = textualMessage;
	}

}
