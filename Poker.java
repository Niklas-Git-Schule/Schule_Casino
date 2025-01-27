import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Poker extends Spiel{
    //Variabeln
    List<PokerCard> allCards = new ArrayList<>();
    static int moneyinpot = 0;
    int moneyspieler1 = 1000;
    int moneynpc1 = 1000;
    int moneynpc2 = 1000;
    int moneynpc3 = 1000;
    int bet = 0;
    int round = 0;
    String input;
    boolean breaki = false;
    boolean allchecked = true;
    private boolean hasPair = false;
    private boolean hasTwoPair = false;
    private boolean hasThreeOfAKind = false;
    private boolean hasStraight = false;
    private boolean hasFlush = false;
    private boolean hasFullHouse = false;
    private boolean hasFourOfAKind = false;
    private boolean hasStraightFlush = false;
    private boolean hasRoyalFlush = false;

    Scanner sc = new Scanner(System.in);
        private PokerCard generateUniqueCard(List<PokerCard> allCards) {
        PokerCard card;
        do {
            card = new PokerCard(PokerCard.Suit.values()[(int) (Math.random() * 4)],
                                 PokerCard.Rank.values()[(int) (Math.random() * 13)]);
        } while (allCards.contains(card));
        allCards.add(card);
        return card;
    }
    public int start(int einsatz) {
    System.out.println("Money: " + moneyspieler1);
    round = 0;
    breaki = false;
    PokerCard gegner1 = generateUniqueCard(allCards);
    PokerCard gegner12 = generateUniqueCard(allCards);
    PokerCard handcardp1 = generateUniqueCard(allCards);
    PokerCard handcardp2 = generateUniqueCard(allCards);
    PokerCard Tisch1 = generateUniqueCard(allCards);
    PokerCard Tisch2 = generateUniqueCard(allCards);
    PokerCard Tisch3 = generateUniqueCard(allCards);
    PokerCard Tisch4 = generateUniqueCard(allCards);
    PokerCard Tisch5 = generateUniqueCard(allCards);


    // Rest des Codes bleibt unverändert
    System.out.println("Deine Hand: " + handcardp1 + " und " + handcardp2);
    // ...

        while(true){
        checkForCards(handcardp1, handcardp2, Tisch1, Tisch2, Tisch3, Tisch4, Tisch5);
            if (round == 1){
                System.out.println(" ");
                System.out.print("Karten auf dem Tisch: " + Tisch1 + " " + Tisch2 + " " + Tisch3);
                System.out.println(" ");            
            }
            System.out.println("c für check, f für fold, r für raise eingeben");
            input = sc.nextLine();
            breaki = input_check(breaki, input);
            if(breaki){
                break;
            }
        }
        start(moneyspieler1);
        return 0;
    }
    public static void main(String[] args) {
        Poker poker = new Poker();
        poker.start(poker.moneyspieler1);

    }
    public boolean input_check(boolean breaker, String input){
            if(input.equalsIgnoreCase("c")){
                moneyinpot += 0;
                if(allchecked){
                  round += 1;
                  return breaker;
                }
                else{
                  return breaker;
                }

            }
            else if(input.equalsIgnoreCase("f")){
                System.out.println("fold");
                moneyinpot += 0;
                breaker = true;
                return breaker;
            }
            else if(input.equalsIgnoreCase("r")){
                System.out.println("Bitte geben sie ein was sie setzen: ");
                int bet = sc.nextInt();
                String clear = sc.nextLine();
                moneyinpot += bet;
                moneyspieler1 -= bet;
                return breaker;
            }
            else {
                return breaker;
            }
    }
public void checkForCards(PokerCard handcardp1, PokerCard handcardp2,
                              PokerCard Tisch1, PokerCard Tisch2, PokerCard Tisch3,
                              PokerCard Tisch4, PokerCard Tisch5) {
        // Add all non-null cards to the list
        allCards.add(handcardp1);
        allCards.add(handcardp2);
        addIfNotNull(Tisch1);
        addIfNotNull(Tisch2);
        addIfNotNull(Tisch3);
        addIfNotNull(Tisch4);
        addIfNotNull(Tisch5);

        checkForPairs();
        checkForThreeOfAKind();
        checkForStraight();
        checkForFlush();
        checkForFullHouse();
        checkForFourOfAKind();
        checkForStraightFlush();

        printResults();
    }

    private void addIfNotNull(PokerCard card) {
        if (card != null) {
            allCards.add(card);
        }
    }

    private void checkForPairs() {
        Map<Integer, Integer> rankCounts = new HashMap<>();
        for (PokerCard card : allCards) {
            rankCounts.put(card.getRank().getValue(), rankCounts.getOrDefault(card.getRank().getValue(), 0) + 1);
        }

        int pairCount = 0;
        for (int count : rankCounts.values()) {
            if (count == 2) pairCount++;
        }

        hasPair = pairCount >= 1;
        hasTwoPair = pairCount >= 2;
    }

    private void checkForThreeOfAKind() {
        Map<Integer, Integer> rankCounts = new HashMap<>();
        for (PokerCard card : allCards) {
            rankCounts.put(card.getRank().getValue(), rankCounts.getOrDefault(card.getRank().getValue(), 0) + 1);
        }

        hasThreeOfAKind = rankCounts.values().stream().anyMatch(count -> count >= 3);
    }

    private void checkForStraight() {
        Set<Integer> ranks = new TreeSet<>();
        for (PokerCard card : allCards) {
            ranks.add(card.getRank().getValue());
        }

        if (ranks.size() >= 5) {
            List<Integer> sortedRanks = new ArrayList<>(ranks);
            for (int i = 0; i <= sortedRanks.size() - 5; i++) {
                if (sortedRanks.get(i + 4) - sortedRanks.get(i) == 4) {
                    hasStraight = true;
                    return;
                }
            }
        }

        // Check for Ace-low straight
        if (ranks.contains(14) && ranks.contains(2) && ranks.contains(3) && ranks.contains(4) && ranks.contains(5)) {
            hasStraight = true;
        }
    }

    private void checkForFlush() {
        Map<String, Integer> suitCounts = new HashMap<>();
        for (PokerCard card : allCards) {
            suitCounts.put(card.getSuit().name(), suitCounts.getOrDefault(card.getSuit().name(), 0) + 1);
        }

        hasFlush = suitCounts.values().stream().anyMatch(count -> count >= 5);
    }

    private void checkForFullHouse() {
        hasFullHouse = hasThreeOfAKind && hasPair;
    }

    private void checkForFourOfAKind() {
        Map<Integer, Integer> rankCounts = new HashMap<>();
        for (PokerCard card : allCards) {
            rankCounts.put(card.getRank().getValue(), rankCounts.getOrDefault(card.getRank().getValue(), 0) + 1);
        }

        hasFourOfAKind = rankCounts.values().stream().anyMatch(count -> count >= 4);
    }

    private void checkForStraightFlush() {
        if (hasFlush && hasStraight) {
            Map<String, List<PokerCard>> suitGroups = new HashMap<>();
            for (PokerCard card : allCards) {
                suitGroups.computeIfAbsent(card.getSuit().name(), k -> new ArrayList<>()).add(card);
            }

            for (List<PokerCard> suitGroup : suitGroups.values()) {
                if (suitGroup.size() >= 5) {
                    Set<Integer> ranks = new TreeSet<>();
                    for (PokerCard card : suitGroup) {
                        ranks.add(card.getRank().getValue());
                    }

                    List<Integer> sortedRanks = new ArrayList<>(ranks);
                    for (int i = 0; i <= sortedRanks.size() - 5; i++) {
                        if (sortedRanks.get(i + 4) - sortedRanks.get(i) == 4) {
                            hasStraightFlush = true;
                            hasRoyalFlush = (sortedRanks.get(i + 4) == 14); // Ace-high straight flush is a Royal Flush
                            return;
                        }
                    }

                    // Check for Ace-low straight flush
                    if (ranks.contains(14) && ranks.contains(2) && ranks.contains(3) && ranks.contains(4) && ranks.contains(5)) {
                        hasStraightFlush = true;
                    }
                }
            }
        }
    }
     private void printResults() {
        if (hasRoyalFlush) System.out.println("Sie haben einen Royal Flush!");
        else if (hasStraightFlush) System.out.println("Sie haben einen Straight Flush!");
        else if (hasFourOfAKind) System.out.println("Sie haben einen Vierling!");
        else if (hasFullHouse) System.out.println("Sie haben ein Full House!");
        else if (hasFlush) System.out.println("Sie haben einen Flush!");
        else if (hasStraight) System.out.println("Sie haben eine Straße!");
        else if (hasThreeOfAKind) System.out.println("Sie haben einen Drilling!");
        else if (hasTwoPair) System.out.println("Sie haben zwei Paare!");
        else if (hasPair) System.out.println("Sie haben ein Paar!");
        else System.out.println("Sie haben eine hohe Karte.");
    }
}


