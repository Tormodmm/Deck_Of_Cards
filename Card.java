package oblig1;

/**
 * The task:
 * a) Lag en klasse Deck som oppretter en fullstendig kort-stokk (52 kort)
 * b) Lag en metode "assign" i Deck som plukker tilfeldig n kort fra kortstokket og returnerer disse
 * i en Collection. "n" er et tall mellom 1 og 52 som sendes inn som parameter til assign
 * funksjonen.
 * c) Skriv et uttrykk med filter og forEach som skriver ut alle spar-kort (suit = 'S').
 * d) Skriv et uttrykk med filter og collect som samler alle hjerter-kort (suit = 'H') i en ny liste.
 * e) Skriv et uttrykk med map som gir en ny list med kortenes kortfarge.
 * f) Skriv et uttrykk med reduce som gir summen av kortverdiene (face).
 * g) Skriv et uttrykk med anyMatch som sier om spar dame finnes i lista.
 * h) Skriv et uttrykk som sier om lista er en poker-flush, dvs. har fem kort hvor alle har samme
 * kortfarge.
 */

/**
 * Represents a playing card. A playing card has a number (face) between
 * 1 and 13, where 1 is called an Ace, 11 = Knight, 12 = Queen and 13 = King.
 * The card can also be one of 4 suits: Spade, Heart, Diamonds and Clubs.
 *
 * @author tormodmuller
 * @version 2020-01-24
 */
public class Card {

    private final String suit; // 'Spades' , 'Clubs' , 'Diamonds' and 'Hearts'
    private final int face; // a number between 1 and 13

    /**
     * Creates an instance of a Card with a given suit and face.
     *
     * @param suit The suit of the card, as a String. 'Spades', 'Heart', 'Diamonds' and 'Clubs'
     * @param face The face value of the card, an integer between 1 and 13
     */
    public Card(String suit, int face) {
        this.suit = suit;
        this.face = face;
    }

    /**
     * Prints the suit and face of the card as a string.
     * A 4 of hearts is returned as the string "4 of Hearts".
     * A 1 of hearts is returned as the string "Ace of Hearts.
     * A 11 of spades is returned as the string "Jack of Spades".
     * A 12 of clubs is returned as the string "Queen of Clubs".
     * A 13 of diamonds is returned as the string "King of Diamonds".
     *
     * Uses if- , else-if-methods to check whether the faces is 1, 11, 12, 13 and prints them as: Ace, Jack, Queen and King.
     *
     * @return the suit and face of the card as a string
     */
    public void getDetails() {
        if (getFace() == 11)
        {
            String numberAsString;
            numberAsString = ("Jack");
            System.out.println(numberAsString + " of " + getSuit());
        }else if (getFace() == 12) {
            String numberAsString;
            numberAsString = ("Queen");
            System.out.println(numberAsString + " of " + getSuit());
        } else if (getFace() == 13)
        {
            String numberAsString;
            numberAsString = ("King");
            System.out.println(numberAsString + " of " + getSuit());
        }
        else if (getFace() == 1) {
            String numberAsString;
            numberAsString = ("Ace");
            System.out.println(numberAsString + " of " + getSuit());
        }else {
            System.out.println(getFace() + " of " + getSuit());
        }
    }

    /**
     * Returns the suit of the card, 'S' for Spades, 'H' for Heart, 'D' for Diamonds and 'C' for clubs
     *
     * @return the suit of the card
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Returns the face of the card (value between 1 and 13).
     *
     * @return the face of the card
     */
    public int getFace() {
        return face;
    }
}
