package wins.otherwins;

import wins.LoginForm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class SalesReport {
    private JFrame previousWindow;
    public SalesReport(JFrame previousWindow){
        JFrame frame = new JFrame();
        frame.setTitle("Recent Sales");
        frame.setLayout(null);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(10,10,500,400);
        panel1.setBackground(new Color(255,255,255,80));

        frame.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(515,10,250,400);
        panel2.setBackground(new Color(255,255,255,80));

        frame.add(panel2);

        JLabel patronLabel = new JLabel("Store Clerk",SwingConstants.CENTER);
        patronLabel.setBounds(10,10,100,30);
        patronLabel.setFont(new Font("Arial", Font.BOLD, 16));
        patronLabel.setFocusable(false);

        panel2.add(patronLabel);

        JTextField txtStoreClerk = new JTextField(12);
        txtStoreClerk.setBounds(10,50,200,30);
        txtStoreClerk.setFont(new Font("Arial", Font.BOLD, 14));
        txtStoreClerk.setText("Emmanuel Abunuwasi");
        txtStoreClerk.setForeground(Color.blue);
        txtStoreClerk.setEditable(false);

        panel2.add(txtStoreClerk);

        JLabel membersLabel = new JLabel("MARINGO SPORTS CLUB STORE",SwingConstants.CENTER);
        membersLabel.setBounds(30,10,420,30);
        membersLabel.setBorder(new LoginForm.RoundBorder(4));
        membersLabel.setFont(new Font("Verdana", Font.BOLD, 12));
        membersLabel.setFocusable(false);
        panel1.add(membersLabel);

        String url = "jdbc:mysql://localhost:3306/maringodatabase";
        String username = "root";
        String password = "";

        DefaultTableModel tableModel = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM `sale_items`");

            tableModel = new DefaultTableModel();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnLabel(columnIndex));
            }

            while ((resultSet.next())) {

                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(rowData);
            }

            resultSet.close();
            connection.close();

        } catch (Exception e1) {
            System.out.println(e1);
            e1.printStackTrace();
        }

        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(400, 400));
        table.setEnabled(false);
        table.setFont(new Font("Arial", Font.BOLD, 12));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30,60,420,400);
        scrollPane.setBorder(new LoginForm.RoundBorder(4));
        scrollPane.setViewportView(table);

        panel1.add(scrollPane);

        JButton newSaleButton = new JButton("NEW SALE");
        newSaleButton.setBounds(10,90,150,30);
        newSaleButton.setFocusable(false);
        newSaleButton.setFont(new Font("Arial", Font.BOLD, 18));
        newSaleButton.setPreferredSize(new Dimension(250,50));
        newSaleButton.setBackground(new Color(50, 64, 64));
        newSaleButton.setForeground(Color.green);
        newSaleButton.setBorderPainted(false);
        newSaleButton.setFocusPainted(false);

        newSaleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                newSaleButton.setBorderPainted(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                newSaleButton.setBorderPainted(false);
            }
        });

        newSaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewSale();

            }
        });

        JButton backButton = new JButton("BACK");
        backButton.setFocusable(false);
        backButton.setFont(new Font("Arial", Font.BOLD, 18));
        backButton.setBounds(10,350,150,30);
        backButton.setPreferredSize(new Dimension(200,50));
        backButton.setBackground(new Color(50, 64, 64));
        backButton.setForeground(Color.white);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);

        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                backButton.setBorderPainted(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setBorderPainted(false);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previousWindow.setVisible(true);
                frame.dispose();
            }
        });
        //mainPanel.add(membersPanel);
        panel2.add(backButton);
        panel2.add(newSaleButton);

        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new EventsReport(new JFrame());
    }
}
