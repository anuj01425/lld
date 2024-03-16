import entities.Game;
import entities.TurnContext;

public class TakeTurnHandler implements LudoHandler{
    private LudoHandler ludoHandler;
    @Override
    public void handleRequest(TurnContext turnContext, Game game) {
        //get currentPlayer from turnContext;
        //roll the dice
        //set the dice value in turnContext as roll the dice value
        //check if the user is allowed to move a token (if the user token at rest and user roll a dice
        //as 6 set is allowed to move as true and pass it to next handler. Else set is as false and pass it to
        //next handler.
        //if the token is not initial position set. Pass it to next handler;
        handleNext(turnContext,game);
    }

    @Override
    public void setNextHandler(LudoHandler ludoHandler) {
        this.ludoHandler = ludoHandler;
    }

    private void handleNext(TurnContext turnContext, Game game){
         this.ludoHandler.handleRequest(turnContext,game);
    }
}
