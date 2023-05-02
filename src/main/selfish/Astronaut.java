package selfish;
import java.util.*;

import selfish.deck.*;

public class Astronaut implements java.io.Serializable {
    private String name;
    private GameEngine game;
    final private static long serialVersionUID = 0;
    private Collection<Card> track;
    private List<Oxygen> oxygens;
    private List<Card> actions;

    @ Override
    public String toString(){return "";}
    
    public Astronaut(String name, GameEngine game){
        this.name = name;
        this.game = game;
        oxygens = new ArrayList<Oxygen>();
        actions = new ArrayList<Card>();
        track = new ArrayList<Card>();
    }

    public void addToHand(Card card){if (card instanceof Oxygen){oxygens.add((Oxygen)card);}
                                     else {actions.add(card); }}
    public void addToTrack(Card card){track.add(card);}
    public int breathe(){for (int i = 0; i < oxygens.size(); i++){
                        if (oxygens.get(i).getValue() == 1){oxygens.remove(i);  return oxygenRemaining();}}
                        oxygens.remove(oxygens.size()-1); oxygens.add(new Oxygen(1));
                        return oxygenRemaining();}
    public int distanceFromShip(){return (6 - track.size());}
    public List<Card> getActions(){List<Card> c = new ArrayList<Card>(actions); Collections.sort(c);return c;}
    public String getActionsStr(boolean enumerated, boolean excludeShields){String s = "";
                                                                            
    
    return null;}
    public List<Card> getHand(){List<Card> c = new ArrayList<Card>();
                                c.addAll(actions); c.addAll(oxygens); Collections.sort(c);
                                return c;}
    public String getHandStr(){return null;}
    public Collection<Card> getTrack(){Collection<Card> c = new ArrayList<Card>(track); return c;}
    public void hack(Card card){if (card instanceof Oxygen){
                                for (int i = 0; i < oxygens.size(); i++){
                                    if (oxygens.get(i).getValue() == ((Oxygen)card).getValue()){oxygens.remove(i); break;}}}
                                else {for (int i = 0; i < actions.size(); i++){
                                    if (actions.get(i).equals(card)){actions.remove(i); break;}}}
                                if (oxygenRemaining() == 0){game.killPlayer(this); actions.clear();}}
    public Card hack(String card) {Card c = new Card(); if (card == "Oxygen(1)" || card == "Oxygen(2)"){
                                for (int i = 0; i < oxygens.size(); i++){
                                    if (oxygens.get(i).toString() == card){c = oxygens.remove(i); break;}}}
                                else {for (int i = 0; i < actions.size(); i++){
                                    if (actions.get(i).toString() == card){c = actions.remove(i); break;}}}
                                    if (oxygenRemaining() == 0){game.killPlayer(this); actions.clear();}
                                    return c;
                                }
    public int hasCard(String card){int num = 0; List<Card> c = getHand();
                                    for (Card o : c){if (card.equals(o.toString())){num++;}}      
                                    return num;}
    public boolean hasMeltedEyeballs(){List<Card> action = new ArrayList<Card>(track); if (action.size() == 0){return false;} return (action.get(action.size()-1).toString() == "Solar flare");}
    public boolean hasWon(){return (distanceFromShip() == 0 && isAlive());}
    public boolean isAlive(){if (oxygens.size() == 0){return false;} return true;}
    public Card laserBlast(){List<Card> c = new ArrayList<Card>(track); Card o = c.remove(c.size()-1); 
                            track.clear(); track.addAll(c); return o;}
    public int oxygenRemaining(){int num = 0; for (Oxygen o : oxygens){num += o.getValue();} return num;}
    public Card peekAtTrack(){if(track.size() > 0){
                            List<Card> c = new ArrayList<Card>(track); return c.remove(c.size()-1);}
                            return null;}
    public Oxygen siphon(){return null;}
    public Card steal(){return null;}
    public void swapTrack(Astronaut swapee){}
}
 