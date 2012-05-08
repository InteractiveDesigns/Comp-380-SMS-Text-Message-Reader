package comp380.Project.SMSTextReceiver;

import android.app.Activity;

public class ReadSMSTextMessageUI extends UserInterface
{
	
	// The text message info to be shown to the user
	private SMSTextMessageInfo m_TextMessage;
	
	/**
	 * Creates a new instance of ReadSMSTextMessageUI
	 * 
	 * @param activity The main activity that is running
	 */
	public ReadSMSTextMessageUI(Activity activity, SMSTextMessageInfo textMessage)
	{
		super(activity);
		m_TextMessage = textMessage;
	}
	
	/**
	 * Returns the SMSTextMessageInfo the UserInterface is using
	 * 
	 * @return the SMSTextMessageInfo the UserInterface is using
	 */
	public SMSTextMessageInfo getTextMessage()
	{
		return m_TextMessage;
	}
	
	/**
	 * Creates the UI controllers for the user interface
	 * 
	 * @return The UI controllers for this particular user interface
	 */
	@Override
	protected UIController[] createUIControllers()
	{
		UIController guiController = new ReadSMSTextMessageGUIController(this);
		UIController vciController = new ReadSMSTextMessageVCIController(this);
		
		return new UIController[] {guiController, vciController};
	}

	/**
	 * Handles the event that a user request is received
	 * 
	 * @param command: The command to be handled
	 */
	public void userRequestReceived(UserCommand command)
	{
		SystemCommand systemCommand = SystemCommand.IgnoreTextMessage;
		
		// create the system command from the user command
		switch (command)
		{
			case IgnoreTextMessage:
				close();
				break;
			case ReadTextMessage:
				systemCommand = SystemCommand.PresentTextMessage;
				break;
			case ReplayTextMessage:
				systemCommand = SystemCommand.ReplayTextMessage;
				break;
		}
		
		// signal each controller to handle the update request
		for (UIController controller : uiControllers)
		{
			controller.handleUpdateRequest(systemCommand);
		}
	}
}
