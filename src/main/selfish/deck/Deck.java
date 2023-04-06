package selfish.deck;

import java.io.*;
import java.util.*;


public abstract class Deck implements java.io.Serializable{
    
    private  Collection<Card> cards;
    final private long serialVersionUID = 0;
    protected Deck(){}

    protected static Card[] stringToCards(String str){
      String name = "", desc = "", data = "";            
      int i = 0;
      data = str;
      name = data.substring(0,data.indexOf(";"));
      data.replaceFirst((name + ";"), "");
      desc = data.substring(0, data.indexOf(";"));
      data.replaceFirst((desc + ";"), "");
      i = Integer.parseInt(String.valueOf(data.charAt(1)));
      Card[] cards = new Card[i];
      for (int j = 0; j < i; j++){
      cards[j] = new Card(name, desc);
      }
      return cards;}

    protected static ArrayList<Card> loadCards(String path){
        ArrayList<Card> c = new ArrayList<Card>();
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              Card[] cards = stringToCards(myReader.nextLine());
              for (Card card : cards){
                c.add(card);
              }
              
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("File not found.");
           
          } 
        return c;
    }

    public int add(Card card){return 0;}
    
    protected int add(ArrayList<Card> cards){return 0;}

    public Card draw(){return null;}
    
    public void shuffle(Random random){
      Collections.shuffle((List<?>)this.cards, random);
    }
    
    public int size(){return 0;}
    
    public void remove(Card card){}
    
}
