package comp380.Project.SMSTextReceiver;

import android.app.Activity;

public class SMSTextMessagevNavigatorUI extends UserInterface
{

	/**
	 * the text message navigator used to navigate messages
	 */
	private SMSTextMessageNavigator m_TextMessageNavigator;
	
	/**
	 * Creates a new instance of SMSTextMessagevNavigatorUI given a main activity
	 * 
	 * @param mainActivty The main activity this user interface is running on 
	 */
	protected SMSTextMessagevNavigatorUI(Activity mainActivty)
	{
		super(mainActivty);
		m_TextMessageNavigator = new SMSTextMessageNavigator();
	}

	@Override
	protected UIController[] createUIControllers()
	{
		
		return null;
	}

	@Override
	public void userRequestReceived(UserCommand command) {
		// TODO Auto-generated method stub
		
	}

}
