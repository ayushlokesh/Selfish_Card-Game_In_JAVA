package selfish.deck;

public class Oxygen extends Card{

    private int value;

    final private static long serialVersionUID = 0;

    public Oxygen(int i){
        this.value = i;
    }

    public int getValue(){return value;}

    @ Override
    public String toString(){return "Oxygen(" + this.value + ")"; }

    // @ Override
    // public int compareTo(Card o) {
    //     if (o instanceof Oxygen)
    //     return this.toString().compareTo(o.toString());
    // }
    
}
