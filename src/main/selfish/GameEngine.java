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
private Random random;
private GameDeck gameDeck;
private GameDeck gameDiscard;
private SpaceDeck spaceDeck;
private SpaceDeck spaceDiscard;
final private static long serialVersionUID = 0;

private GameEngine(){}
public GameEngine(long seed, String gameDeck, String spaceDeck){
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
public int endTurn(){return 0;}
public boolean gameOver(){return false;}
public List<Astronaut> getAllPlayers(){
    List<Astronaut> p = new ArrayList<Astronaut>();
    for (Astronaut a : activePlayers){p.add(a);}
    if(corpses.size() != 0){
        for(Astronaut a : corpses){p.add(a);}
    }
    return p;}
public Astronaut getCurrentPlayer(){return currentPlayer;}
public int getFullPlayerCount(){return getAllPlayers().size();}
public GameDeck getGameDeck(){return null;}
public GameDeck getGameDiscard(){return null;}
public SpaceDeck getSpaceDeck(){return null;}
public SpaceDeck getSpaceDiscard(){return null;}
public Astronaut getWinner(){return null;}
public void killPlayer(Astronaut corpse){}
public static GameEngine loadState(String path){return null;}
public void mergeDecks(Deck deck1, Deck deck2){}
public void saveState(String path){}
public Oxygen[] splitOxygen(Oxygen dbl){return null;}
public void startGame(){}
public void startTurn(){}
public Card travel(Astronaut traveller){return null;}
}
