package entities;

import java.util.List;
import java.util.Map;

public class Game {
    public List<Player> playerList;
    public Board board;
    public TurnContext turnContext;

    public Map<String,Token> playerToTokenMapping;
    public boolean isGameFinished;

    public int switchCurrentPlayer(int currentPlayerIndex){
        return (currentPlayerIndex + 1)%(playerList.size());
    }
}
