
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