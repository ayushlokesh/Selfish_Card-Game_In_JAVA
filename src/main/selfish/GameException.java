package selfish;
/**
 * This class handles exceptions
 * 
 * @author Ayush
 * @version 1.0
 * @since 1.0
 */
public class GameException extends Exception{
    /**
     * This funtion throws exceptions
     * @param msg this is error message
     * @param e this is exception
     */
    public GameException(String msg, Throwable e){
        super(msg, e);
    }
    
    
}
