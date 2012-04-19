package comp380.Project.SMSTextReceiver;

import java.io.Serializable;

public class SMSTextMessageInfo implements Serializable
{

	public String m_Adress;
	public String m_Message;
	
	public String getAdress()
	{
		return m_Adress;
		
	}
	
	public String getMessage()
	{
		return m_Message;
	}
	
	
	public  SMSTextMessageInfo(String newAdress, String newMessage)
	{
		
	}

}
