package comp380.Project.SMSTextReceiver;

public enum UserCommand
{
	IgnoreTextMessage(0),
	ReadTextMessage(1),
	ReplayTextMessage(2);
	
	// The id of the user command
	private final int m_ID;
	
	/**
	 * Creates a new instance of UserCommand
	 * 
	 * @param id: The id of the user command
	 */
	UserCommand(int id)
	{
		m_ID = id;
	}
	
	/**
	 * Returns the id of the user command
	 * 
	 * @return The id of the user command
	 */
	public int getID()
	{
		return m_ID;
	}
}
