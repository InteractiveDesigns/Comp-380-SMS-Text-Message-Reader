package comp380.Project.SMSTextReceiver;

import java.util.ArrayList;

public abstract class UserInterface
{
	
	private UIController[] uiControllers;
	
	private UIUpdateRequestHandler[] updateHandlers;
	
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
		}
		
		for (UIUpdateRequestHandler handler : handlers)
		{
			updateRequestHandlers.add(handler);
		}
		
		updateHandlers = new UIUpdateRequestHandler[updateRequestHandlers.size()];
		
		updateRequestHandlers.toArray(updateHandlers);
	}
	
	public void show()
	{
		
	}
	
	public void close()
	{
		
	}
	
	public void sendUpdateRequest(SystemCommand command)
	{
		
	}
	
	protected abstract UIController[] createUIControllers();
	
	protected abstract UIUpdateRequestHandler[] createUpdateRequestHandlers();
	
	public abstract void userRequestReceived(UserCommand command);
}
