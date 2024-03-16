import entities.Game;
import entities.TurnContext;

public class MoveTokenHandler implements LudoHandler{

    private LudoHandler ludoHandler;
    @Override
    public void handleRequest(TurnContext turnContext, Game game) {
        //if user can move the token
        //calculate the new position of token and update in turncontext and update the game
        handleNext(turnContext,game);
    }

    @Override
    public void setNextHandler(LudoHandler ludoHandler) {
       this.ludoHandler=ludoHandler;
    }

    private void handleNext(TurnContext turnContext, Game game){
        this.ludoHandler.handleRequest(turnContext,game);
    }




}
