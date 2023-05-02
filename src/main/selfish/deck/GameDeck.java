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
        Oxygen c = new Oxygen(i);
       
        List<Card> a = new ArrayList<Card>();

        for (int j = 0; j < this.size(); j++){a.add(this.draw());

             if (a.get(a.size()-1) instanceof Oxygen && ((Oxygen)a.get(a.size()-1)).getValue() == i)
            
             {c = (Oxygen)a.get(a.size()-1); a.remove(j); break;}}
        
             for (int j = a.size()-1; j >= 0; j--){this.add(a.remove(j));}
        return c;}

    public Oxygen[] splitOxygen(Oxygen o){
        Oxygen[] x = new Oxygen[2];
        x[1] = this.drawOxygen(1);
        x[0] = this.drawOxygen(1);
        this.add(o);
        
        return x;}
    
}
