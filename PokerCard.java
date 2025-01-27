public class PokerCard {
    // Enum für die Farben
    public enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

    // Enum für die Werte
    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        JACK(11), QUEEN(12), KING(13), ACE(14);

        private final int value;

        Rank(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private final Suit suit;
    private final Rank rank;

    public PokerCard(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    // Beispiel für die Verwendung
    public static void main(String[] args) {
        PokerCard card = new PokerCard(Suit.HEARTS, Rank.ACE);
        System.out.println(card); // Ausgabe: ACE of HEARTS
        System.out.println("Wert: " + card.getRank().getValue()); // Ausgabe: Wert: 14
    }
}

