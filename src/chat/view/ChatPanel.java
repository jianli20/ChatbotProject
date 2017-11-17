package chat.view;

import javax.swing.JPanel;
import chat.controller.ChatbotController;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JTextArea chatArea;
	private JTextField inputField;
	private SpringLayout appLayout;
	private JButton checkerButton;
	
	/**
	 * Constructor, initializes the GUI data members
	 */
	
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		chatButton = new JButton("Chat");
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(20);
		appLayout = new SpringLayout();
		checkerButton = new JButton("Check");
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 0, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -5, SpringLayout.NORTH, chatButton);
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	/**
	 * Sets up the panel with specific parameters, and proper contents
	 */
	
	private void setupPanel()
	{
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatArea);
		this.add(checkerButton);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
	}
	
	/**
	 * Sets up the placement of the content pieces in the GUI
	 */
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatArea);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -36, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatArea);
	}
	
	/**
	 * Sets up the actions with the objects in the panel
	 */
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click) 
				{
					String userText = inputField.getText();
					String displayText = appController.interactWithChatbot(userText);
					chatArea.append(displayText);
					inputField.setText("");
				}
			});
		checkerButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{
					
				}
			});
	}
}
