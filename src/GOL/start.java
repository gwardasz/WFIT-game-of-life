package GOL;

import javax.swing.*;
import java.awt.*;

public class start {
    private Integer size;
    private JFrame frame;
    private Cell[][] cellList;
    public start() {
        size = 50;
        frame = new JFrame();
        frame.setSize(965,990);
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

                    //if (cellList[i][b].getWalls()[0]) {
                    g.drawPolyline(new int[]{i * value, i * value + value}, new int[]{b * value, b * value}, 2);
                    //}
                    //if (cellList[i][b].getWalls()[1]) {
                    g.drawPolyline(new int[]{i * value + value, i * value + value}, new int[]{b * value, b * value + value}, 2);
                    //}
                    //if (cellList[i][b].getWalls()[2]) {
                    g.drawPolyline(new int[]{i * value + value, i * value}, new int[]{b * value + value, b * value + value}, 2);
                    //}
                    //if (cellList[i][b].getWalls()[3]) {
                    g.drawPolyline(new int[]{i * value, i * value}, new int[]{b * value + value, b * value}, 2);
                    // }
                    g.setColor(Color.black);
                    System.out.println(cellList[i][b].getColour());
                    if (cellList[i][b].getColour().equals("1")){
                        //g.fillRect(value);
                        g.fillRect((int) (value * cellList[i][b].getRow()), (int) (value * cellList[i][b].getCol()), (int) (value), (int) (value));
                    }
                }

                }


        }
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
