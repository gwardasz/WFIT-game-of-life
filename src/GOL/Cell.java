package GOL;

import java.util.ArrayList;
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


    public Cell(int row, int col) {
        this.col = col;
        this.row = row;
        //Random random = new Random();
        //this.colour = String.valueOf(random.nextInt(colours.length));
        this.colour = colours[(int) (Math.random() * colours.length)];
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


        if (top != null && top.getColour().equals("white")) {
            neighbors.add(top);

        }
        if (right != null && right.getColour().equals("white")) {
            neighbors.add(right);

        }
        if (bottom != null && bottom.getColour().equals("white")) {
            neighbors.add(top);

        }
        if (left != null && left.getColour().equals("white")) {
            neighbors.add(top);

        }
        if (topright != null && topright.getColour().equals("white")) {
            neighbors.add(top);

        }
        if (topleft != null && topleft.getColour().equals("white")) {
            neighbors.add(right);

        }
        if (bottomright != null && bottomright.getColour().equals("white")) {
            neighbors.add(top);

        }
        if (bottomleft != null && bottomleft.getColour().equals("white")) {
            neighbors.add(top);

        }
        return neighbors.size();
    }







}
