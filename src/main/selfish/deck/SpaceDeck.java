package selfish.deck;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

import selfish.GameException;
/**
 * Represents Astronaut in the game.
 * 
 * @author Ayush
 * @version 1.0
 * @since 1.0
 */
public class SpaceDeck extends Deck{
    final public static String ASTEROID_FIELD = "Asteroid field";
    final public static String BLANK_SPACE = "Blank space";
    final public static String COSMIC_RADIATION = "Cosmic radiation";
    final public static String GRAVITATIONAL_ANOMALY = "Gravitation anomaly";
    final public static String HYPERSPACE = "Hyperspace";
    final public static String METEOROID = "Meteoroid";
    final public static String MYSTERIOUS_NEBULA = "Mysterious nebula";
    final public static String SOLAR_FLARE = "Solar flare";
    final public static String USEFUL_JUNK = "Useful junk";
    final public static String WORMHOLE = "Wormhole";
    final private static long serialVersionUID = 0;
/**
 * lvdha;hvberonvr
 */
    public SpaceDeck(){
        
    }
    /**
     * lvdshalbhvaerg
     * @param s ;vh;waVHR;EO
     * @throws GameException ZDSFHALWIRV;OEWRBGO;EF
     */
    public SpaceDeck(String s) throws GameException{
        try{
            add(loadCards(s));}
            catch(Exception e){throw new GameException("File not Found", new FileNotFoundException());}
    }
  
}
