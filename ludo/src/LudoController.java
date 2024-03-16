import entities.Game;
import entities.TurnContext;

import java.util.ArrayList;

public class LudoController {
    public Game game;
    public TurnContext turnContext;
    public LudoHandler ludoHandler;
    public boolean gameFinished;
    public LudoController(int players){
        TurnContext turnContext1 = new TurnContext();
        turnContext1.currentPlayerIndex=0;
        turnContext1.isAllowedToMove=false;
        this.turnContext=turnContext1;
        Game game1 = new Game();
        game1.playerList = new ArrayList<>(players);
        game1.turnContext=turnContext1;
        game1.isGameFinished=false;
        //other logic of creating the board etc
        this.ludoHandler = new TakeTurnHandler();
    }
    public void createChain(){
        //create the chain of handler;
        this.ludoHandler = new TakeTurnHandler();
        LudoHandler ludoHandler1 = new MoveTokenHandler();
        LudoHandler ludoHandler2 = new CaptureTokenHandler();
        this.ludoHandler.setNextHandler(ludoHandler1);
        ludoHandler1.setNextHandler(ludoHandler2);
        ludoHandler2.setNextHandler(new EndTurnHandler());
    }


    public void takeTurn(){
        while(!game.isGameFinished){
            ludoHandler.handleRequest(turnContext,game);
        }
    }
}
