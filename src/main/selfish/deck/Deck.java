package selfish.deck;

import java.io.*;
import java.util.*;
import java.util.Random;

import selfish.GameException;

/**
 * Represents Deck in the game.
 * 
 * @author Ayush
 * @version 1.0
 * @since 1.0
 */
public abstract class Deck implements java.io.Serializable{
    
    private Collection<Card> cards = new ArrayList<Card>();
    final private static long serialVersionUID = 0;
   /**
    * empty constructor
    */
    protected Deck(){}
/**
 * this is used to read cards
 * @param str line from file
 * @return card from line
 */
    protected static Card[] stringToCards(String str){
      String name = "", desc = "", data = "";            
      int i = 0;
      data = str;
      i = Integer.parseInt(String.valueOf(data.charAt(data.length()-1)));
      name = data.substring(0,data.indexOf(";"));
      data = data.replaceFirst((name + "; "), "");
      desc = data.substring(0, data.indexOf(";"));
      data = data.replaceFirst((desc + ";"), "");
      // i = Integer.parseInt(String.valueOf(data.charAt(1)));
      Card[] cards = new Card[i];
      for (int j = 0; j < i; j++){
      cards[j] = new Card(name, desc);
      }
      return cards;}
/**
 * loads cards in deck
 * @param path file path for cards
 * @return filled deck
 * @throws GameException gives error
 */
    protected static List<Card> loadCards(String path) throws GameException{
        
        List<Card> c = new ArrayList<Card>();
        if (path.equals("")){return c;}
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            String line;
            while (myReader.hasNextLine()) {
              line = myReader.nextLine();
              if(line.equals("NAME; DESCRIPTION; QUANTITY"))
              {continue;}
              Card[] cards = stringToCards(line);
              for (Card card : cards){
                c.add(card);
              }
              
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            throw new GameException("File not Found", new FileNotFoundException());
            
           
          } 
        return c;
    }
/**
 * adds card to deck
 * @param card takes card
 * @return return deck size
 */
    public int add(Card card){
      cards.add(card);
      return cards.size();}
  /**
   * add a list of cards
   * @param cards takes a list of cards
   * @return deck size
   */
    protected int add(List<Card> cards){
      if (cards == null){return 0;}
      for (Card card : cards){this.cards.add(card);}
      return this.cards.size();
    }
/**
 * draws card
 * @return drawn card
 */
    public Card draw(){
      try{
      Card card1 = ((List<Card>)cards).get(cards.size()-1);
      cards.remove(card1);
      return card1;}
      catch(IndexOutOfBoundsException e){throw new IllegalStateException();}
    }
/**
 * shuffles deck
 * @param random random object
 */
    public void shuffle(Random random){
      Collections.shuffle((List<Card>)this.cards, random);
    }
/**
 * size of deck
 * @return return size of deck
 */
    public int size(){return cards.size();}
/**
 * removes a card from deck
 * @param card take card to be removed
 */
    public void remove(Card card){
      for (Card c : cards){
        if (c == card){cards.remove(card); break;}
      }
      
    }

    

}
