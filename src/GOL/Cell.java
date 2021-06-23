package GOL;

import java.io.Serializable;
import java.util.Random;

enum State{
    ALIVE, DEAD
}

public class Cell implements Serializable {
    private final int row;
    private final int col;
    private State previousState;
    private State nextState;

    public Cell(int row, int col) {
        this.col = col;
        this.row = row;

        /* test init
        if ((this.row%7 == 0 || this.row == 50 || this.row == 51)
                && (this.col%4 == 0 || this.col == 50 || this.col == 51))
        this.nextState = State.ALIVE;
         */

        boolean alive = new Random().nextBoolean();
        if (alive) this.nextState = State.ALIVE;
        else this.nextState = State.DEAD;
    }

    public Cell checkNegative(int row, int col) {
        int size = start.getCellArr().length;
        boolean niePrzechodzi = false;
        if (niePrzechodzi){
            if (col < 0 || row < 0 || col > size - 1 ||
                    row > size - 1)
                return null;
            else return start.getCellArr()[row][col];

        }else {
            int newRow, newCol;
            if (row == -1) newRow = size-1;
            else if (row == size) newRow = 0;
            else newRow = row;
            if (col == -1) newCol = size-1;
            else if (col == size) newCol = 0;
            else newCol = col;
            return start.getCellArr()[newRow][newCol];
        }
    }

    public Integer checkNeighbors() {
        int aliveNeighbors = 0;
        Cell [] neighbours = new Cell[8];

        neighbours[0] = checkNegative(row, col - 1); //top
        neighbours[1] = checkNegative(row + 1, col); //right
        neighbours[2] = checkNegative(row, col + 1); //bottom
        neighbours[3] = checkNegative(row - 1, col); // left
        neighbours[4] = checkNegative(row + 1, col - 1); // topRight
        neighbours[5] = checkNegative(row - 1, col - 1); // topLeft
        neighbours[6] = checkNegative(row + 1, col + 1); // bottomRight
        neighbours[7] = checkNegative(row - 1, col + 1); // bottomLeft

        for (Cell neighbour: neighbours){
            if (neighbour != null && neighbour.getPreviousState()==State.ALIVE) aliveNeighbors++;
        }
        return aliveNeighbors;
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

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}