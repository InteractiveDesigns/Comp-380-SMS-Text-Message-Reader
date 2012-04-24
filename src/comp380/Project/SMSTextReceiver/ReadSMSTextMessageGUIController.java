package comp380.Project.SMSTextReceiver;

public class ReadSMSTextMessageGUIController extends UIController
{
	/**
	 * Creates a new instance of ReadSMSTextMessageGUIController given the parent user interface
	 * 
	 * @param userInterface the parent user interface for this class
	 */
	public ReadSMSTextMessageGUIController(UserInterface userInterface)
	{
		super(userInterface);
	}
	
	/**
	 * Initializes the UI controller
	 */
	@Override
	public void initializeUI()
	{
		// TODO Auto-generated method stub
	}

	/**
	 * Shows the user interface controller
	 */
	@Override
	public void showUI()
	{
		// TODO: Load the view object into the activity
	}

	/**
	 * Closes the UI controller
	 */
	@Override
	public void closeUI()
	{
		// TODO Auto-generated method stub
	}

	/**
	 * Handles update request from the main user interface
	 */
	@Override
	public void handleUpdateRequest(SystemCommand request)
	{
		switch(request)
		{
			case IgnoreTextMessage:
				
			case PresentTextMessage:
				
			case ReplayTextMessage:
				
		}
	}
}
