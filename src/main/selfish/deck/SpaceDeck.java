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
    /**UFHeovngrvjnewiv */
    final public static String ASTEROID_FIELD = "Asteroid field";
    /**UFHeovngrvjnewiv */
    final public static String BLANK_SPACE = "Blank space";
    /**UFHeovngrvjnewiv */
    final public static String COSMIC_RADIATION = "Cosmic radiation";
    /**UFHeovngrvjnewiv */
    final public static String GRAVITATIONAL_ANOMALY = "Gravitation anomaly";
    /**UFHeovngrvjnewiv */
    final public static String HYPERSPACE = "Hyperspace";
    /**UFHeovngrvjnewiv */
    final public static String METEOROID = "Meteoroid";
    /**UFHeovngrvjnewiv */
    final public static String MYSTERIOUS_NEBULA = "Mysterious nebula";
    /**UFHeovngrvjnewiv */
    final public static String SOLAR_FLARE = "Solar flare";
    /**UFHeovngrvjnewiv */
    final public static String USEFUL_JUNK = "Useful junk";
    /**UFHeovngrvjnewiv */
    final public static String WORMHOLE = "Wormhole";
    /**UFHeovngrvjnewiv */
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
