package selfish.deck;

/**
 * Represents cards in the game.
 * 
 * @author Ayush
 * @version 1.0
 * @since 1.0
 */
public class Card implements java.io.Serializable, Comparable<Card> {
    private String name;
    private String description;
    private static final long serialVersionUID = 0;
    
    /*
    * empty card constructor
    */
    public Card(){

    }

/**
 * Returns the name of card
 * @param name takes name of card
 * @param desc takes description of cards
 */
    public Card(String name, String desc){
        this.name = name;
        this.description = desc;
    }


/**
 * overriden toString method
 * @return name of card
 */
    public String toString(){return name;}
/**
 * getter for description of card
 * @return description
 */
    public String getDescription(){return description;}

/**
 * overriden compareto
 * @param o takes card instance
 * @return returns a number
 */
    public int compareTo(Card o) {        
        return this.toString().compareTo(o.toString());
    }


    
}
