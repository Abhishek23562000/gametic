package gametic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame {
    private JButton[][] buttons;
    private char currentPlayer;

    public TicTacToe() {
        buttons = new JButton[3][3];
        currentPlayer = 'X';

        initializeUI();
    }

    private void initializeUI() {
        setTitle("Tic Tac Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].setBackground(Color.WHITE);
                buttons[i][j].setFocusPainted(false);
                int finalI = i;
                int finalJ = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        buttonClicked(finalI, finalJ);
                    }
                });
                add(buttons[i][j]);
            }
        }
    }

    private void buttonClicked(int i, int j) {
        if (buttons[i][j].getText().equals("")) {
            buttons[i][j].setText(String.valueOf(currentPlayer));
            buttons[i][j].setEnabled(false);

            if (checkWin(i, j)) {
                JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
                resetGame();
            } else if (isBoardFull()) {
                JOptionPane.showMessageDialog(this, "It's a draw!");
                resetGame();
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    private boolean checkWin(int row, int col) {
        // Check row
        if (buttons[row][0].getText().equals(String.valueOf(currentPlayer)) &&
            buttons[row][1].getText().equals(String.valueOf(currentPlayer)) &&
            buttons[row][2].getText().equals(String.valueOf(currentPlayer))) {
            return true;
        }

        // Check column
        if (buttons[0][col].getText().equals(String.valueOf(currentPlayer)) &&
            buttons[1][col].getText().equals(String.valueOf(currentPlayer)) &&
            buttons[2][col].getText().equals(String.valueOf(currentPlayer))) {
            return true;
        }

        // Check diagonals
        if (buttons[0][0].getText().equals(String.valueOf(currentPlayer)) &&
            buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
            buttons[2][2].getText().equals(String.valueOf(currentPlayer))) {
            return true;
        }

        if (buttons[0][2].getText().equals(String.valueOf(currentPlayer)) &&
            buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
            buttons[2][0].getText().equals(String.valueOf(currentPlayer))) {
            return true;
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
        currentPlayer = 'X';
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicTacToe ticTacToe = new TicTacToe();
            ticTacToe.setVisible(true);
        });
    }
}

