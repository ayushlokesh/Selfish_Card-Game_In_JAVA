package selfish.deck;
/**
 * Represents Astronaut in the game.
 * 
 * @author Ayush
 * @version 1.0
 * @since 1.0
 */
public class Oxygen extends Card{

    private int value;

    final private static long serialVersionUID = 0;
/**
 * HVSA;OIHVAREPJVGAER
 * @param i ;VH;AOWHVORHV;ORA
 */
    public Oxygen(int i){
        this.value = i;
    }
/**
 * ;SHvoarhgv;oerhver
 * @return ;dsfvhw;ovhr;ohvre
 */
    public int getValue(){return value;}

    /**
     * .LJVB.LBVwvbvafjv
     */
    public String toString(){return "Oxygen(" + value + ")"; }

    // @ Override
    // public int compareTo(Card o) {
    //     if (o instanceof Oxygen)
    //     return this.toString().compareTo(o.toString());
    // }
    
}
