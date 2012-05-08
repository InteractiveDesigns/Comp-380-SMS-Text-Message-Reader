package comp380.Project.SMSTextReceiver;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
				showTextMessageView();
				break;
			case ReplayTextMessage:
				
		}
	}
	
	private void showTextMessageView()
	{
		m_UserInterface.getMainActivity().setContentView(R.layout.present_text_message);
		
		TextView txtPhoneNumber = (TextView)m_UserInterface.getMainActivity().findViewById(R.id.txtPhoneNumber);
		txtPhoneNumber.setText("(815) 555-1121");
		
		TextView txtMessage = (TextView)m_UserInterface.getMainActivity().findViewById(R.id.txtMessage);
		txtMessage.setText("hello");
		
		Button btnExit = (Button)m_UserInterface.getMainActivity().findViewById(R.id.exitNow);
		btnExit.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				m_UserInterface.userRequestReceived(UserCommand.IgnoreTextMessage);
			}
		});
		
		Button btnReplay = (Button)m_UserInterface.getMainActivity().findViewById(R.id.replay);
		btnReplay.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				m_UserInterface.userRequestReceived(UserCommand.ReplayTextMessage);
			}
		});
	}
}
