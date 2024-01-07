package exceptions;

public class UserDoesntExist extends Exception {

    public UserDoesntExist(String message){
        super(message);
    }
}
