package exceptions;

public class DuplicateBook extends  Exception {
    public DuplicateBook(String message){
        super(message);
    }
}
