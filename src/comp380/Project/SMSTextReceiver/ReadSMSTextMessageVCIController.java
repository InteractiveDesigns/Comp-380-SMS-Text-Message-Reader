package comp380.Project.SMSTextReceiver;

public class ReadSMSTextMessageVCIController extends UIController
{
	
	/**
	 * Creates a new instance of ReadSMSTextMessageVCIController given the parent user interface object
	 * 
	 * @param userInterface The parent interface for this controller
	 */
	public ReadSMSTextMessageVCIController(UserInterface userInterface)
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
		// TODO: present the read/ignore menu
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
				// TODO: exit
			case PresentTextMessage:
				// TODO: Read SMS text message aloud
			case ReplayTextMessage:
				// TODO: Replay message
		}
	}
}

