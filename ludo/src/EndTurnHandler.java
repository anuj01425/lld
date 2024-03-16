import entities.Game;
import entities.TurnContext;

public class EndTurnHandler implements LudoHandler{
    private LudoHandler ludoHandler;

    @Override
    public void handleRequest(TurnContext turnContext, Game game) {
        //get the currentplayer index
        //check if game is finished. If yes the currentplayer has won. set the status in game as won.
        //
        //if the user has cut the opponents, don't change the turn.
        //if not get the next player from game. change the turn.
        //this endturn handler will end the chain and go back to ludocontroller.
    }

    @Override
    public void setNextHandler(LudoHandler ludoHandler) {
       this.ludoHandler=null;
    }
}
