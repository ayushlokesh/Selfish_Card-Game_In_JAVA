package selfish.deck;

import java.util.ArrayList;

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

    public SpaceDeck(){}
    
    public SpaceDeck(String s){
        ArrayList<Card> cards = loadCards("../../../../io/SpaceCards.txt");
    }
    
}
