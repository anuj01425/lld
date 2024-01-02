import dto.Identifier;
import exception.CustomException;

public interface RateLimit {
    public void allow_request(Identifier identifier, int token_count) throws CustomException;
}
