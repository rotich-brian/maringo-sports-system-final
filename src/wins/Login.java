package wins;

import wins.otherwins.RegisterMember;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Login extends JFrame {

    private JPanel panel;
    private  JPanel backgroundPanel;
    JLabel mainLabel = new JLabel("LOGIN FORM",SwingConstants.CENTER);

    public Login() {

        setTitle("Login Form");
        setSize(800, 600);

        mainLabel.setBounds(260,50,300,50);
        mainLabel.setFont(new Font(null,Font.BOLD,30));
        mainLabel.setForeground(Color.WHITE);
        mainLabel.setBorder(new LoginForm.RoundBorder(6));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Image backgroundImage = new ImageIcon("src/res/background.jpg").getImage();
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new LoginForm.RoundBorder(5));
        JTextField userTextField = new JTextField();
        userTextField.setBorder(new MatteBorder(0,0,1,0, Color.BLACK));
        userTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (userTextField.getText().equals("Enter username")) {
                    userTextField.setText("");
                    userTextField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (userTextField.getText().isEmpty()) {
                    userTextField.setForeground(Color.GRAY);
                    userTextField.setText("Enter username");
                }
            }
        });

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBorder(new MatteBorder(0,0,1,0, Color.BLACK));
        passwordField.setText("Enter password");

        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passwordField.getText().equals("Enter password")) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getText().isEmpty() || passwordField.getPassword().equals("Enter password")) {
                    passwordField.setForeground(Color.GRAY);
                    passwordField.setText("Enter password");
                }
            }
        });

        panel.setBounds(200,125,400,320);
        panel.setBackground(new Color(255,255,255,100));

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(50,25,100,50);
        usernameLabel.setFont(new Font(null,Font.BOLD,14));
        usernameLabel.setForeground(Color.BLACK);
        userTextField.setBounds(125,25,200,50);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font(null,Font.BOLD,14));
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setBounds(50,125,100,50);
        passwordField.setBounds(125,125,200,50);

        JButton loginButton = new JButton("Login");
        //JLabel loginButton = new JLabel("Login",SwingConstants.CENTER);
        loginButton.setBorder(new LoginForm.RoundBorder(5));
        loginButton.setForeground(Color.BLUE);

        loginButton.setFont(new Font(null,Font.BOLD,18));
        loginButton.setBounds(100,225,200,50);
        loginButton.setFocusable(false);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterMember(new JFrame());
            }
        });

        panel.add(usernameLabel);
        panel.add(userTextField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        backgroundPanel.add(panel);
        setContentPane(backgroundPanel);

        add(mainLabel);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login());
    }
}
