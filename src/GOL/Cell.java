package GOL;

import java.util.Random;

public class Cell {
    private int row;

    public String getColour() {
        return colour;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    private int col;
    private String colour;
    private String[] colours = {"white", "black"};
    private State previousState;
    private State nextState;



    public Cell(int row, int col) {
        this.col = col;
        this.row = row;
        Random random = new Random();
        this.colour = String.valueOf(random.nextInt(colours.length));
        if (this.colour.equals("1")){
            this.nextState = State.ALIVE;
            //this.previousState = State.ALIVE;//

        }
        else{
            this.nextState = State.DEAD;
            //this.previousState = State.DEAD; //
        }
    }

    public State getPreviousState() {
        return previousState;
    }

    public void setPreviousState(State previousState) {
        this.previousState = previousState;
    }

    public State getNextState() {
        return nextState;
    }

    public void setNextState(State nextState) {
        this.nextState = nextState;
    }
}
