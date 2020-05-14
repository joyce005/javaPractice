import java.util.ArrayList;

public class Hangman {
/* INSTANCE VARIABLES */
	
	public String[] wordBank = {"python", "jumble", "easy", "difficult", "answer", "xylophone"};
	public String word;
	public String tempStateOfGuess = "";
	public String stateOfGuess;
	public ArrayList<Character> charUsed = new ArrayList<Character>();
	public ArrayList<Integer> guessPositions = new ArrayList<Integer>();
	public int position;
	public int lives;
	
/* CONSTRUCTORS */
	
	public Hangman()
	{
		this.word = wordBank[(int)(Math.random()*wordBank.length)];
		for (int i = 0; i < word.length(); i++)
			tempStateOfGuess = tempStateOfGuess + "-";
		setStateOfGuess('-');
		setLives(6);
	}
	
/* SET METHODS */
	
	// Calls specific setter methods that use the guess parameter
	public void setChanges(char guess)
	{
		setGuessPositions(guess);
		setStateOfGuess(guess);
		
		// Sets changes if the player guessed a new unique letter
		boolean contains = false;
		for (int i = 0; i < charUsed.size(); i++)
			if (charUsed.get(i) == guess)
				contains = true;
		
		if (!contains)
		{
			setCharUsed(guess);
			if (getGuessPositionsSize() == 0)
				setLives(getLives()-1);
		}
	}
	
	public void setStateOfGuess(char guess)
	{
		stateOfGuess = "";
		int startIndex = 0;
		if (guessPositions.size() > 0)
			for (int i = 0; i < guessPositions.size(); i++)
			{
				position = guessPositions.get(i);
				for (int j = startIndex; j < position; j++)
					stateOfGuess = stateOfGuess + tempStateOfGuess.charAt(j);
				stateOfGuess = stateOfGuess + guess;
				startIndex = position + 1;
			}
		
		if (stateOfGuess.length() < word.length())
			for (int i = stateOfGuess.length(); i < word.length(); i++)
					stateOfGuess = stateOfGuess + tempStateOfGuess.charAt(i);
		
		tempStateOfGuess = stateOfGuess;
	}
	
	public void setGuessPositions(char guess)
	{
		guessPositions.clear();
		
		for (int i = 0; i < word.length(); i++)
			if (word.charAt(i) == guess)
				guessPositions.add(i);
	}
	
	public void setCharUsed(char guess)
	{
		charUsed.add(guess);
	}
	
	public void setLives(int lives)
	{
		this.lives = lives;
	}

/* GET METHODS */
	
	public String getWord()
	{
		return word;
	}
	
	public String getStateOfGuess()
	{
		return stateOfGuess;
	}
	
	public int getGuessPositionsSize()
	{
		return guessPositions.size();
	}
	
	public int getLives()
	{
		return lives;
	}
	
	public String getCharUsed()
	{
		String output = "";
		for (int i = 0; i < charUsed.size(); i++)
			output = output + charUsed.get(i) + " ";
		return output;
	}
	
/* PRINT METHOD */
	
	public String toString()
	{
		return "This is your word so far: " + getStateOfGuess() 
			+ "\nLetters used: " + getCharUsed() + "\nLives left: " + getLives();
	}
	
}
