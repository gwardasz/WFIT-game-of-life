package GOL;

import javax.swing.*;
import java.awt.*;

public class start {
    private final JFrame frame;
    private static Cell[][] cellArr;
    public final int size = 100;

    public static Cell[][] getCellArr() {
        return cellArr;
    }

    public start() {
        frame = new JFrame();
        frame.setSize(915, 937);
        cellArr = new Cell[size][size];
        createCanvas();
        frame.add(new grid(), BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Game of life");
        frame.setVisible(true);
    }

    class grid extends JPanel {
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            int value = 990 / size;

            for (int y = 0; y < size; y++) {
                for (int x = 0; x < size; x++) {

                    if (cellArr[y][x].getNextState()== State.ALIVE) {
                        g.setColor(Color.white);
                    } else {
                        g.setColor(Color.black);
                    }
                    g.fillRect(value * cellArr[y][x].getCol(), value * cellArr[y][x].getRow(), value, value);
                    cellArr[y][x].setPreviousState(cellArr[y][x].getNextState());
                }
            }
            try {
                Thread.sleep(15);
            } catch (InterruptedException ignored) {}

            nextState();
        }
    }

    public void nextState(){
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size ; x++) {
                int aliveNeighbours = cellArr[y][x].checkNeighbors();
                    if (cellArr[y][x].getPreviousState()==State.DEAD &&
                            aliveNeighbours == 3) cellArr[y][x].setNextState(State.ALIVE);

                    else if (cellArr[y][x].getPreviousState()==State.ALIVE &&
                            aliveNeighbours < 2 || aliveNeighbours > 3) cellArr[y][x].setNextState(State.DEAD);

                    else cellArr[y][x].setNextState(cellArr[y][x].getPreviousState());
            }
        }
        SwingUtilities.updateComponentTreeUI(frame);
    }

    public void createCanvas() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                cellArr[y][x] = new Cell(y, x);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                start::new
        );
    }
}