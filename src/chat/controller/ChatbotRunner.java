package chat.controller;

import chat.view.PopupDisplay;

public class ChatbotRunner
{
	public static void main (String [] args)
	{
		PopupDisplay test = new PopupDisplay();
		ChatbotController app = new ChatbotController();
		app.start();
	
		
	}
}
