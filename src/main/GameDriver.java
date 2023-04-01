import java.io.*;
import java.util.Scanner;

public class GameDriver {

    /**
     * A helper function to centre text in a longer String.
     * @param width The length of the return String.
     * @param s The text to centre.
     * @return A longer string with the specified text centred.
     */
    public static String centreString (int width, String s) {
        return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }

    public GameDriver() {
    }

    public static void main(String[] args)  {
        try {
            File myObj = new File("../../io/art.txt");
            Scanner myReader = new Scanner(myObj);  
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              System.out.println(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("File not found.");
           
          } 
        Scanner input = new Scanner(System.in);
        String[] names = {"", "", "", "", ""};
        int count = 2;
        System.out.print("Player 1 name? ");
        names[0] = input.nextLine();
        System.out.println();
        System.out.print("Player 2 name? "); 
        names[1] = input.nextLine();
        System.out.println();
        for (int i = 2; i < 5; i++){
            System.out.print("Add another? [Y]es / [N]o ");
            System.out.println();
            if (input.nextLine().toUpperCase().equals("N")){break;}
            else {System.out.print("Player "+(i+1)+" name? ");
                   count++; names[i] = input.nextLine();}
        }System.out.print("After a dazzling (but boomed) space mission, ");
        for (int i = 0; i < count-2; i++){
            System.out.print(names[i]+", ");
        }
        System.out.print(names[count-2]+" and "+names[count-1]+" are floating in space and their Oxygen supplies are runing low.\nOnly the first back to the ship will survive!");
    
    
        
    
    
    
    }

}