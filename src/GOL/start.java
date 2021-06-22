package GOL;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class start {
    private Integer size;
    private JFrame frame;
    private Cell[][] cellList;

    public start() {
        size = 50;
        frame = new JFrame();
        frame.setSize(965, 990);
        cellList = new Cell[50][50];
        createCanvas(size, cellList);
        grid board = new grid();
        frame.add(board, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Game of life");
        frame.setVisible(true);


    }

    class grid extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Integer value = (Integer) 990 / size;


            for (int b = 0; b < size; b++) {
                for (int i = 0; i < size; i++) {

                    //System.out.println(cellList[i][b].getColour());
                    if (cellList[i][b].getNextState()== State.DEAD) {

                        g.setColor(Color.black);
                        //g.fillRect(value);
                        g.fillRect((int) (value * cellList[i][b].getRow()), (int) (value * cellList[i][b].getCol()), (int) (value), (int) (value));
                    }

                    if (cellList[i][b].getNextState()== State.ALIVE) {
                        g.setColor(Color.white);
                        g.fillRect(30,30,50,50);
                        //g.fillRect(value);
                        g.fillRect((int) (value * cellList[i][b].getRow()), (int) (value * cellList[i][b].getCol()), (int) (value), (int) (value));
                    }

                    cellList[i][b].setPreviousState(cellList[i][b].getNextState());
                    //System.out.println(cellList[i][b].getNextState());
                }

            }
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("HEJ");
            nextState();
        }
    }

    public void nextState(){
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size ; x++) {
                int aliveNeighbourhoods = 0;
                    for (int i = y-1; i < y+1; i++) {
                        for (int j = x-1; j < x+1; j++) {
                            if (i ==y && j ==x) continue;
                            try {
                                if (cellList[i][j].getPreviousState() == State.ALIVE) aliveNeighbourhoods++;
                            } catch (Exception ignored){
                            }

                        }
                    }
                    if (cellList[y][x].getPreviousState()==State.DEAD && aliveNeighbourhoods == 3) cellList[y][x].setNextState(State.ALIVE);
                    else if (cellList[y][x].getPreviousState()==State.ALIVE && (aliveNeighbourhoods < 2 || aliveNeighbourhoods > 3)) cellList[y][x].setNextState(State.DEAD);
                    else cellList[y][x].setNextState(cellList[y][x].getPreviousState());
            }
        }
        SwingUtilities.updateComponentTreeUI(frame);
    }

    public void createCanvas(Integer size, Cell[][] cells) {
        for (int b = 0; b < size; b++) {
            for (int i = 0; i < size; i++) {
                cells[i][b] = new Cell(i, b);
            }
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> {
                    start g = new start();


                }
        );
    }
}