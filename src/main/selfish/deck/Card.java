package selfish.deck;
/**
 * Represents Astronaut in the game.
 * 
 * @author Ayush
 * @version 1.0
 * @since 1.0
 */
public class Card implements java.io.Serializable, Comparable<Card> {
    private String name;
    private String description;
    final private static long serialVersionUID = 0;

    public Card(String name, String desc){
        this.name = name;
        this.description = desc;
    }

    public Card(){}

    @ Override
    public String toString(){return name;}

    public String getDescription(){return description;}

    @ Override
    public int compareTo(Card o) {        
        return this.toString().compareTo(o.toString());
    }


    
}
