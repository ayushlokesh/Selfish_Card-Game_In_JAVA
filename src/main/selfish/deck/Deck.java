package selfish.deck;

import java.io.*;
import java.util.*;

public class Deck {
    
    
    protected Deck(){}

    protected Card[] stringToCards(){return null;}

    protected ArrayList<Card> loadCards(String path){
        ArrayList<Card> c = new ArrayList<Card>();
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            String name = "", desc = "", data = ""; 
            
            int i = 0;
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
              name = data.substring(0,data.indexOf(";"));
              data.replaceFirst((name + ";"), "");
              desc = data.substring(0, data.indexOf(";"));
              data.replaceFirst((desc + ";"), "");
              i = Integer.parseInt(String.valueOf(data.charAt(1)));
              for (int j = 0; j < i; j++){
              c.add(new Card(name, desc));  
            }}
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
