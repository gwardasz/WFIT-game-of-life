package GOL;

import java.util.Random;

enum State{
    ALIVE, DEAD
}
public class Cell {
    private final int row;
    private final int col;
    private State previousState;
    private State nextState;


    public Cell(int row, int col) {
        this.col = col;
        this.row = row;
        /*
        if ((this.row == 39 || this.row == 40 || this.row == 41)
                && (this.col == 39 || this.col == 40 || this.col == 41))
        this.nextState = State.ALIVE;
         */
        boolean alive = new Random().nextBoolean();
        if (alive) this.nextState = State.ALIVE;
        else this.nextState = State.DEAD;



    }
    public Cell checkNegative(int row, int col, Cell[][] cellArr) {
        if (col < 0 || row < 0 || col > cellArr.length - 1 || row > cellArr.length - 1) {
            return null;
        } else {
            return cellArr[row][col];

        }
    }
    public Integer checkNeighbors(Cell[][] cellArr) {
        int aliveNeighbors = 0;
        Cell [] neighbours = new Cell[8];

        neighbours[0] = checkNegative(row, col - 1, cellArr); //top
        neighbours[1] = checkNegative(row + 1, col, cellArr); //right
        neighbours[2] = checkNegative(row, col + 1, cellArr); //bottom
        neighbours[3] = checkNegative(row - 1, col, cellArr); // left
        neighbours[4] = checkNegative(row + 1, col - 1, cellArr); // topRight
        neighbours[5] = checkNegative(row - 1, col - 1, cellArr); // topLeft
        neighbours[6] = checkNegative(row + 1, col + 1, cellArr); // bottomRight
        neighbours[7] = checkNegative(row - 1, col + 1, cellArr); // bottomLeft

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
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
