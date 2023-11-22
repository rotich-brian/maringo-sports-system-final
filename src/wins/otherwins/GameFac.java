package wins.otherwins;

import wins.LoginForm;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

public class GameFac {
    JFrame frame = new JFrame();
    JTextField patronNameField;
    JRadioButton internal;
    JRadioButton external;
    JTextField membersField;
    JLabel showAmountLabel;
    JLabel totalLabel;
    JLabel commissionLabel;
    JLabel errorLabel;
    JRadioButton yesRadioButton,noRadioButton;
    JLabel damagesCostLabel;
    JTextField damagesCostField, costFineField;
    JButton payButton,costFineButton;
    private final double internalFee = 0.0;
    private final double externalFee = 500.0;
    boolean costFineButtonIsClicked = false;
    public GameFac(){
        frame.setTitle("Game Facilitation");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel title = new  JLabel("Manage Game events and Fee Facilitation",SwingConstants.CENTER);
        title.setForeground(Color.BLUE);
        title.setFont(new Font("Arial",Font.BOLD,16));
        title.setBorder(new LoginForm.RoundBorder(4));
        title.setBounds(25,25,725,30);
        frame.add(title);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBorder(new LoginForm.RoundBorder(4));
        panel1.setBackground(new Color(255,255,255,200));
        panel1.setBounds(25,65,350,150);

        JLabel game = new JLabel("Choose Game",SwingConstants.CENTER);
        //game.setBorder(new LoginForm.RoundBorder(4));
        game.setBounds(15,10,300,30);
        panel1.add(game);

        String[] games = {"select","Football", "Rugby", "Volleyball", "Basketball", "Netball",
                "Hockey", "Tennis", "Swimming", "Chess", "Darts", "Draft"};
        JComboBox<String> gameBox = new JComboBox<>(games);

        gameBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    patronNameField.setEnabled(true);
                    internal.setEnabled(true);
                    external.setEnabled(true);
                    yesRadioButton.setEnabled(true);
                    noRadioButton.setEnabled(true);
                    String selectedGame = (String) gameBox.getSelectedItem();
                    patronNameField.setText(getPatronName(selectedGame));
                }
            }
        });

        gameBox.setBounds(15,50,300,30);
        panel1.add(gameBox);

        JLabel patronName = new JLabel("Game Patron");
        patronName.setBounds(15,90,120,30);
        panel1.add(patronName);
        patronNameField = new JTextField();
        patronNameField.setBounds(130,90,185,30);
        patronNameField.setFont(new Font(null,Font.BOLD,12));
        patronNameField.setEditable(false);
        patronNameField.setEnabled(false);
        panel1.add(patronNameField);

        frame.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBorder(new LoginForm.RoundBorder(4));
        panel2.setBackground(new Color(255,255,255,200));
        panel2.setBounds(25,230,350,135);

        JLabel event = new JLabel("Team Event vs:");
        event.setBounds(15,10,100,30);
        panel2.add(event);
        ButtonGroup buttonGroup = new ButtonGroup();
        internal = new JRadioButton("Internal Team");
        internal.setBorder(new LoginForm.RoundBorder(4));
        internal.setBounds(120,10,150,30);
        internal.setFocusable(false);
        internal.setEnabled(false);

        internal.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    membersField.setEditable(true);
                    showAmountLabel.setText(String.valueOf(internalFee));
                }
            }
        });
        buttonGroup.add(internal);
        panel2.add(internal);

        external = new JRadioButton("External Team");
        external.setBounds(120,50,150,30);
        external.setFocusable(false);
        external.setEnabled(false);

        external.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    membersField.setEditable(true);
                    showAmountLabel.setText(String.valueOf(externalFee));
                }
            }
        });
        buttonGroup.add(external);
        panel2.add(external);

        JLabel amount = new JLabel("Amount per Member");
        amount.setBounds(15,90,120,30);
        panel2.add(amount);

        showAmountLabel = new JLabel();
        showAmountLabel.setBounds(150,90,120,30);
        showAmountLabel.setFont(new Font(null,Font.BOLD,12));
        showAmountLabel.setOpaque(true);
        panel2.add(showAmountLabel);

        frame.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBorder(new LoginForm.RoundBorder(4));
        panel3.setForeground(Color.BLUE);
        panel3.setBackground(new Color(255,255,255,200));
        panel3.setBounds(25,380,350,150);

        JLabel members = new JLabel("No of Members");
        members.setBounds(10,10,120,30);
        panel3.add(members);
        membersField = new JTextField();
        membersField.setBounds(150,10,120,30);
        membersField.setFont(new Font(null,Font.BOLD,12));
        membersField.setEditable(false);

        membersField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                textChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                textChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Plain text components do not fire these events
            }

            private void textChanged() {
                // This method will be called when the text changes
                try {
                    errorLabel.setText("");

                    double members = Double.parseDouble(membersField.getText());
                    double amount = Double.parseDouble(showAmountLabel.getText());

                    double total = members * amount;
                    double patronCommission = total * 0.20;

                    totalLabel.setText(String.valueOf(total));
                    commissionLabel.setText(String.valueOf(patronCommission));

                    membersField.requestFocus();
                } catch (NumberFormatException e1) {
                    errorLabel.setText("Enter Valid Input!");
                }
            }
        });
        panel3.add(membersField);

        JButton totalButton = new JButton("Compute Total");
        totalButton.setFocusable(false);
        totalButton.setBounds(10,50,120,30);

        totalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(membersField.getText().isEmpty()){
                    errorLabel.setText("Please Enter Number of Members!");
                    if(!internal.isSelected() && !external.isSelected()){
                        errorLabel.setText("Please specify team Event!");
                    }
                }else {
                    try {
                        errorLabel.setText("");

                        double members = Double.parseDouble(membersField.getText());
                        double amount = Double.parseDouble(showAmountLabel.getText());

                        double total = members * amount;
                        double patronCommission = total * 0.20;

                        totalLabel.setText(String.valueOf(total));
                        commissionLabel.setText(String.valueOf(patronCommission));
                    } catch (NumberFormatException e1) {
                        errorLabel.setText("Enter Valid Input!");
                    }
                }

            }
        });
        panel3.add(totalButton);

        totalLabel = new JLabel();
        totalLabel.setBounds(150,50,120,30);
        totalLabel.setOpaque(true);
        panel3.add(totalLabel);
        JLabel patronCommissionLabel = new JLabel("Patron Commission");
        patronCommissionLabel.setBounds(10,90,120,30);
        panel3.add(patronCommissionLabel);
        commissionLabel = new JLabel();
        commissionLabel.setBounds(150,90,120,30);
        commissionLabel.setOpaque(true);
        panel3.add(commissionLabel);

        frame.add(panel3);

        JPanel panel4 = new JPanel();
        panel4.setLayout(null);
        panel4.setBorder(new LoginForm.RoundBorder(4));
        panel4.setForeground(Color.RED);
        panel4.setBackground(new Color(255,255,255,255));
        panel4.setBounds(400,65,350,230);
        panel4.setOpaque(true);

        ButtonGroup damage = new ButtonGroup();
        JLabel damagesLabel = new JLabel("Any Damages?");
        damagesLabel.setBounds(10,10,120,30);
        panel4.add(damagesLabel);
        yesRadioButton = new JRadioButton("Yes");
        yesRadioButton.setBounds(150,10,150,30);
        yesRadioButton.setEnabled(false);

        yesRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    JOptionPane.showMessageDialog(null, "For Damages,\n Captain and Team Members Will Pay\n The Market Value of The Items Damaged PLUS 10% of it!!!");
                    damagesCostLabel.setVisible(true);
                    damagesCostField.setVisible(true);
                    costFineButton.setVisible(true);
                    costFineField.setVisible(true);
                    payButton.setVisible(true);

                }
            }
        });
        damage.add(yesRadioButton);
        panel4.add(yesRadioButton);

        noRadioButton = new JRadioButton("No");
        noRadioButton.setBounds(150,50,150,30);
        noRadioButton.setEnabled(false);

        noRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    JOptionPane.showMessageDialog(null, "Thank You For Maintaining The Items");
                }
            }
        });
        damage.add(noRadioButton);
        panel4.add(noRadioButton);

        damagesCostLabel = new JLabel("Market Value of Damages");
        damagesCostLabel.setBounds(10,90,120,30);
        damagesCostLabel.setVisible(false);
        panel4.add(damagesCostLabel);
        damagesCostField = new JTextField(5);
        damagesCostField.setBounds(150,90,150,30);
        damagesCostField.setVisible(false);
        panel4.add(damagesCostField);

        costFineButton = new JButton("Fine For Damages");
        costFineButton.setBounds(10,130,130,30);
        costFineButton.setVisible(false);
        panel4.add(costFineButton);

        costFineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                costFineButtonIsClicked = true;
                try {
                    errorLabel.setText("");
                    double damagesCost = Double.parseDouble(damagesCostField.getText());
                    double fine = damagesCost * 1.10;

                    costFineField.setText(String.valueOf(fine));
                }catch (NumberFormatException ex){
                    errorLabel.setText("Enter Valid Input!");
                    costFineButtonIsClicked = false;
                }

            }
        });

        costFineField = new JTextField(5);
        costFineField.setBounds(150,130,150,30);
        costFineField.setVisible(false);
        costFineField.setEditable(false);
        panel4.add(costFineField);

        payButton = new JButton("Pay For Damages");
        payButton.setBounds(90,170,150,30);
        payButton.setVisible(false);

        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(costFineButtonIsClicked) {
                    JOptionPane.showInputDialog(null, ("Enter Account Number"));
                    JOptionPane.showMessageDialog(null, "An Request Pay prompt\n Has Been Sent To your Account " +
                            "\n TOTAL Ksh. " + costFineField.getText()+ " \nPlease Enter PIN To Complete Transaction!");
                    JOptionPane.showMessageDialog(null, "Damages Paid For Successfully!");
                    errorLabel.setText("");
                } else{
                    errorLabel.setText("Please Click 'Fine for Damages' button First!");
                }
            }
        });
        panel4.add(payButton);

        frame.add(panel4);

        errorLabel = new JLabel();
        errorLabel.setBounds(420,290,300,30);
        errorLabel.setForeground(Color.RED);
        frame.add(errorLabel);

        JLabel saveEvent = new JLabel("Save Event",SwingConstants.CENTER);
        saveEvent.setBorder(new LoginForm.RoundBorder(4));
        saveEvent.setBounds(420,330,250,30);
        //frame.add(saveEvent);

        JLabel saveEvent1 = new JLabel("Save Event",SwingConstants.CENTER);
        saveEvent1.setForeground(Color.BLACK);
        saveEvent1.setBounds(450,330,250,40);
        saveEvent1.setBorder(new LoginForm.RoundBorder(4));
        saveEvent1.setOpaque(true);
        saveEvent1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                saveEvent1.setForeground(Color.RED);
                Timer timer = new Timer(200, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        new ViewMembers(frame);
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
                saveEvent1.setForeground(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                saveEvent1.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                saveEvent1.setBackground(Color.WHITE);
                saveEvent1.setForeground(Color.BLACK);
            }
        });

        frame.add(saveEvent1);

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static String getPatronName(String game){

        switch (game){
            case "Football":
                return "Mohammed Ali";
            case "Rugby":
                return "David Khalwale";
            case "Volleyball":
                return "Mercy Anyango";
            case "Basketball":
                return "John Masila";
            case "Netball":
                return "Faith Kwamboka";
            case "Hockey":
                return "Cheryl Wamboi";
            case "Tennis":
                return "Brian Mark";
            case "Swimming":
                return "Agnes Karori";
            case "Chess":
                return "James Musyoki";
            case "Darts":
                return "Peter Ogulo";
            case "Draft":
                return "Jane Cheptoo";
            default:
                return "";

        }

    }

    public static void main(String[] args) {
        new GameFac();
    }
}
