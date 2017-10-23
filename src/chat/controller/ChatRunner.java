package chat.controller;

import chat.view.PopupDisplay;

public class ChatRunner
{
	public static void main (String [] args)
	{
		PopupDisplay test = new PopupDisplay();
		ChatController app = new ChatController();
				app.start();
		test.displayText("hi");
		
	}
}
