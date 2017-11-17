package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	private ChatbotController appController;
	private ChatPanel appPanel;
	
	/**
	 * Constructor, initializes the data members
	 * @param appController
	 */
	
	public ChatFrame(ChatbotController appController)
	{
		super();
		this.appController = appController;
		appPanel = new ChatPanel(appController);
		setupFrame();
	}
	
	/**
	 * Sets up the frame with established parameters
	 */
	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("Chatting with square");
		this.setResizable(false);
		this.setSize(600, 600);
		this.setVisible(true);
	}
	
	/**
	 * Gets app controller and returns it
	 */
	
	public ChatbotController getAppController()
	{
		return appController;
	}
}
