package selfish.deck;

import java.io.*;
import java.util.*;

public class Deck {
    
    
    protected Deck(){}

    protected Card[] stringToCards(String str){
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
      cards[i] = new Card(name, desc);
      return cards;}

    protected ArrayList<Card> loadCards(String path){
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
    
    public void shuffle(Random random){}
    
    public int size(){return 0;}
    
    public void remove(Card card){}
    
}
