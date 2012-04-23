package comp380.Project.SMSTextReceiver;

public enum SystemCommand
{
	IgnoreTextMessage(0),
	PresentTextMessage(1),
	ReplayTextMessage(2);
	
	// The id of the system command
	private final int m_ID;
	
	/**
	 * Creates a new instance of SystemCommand
	 * 
	 * @param id: The id of the system command
	 */
	SystemCommand(int id)
	{
		m_ID = id;
	}
	
	/**
	 * Returns the id of the system command
	 * 
	 * @return The id of the command
	 */
	public int getID()
	{
		return m_ID;
	}
}
