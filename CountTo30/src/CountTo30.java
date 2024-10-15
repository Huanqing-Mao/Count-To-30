import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CountTo30 extends JFrame {
    private int currentCount = 0;
    private int humanCount = 0;
    private int computerCount = 0;
    private JLabel countLabel;
    private JTextArea logArea;
    private JButton oneButton;
    private JButton twoButton;
    private JButton threeButton;

    public CountTo30() {
        setTitle("Count to 30 Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        countLabel = new JLabel("Current Count: " + currentCount);
        countLabel.setBounds(20, 20, 200, 30);
        add(countLabel);

        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);
        scrollPane.setBounds(20, 60, 340, 150);
        add(scrollPane);

        oneButton = new JButton("Count 1");
        oneButton.setBounds(50, 220, 100, 30);
        oneButton.addActionListener(new ButtonListener(1));
        add(oneButton);

        twoButton = new JButton("Count 2");
        twoButton.setBounds(200, 220, 100, 30);
        twoButton.addActionListener(new ButtonListener(2));
        add(twoButton);

        logArea.append("Game started at: " + getCurrentTimestamp() + "\n");

        setVisible(true);

    }
    private class ButtonListener implements ActionListener {
        private int count;

        public ButtonListener(int count) {
            this.count = count;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Player's turn
            logArea.append("\n" + getCurrentTimestamp() + "\n");
            currentCount += count;
            humanCount = currentCount;
            logArea.append("You counted: " + count + "\n");
            updateGame();

            // Computer's turn
            if (currentCount < 30) {
                int compMove = makeComputerMove();
                logArea.append("Computer counted: " + compMove + "\n");
                currentCount += compMove;
                computerCount = currentCount;
                updateGame();
            }
        }
    }

    private String getCurrentTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    private void updateGame() {
        countLabel.setText("Current Count: " + currentCount);
        // logArea.append("Human Count = " + humanCount + "\n");
        // logArea.append("Computer Count = " + computerCount + "\n");

        if (currentCount >= 30) {
            if (humanCount >= 30) {
                JOptionPane.showMessageDialog(this, "You lost! You had to say 30!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            } else if (computerCount >= 30) {
                JOptionPane.showMessageDialog(this, "Computer lost! It is forced to say 30!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            }
            disableButtons();
        }
    }

    private void disableButtons() {
        oneButton.setEnabled(false);
        twoButton.setEnabled(false);
        threeButton.setEnabled(false);
    }

    private int makeComputerMove() {
        // A randomised answer!

        if (currentCount >= 28) {
            return 30 - currentCount;
        } else {
            return (int) (Math.random() * 2) + 1; // Random choice of 1, or 2
        }
    }

    public static void main(String[] args) {
        new CountTo30();
    }
}
