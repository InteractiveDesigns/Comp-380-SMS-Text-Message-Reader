package comp380.Project.SMSTextReceiver;

import java.util.ArrayList;

import android.app.Activity;

public abstract class UserInterface
{
	// the UI controllers for this user interface
	protected UIController[] uiControllers;
	
	// The update request handlers for the user interface
	protected UIUpdateRequestHandler[] updateHandlers;
	
	// The main activity that is actually running
	protected Activity m_MainActivty;
	
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
		ArrayList<UIUpdateRequestHandler> updateRequestHandlers;
		UIUpdateRequestHandler[] handlers;
		
		updateRequestHandlers = new ArrayList<UIUpdateRequestHandler>();
		
		uiControllers = createUIControllers();
		handlers = createUpdateRequestHandlers();
		
		for (UIController controller : uiControllers)
		{
			updateRequestHandlers.add(controller);
			controller.initializeUI();
		}
		
		for (UIUpdateRequestHandler handler : handlers)
		{
			updateRequestHandlers.add(handler);
		}
		
		updateHandlers = new UIUpdateRequestHandler[updateRequestHandlers.size()];
		
		updateRequestHandlers.toArray(updateHandlers);
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
	}
	
	/**
	 * Sends an update request to each of its handlers
	 */
	public void sendUpdateRequest(SystemCommand command)
	{
		for (UIUpdateRequestHandler handler : updateHandlers)
		{
			handler.handleUpdateRequest(command);
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
	 * Creates the update request handlers for the user interface
	 * 
	 * @return the update request handlers for the user interface
	 */
	protected abstract UIUpdateRequestHandler[] createUpdateRequestHandlers();
	
	/**
	 * Handles the given user command
	 * 
	 * @param command The command to be handled
	 */
	public abstract void userRequestReceived(UserCommand command);
}
