import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Card {
	int rank, suit;

	String[] suits = { "Club", "Diamond", "Heart", "Spade" };
	String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack",
			"Queen", "King", "Ace", "Joker" };
	int[] numSuits = { 0, 1, 3, 4 };
	int[] numRanks = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 0 };

	Card(int s, int r) {
		rank = r;
		suit = s;
	}

	public String toString() {
		return ranks[rank] + " of " + suits[suit];
	}

	public int getValue() {
		if (numRanks[rank] == 0)
			return 0;
		else
			return ((numRanks[rank] * 10) + (numSuits[suit]));
	}

	public int isJoker() {
		if (numRanks[rank] == 0) {
			return -1;
		} else
			return 0;
	}

	public int getRank() {
		return rank;
	}

	public int getSuit() {
		return suit;
	}
}

class Deck {
	private Card[] cards;
	int i;
	int n;

	Deck() {
		i = 56;
		cards = new Card[60];
		int x = 0;
		for (int r = 0; r <= 3; r++) {
			for (int s = 0; s <= 13; s++) {
				cards[x] = new Card(r, s);
				x++;
			}
		}
	}

	void shuffle() {
		Random getRand = new Random();
		int i = 0;
		Card c, d;
		for (int x = 0; x < 56; x++) {
			i = getRand.nextInt(56);
			c = cards[i];
			d = cards[x];
			cards[i] = d;
			cards[x] = c;
		}
		n = 0;
	}

	Card drawCard(int x) {
		return cards[x];
	}
}

class Players {
	String name;
	int points;

	Players(String n) {
		name = n;
	}

	String getName() {
		return name;
	}

	int getPoints() {
		return points;
	}
}

class CardGame {

	int[] points, value, win;
	int temp, index = 0;

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

public class LetsPlay {

	public static void main(String[] args) {
		int numPlayers;
		CardGame Play = new CardGame();
		Scanner myScanner = new Scanner(System.in);

		System.out.println("How many players?");
		numPlayers = myScanner.nextInt();
		Play.Game(numPlayers);

	}
}
