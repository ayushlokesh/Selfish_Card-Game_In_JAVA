package selfish.deck;

public class Card implements java.io.Serializable, Comparable<Card> {
    private String name;
    private String description;
    final private long serialVersionUID = 0;

    public Card(String name, String desc){
        this.name = name;
        this.description = description;
    }

    public Card(){}

    public String getDescription(){return "";}

    

    @Override
    public int compareTo(Card o) {
        return this.name.compareTo(o.name);
    }


    
}
