package comp380.Project.SMSTextReceiver;

import android.app.Activity;

public abstract class UserInterface
{
	// the UI controllers for this user interface
	protected UIController[] uiControllers;
	
	// The main activity that is actually running
	private Activity m_MainActivty;
	
	/**
	 * Creates a new instance of UserInterface given the main activity
	 * 
	 * @param mainActivty The currently running activity
	 */
	protected UserInterface(Activity mainActivty)
	{
		m_MainActivty = mainActivty;
	}
	
	/**
	 * Initializes the user interface
	 */
	public void initialize()
	{	
		uiControllers = createUIControllers();
		
		for (UIController controller : uiControllers)
		{
			controller.initializeUI();
		}
	}
	
	/**
	 * Shows the user interface
	 */
	public void show()
	{
		for (UIController controller : uiControllers)
		{
			controller.showUI();
		}
	}
	
	/**
	 * Closes the user interface
	 */
	public void close()
	{
		for (UIController controller : uiControllers)
		{
			controller.closeUI();
		}
		
		m_MainActivty.finish();
	}
	
	/**
	 * Sends an update request to each of its handlers
	 */
	protected void sendUpdateRequest(SystemCommand command)
	{
		for (UIController controller : uiControllers)
		{
			controller.handleUpdateRequest(command);
		}
	}
	
	/**
	 * Returns the main activity
	 * 
	 * @return the main activity
	 */
	public Activity getMainActivity()
	{
		return m_MainActivty;
	}
	
	/**
	 * Creates a the UIControllers for the user interface
	 * 
	 * @return The UIControllers for the user interface
	 */
	protected abstract UIController[] createUIControllers();
	
	/**
	 * Handles the given user command
	 * 
	 * @param command The command to be handled
	 */
	public abstract void userRequestReceived(UserCommand command);
}