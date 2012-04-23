package comp380.Project.SMSTextReceiver;

public class ReadSMSTextMessageUI extends UserInterface
{
	
	@Override
	protected UIController[] createUIControllers()
	{
		//UIController guiController = new UIController();
		UIController vciController = new ReadSMSTextMessageVCIController();
		
		return new UIController[] {vciController};
	}
	
	@Override
	protected UIUpdateRequestHandler[] createUpdateRequestHandlers()
	{
		return null;
	}
	
	public void exit(){
		
	}

	@Override
	public void userRequestReceived(UserCommand command)
	{
		return;
	}
}
