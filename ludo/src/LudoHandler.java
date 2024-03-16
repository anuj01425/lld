import entities.Game;
import entities.TurnContext;

public interface LudoHandler {
    public void handleRequest(TurnContext turnContext, Game game);
    public void setNextHandler(LudoHandler ludoHandler);
}
