package entities;

public class TurnContext {
    public int currentPlayerIndex;
    public boolean isAllowedToMove;
    public int lastDiceRolled;

    public Token lastMovedToken;

    public boolean hasCaptured;
}
