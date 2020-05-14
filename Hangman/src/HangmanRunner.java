import java.util.List;
import java.util.Scanner;

public class HangmanRunner {

	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		Hangman game = new Hangman();
		
		// Print status before player starts guessing
		System.out.println(game);
		
		while (!game.getStateOfGuess().equals(game.getWord()) && game.getLives() > 0)
		{	
			// Asks for player's guess
			System.out.print("\nGuess a letter: ");
			game.setChanges(Character.toLowerCase(keyboard.next().charAt(0)));
			
			// Print status
			System.out.println(game);
		}
		
		// Reveals if player won or lost
		System.out.println("\nThe word was " + game.getWord() + ".");
		if (game.getStateOfGuess().equals(game.getWord()))
			System.out.println("\nYou win!");
		else
			System.out.println("\nYou lose!");
	}
	
}
