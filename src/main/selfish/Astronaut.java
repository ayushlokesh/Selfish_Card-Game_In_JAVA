package selfish;
import java.util.*;

import selfish.deck.*;

/**
 * Represents Astronaut in the game.
 * 
 * @author Ayush
 * @version 1.0
 * @since 1.0
 */
public class Astronaut implements java.io.Serializable {
    private String name;
    private GameEngine game;
    final private static long serialVersionUID = 0;
    private Collection<Card> track;
    private List<Oxygen> oxygens;
    private List<Card> actions;

    /**
     * lvha;roehvreovb
     */
    public String toString(){if(this.isAlive()){return name;} return this.name + " (is dead)"; }
    /**
     * jkbdvabvaorebnreb
     * @param name .djva;erbhoabhrog
     * @param game vha;reiherahg;aeo
     */
    public Astronaut(String name, GameEngine game){
        this.name = name;
        this.game = game;
        oxygens = new ArrayList<Oxygen>();
        actions = new ArrayList<Card>();
        track = new ArrayList<Card>();
    }
/**
 * .dvsavhboareibaoer
 * @param card vh;devhr;hroeha
 */
    public void addToHand(Card card){if (card instanceof Oxygen){oxygens.add((Oxygen)card);}
                                     else {actions.add(card); }}
/**
 * cjD:Svh;afhbe
 * @param card dvhweivu beraihg
 */
    public void addToTrack(Card card){track.add(card);}
/**
 * askvglaivgrbe
 * @return dhvaeow;erghrw
 */
    public int breathe(){for (int i = 0; i < oxygens.size(); i++){
                        if (oxygens.get(i).getValue() == 1){game.getGameDiscard().add(oxygens.remove(i));if(oxygenRemaining() == 0){game.killPlayer(this);}  return oxygenRemaining();}}
                        game.getGameDiscard().add(oxygens.remove(oxygens.size()-1)); oxygens.add(new Oxygen(1));
                        return oxygenRemaining();}
/**
 * jdsavh;aorhgov
 * @return ahfv;weohvRVH
 */
    public int distanceFromShip(){return (6 - track.size());}
    /**
     * lhdv;owehgven
     * @return ;fhv;ewvbera;ugbhreg
     */
    public List<Card> getActions(){List<Card> c = new ArrayList<Card>(actions); Collections.sort(c);return c;}
    /**
     * V;RVHRO;EIHBVERAOHGRE
     * @param enumerated AKVG;EWOHGVEROHGOEHG
     * @param excludeShields CGEwgveugfEGEHV
     * @return VGgvwgevwevrgbvr
     */
    public String getActionsStr(boolean enumerated, boolean excludeShields){
    String s = "";List<Card> c = getActions(); c.add(new Card("jsdbc", "dgcv"));
    String a = "ABCDEFGHIJKLMNOPQ";int count = 0; String s1 = c.get(0).toString();
    if(c.size() > 1){if(!enumerated && !excludeShields){
         for (int i = 0; i < c.size(); i++){
            if(s1.equals(c.get(i).toString())){count++;}
            else{
                if(count == 1 || count == 0){s += s1+", ";s1 = c.get(i).toString();}
                else{ s += count+"x "+s1+", ";s1 = c.get(i).toString();} 
                count = 1;}}}
    else if(!enumerated && excludeShields){
        s1 = null; 
        for (Card o : c){if(!(o.toString().equals("Shield"))){s1 = o.toString(); break;}}
        for (int i = 0; i < c.size(); i++){
            if(!(c.get(i).toString().equals("Shield"))){
                if(s1.equals(c.get(i).toString())){count++;}else{
                    if(count == 1 || count == 0){s += s1+", ";s1 = c.get(i).toString();}
                    else{ s += count+"x "+s1+", ";s1 = c.get(i).toString();}
                     count = 0;}}}}
    else if(enumerated && excludeShields){
        int i = 0; s1 = null; 
        for (Card o : c){if(!(o.toString().equals("Shield"))){s1 = o.toString(); break;}}
        for (Card o : c){
            if(!(o.toString().equals("Shield"))){

                if(s1.equals(o.toString())){count++;}
                else{s += "["+a.charAt(i)+"] "+s1+", "; i++;s1 = o.toString();}}}}
            
    else if(enumerated && !excludeShields){
        int i = 0;
        for (Card o : c){
            {if((s1.equals(o.toString()))){count++;}
            else{s += "["+a.charAt(i)+"] "+s1+", ";
             s1 = null;
              s1 = o.toString();
               i++;}}}}}
    String res = "";
    if (s.length() > 0 && (s.trim()).charAt(s.length()-2) == ','){res += (s.trim()).substring(0, s.length()-2);}
    return res;}
    /**
     * .ajdsvbawrvbR
     * @return ADSVHw;vhrowhv
     */
    public List<Card> getHand(){List<Card> c = new ArrayList<Card>();
                                c.addAll(actions); c.addAll(oxygens); Collections.sort(c);
                                return c;}
    public String getHandStr(){List<Card> cards = this.getHand();
        String ans = "";
        int ones = 0;
        int doubles = 0;
        for (Card card : cards) {
            if (card instanceof Oxygen && ((Oxygen) (card)).getValue() == 1) {
                ones++;
            } else if (card instanceof Oxygen && ((Oxygen) (card)).getValue() == 2) {
                doubles++;
            } else {
                ans += card.toString();
            }
        }
        String twos = "";
        String singles = "";
        if (doubles > 1) {
            twos += doubles + "x " + "Oxygen(2), ";
        } else if (doubles == 1 && ones > 0) {
            twos += "Oxygen(2), ";
        } else if (doubles == 1 && ones == 0) {
            twos += "Oxygen(2)";
        }

        if (ones > 1) {
            singles += ones + "x " + "Oxygen(1); ";
        }
        if (ones == 1) {
            singles += "Oxygen(1); ";
        }
        return (twos + singles + ans);
}
    public Collection<Card> getTrack(){Collection<Card> c = new ArrayList<Card>(track); return c;}
    public void hack(Card card){if (card == null){throw new IllegalArgumentException();}
        boolean fnd = false;
        if (card instanceof Oxygen){
                                for (int i = 0; i < oxygens.size(); i++){
                                    if (oxygens.get(i).getValue() == ((Oxygen)card).getValue()){fnd = true; oxygens.remove(i); break;}}}
                                else {for (int i = 0; i < actions.size(); i++){
                                    if (actions.get(i).equals(card)){fnd = true; actions.remove(i); break;}}}
                                if(!fnd){throw new IllegalArgumentException();}
                                if (oxygenRemaining() == 0){game.killPlayer(this); actions.clear();} }
    public Card hack(String card) {if (card == null){throw new IllegalArgumentException();}
        boolean fnd = false;
        Card c = new Card(); if (card.equals("Oxygen(1)") || card.equals("Oxygen(2)")){
                                for (int i = 0; i < oxygens.size(); i++){
                                    if (oxygens.get(i).toString().equals(card)){ fnd = true;c = oxygens.remove(i); break;}}}
                                else {for (int i = 0; i < actions.size(); i++){
                                    if (actions.get(i).toString() == card){fnd = true;c = actions.remove(i); break;}}}
                                    if (oxygenRemaining() == 0){actions.clear(); game.killPlayer(this);}
                                    if (!fnd){throw new IllegalArgumentException();}
                                    return c;
                                }
    public int hasCard(String card){int num = 0; List<Card> c = getHand();
                                    for (Card o : c){if (card.equals(o.toString())){num++;}}      
                                    return num;}
    public boolean hasMeltedEyeballs(){List<Card> action = new ArrayList<Card>(track); if (action.size() == 0){return false;} return (action.get(action.size()-1).toString() == "Solar flare");}
    public boolean hasWon(){return (distanceFromShip() == 0 && isAlive());}
    public boolean isAlive(){if (oxygens.size() == 0){return false;} return true;}
    public Card laserBlast(){try {List<Card> c = new ArrayList<Card>(track); Card o = c.remove(c.size()-1); 
                            track.clear(); track.addAll(c); return o;}
                        catch(IndexOutOfBoundsException e){throw new IllegalArgumentException();}}
    public int oxygenRemaining(){int num = 0; for (Oxygen o : oxygens){num += o.getValue();} return num;}
    public Card peekAtTrack(){if(track.size() > 0){
                            List<Card> c = new ArrayList<Card>(track); return c.remove(c.size()-1);}
                            return null;}
    public Oxygen siphon(){Oxygen o; for (int i = 0; i < oxygens.size(); i++){
        if (oxygens.get(i).getValue() == 1){o = oxygens.remove(i);if(oxygenRemaining() == 0){game.killPlayer(this);}return o;}}
        o = new Oxygen(1); oxygens.remove(oxygens.size()-1); oxygens.add(new Oxygen(1)); return o;}
    public Card steal(){List<Card> c = getHand(); 
        Random r = new Random(); int i = r.nextInt(c.size()); Card o = c.get(i);
    if (o instanceof Oxygen){for (int j = 0; j < oxygens.size(); j++){if(o.equals(oxygens.get(j)))oxygens.remove(j); if(oxygenRemaining() == 0){game.killPlayer(this);}}}
    else {for (int j = 0; j < actions.size(); j++){if(o.equals(actions.get(j)))actions.remove(j);}} return o;}
    public void swapTrack(Astronaut swapee){List<Card> c = new ArrayList<>(this.track); this.track = swapee.track; swapee.track = c;}
}
 