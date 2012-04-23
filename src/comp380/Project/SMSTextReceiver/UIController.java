package comp380.Project.SMSTextReceiver;

public abstract class UIController implements UIUpdateRequestHandler
{
	public abstract void initializeUI();
	
	public abstract void showUI();
	
	public abstract void handleUpdateRequest(SystemCommand request);
	
	public abstract void closeUI();
}
