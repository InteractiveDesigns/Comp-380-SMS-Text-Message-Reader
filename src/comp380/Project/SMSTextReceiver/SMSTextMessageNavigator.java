package comp380.Project.SMSTextReceiver;

public class SMSTextMessageNavigator
{
	// The current message pointer
	private int m_CurrentMessage = 0;
	
	// The repository of text messages
	private SMSTextMessageInfo[] m_TextMessages;
	
	/**
	 * Generates the repository of SMS Text Messages to navigate through
	 */
	public void initialize()
	{
		// TODO: get SMS Text Message Info
		m_TextMessages = new SMSTextMessageInfo[]{};
	}
	
	/**
	 * Navigates to the next message in the list
	 * 
	 * @return The next message if there are more messages, otherwise null if there's no more messages
	 */
	public SMSTextMessageInfo nextMessage()
	{
		if (m_CurrentMessage < (m_TextMessages.length - 1))
		{
			return m_TextMessages[++m_CurrentMessage];
		}
		
		return null;
	}
	
	/**
	 * Navigates to the previous message in the list
	 * 
	 * @return The previous message if there are messages before the current one, otherwise null
	 */
	public SMSTextMessageInfo previousMessage()
	{
		if (m_CurrentMessage > 0)
		{
			return m_TextMessages[--m_CurrentMessage];
		}
		
		return null;
	}
}
