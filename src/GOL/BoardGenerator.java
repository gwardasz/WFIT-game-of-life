package GOL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardGenerator extends JFrame implements ActionListener {

    private final JButton[][] board = new JButton[100][100];
    private final JButton bSave=new JButton("Save board");



    public BoardGenerator() {
        setTitle("Board");
        setSize(1000, 1000);
        setLayout(new GridLayout(start.SIZE,start.SIZE));
        setLocationRelativeTo(null);

        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        menubar.add(bSave);
        bSave.addActionListener(this);

        initGrid();

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGrid(){
        for (int y = 0; y < board.length; y++) {
            JButton[] box = board[y];
            for (int x = 0; x < box.length; x++) {
                board[y][x] = new JButton();
                board[y][x].setBounds(y * 55, x * 55, 55, 55);
                board[y][x].setFont(new Font(board[y][x].getFont().getName(), Font.PLAIN,30));
                board[y][x].setForeground(Color.black);
                add(board[y][x]);
                board[y][x].addActionListener(this);
                start.getCellArr()[y][x].setNextState(State.DEAD);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source==bSave){
            String s = JOptionPane.showInputDialog("Type filename");
            start.saveToFile(s);
            System.exit(0);


        }

        for (int y = 0; y < start.SIZE; y++) {
            for (int x = 0; x < start.SIZE; x++) {
                JButton box = board[y][x];
                if (source == box) {
                    Color background = box.getBackground();
                    if (!Color.black.equals(background)) {
                        box.setBackground(Color.black);
                        start.getCellArr()[y][x].setNextState(State.ALIVE);
                    } else{
                        box.setBackground(null);
                        start.getCellArr()[y][x].setNextState(State.DEAD);
                    }
                }
            }
        }
    }
}



