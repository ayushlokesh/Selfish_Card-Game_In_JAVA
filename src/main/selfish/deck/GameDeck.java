package selfish.deck;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import selfish.GameException;

/**
 * Represents the Game Deck that actions cards.
 * 
 * @author Ayush
 * @version 1.0
 * @since 1.0
 * 
 */

public class GameDeck extends Deck{
/** A constant. */
    public static final String HACK_SUIT = "Hack suit";
/** A constant. */
    final public static String HOLE_IN_SUIT = "Hole in suit";
/**algherilghqi */    
    final public static String LASER_BLAST = "Laser blast";
    /**algherilghqi */
    final public static String OXYGEN_1 = "Oxygen(1)";
    /**algherilghqi */
    final public static String OXYGEN_2 = "Oxygen(2)";
    /**algherilghqi */
    final public static String OXYGEN_SIPHON = "Oxygen siphon";
    /**algherilghqi */
    final public static String ROCKET_BOOSTER = "Rocket booster";
    /**algherilghqi */
    final public static String SHIELD = "Shield";
    /**algherilghqi */
    final public static String TETHER = "Tether";
    /**algherilghqi */
    final public static String TRACTOR_BEAM = "Tractor beam";
    /**algherilghqi */
    final public static String OXYGEN = "Oxygen";
    /**algherilghqi */
    final private static long serialVersionUID = 0;

/**
 * ksdbvcksav
 */
    public GameDeck(){
        
    }
/**
 * asdfhgseilrugfai
 * @param s kadshflarhzdhvg
 * @throws GameException aslufwEIUF
 */
    public GameDeck(String s) throws GameException{
        try{
        add(loadCards(s));}
        catch(Exception e){throw new GameException("File not Found", new FileNotFoundException());}
        for (int i = 0; i<10; i++){this.add(new Oxygen(2));}
        for (int i = 0; i<38; i++){this.add(new Oxygen(1));}
    }
/**
 * dsvhelrhg;oerhg
 * @param i ;hfawuiehvqr;ehv
 * @return s;fuhqreifgqer;if
 */
    public Oxygen drawOxygen(int i){ if (this.size() == 0){throw new IllegalStateException("JHVBSV");}
        Oxygen c = new Oxygen(i);
       boolean fnd = false;
        List<Card> a = new ArrayList<Card>();

        for (int j = 0; j < this.size(); j++){a.add(this.draw());

             if (a.get(a.size()-1) instanceof Oxygen && ((Oxygen)a.get(a.size()-1)).getValue() == i)
            
             {fnd = true; c = (Oxygen)a.get(a.size()-1); a.remove(j); break;}}
        
             for (int j = a.size()-1; j >= 0; j--){this.add(a.remove(j));}
             if(!fnd){throw new IllegalStateException("HACK_SUIT");}
        return c;}
/**
 * ;fihweg;uhqre;og
 * @param o ufhwquogv;wqeohf
 * @return ;fhverpgfvweohgvo
 */
    public Oxygen[] splitOxygen(Oxygen o){
        if(o.getValue() == 1){
            throw new IllegalArgumentException();
        }
        Oxygen[] x = new Oxygen[2];
        x[1] = this.drawOxygen(1);
        x[0] = this.drawOxygen(1);
        this.add(o);
        
        return x;}
    
}
