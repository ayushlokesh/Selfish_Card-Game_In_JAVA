package selfish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import selfish.deck.Card;
import selfish.deck.Deck;
import selfish.deck.GameDeck;
import selfish.deck.Oxygen;
import selfish.deck.SpaceDeck;

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
final private static long serialVersionUID = 0;

private GameEngine(){}
public GameEngine(long seed, String gameDeck, String spaceDeck){
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
public int addPlayer(String player){
    activePlayers.add(new Astronaut(player, this));
    return getFullPlayerCount();}
public int endTurn(){if(currentPlayer.isAlive()){activePlayers.add(currentPlayer);}
                    else{killPlayer(currentPlayer);}
                    if(!gameOver()){currentPlayer = null;}
                    return activePlayers.size();}
public boolean gameOver(){return (activePlayers.size() == 0 || currentPlayer.hasWon());}
public List<Astronaut> getAllPlayers(){
    List<Astronaut> p = new ArrayList<Astronaut>();
    for (Astronaut a : activePlayers){p.add(a);}
    if(corpses.size() != 0){
        for(Astronaut a : corpses){p.add(a);}
    }
    return p;}
public Astronaut getCurrentPlayer(){return currentPlayer;}
public int getFullPlayerCount(){return getAllPlayers().size();}
public GameDeck getGameDeck(){return gameDeck;}
public GameDeck getGameDiscard(){return gameDiscard;}
public SpaceDeck getSpaceDeck(){return spaceDeck;}
public SpaceDeck getSpaceDiscard(){return spaceDiscard;}
public Astronaut getWinner(){return null;}
public void killPlayer(Astronaut corpse){corpses.add(corpse);}
public static GameEngine loadState(String path){return null;}
public void mergeDecks(Deck deck1, Deck deck2){}
public void saveState(String path){}
public Oxygen[] splitOxygen(Oxygen dbl){return null;}
public void startGame(){{for (Astronaut a : activePlayers){a.addToHand(gameDeck.drawOxygen(2));
     a.addToHand(gameDeck.drawOxygen(1)); a.addToHand(gameDeck.drawOxygen(1)); a.addToHand(gameDeck.drawOxygen(1)); a.addToHand(gameDeck.drawOxygen(1));}}
     for (int i = 0; i < 4; i++){for (Astronaut a : activePlayers){a.addToHand(gameDeck.draw());}}
    hasStarted = true;}
public void startTurn(){if(hasStarted && currentPlayer == null){List<Astronaut> a = new ArrayList<Astronaut>(activePlayers); currentPlayer = a.remove(0);
    activePlayers.clear();activePlayers.addAll(a); }}
public Card travel(Astronaut traveller){traveller.hack("Oxygen(2)"); Card o = spaceDeck.draw(); if(!o.toString().equals("Gravitation anomaly")){traveller.addToTrack(o);}return o;}
}
