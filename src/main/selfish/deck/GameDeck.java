package selfish.deck;

import java.util.ArrayList;
import java.util.List;

public class GameDeck extends Deck{

    final public static String HACK_SUIT = "Hack suit";
    final public static String HOLE_IN_SUIT = "Hole in suit";
    final public static String LASER_BLAST = "Laser blast";
    final public static String OXYGEN_1 = "Oxygen(1)";
    final public static String OXYGEN_2 = "Oxygen(2)";
    final public static String OXYGEN_SIPHON = "Oxygen siphon";
    final public static String ROCKET_BOOSTER = "Rocket booster";
    final public static String SHIELD = "Shield";
    final public static String TETHER = "Tether";
    final public static String TRACTOR_BEAM = "Tractor beam";
    final public static String OXYGEN = "Oxygen";
    final private static long serialVersionUID = 0;


    public GameDeck(){
        add(loadCards(""));
    }

    public GameDeck(String s){
        add(loadCards(s));
        for (int i = 0; i<10; i++){this.add(new Oxygen(2));}
        for (int i = 0; i<38; i++){this.add(new Oxygen(1));}
    }

    public Oxygen drawOxygen(int i){
        c = new Oxygen(i);
        this.remove(c);
        return c;}

    public Oxygen[] splitOxygen(Oxygen o){
        c = new Oxygen(1);
        this.remove(c); this.remove(c);
        this.add(new Oxygen(2));
        Oxygen[] o;
        o = new Oxygen[] {new Oxygen(1), new Oxygen(1)};
        return o;}
    
}
