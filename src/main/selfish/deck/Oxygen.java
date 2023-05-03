package selfish.deck;
/**
 * Represents Oxygen in the game.
 * 
 * @author Ayush
 * @version 1.0
 * @since 1.0
 */
public class Oxygen extends Card{

    private int value;

    final private static long serialVersionUID = 0;
/**
 * oxygen constructor
 * @param i takes oxygen number
 */
    public Oxygen(int i){
        this.value = i;
    }
/**
 * getter for oxygen value
 * @return returns oxygen number
 */
    public int getValue(){return value;}

    /**
     * overriden tostring method
     * @return returns name of oxygen card
     */
    public String toString(){return "Oxygen(" + value + ")"; }

    // @ Override
    // public int compareTo(Card o) {
    //     if (o instanceof Oxygen)
    //     return this.toString().compareTo(o.toString());
    // }
    
}
