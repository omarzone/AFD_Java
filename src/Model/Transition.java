package Model;


public class Transition {

    private int currentState;
    private String symbol;
    private int nextState;

    
    public Transition(){

    }

    public Transition(int currentState, String symbol, int nextState) {
        this.currentState = currentState;
        this.symbol = symbol;
        this.nextState = nextState;
    }

    public int getCurrentState() {
        return currentState;
    }
    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public int getNextState() {
        return nextState;
    }
    public void setNexState(int nexState) {
        this.nextState = nexState;
    }

    

}