import entities.Game;
import entities.TurnContext;

public class CaptureTokenHandler implements LudoHandler{
    private LudoHandler ludoHandler;
    @Override
    public void handleRequest(TurnContext turnContext, Game game) {
        //if the user has moved the token
        //get the position of the token and all the opponents from the game
        //if captured set the captured info in turncontext and pass to next handler
    }

    @Override
    public void setNextHandler(LudoHandler ludoHandler) {
       this.ludoHandler = ludoHandler;
    }

    private void handleNext(TurnContext turnContext, Game game){
        this.ludoHandler.handleRequest(turnContext,game);
    }
}
