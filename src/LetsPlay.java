import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class LetsPlay {

	public static void main(String[] args) {
		int numPlayers;
		CardGame Play = new CardGame();
		Scanner myScanner = new Scanner(System.in);

		System.out.println("How many players?");
		numPlayers = myScanner.nextInt();
		Play.printDeck();

	}
}
	