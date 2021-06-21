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
        Random random = new Random();
        this.colour = String.valueOf(random.nextInt(colours.length));
    }
}
