import java.util.Random;

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