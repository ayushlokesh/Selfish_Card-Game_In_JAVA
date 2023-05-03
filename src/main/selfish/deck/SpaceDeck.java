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
/** A constant.  */
    public static final String ASTEROID_FIELD = "Asteroid field";
/** A constant.  */
    public static final String BLANK_SPACE = "Blank space";
/** A constant.  */
    public static final String COSMIC_RADIATION = "Cosmic radiation";
/** A constant.  */
    public static final String GRAVITATIONAL_ANOMALY = "Gravitation anomaly";
/** A constant.  */
    public static final String HYPERSPACE = "Hyperspace";
/** A constant.  */
    public static final String METEOROID = "Meteoroid";
/** A constant. */
    public static final String MYSTERIOUS_NEBULA = "Mysterious nebula";
/**  A constant.  */
    public static final String SOLAR_FLARE = "Solar flare";
/**  A constant.  */
    public static final String USEFUL_JUNK = "Useful junk";
/** A constant. */
    public static final String WORMHOLE = "Wormhole";
    final private static long serialVersionUID = 0;
/**
 * empty constructor
 */
    public SpaceDeck(){
        
    }
    /**
     * spacedeck constructor
     * @param s takes file path
     * @throws GameException inherits gameexception
     */
    public SpaceDeck(String s) throws GameException{
        try{
            add(loadCards(s));}
            catch(Exception e){throw new GameException("File not Found", new FileNotFoundException());}
    }
  
}
