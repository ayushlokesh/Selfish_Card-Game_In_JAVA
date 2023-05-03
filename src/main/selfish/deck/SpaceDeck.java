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
    public static final String ASTEROID_FIELD = "Asteroid field";
/**UFHeovngrvjnewiv */
    public static final String BLANK_SPACE = "Blank space";
/**UFHeovngrvjnewiv */
    public static final String COSMIC_RADIATION = "Cosmic radiation";
/**UFHeovngrvjnewiv */
    public static final String GRAVITATIONAL_ANOMALY = "Gravitation anomaly";
/**UFHeovngrvjnewiv */
    public static final String HYPERSPACE = "Hyperspace";
/**UFHeovngrvjnewiv */
    public static final String METEOROID = "Meteoroid";
/**MYSTERIOUS NEBULA UFHeovngrvjnewiv */
    public static final String MYSTERIOUS_NEBULA = "Mysterious nebula";
/**SOLAR FLARE UFHeovngrvjnewiv */
    public static final String SOLAR_FLARE = "Solar flare";
/**USEFUL JUNK UFHeovngrvjnewiv */
    public static final String USEFUL_JUNK = "Useful junk";
/**WORMHOLE  UFHeovngrvjnewiv */
    public static final String WORMHOLE = "Wormhole";
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
