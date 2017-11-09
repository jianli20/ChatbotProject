package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = null;
		this.questions = new String [10];
		this.username = username;
		this.content = null;
		this.intro = null;
		this.currentTime = null;
		this.topics = new String [7];
		this.verbs = new String [4];
		this.followUps = new String [5];
		
		buildVerbs();
		buildTopics();
//		buildFollowups();
		buildQuestions();
		buildShoppingList();
		buildCuteAnimals();
	}
	
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}
	
//	public void buildMovieList()
//	{
//		movieList.add("Inception");
//		movieList.add("Spiderman");
//		movieList.add("Hidden Figures");
//		movieList.add("Big Hero 6");
//		movieList.add("Rogue One");
//		movieList.add("IT");
//		movieList.add("Baby Driver");
//	}
	
	private void buildTopics()
	{
		topics[0] = "Animals";
		topics[1] = "Food";
		topics[2] = "School";
		topics[3] = "Movies";
		topics[4] = "Memes";
		topics[5] = "Books";
		topics[6] = "Shopping";
				
	}
	
	
	public void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("salad");
		shoppingList.add("crackers");
		shoppingList.add("jelly");
		shoppingList.add("juice");
		shoppingList.add("gummi");
		shoppingList.add("soda");
		shoppingList.add("chips");
		shoppingList.add("coffee");
	}
	
	public void buildCuteAnimals()
	{
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("FLOOFER");
	}
	
	public void buildQuestions()
	{
		questions[0] = "What is your favorite food?";
		questions[1] = "What is your favorite movie?";
		questions[2] = "What is your favorite book?";
		questions[3] = "Do you like memes?";
		questions[4] = "How many siblings do you have?";
		questions[5] = "What is your favorite season?";
		questions[6] = "What is your favorite subject?";
		questions[7] = "Do you like cars?";
		questions[8] = "Do you like games?";
		questions[9] = "Do you have a favorite video game?";
	}
	
	/**
	 * Method takes user input, repeats input back to them, and adds an additional "response" relating to input.
	 * @param The response that the user gives as a String.
	 * @return Returns the combined input from user and response from chatbot.
	 */
	public String processConversation(String input) // Repeats user input
	{
		String chatbotResponse = "";
		chatbotResponse += "You said:" + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	/**
	 * Method to make Chatbot response by randomly selecting parts of sentences to produce a response
	 * @return returns the generated random response produced, 
	 */
	private String buildChatbotResponse() //Chatbot "Responses" to the user response by adding "thoughts" to it
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		random = (int) (Math.random() * 2);
		
		if (random % 2 == 0)
		{
			random = (int) (Math.random() * movieList.size());
			response += "\n" + movieList.get(random).getTitle() + " is a great movie!";
		}
		return response;
	}
	
	public boolean lengthChecker(String input) //Makes sure the length of the user input is longer than 2
	{
		boolean validLength = false;
		
		if (input != null)
		{
			if (input.length() > 2)
			{
				validLength = true;
			}
		}
		
		return validLength;
	}
	
	public boolean htmlTagChecker(String input)
	{
		boolean validTag = false;
		if(!input.equals("<>") && !input.equals("< >") && !input.equals("<B>  ") && !input.equals("<A HREF> </a>") && input.equals("<B>  </B>") || input.equals("<I> sdadas </i>") || input.equals("<P>") || input.equals("<A HREF=\"sdfs.html\"> </a>") )
		{
			validTag = true;
		}
		return validTag;
	}
	
	public boolean userNameChecker(String input)
	{
		boolean validUser = false;
		
		if(input != "" && input != null && input.indexOf("@") <= 0 && input.indexOf("@") >= 0 && !input.contains("@@"))
		{
			validUser = true;
		}
		return validUser;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		boolean validCheck = false;
//		if(validCheck.equals(newContent))
//		{
//			validCheck = true;
//		}
		return validCheck;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		boolean validMeme = false;
		if (input != "pepe" && input.equals("pupper") || input.equals("kittie") || input.equals("otter"))
		{
			validMeme = true;
		}
		return validMeme;
	}
	
	public boolean shoppingListChecker(String shoppingItem) // Checks shopping item to see if it contains something from list
	{
		boolean validList = false;
		
		for(int index = 0; index <11; index ++)
		{
			if(shoppingItem.contains(shoppingList.get(index)))
			{
				validList = true;
			}
		}
		return validList;
	}
	
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString) //Makes sure user input isn't "quit"
	{
		boolean validQuit = false;
		
		if (exitString!= "" && exitString != null && !exitString.equalsIgnoreCase("exit") && exitString.equalsIgnoreCase("quit"))
		{
			validQuit = true;
		}
		return validQuit;
	}

	public boolean keyboardMashChecker(String sample)
	{
		boolean validMash = false;
		if (sample.contains("sdf") || sample.contains("SDF") || sample.contains("dfg") || sample.contains("cvb") || sample.contains(",./") || sample.contains("kjh") || sample.contains("DFG") || sample.contains("CVB") || sample.contains("KJH"))
		{
			validMash = true;
		}
		else if (sample.contains("S.D.F.") || sample.contains("derf"))
		{
			validMash = false;
		}
		return validMash;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return questions;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return intro;
	}
	
	public LocalTime getCurrentTime()
	{
		return currentTime;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}