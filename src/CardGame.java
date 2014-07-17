import java.util.Arrays;
import java.util.Scanner;


class CardGame {

	int[] points, value, win;
	int temp, index = 0;
	
	void printDeck(){
		Deck myDeck = new Deck();
		Card c;
		for(int x=0;x<56;x++){
			c=myDeck.drawCard(x);
			System.out.println(c.toString());
			
		}
	}
	void Game(int numPlayers) {
		String input;
		Deck myDeck = new Deck();
		Scanner myScanner = new Scanner(System.in);
		Card c;
		int x = 0;
		int max, winner = 0;
		win = new int[numPlayers];
		points = new int[numPlayers];

		while (winner == 0) {
			temp = 0;
			myDeck.shuffle();
			value = new int[numPlayers];
			for (x = 0; x < numPlayers; x++) {
				System.out.print("Player " + (x + 1)
						+ " press 'Enter' to draw a card");
				input = myScanner.nextLine();
				c = myDeck.drawCard(x);
				System.out.println("You drew a: " + c.toString());
				System.out.println("");
				value[x] = c.getValue();
				if (value[x] == 0)
					points[x] = points[x] - 1;
				if (value[x] > temp) {
					temp = value[x];
					index = x;
				}
			}
			points[index] = points[index] + 2;

			for (x = 0; x < numPlayers; x++) {
				System.out.println("Player " + (x + 1) + " currrent score is "
						+ points[x]);
			}

			win = points.clone();
			Arrays.sort(win);
			max = win[numPlayers - 1];
			if ((win[numPlayers - 1] >= 5)
					&& win[numPlayers - 1] >= (win[numPlayers - 2] + 2))
				for (x = 0; x < numPlayers; x++) {
					if (max == points[x])
						winner = x + 1;
				}
			System.out.println("");
		}
		System.out.println("Player " + winner + " is the winner! Congrats!");

	}

}