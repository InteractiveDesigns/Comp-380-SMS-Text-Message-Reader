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
	
	/**
	 * Initializes the UI controller
	 */
	public abstract void initializeUI();
	
	/**
	 * Shows the user interface controller
	 */
	public abstract void showUI();
	
	/**
	 * Handles update request from the main user interface
	 */
	public abstract void handleUpdateRequest(SystemCommand request);
	
	/**
	 * Closes the UI controller
	 */
	public abstract void closeUI();
}