package selfish.deck;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    
    
    protected Deck(){}

    protected Card[] stringToCards(){return null;}

    protected ArrayList<Card> loadCards(String path){
        return null;
    }

    public int add(Card card){return 0;}
    
    protected int add(ArrayList<Card> cards){return 0;}

    public Card draw(){return null;}
    
    public void shuffle(Random random){}
    
    public int size(){return 0;}
    
    public void remove(Card card){}
    
}
