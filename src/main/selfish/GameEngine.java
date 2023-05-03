package selfish;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import selfish.deck.Card;
import selfish.deck.Deck;
import selfish.deck.GameDeck;
import selfish.deck.Oxygen;
import selfish.deck.SpaceDeck;
/**
 * Represents Astronaut in the game.
 * 
 * @author Ayush
 * @version 1.0
 * @since 1.0
 */
public class GameEngine implements java.io.Serializable{

private Collection<Astronaut> activePlayers; 
private List<Astronaut> corpses;
private Astronaut currentPlayer;
private boolean hasStarted = false;
private Random random = new Random();
private GameDeck gameDeck;
private GameDeck gameDiscard;
private SpaceDeck spaceDeck;
private SpaceDeck spaceDiscard;
private static final long serialVersionUID = 0;

private GameEngine(){}
/**
 * kz.fg
 * @param seed kjharejnv
 * @param gameDeck krgslkf
 * @param spaceDeck kjdhf
 * @throws GameException kfhskjf
 */
public GameEngine(long seed, String gameDeck, String spaceDeck) throws GameException{
    random.setSeed(seed);
    this.gameDeck = new GameDeck(gameDeck);
    this.spaceDeck = new SpaceDeck(spaceDeck);
    spaceDiscard = new SpaceDeck();
    gameDiscard = new GameDeck();
    this.gameDeck.shuffle(random);
    this.spaceDeck.shuffle(random);
    this.activePlayers = new ArrayList<Astronaut>();
    this.corpses = new ArrayList<Astronaut>();
}
/**
 * 
 * @param player
 * @return
 */
public int addPlayer(String player){if (hasStarted){throw new IllegalStateException("jhbdfhiabv");}
    if(activePlayers.size() == 5){throw new IllegalStateException("jhbdfhiabv");}
    activePlayers.add(new Astronaut(player, this));
    return getFullPlayerCount();}
public int endTurn(){if(currentPlayer.isAlive()){activePlayers.add(currentPlayer);}
                    // else{killPlayer(currentPlayer);}
                    if(!gameOver()){currentPlayer = null;}
                    return activePlayers.size();}
public boolean gameOver(){if(currentPlayer == null){return false;} return (activePlayers.size() == 0 || currentPlayer.hasWon());}
public List<Astronaut> getAllPlayers(){
    List<Astronaut> p = new ArrayList<Astronaut>();
    for (Astronaut a : activePlayers){p.add(a);}
    if(corpses.size() != 0){
        for(Astronaut a : corpses){p.add(a);}
    } if (currentPlayer != null && currentPlayer.isAlive()){Astronaut a = currentPlayer; p.add(a);}
    return p;}
public Astronaut getCurrentPlayer(){return currentPlayer;}
public int getFullPlayerCount(){return getAllPlayers().size();}
public GameDeck getGameDeck(){return gameDeck;}
public GameDeck getGameDiscard(){return gameDiscard;}
public SpaceDeck getSpaceDeck(){return spaceDeck;}
public SpaceDeck getSpaceDiscard(){return spaceDiscard;}
public Astronaut getWinner(){Astronaut p = null; for(Astronaut o : activePlayers){if(o.hasWon()){p = o;}}
    return p;}
public void killPlayer(Astronaut corpse){corpses.add(corpse);}
public static GameEngine loadState(String path) throws GameException{ GameEngine p = null;
    try {
        FileInputStream fileIn = new FileInputStream(path);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        p = (GameEngine) objectIn.readObject();
        objectIn.close();
        fileIn.close();
    } catch (Exception e) {
        System.out.println("An error occurred: " );
        throw new GameException(path, e);
    }
    return p;}
public void mergeDecks(Deck deck1, Deck deck2){while(deck2.size() > 0){deck1.add(deck2.draw());}}
public void saveState(String path){
    try {
        FileOutputStream fileOut = new FileOutputStream(path);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(this);
        objectOut.close();
        fileOut.close();
    } catch (Exception e) {
        System.out.println("An error occurred: ");
    }
}
public Oxygen[] splitOxygen(Oxygen dbl){if ((this.gameDiscard.size() == 0 && this.gameDeck.size() == 1)
|| (this.gameDiscard.size() == 1 && this.gameDeck.size() == 0)) {
throw new IllegalStateException();
}
    List<Card> c = new ArrayList<Card>(); int count = 0; Oxygen[] o = new Oxygen[2];
    while(count < 2 && gameDeck.size() > 0){
        c.add(gameDeck.draw()); 
        if (c.get(c.size()-1).toString().equals("Oxygen(1)")){count++; 
            if(count == 1){o[0] = (Oxygen)c.remove(c.size()-1);}
            else{o[0] = (Oxygen)c.remove(c.size()-1);}}}
    for (int i = c.size()-1; i >= 0; i--){gameDeck.add(c.remove(i));}
    while(count < 2 && gameDiscard.size() > 0){c.add(gameDiscard.draw()); 
        if (c.get(c.size()-1).toString().equals("Oxygen(1)")){count++; 
            if(count == 1){o[0] = (Oxygen)c.remove(c.size()-1);}
            else{o[0] = (Oxygen)c.remove(c.size()-1);}}}    
    for (int i = c.size()-1; i >= 0; i--){gameDiscard.add(c.remove(i));}
        if (count == 2){gameDeck.remove(dbl); gameDiscard.add(dbl); return o;}
    return null;}
public void startGame(){if (hasStarted || activePlayers.size() == 1 || activePlayers.size() == 6) {
    throw new IllegalStateException();}
    {for (Astronaut a : activePlayers){a.addToHand(gameDeck.drawOxygen(2));
     a.addToHand(gameDeck.drawOxygen(1)); a.addToHand(gameDeck.drawOxygen(1)); a.addToHand(gameDeck.drawOxygen(1)); a.addToHand(gameDeck.drawOxygen(1));}}
     for (int i = 0; i < 4; i++){for (Astronaut a : activePlayers){a.addToHand(gameDeck.draw());}}
    hasStarted = true;}
public void startTurn(){if (activePlayers.size() == 0 || hasStarted == false || currentPlayer != null || getWinner() != null) {
    throw new IllegalStateException();}
    if(hasStarted && currentPlayer == null){List<Astronaut> a = new ArrayList<Astronaut>(activePlayers); 
        currentPlayer = a.remove(0);
    activePlayers.clear();activePlayers.addAll(a); }}
public Card travel(Astronaut traveller){
    if (traveller.oxygenRemaining() <= 1) {
        throw new IllegalStateException();}
        //remove2ones
        traveller.breathe(); traveller.breathe(); Card o = spaceDeck.draw(); if(!(o.toString().equals("Gravitational anomaly"))){traveller.addToTrack(o);}return o;}
}
