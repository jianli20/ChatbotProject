package chat.controller;

import chat.view.PopupDisplay;

/**
 * Runner method, runs the program
 * @author jli8189
 *
 */

public class ChatbotRunner
{
	public static void main (String [] args)
	{
		PopupDisplay test = new PopupDisplay();
		ChatbotController app = new ChatbotController();
		app.start();
	
		
	}
}
