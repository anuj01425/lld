import constant.Type;
import dto.Identifier;
import exception.CustomException;

public class Main {
    public static void main(String[] args) throws CustomException, InterruptedException {
        TokenBucket tokenBucket = new TokenBucket(10, 10);
        for (int i = 0; i < 10000; i++) {
            System.out.println(tokenBucket.allowRequest(new Identifier(Type.USER_ID, "1"), 1));
        }
    }
}