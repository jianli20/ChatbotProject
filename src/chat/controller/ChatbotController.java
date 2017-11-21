package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;
import chat.view.ChatFrame;

/**
 * Manages the Chatbot application including the Model and Frame of the View package
 * @author Jian Li
 *@version 21.11.17 Added Frame 1.3
 */
public class ChatbotController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appframe;

	/**
	 * Constructor, assigns data members to methods
	 */
	public ChatbotController()
	{
		chatbot = new Chatbot("Squarebot");
		display = new PopupDisplay();
		appframe = new ChatFrame(this);
	}
	
	/**
	 * Start method
	 */
	public void start()
	{
		String response = display.collectResponse("What do you want to talk about?");
		
		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
		{
			response = popupChat(response);
			response = display.collectResponse(response);
		}
	}
	
	public String interactWithChatbot(String input)
	{
		String chatbotSays = "";
		
		if(chatbot.quitChecker(input))
		{
			close();
		}
		
		chatbotSays += chatbot.processConversation(input);
		
		return chatbotSays;
	}
	
	private void close()
	{
		display.displayText("Goodbye");
		System.exit(0);
	}
	
	/**
	 * Makes a popup that allows the user to respond
	 * @param chat
	 * @return Returns response with an processed comment
	 */
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
}
