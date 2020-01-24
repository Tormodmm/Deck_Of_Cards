package oblig1;

// Imports java libraries
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author tormodmuller
 * @version 2020.01.24
 *
 * A deck of new untouched deck of cards.
 * Contains methods which:
 *      - creates a new deck untouched deck of cards.
 *      - prints out/ returns the deck.
 *      - shuffles the deck and picks out a random amount of cards and prints them to the user.
 *      - filters out the 'Spades' in the shuffled deck and prints them to the user.
 *      - filters out the 'Hearts' in the shuffled deck and collect them in a new list.
 *      - creates a new list with the shuffled cards color.
 *      - sums the shuffled cards faces and prints the sum to the user.
 *      - checks if 'Queen of Spades' exists in the shuffled list, and returns the result to the user.
 *      - tells whether your list of five cards is a Poker Flush.
 */
public class Deck {

    public ArrayList<Card> cards = new ArrayList<>();
    public ArrayList<Card> deckShuffled = new ArrayList<>();
    public List<Card> flushRed;
    public List<Card> flushBlack;

    /**
     * The constructor used to initialize the methods, while the program does not have a GUI.
     */
    public Deck() {
        createDeck();
        printDeck();
        Collection<Card> randomCards = assignShuffeled(5);
        printSpades();
        collectHearts();
        printHearts();
        cardColorR(cards);
        printValueOfCards();
        printQueenOfSpades();
        printFlush(deckShuffled);
    }

    /**
     * Main method used to run the program.
     * Calls on the constructor which contains all the methods to be used in the program.
     * @param args
     */
    public static void main(String[] args) {
        Deck deck = new Deck();
    }

    /**
     * Creates a deck containing 'Spades', 'Hearts', 'Diamonds' and Clubs - each of the suits counting from 1-13, where:
     *      - 1 = Ace
     *      - 11 = Jack
     *      - 12 = Queen
     *      - 13 = King
     */
    public void createDeck() {
        for (int index = 1; index <= 13; index++) {
            cards.add(new Card("Spades", index));
            cards.add(new Card("Hearts", index));
            cards.add(new Card("Diamonds", index));
            cards.add(new Card("Clubs", index));
        }
    }

    /**
     * Prints out the untouched deck in the correct order.
     * Prints out the amount of cards in the deck (cards).
     */
    public void printDeck() {
        System.out.println();
        for (Card card : cards) {
            card.getDetails();
        }
        System.out.println();
        System.out.println("Amount of card: " + cards.size());
    }

    /**
     * Creates a collection of a given amount of cards.
     * Shuffles the untouched deck of cards.
     * Prints out the first 'amount' of cards from the shuffled deck and prints it to the user.
     * Prints the colors of the 'amount' cards.
     * @param amount
     * @return the shuffled deck of cards
     */
    public Collection<Card> assignShuffeled(int amount) {
        Collections.shuffle(cards);
        ArrayList<Card> deckShuffled = this.deckShuffled;
        for (int index = 0; index < amount; index++) {
            deckShuffled.add(cards.get(index));
        }

        System.out.println();
        System.out.println("Shuffled deck with the amount of cards you wanted: " + amount);
        for (Card tempCards_FullDeck : deckShuffled) {
            tempCards_FullDeck.getDetails();
        }
        System.out.println();
        System.out.println("The color of your " + amount + " cards: ");
        printCardColor();

        return deckShuffled;
    }

    /**
     * Creates a new empty ArrayList called "spades".
     * Searches through the original, shuffled ArrayList and collects all the 'Spades' from this list.
     * Then it puts all the 'Spades' inside the new empty ArrayList, "spades".
     * @return the ArrayList "spades"
     */
    public ArrayList<Card> collectSpades() {
        ArrayList<Card> spades = new ArrayList<>();
        cards.stream().filter(card -> card.getSuit().equals("Spades")).forEach(spades::add);
        return spades;
    }

    /**
     * Creates a new empty ArrayList called "hearts".
     * Searches through the original, shuffled ArrayList and collects all the 'Hearts' from this list.
     * Then it puts all the 'Hearts' inside the new empty ArrayList, "hearts".
     * @return the ArrayList "hearts"
     */
    public ArrayList<Card> collectHearts() {
        ArrayList<Card> hearts = new ArrayList<>();
        cards.stream().filter(card -> card.getSuit().equals("Hearts")).forEach(hearts::add);
        return hearts;
    }

    /**
     * Creates a temporary List containing the "spades"-ArrayList.
     * Prints all the 'Spades' from the ArrayList "spades".
     */
    public void printSpades() {
        System.out.println("\nAll 'Spades' in shuffled order: ");
        List<Card> collectedCards = collectSpades();
        for (Card tempCards_S : collectedCards) {
            tempCards_S.getDetails();
        }
    }

    /**
     * Creates a temporary List containing the "hearts"-ArrayList.
     * Prints all the 'Hearts' from the ArrayList "hearts".
     */
    public void printHearts() {
        System.out.println("\nAll 'Hearts' in shuffled order: ");
        List<Card> collectedCards = collectHearts();
        for (Card tempCards_H : collectedCards) {
            tempCards_H.getDetails();
        }
    }

    /**
     * Creates a List containing the shuffled deck.
     * Checks whether the cards suits in the shuffled deck is "RED" or "BLACK".
     * @param deckShuffled
     * @return the colors of the 'amount' cards
     */
    public List<String> cardColorR(ArrayList<Card> deckShuffled) {
        return deckShuffled.stream().map(card -> (card.getSuit()).equals("Hearts") || card.getSuit().equals("Diamonds") ? "RED" : "BLACK").collect(Collectors.toList());
    }

    /**
     * Prints the List containing the card colors
     */
    public void printCardColor() {
        System.out.println(cardColorR(deckShuffled));
    }

    /**
     * Sums the faces' on the 'amount' of cards from the shuffled deck
     * @param deckShuffled
     * @return sum of the selected cards
     */
    public int valueOfCards(ArrayList<Card> deckShuffled) {
        return deckShuffled.stream().reduce(0, (subtotal, card) -> subtotal + card.getFace(), Integer::sum);
    }

    /**
     * Prints out the sum of the 'amount' cards the user picked from the deck.
     */
    public void printValueOfCards() {
        System.out.println("\nThe total sum of the cards you picked from the deck is: " + valueOfCards(deckShuffled));
    }

    /**
     * Checks whether the queen of spades exists in your selection of cards.
     * @param deckShuffled
     * @return true, if the 'Queen of Spades' exists in the selected cards
     */
    public boolean queenOfSpadesExists(ArrayList<Card> deckShuffled) {
        return deckShuffled.stream().anyMatch((card) -> card.getSuit().equals("Spades") && card.getFace() == 12);
    }

    /**
     * Initializes the 'queenOfSpadesExists(ArrayList<Card> deckShuffled)'-method.
     * Prints out some output depending on whether the queen exists in the selected cards or not.
     */
    public void printQueenOfSpades() {
        queenOfSpadesExists(deckShuffled);
        System.out.println("\nDoes the queen of spades exists in your selection?");
        if (queenOfSpadesExists(deckShuffled) == false) {
            System.out.println("There is no queen of spades in the deck.");
        } else {
            System.out.println("You do have the queen of spades in your deck! Congrats!");
        }
    }

    /**
     * Creates a new ArrayList in the two Lists "flushBlack" and "flushRed".
     * Fills these two ArrayLists with the matching colors.
     * 'Diamonds' and 'Spades' in the "flushRed".
     * 'Spades' and 'Clubs' in the "flushBlack".
     * @param flush
     */
    public void isFlush(ArrayList<Card> flush) {
        flushBlack = new ArrayList<>(deckShuffled);
        flushRed = new ArrayList<>(deckShuffled);
        flush.stream().filter(card -> (card.getSuit().equals("Spades") || card.getSuit().equals("Clubs"))).forEach(flushBlack::add);
        flush.stream().filter(card -> (card.getSuit().equals("Diamonds") || card.getSuit().equals("Hearts"))).forEach(flushRed::add);
    }

    /**
     * Initializes the isFlush()-method.
     * if-statement checking the result from the isFlush()-method and prints out the info on whether the user got a Poker Flush, or not.
     * @param random
     */
    public void printFlush(ArrayList<Card> random) {
        isFlush(random);
        if ((flushRed.size() == 5) || (flushBlack.size() == 5)) {
            System.out.println("Congrats! You have gotten an poker flush!");
        } else {
            System.out.println("I'm sorry, you did not get an poker flush this time!");
        }
    }
}