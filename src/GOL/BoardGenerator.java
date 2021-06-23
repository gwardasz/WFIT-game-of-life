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
        setSize(750, 750);
        setLayout(new GridLayout(100,100));
        setLocationRelativeTo(null);

        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        menubar.add(bSave);
        bSave.addActionListener(this);

        initGrid();

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initGrid(){
        for (int y = 0; y < board.length; y++) {
            JButton[] box = board[y];
            for (int x = 0; x < box.length; x++) {
                board[y][x] = new JButton();
                board[y][x].setBounds(y * 45, x * 45, 45, 45);
                board[y][x].setFont(new Font(board[y][x].getFont().getName(), Font.PLAIN,30));
                board[y][x].setForeground(Color.black);
                add(board[y][x]);
                board[y][x].addActionListener(this);
                for (int i = 0; i < 100; i++) {
                    for (int j = 0; j < 100; j++) {
                        start.getCellArr()[i][j].setNextState(State.DEAD);

                    }

                }
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

        for (int y = 0; y < 100; y++) {
            for (int x = 0; x < 100; x++) {
                JButton box = board[y][x];
                if (source == box) {
                    Color foreground = box.getBackground();
                    if (!Color.black.equals(foreground)) {
                        box.setBackground(Color.black);
                        start.getCellArr()[y][x].setNextState(State.ALIVE);
                    } else if (!Color.white.equals(foreground)) {
                        box.setBackground(Color.white);
                        start.getCellArr()[y][x].setNextState(State.DEAD);
                    }
                }
            }
        }
    }
}



