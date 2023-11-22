package wins.otherwins;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeautifulCheckBoxApp extends JFrame {
    public BeautifulCheckBoxApp() {
        setTitle("Beautiful Checkboxes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1)); // 0 rows means as many rows as needed

        // Create an array to store the checkboxes
        JCheckBox[] checkboxes = new JCheckBox[10];

        // Create and add checkboxes with custom icons for each game
        for (int i = 0; i < checkboxes.length; i++) {
            checkboxes[i] = createBeautifulCheckBox("Game " + (i + 1));
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
                JOptionPane.showMessageDialog(BeautifulCheckBoxApp.this, selectedGames.toString());
            }
        });
        add(showSelectedButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JCheckBox createBeautifulCheckBox(String text) {
        JCheckBox checkBox = new JCheckBox(text);

        // Load custom icons for the checkbox
        Icon selectedIcon = new ImageIcon("src/res/background.jpg");
        Icon deselectedIcon = new ImageIcon("deselectedIcon.png");

        // Set the custom icons
        checkBox.setIcon(deselectedIcon);
        checkBox.setSelectedIcon(selectedIcon);

        // Optional: Set additional properties, e.g., font, foreground color, etc.
        // checkBox.setFont(new Font("Arial", Font.BOLD, 14));
        // checkBox.setForeground(Color.BLUE);

        return checkBox;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BeautifulCheckBoxApp();
            }
        });
    }
}
