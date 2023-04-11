package selfish;
import java.util.*;

import selfish.deck.*;

public class Astronaut implements java.io.Serializable {
    private String name;
    private GameEngine game;
    final private static long serialVersionUID = 0;
    private Collection<Card> track;
    private List<Oxygen> oxygens = new ArrayList<Oxygen>();
    private List<Card> actions = new ArrayList<Card>();

    @ Override
    public String toString(){return "";}
    
    public Astronaut(String name, GameEngine game){
        this.name = name;
        this.game = game;
    }

    public void addToHand(Card card){}
    public void addToTrack(Card card){}
    public int breathe(){return 0;}
    public int distanceFromShip(){return 0;}
    public List<Card> getActions(){return null;}
    public String getActionsStr(boolean enumerated, boolean excludeShields){return null;}
    public List<Card> getHand(){return null;}
    public String getHandStr(){return null;}
    public Collection<Card> getTrack(){return null;}
    public void hack(Card card){}
    public Card hack(String card) {return null;}
    public int hasCard(String card){return 0;}
    public boolean hasMeltedEyeballs(){return false;}
    public boolean hasWon(){return false;}
    public boolean isAlive(){return false;}
    public Card laserBlast(){return null;}
    public int oxygenRemaining(){return 0;}
    public Card peekAtTrack(){return null;}
    public Oxygen siphon(){return null;}
    public Card steal(){return null;}
    public void swapTrack(Astronaut swapee){}
}
 