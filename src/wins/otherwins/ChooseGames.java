package wins.otherwins;

import wins.Login;
import wins.LoginForm;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChooseGames extends JFrame {
    public ChooseGames(){
        //setTitle("Choose Games");
        setSize(340,430);
        setResizable(false);
        setLayout(null);

        JLabel storeLabel = new JLabel("Please, Choose Games of Interest:",SwingConstants.CENTER);
        storeLabel.setBounds(15,10,300,30);
        storeLabel.setForeground(Color.BLUE);
        storeLabel.setFont(new Font(null,Font.BOLD,13));
        storeLabel.setBorder(new LoginForm.RoundBorder(4));
        add(storeLabel);

        JPanel storePanel = new JPanel();
        storePanel.setLayout(null);
        storePanel.setBounds(15,50,300,350);
        storePanel.setBackground(new Color(255,255,255,100));

        JCheckBox[] checkBoxes = new JCheckBox[16];

        checkBoxes[0] = new JCheckBox("Swimming");
        checkBoxes[0].setBounds(10,10,130,30);
        checkBoxes[0].setFont(new Font(null,Font.BOLD,15));
        checkBoxes[0].setBackground(Color.WHITE);
        checkBoxes[0].setBorder(new LoginForm.RoundBorder(4));
        checkBoxes[0].setFocusable(false);
        storePanel.add(checkBoxes[0]);

        checkBoxes[1] = new JCheckBox("Badminton");
        checkBoxes[1].setBounds(10,50,120,30);
        checkBoxes[1].setFont(new Font(null,Font.BOLD,15));
        checkBoxes[1].setBackground(Color.WHITE);
        checkBoxes[1].setBorder(new LoginForm.RoundBorder(4));
        checkBoxes[1].setFocusable(false);
        storePanel.add(checkBoxes[1]);

        checkBoxes[2] = new JCheckBox("Baseball");
        checkBoxes[2].setBounds(10,90,130,30);
        checkBoxes[2].setFont(new Font(null,Font.BOLD,15));
        checkBoxes[2].setBackground(Color.WHITE);
        checkBoxes[2].setBorder(new LoginForm.RoundBorder(4));
        checkBoxes[2].setFocusable(false);
        storePanel.add(checkBoxes[2]);

        checkBoxes[3] = new JCheckBox("Hockey");
        checkBoxes[3].setBounds(10,130,130,30);
        checkBoxes[3].setFont(new Font(null,Font.BOLD,15));
        checkBoxes[3].setBackground(Color.WHITE);
        checkBoxes[3].setBorder(new LoginForm.RoundBorder(4));
        checkBoxes[3].setFocusable(false);
        storePanel.add(checkBoxes[3]);

        checkBoxes[4] = new JCheckBox("Volleyball");
        checkBoxes[4].setBounds(10,170,130,30);
        checkBoxes[4].setFont(new Font(null,Font.BOLD,15));
        checkBoxes[4].setBackground(Color.WHITE);
        checkBoxes[4].setBorder(new LoginForm.RoundBorder(4));
        checkBoxes[4].setFocusable(false);
        storePanel.add(checkBoxes[4]);

        checkBoxes[5] = new JCheckBox("Rugby");
        checkBoxes[5].setBounds(10,210,130,30);
        checkBoxes[5].setFont(new Font(null,Font.BOLD,15));
        checkBoxes[5].setBackground(Color.WHITE);
        checkBoxes[5].setBorder(new LoginForm.RoundBorder(4));
        checkBoxes[5].setFocusable(false);
        storePanel.add(checkBoxes[5]);

        checkBoxes[6] = new JCheckBox("Lawn Tennis");
        checkBoxes[6].setBounds(10,250,130,30);
        checkBoxes[6].setFont(new Font(null,Font.BOLD,15));
        checkBoxes[6].setBackground(Color.WHITE);
        checkBoxes[6].setBorder(new LoginForm.RoundBorder(4));
        checkBoxes[6].setFocusable(false);
        storePanel.add(checkBoxes[6]);

        checkBoxes[7] = new JCheckBox("Basketball");
        checkBoxes[7].setBounds(10,290,130,30);
        checkBoxes[7].setFont(new Font(null,Font.BOLD,15));
        checkBoxes[7].setBackground(Color.WHITE);
        checkBoxes[7].setBorder(new LoginForm.RoundBorder(4));
        checkBoxes[7].setFocusable(false);
        storePanel.add(checkBoxes[7]);

        checkBoxes[8] = new JCheckBox("Pool");
        checkBoxes[8].setBounds(150,10,130,30);
        checkBoxes[8].setFont(new Font(null,Font.BOLD,15));
        checkBoxes[8].setBackground(Color.WHITE);
        checkBoxes[8].setBorder(new LoginForm.RoundBorder(4));
        checkBoxes[8].setFocusable(false);
        storePanel.add(checkBoxes[8]);

        checkBoxes[9] = new JCheckBox("Table tennis");
        checkBoxes[9].setBounds(150,50,130,30);
        checkBoxes[9].setFont(new Font(null,Font.BOLD,15));
        checkBoxes[9].setBackground(Color.WHITE);
        checkBoxes[9].setBorder(new LoginForm.RoundBorder(4));
        checkBoxes[9].setFocusable(false);
        storePanel.add(checkBoxes[9]);

        checkBoxes[10] = new JCheckBox("Netball");
        checkBoxes[10].setBounds(150,90,130,30);
        checkBoxes[10].setFont(new Font(null,Font.BOLD,15));
        checkBoxes[10].setBackground(Color.WHITE);
        checkBoxes[10].setBorder(new LoginForm.RoundBorder(4));
        checkBoxes[10].setFocusable(false);
        storePanel.add(checkBoxes[10]);

        checkBoxes[11] = new JCheckBox("Chess");
        checkBoxes[11].setBounds(150,130,130,30);
        checkBoxes[11].setFont(new Font(null,Font.BOLD,15));
        checkBoxes[11].setBackground(Color.WHITE);
        checkBoxes[11].setBorder(new LoginForm.RoundBorder(4));
        checkBoxes[11].setFocusable(false);
        storePanel.add(checkBoxes[11]);

        checkBoxes[12] = new JCheckBox("Darts");
        checkBoxes[12].setBounds(150,170,130,30);
        checkBoxes[12].setFont(new Font(null,Font.BOLD,15));
        checkBoxes[12].setBackground(Color.WHITE);
        checkBoxes[12].setBorder(new LoginForm.RoundBorder(4));
        checkBoxes[12].setFocusable(false);
        storePanel.add(checkBoxes[12]);

        checkBoxes[13] = new JCheckBox("Football");
        checkBoxes[13].setBounds(150,210,130,30);
        checkBoxes[13].setFont(new Font(null,Font.BOLD,15));
        checkBoxes[13].setBackground(Color.WHITE);
        checkBoxes[13].setBorder(new LoginForm.RoundBorder(4));
        checkBoxes[13].setFocusable(false);
        storePanel.add(checkBoxes[13]);

        checkBoxes[14] = new JCheckBox("Draft");
        checkBoxes[14].setBounds(150,250,130,30);
        checkBoxes[14].setFont(new Font(null,Font.BOLD,15));
        checkBoxes[14].setBackground(Color.WHITE);
        checkBoxes[14].setBorder(new LoginForm.RoundBorder(4));
        checkBoxes[14].setFocusable(false);
        storePanel.add(checkBoxes[14]);

        JLabel items = new JLabel("Confirm Selection",SwingConstants.CENTER);
        items.setForeground(Color.RED);
        items.setBounds(150,292,130,30);
        items.setBorder(new LoginForm.RoundBorder(4));
        items.setOpaque(true);
        items.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //viewmember.setEnabled(false);
                items.setForeground(Color.YELLOW);

                Timer timer = new Timer(200, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        new Login();
                        //viewmember.setEnabled(true);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                items.setForeground(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                items.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                items.setBackground(Color.WHITE);
                items.setForeground(Color.RED);
            }
        });
        storePanel.add(items);

        // Create a button to display selected games
        JButton showSelectedButton = new JButton("Show Selected Games");
        //showSelectedButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                StringBuilder selectedGames = new StringBuilder("Selected Games: ");
//                for (int i = 0; i < checkBoxes.length; i++) {
//                    if (checkBoxes[i].isSelected()) {
//                        selectedGames.append("Game ").append(i + 1).append(", ");
//                    }
//                }
//                // Remove the trailing comma and space
//                if (selectedGames.length() > 16) {
//                    selectedGames.delete(selectedGames.length() - 2, selectedGames.length());
//                } else {
//                    selectedGames.append("None");
//                }
//                //JOptionPane.showMessageDialog(GameSelectorApp.this, selectedGames.toString());
//            }
//        });
//        add(showSelectedButton);
        add(storePanel);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ChooseGames();
    }
}
