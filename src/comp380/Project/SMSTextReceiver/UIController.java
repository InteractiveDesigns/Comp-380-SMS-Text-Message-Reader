package comp380.Project.SMSTextReceiver;

import android.app.Activity;

public abstract class UIController implements UIUpdateRequestHandler
{
	// The main activity that is currently running
	protected Activity m_MainActivity;
	
	/**
	 * Creates a new instance of UIController given a main activity running
	 * 
	 * @param mainActivity The main activity running
	 */
	protected UIController(Activity mainActivity)
	{
		m_MainActivity = mainActivity;
	}
	
	public abstract void initializeUI();
	
	public abstract void showUI();
	
	public abstract void handleUpdateRequest(SystemCommand request);
	
	public abstract void closeUI();
}