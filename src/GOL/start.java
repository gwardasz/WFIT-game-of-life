package GOL;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class start {
    private JFrame frame;
    private Cell[][] cellList;
    public final int size = 80;

    public start() {
        frame = new JFrame();
        frame.setSize(965, 990);
        cellList = new Cell[size][size];
        createCanvas(cellList);
        frame.add(new grid(), BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Game of life");
        frame.setVisible(true);


    }

    class grid extends JPanel {
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            int value = 990 / size;


            for (int y = 0; y < size; y++) {
                for (int x = 0; x < size; x++) {
                    // mam pytanie w tej pętli czy get getRow i getCol to nie powinny gbyć odwrotnie?
                    // bo w sumie kolumna wskazuje na x a rząd na y
                    if (cellList[y][x].getNextState()== State.DEAD) {
                        g.setColor(Color.black);
                        g.fillRect(value * cellList[y][x].getRow(), value * cellList[y][x].getCol(), value, value);
                    }

                    if (cellList[y][x].getNextState()== State.ALIVE) {
                        g.setColor(Color.white);
                        g.fillRect(value * cellList[y][x].getRow(), value * cellList[y][x].getCol(), value, value);
                    }
                    cellList[y][x].setPreviousState(cellList[y][x].getNextState());
                }
            }
            /*
            try {
                TimeUnit.SECONDS.sleep((long) 1.5);
            } catch (InterruptedException ignored){}
             */
            nextState();
        }
    }

    public void nextState(){
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size ; x++) {
                int aliveNeighbourhoods = cellList[y][x].checkNeighbors(cellList);
                    if (cellList[y][x].getPreviousState()==State.DEAD &&
                            aliveNeighbourhoods == 3){
                        cellList[y][x].setNextState(State.ALIVE);
                    }

                    else if (cellList[y][x].getPreviousState()==State.ALIVE &&
                            aliveNeighbourhoods < 2 ||
                            aliveNeighbourhoods > 3)
                        cellList[y][x].setNextState(State.DEAD);
                    else cellList[y][x].setNextState(cellList[y][x].getPreviousState());
            }
        }
        SwingUtilities.updateComponentTreeUI(frame);
    }

    public void createCanvas(Cell[][] cells) {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                cells[y][x] = new Cell(y, x);
            }
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                start::new
        );
    }
}