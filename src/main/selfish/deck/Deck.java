package selfish.deck;

import java.io.*;
import java.util.*;


public abstract class Deck implements java.io.Serializable{
    
    private Collection<Card> cards = new ArrayList<Card>();
    final private static long serialVersionUID = 0;
    protected Deck(){}

    protected static Card[] stringToCards(String str){
      String name = "", desc = "", data = "";            
      int i = 0;
      data = str;
      name = data.substring(0,data.indexOf(";"));
      data = data.replaceFirst((name + "; "), "");
      desc = data.substring(0, data.indexOf(";"));
      data = data.replaceFirst((desc + ";"), "");
      i = Integer.parseInt(String.valueOf(data.charAt(1)));
      Card[] cards = new Card[i];
      for (int j = 0; j < i; j++){
      cards[j] = new Card(name, desc);
      }
      return cards;}

    protected static List<Card> loadCards(String path){
        
        List<Card> c = new ArrayList<Card>();
        if (path.equals("")){return null;}
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
            System.out.println("File not found.");
           
          } 
        return c;
    }

    public int add(Card card){
      cards.add(card);
      return cards.size();}
    
    protected int add(List<Card> cards){
      if (cards == null){return 0;}
      this.cards.addAll(cards);
      return cards.size();
    }

    public Card draw(){
      Card card1 = ((List<Card>)cards).get(cards.size()-1);
      cards.remove(card1);
      return card1;}
    
    public void shuffle(Random random){
      Collections.shuffle((List<Card>)this.cards, random);
    }
    
    public int size(){return 0;}
    
    public void remove(Card card){
      for (Card c : cards){
        if (c == card){cards.remove(card); break;}
      }
      
    }

    
public static void main(String[] args){
  List<Card> cards1 = loadCards("io/SpaceCards.txt");
  System.out.print(cards1.size());
}
}
