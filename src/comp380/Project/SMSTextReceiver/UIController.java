package comp380.Project.SMSTextReceiver;

public abstract class UIController
{
	// The parent interface of the controller
	protected UserInterface m_UserInterface;
	
	/**
	 * Creates a new instance of UIController given a main activity running
	 * 
	 * @param mainActivity The main activity running
	 */
	protected UIController(UserInterface userInterface)
	{
		m_UserInterface = userInterface;
	}
	
	/**
	 * Handles the event that a user request has been received
	 * 
	 * @param command The user command received
	 */
	public void userCommandReceived(UserCommand command)
	{
		m_UserInterface.userRequestReceived(command);
	}
	
	public abstract void initializeUI();
	
	public abstract void showUI();
	
	public abstract void handleUpdateRequest(SystemCommand request);
	
	public abstract void closeUI();
}