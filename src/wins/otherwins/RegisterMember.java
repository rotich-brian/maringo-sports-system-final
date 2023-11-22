package wins.otherwins;

import wins.Welcome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RegisterMember {
    private JFrame previousWindow;
    public RegisterMember(JFrame previousWindow) {
        JFrame frame = new JFrame("Maringo Sports Club Registration");
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());


        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Maringo Sports Club Registration");
        titleLabel.setFont(new Font("Arial",Font.BOLD,20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.add(titleLabel,BorderLayout.CENTER);

        JLabel errorLabel = new JLabel("Failure! Please fill all the blank fields");
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        errorLabel.setForeground(Color.red);
        titlePanel.add(errorLabel,BorderLayout.SOUTH);
        errorLabel.setVisible(false);

        frame.add(titlePanel,BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField txtFullName = new JTextField(20);
        JTextField txtGender = new JTextField(20);
        JTextField txtDateOfBirth = new JTextField(10);
        JTextField txtNextOfKin = new JTextField(20);
        JTextField txtContactDetails = new JTextField(14);
        JTextField txtSubCounties = new JTextField(14);
        JTextField txtSchool = new JTextField(20);
        JTextField txtGames = new JTextField(20);
        JTextField txtWeight = new JTextField(5);
        JTextField txtHeight = new JTextField(20);
        JTextField txtSpecialNeeds = new JTextField(20);
        JTextField txtMembership = new JTextField(20);

        JComboBox<String> comboGender = new JComboBox<>(new String[]{"Male","Female"});
        JComboBox<String> comboMembership = new JComboBox<>(new String[]{"Individual","Group"});
        JComboBox<String> comboSpecialNeeds = new JComboBox<>(new String[]{"No","Yes"});
        String[] yearList = new String[]{"1989","1990","1991","1992","1993","1994","1995","1996",
                "1997","1998","1999","2000","2001","2002","2003","2004","2005","2006",
                "2007","2008","2009","2010","2011"};
        JComboBox<String> comboYears = new JComboBox<>(yearList);

        JButton backButton = new JButton("BACK");
        backButton.setBackground(new Color(50, 64, 64));
        backButton.setForeground(Color.white);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new Dimension(200,50));
        backButton.setFont(new Font("Arial",Font.BOLD,18));

        JButton registerButton = new JButton("REGISTER");
        registerButton.setBorderPainted(false);
        registerButton.setFocusPainted(false);
        registerButton.setPreferredSize(new Dimension(250,50));
        registerButton.setFont(new Font("Arial",Font.BOLD,18));

        JCheckBox game1Checkbox = new JCheckBox("Football");
        JCheckBox game2Checkbox = new JCheckBox("BasketBall");
        JCheckBox game3Checkbox = new JCheckBox("Lawn Tennis");
        JCheckBox game4Checkbox = new JCheckBox("Table Tennis");

        gbc.gridx=0;
        gbc.gridy=0;
        mainPanel.add(new JLabel("Full Name"), gbc);
        gbc.gridx=1;
        gbc.gridy=0;
        mainPanel.add(txtFullName,gbc);

        gbc.gridx=2;
        gbc.gridy=0;
        mainPanel.add(new JLabel("Gender"), gbc);
        gbc.gridx=3;
        gbc.gridy=0;
        mainPanel.add(comboGender,gbc);

        gbc.gridx=0;
        gbc.gridy=2;
        mainPanel.add(new JLabel("Next of Kin"), gbc);
        gbc.gridx=1;
        gbc.gridy=2;
        mainPanel.add(txtNextOfKin,gbc);

        gbc.gridx=0;
        gbc.gridy=3;
        mainPanel.add(new JLabel("Year of Birth"), gbc);
        gbc.gridx=1;
        gbc.gridy=3;
        mainPanel.add(comboYears,gbc);

        gbc.gridx=0;
        gbc.gridy=4;
        mainPanel.add(new JLabel("Contact Details"), gbc);
        gbc.gridx=1;
        gbc.gridy=4;
        mainPanel.add(txtContactDetails,gbc);

        gbc.gridx=0;
        gbc.gridy=5;
        mainPanel.add(new JLabel("Sub-Counties"), gbc);
        gbc.gridx=1;
        gbc.gridy=5;
        mainPanel.add(txtSubCounties,gbc);

        gbc.gridx=0;
        gbc.gridy=6;
        mainPanel.add(new JLabel("College/School"), gbc);
        gbc.gridx=1;
        gbc.gridy=6;
        mainPanel.add(txtSchool,gbc);

        gbc.gridx=0;
        gbc.gridy=7;
        mainPanel.add(new JLabel("Games of Interest"), gbc);

        JPanel gamePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc1.gridx=0;
        gbc1.gridy=0;
        gamePanel.add(game1Checkbox,gbc1);
        gbc1.gridx=0;
        gbc1.gridy=1;
        gamePanel.add(game2Checkbox,gbc1);
        gbc1.gridx=1;
        gbc1.gridy=0;
        gamePanel.add(game3Checkbox,gbc1);
        gbc1.gridx=1;
        gbc1.gridy=1;
        gamePanel.add(game4Checkbox,gbc1);

        gbc.gridx=1;
        gbc.gridy=7;
        mainPanel.add(gamePanel,gbc);

        gbc.gridx=2;
        gbc.gridy=2;
        mainPanel.add(new JLabel("Weight"), gbc);
        gbc.gridx=3;
        gbc.gridy=2;
        mainPanel.add(txtWeight,gbc);

        gbc.gridx=2;
        gbc.gridy=3;
        mainPanel.add(new JLabel("Height"), gbc);
        gbc.gridx=3;
        gbc.gridy=3;
        mainPanel.add(txtHeight,gbc);

        gbc.gridx=2;
        gbc.gridy=4;
        mainPanel.add(new JLabel("Special Needs"), gbc);
        gbc.gridx=3;
        gbc.gridy=4;
        mainPanel.add(comboSpecialNeeds,gbc);

        gbc.gridx=2;
        gbc.gridy=5;
        mainPanel.add(new JLabel("Membership"), gbc);
        gbc.gridx=3;
        gbc.gridy=5;
        mainPanel.add(comboMembership,gbc);

        gbc.gridx=2;
        gbc.gridy=6;
        JLabel groupName = new JLabel("Group Name");
        mainPanel.add(groupName, gbc);
        gbc.gridx=3;
        gbc.gridy=6;
        mainPanel.add(txtMembership,gbc);
        groupName.setVisible(false);
        txtMembership.setVisible(false);

        gbc.gridx=2;
        gbc.gridy=7;
        mainPanel.add(new JLabel("Membership Fee"), gbc);
        gbc.gridx=3;
        gbc.gridy=7;
        JTextField fee = new JTextField("1000");
        fee.setFocusable(false);
        fee.setFont(new Font("Arial",Font.BOLD,15));
        fee.setForeground(Color.blue);
        fee.setEditable(false);
        mainPanel.add(fee,gbc);

        gbc.gridx=2;
        gbc.gridy=8;
        gbc.gridwidth=2;
        mainPanel.add(registerButton,gbc);

        gbc.gridx=1;
        gbc.gridy=8;
        gbc.gridwidth=1;
        mainPanel.add(backButton,gbc);

        comboMembership.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboMembership.getSelectedItem() == "Group") {
                    groupName.setVisible(true);
                    txtMembership.setVisible(true);
                    fee.setText("500");
                }else {
                    groupName.setVisible(false);
                    txtMembership.setVisible(false);
                    fee.setText("1000");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorLabel.setVisible(false);
                if (txtFullName.getText().isBlank() ||
                        txtContactDetails.getText().isBlank() || txtSubCounties.getText().isBlank() ||
                        txtSchool.getText().isBlank() || txtWeight.getText().isBlank()) {

                    errorLabel.setVisible(true);
                    //registerButton.hide();
                    System.out.println("Failed, Fill all the fields!");
                } else {
//                    ClubMember member = new ClubMember(txtFullName.getText(), (String) comboGender.getSelectedItem(),
//                            txtDateOfBirth.getText(), txtContactDetails.getText(), txtSubCounties.getText(),
//                            txtSchool.getText(), txtGames.getText(), (String) comboSpecialNeeds.getSelectedItem(),
//                            (String) comboMembership.getSelectedItem());
                    JOptionPane.showMessageDialog(frame,"Registration Successful");
                    frame.dispose();
                    new RegisterMember(frame);
                    //previousWindow.setVisible(true);

                    String Full_Name = txtFullName.getText();
                    String Next_of_Kin = txtNextOfKin.getText();
                    int Year_of_Birth = Integer.parseInt((String) comboYears.getSelectedItem());
                    int Contact_Details =Integer.parseInt(txtContactDetails.getText());;
                    String Sub_Counties = txtSubCounties.getText();
                    String School = txtSchool.getText();
                    String Games_of_Interest = "";
                    String Gender = (String) comboGender.getSelectedItem();
                    int Weight =Integer.parseInt(txtWeight.getText());;
                    int Height =Integer.parseInt(txtHeight.getText());;
                    String Special_Needs = (String) comboSpecialNeeds.getSelectedItem();
                    String Membership = (String) comboMembership.getSelectedItem();
                    String Group_Name = txtMembership.getText();
                    int Fee= Integer.parseInt(fee.getText());

                    String url = "jdbc:mysql://localhost:3306/maringodatabase";
                    String username = "root";
                    String password = "";

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        Connection connection = DriverManager.getConnection(url,username,password);

                        System.out.println("Connected!");

                        //PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `members`(`Name`, `Next of Kin`, `Y.O.B`, `Weight`, `Height`, `School`) " +
                        //     "VALUES ('Emmanuel Nyabicha','Ogeto','2004','59','169','KU')");
                        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO members(`Full_Name`, `Next_of_Kin`, `Year_of_Birth`,`Contact_Details`, `Sub_Counties`, `School`,`Games_of_Interest`,`Gender`,`Weight`,`Height`,`Special_Needs`,`Membership`,`Group_Name`,`Fee`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        preparedStatement.setString(1, Full_Name );
                        preparedStatement.setString(2, Next_of_Kin);
                        preparedStatement.setInt(3, Year_of_Birth);
                        preparedStatement.setInt(4, Contact_Details);
                        preparedStatement.setString(5,Sub_Counties );
                        preparedStatement.setString(6, School );
                        preparedStatement.setString(7, Games_of_Interest);
                        preparedStatement.setString(8, Gender);
                        preparedStatement.setInt(9, Weight);
                        preparedStatement.setInt(10,Height);
                        preparedStatement.setString(11, Special_Needs);
                        preparedStatement.setString(12, Membership);
                        preparedStatement.setString(13, Group_Name);
                        preparedStatement.setInt(14, Fee);
                        preparedStatement.executeUpdate();

                        Statement statement = connection.createStatement();

                        //statement.executeUpdate("INSERT INTO members(`Full Name`, `Next of Kin`, `Year of Birth`,`Contact Details`, `Sub-Counties`, `School`,`Games of Interest`,`Gender`,`Weight`,`Height`,`Special Needs`,`Membership`,`Group Name`,`Fee`) VALUES (`"+Full_Name+"`,`"+Next_of_Kin+"`,`"+Year_of_Birth+"`,`"+Contact_Details+"`,`"+Sub_Counties+"`,`"+School+"`,`"+Games_of_Interest+"`,`"+Gender+"`,`"+Weight+"`,`"+Height+"`,`"+Special_Needs+"`,`"+Membership+"`,`"+Group_Name+"`,`"+Fee+"`)");

                        ResultSet resultSet = statement.executeQuery("SELECT * FROM members");

                        while ((resultSet.next())) {
                            //System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
                        }

                        resultSet.close();
                        connection.close();

                    } catch (Exception e1) {
                        System.out.println(e1);
                        e1.printStackTrace();
                    }

//                    System.out.println(member.getMembershipType());
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previousWindow.setVisible(true);
                frame.dispose();
            }
        });

        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        new RegisterMember(new JFrame());
    }
}
