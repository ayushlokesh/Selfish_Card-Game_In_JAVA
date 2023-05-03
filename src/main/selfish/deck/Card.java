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
 * @param name auighilreh;agie
 * @param desc sagfliauerghliuer
 */
    public Card(String name, String desc){
        this.name = name;
        this.description = desc;
    }


/**
 * kjefbawkfb
 * @return dfhffgfg
 */
    public String toString(){return name;}
/**
 * kawhf;arehg;o
 * @return akdfiewbfo;HE
 */
    public String getDescription(){return description;}

/**
 * kdaefgbearlb
 */
    public int compareTo(Card o) {        
        return this.toString().compareTo(o.toString());
    }


    
}
