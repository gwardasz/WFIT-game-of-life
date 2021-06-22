package GOL;

import java.util.ArrayList;
import java.util.Random;

enum State{
    ALIVE, DEAD
}
public class Cell {
    private int row;
    private int col;
    private State previousState;
    private State nextState;
    private final boolean alive = new Random().nextBoolean();


    public Cell(int row, int col) {
        this.col = col;
        this.row = row;
        /*
        if ((this.row == 39 || this.row == 40 || this.row == 41)
                && (this.col == 39 || this.col == 40 || this.col == 41))
        this.nextState = State.ALIVE;
         */
        if (alive) this.nextState = State.ALIVE;
        else this.nextState = State.DEAD;



    }
    public Cell checkNegative(int row, int col, Cell[][] celllist) {
        if (col < 0 || row < 0 || col > celllist.length - 1 || row > celllist.length - 1) {
            return null;
        } else {
            return celllist[row][col];

        }
    }
    public Integer checkNeighbors(Cell[][] celllist) {
        ArrayList<Cell> neighbors = new ArrayList<>();
        Cell top = checkNegative(row, col - 1, celllist);

        Cell right = checkNegative(row + 1, col, celllist);

        Cell bottom = checkNegative(row, col + 1, celllist);

        Cell left = checkNegative(row - 1, col, celllist);

        Cell topright = checkNegative(row + 1, col - 1, celllist);

        Cell topleft = checkNegative(row - 1, col - 1, celllist);

        Cell bottomright = checkNegative(row + 1, col + 1, celllist);

        Cell bottomleft = checkNegative(row - 1, col + 1, celllist);


        if (top != null && top.getPreviousState()== State.ALIVE) {
            neighbors.add(top);

        }
        if (right != null && right.getPreviousState()== State.ALIVE) {
            neighbors.add(right);

        }
        if (bottom != null && bottom.getPreviousState()== State.ALIVE) {
            neighbors.add(bottom);

        }
        if (left != null && left.getPreviousState()== State.ALIVE) {
            neighbors.add(left);

        }
        if (topright != null && topright.getPreviousState()== State.ALIVE) {
            neighbors.add(topright);

        }
        if (topleft != null && topleft.getPreviousState()== State.ALIVE) {
            neighbors.add(topleft);

        }
        if (bottomright != null && bottomright.getPreviousState()== State.ALIVE) {
            neighbors.add(bottomright);

        }
        if (bottomleft != null && bottomleft.getPreviousState()== State.ALIVE) {
            neighbors.add(bottomleft);

        }
        return neighbors.size();
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
