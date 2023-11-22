package wins.otherwins;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSelectorApp extends JFrame {
    public GameSelectorApp() {
        setTitle("Game Selector");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1)); // 0 rows means as many rows as needed

        // Create an array to store the checkboxes
        JCheckBox[] checkboxes = new JCheckBox[10];

        // Create and add checkboxes for each game
        for (int i = 0; i < checkboxes.length; i++) {
            checkboxes[i] = new JCheckBox("Game " + (i + 1));
            add(checkboxes[i]);
        }

        // Create a button to display selected games
        JButton showSelectedButton = new JButton("Show Selected Games");
        showSelectedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder selectedGames = new StringBuilder("Selected Games: ");
                for (int i = 0; i < checkboxes.length; i++) {
                    if (checkboxes[i].isSelected()) {
                        selectedGames.append("Game ").append(i + 1).append(", ");
                    }
                }
                // Remove the trailing comma and space
                if (selectedGames.length() > 16) {
                    selectedGames.delete(selectedGames.length() - 2, selectedGames.length());
                } else {
                    selectedGames.append("None");
                }
                JOptionPane.showMessageDialog(GameSelectorApp.this, selectedGames.toString());
            }
        });
        add(showSelectedButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameSelectorApp();
            }
        });
    }
}
