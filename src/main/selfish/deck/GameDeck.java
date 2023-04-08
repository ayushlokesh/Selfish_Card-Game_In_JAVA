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


    public GameDeck(){}

    public GameDeck(String s){
        add(loadCards(s));
    }

    public Oxygen drawOxygen(int i){return null;}

    public Oxygen[] splitOxygen(Oxygen o){return null;}
    
}
