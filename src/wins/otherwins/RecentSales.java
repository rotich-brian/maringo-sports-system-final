package wins.otherwins;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class RecentSales {
    private JFrame previousWindow;
    public RecentSales(JFrame previousWindow){
        JFrame frame = new JFrame();
        frame.setTitle("Club Store");
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcTop = new GridBagConstraints();
        gbcTop.insets = new Insets(10,10,10,10);
        gbcTop.anchor = GridBagConstraints.WEST;

        JTextField txtStoreClerk = new JTextField(12);
        txtStoreClerk.setFont(new Font("Arial", Font.BOLD, 14));
        txtStoreClerk.setText("Emmanuel Abunuwasi");
        txtStoreClerk.setForeground(Color.blue);
        txtStoreClerk.setEditable(false);
        JLabel patronLabel = new JLabel("Store Clerk");
        patronLabel.setFont(new Font("Arial", Font.BOLD, 16));
        patronLabel.setFocusable(false);

        gbcTop.gridx=0;
        gbcTop.gridy=1;
        topPanel.add(patronLabel, gbcTop);
        gbcTop.gridx=1;
        gbcTop.gridy=1;
        topPanel.add(txtStoreClerk,gbcTop);

        JLabel membersLabel = new JLabel("MARINGO SPORTS CLUB STORE");
        membersLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        membersLabel.setFocusable(false);
        gbcTop.gridx=0;
        gbcTop.gridy=0;
        gbcTop.gridwidth=3;
        topPanel.add(membersLabel, gbcTop);

        frame.add(topPanel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();

        JPanel membersPanel = new JPanel(new BorderLayout());
        JLabel minorsLabel = new JLabel("Items sold This week");
        minorsLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        membersPanel.setFocusable(false);
        membersPanel.add(minorsLabel, BorderLayout.NORTH);

        String url = "jdbc:mysql://localhost:3306/maringodatabase";
        String username = "root";
        String password = "";

        DefaultTableModel tableModel = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM `store_items`");

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
        scrollPane.setViewportView(table);

        membersPanel.add(scrollPane);

        frame.add(mainPanel,BorderLayout.CENTER);


        JButton newSaleButton = new JButton("NEW SALE");
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

                String[] options = {"one","two","three"};

                JComboBox<String> comboBox = new JComboBox<>(options);

                int result = (JOptionPane.showConfirmDialog(null,comboBox,"Select Item: ",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE));
                //JOptionPane.showInputDialog("Pick Item");
                if(result == JOptionPane.OK_OPTION) {
                    String selectedItem = (String) comboBox.getSelectedItem();
                    int result2 = (JOptionPane.showConfirmDialog(null,comboBox,"Select Item: ",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE));
                }

            }
        });

        JButton backButton = new JButton("BACK");
        backButton.setFocusable(false);
        backButton.setFont(new Font("Arial", Font.BOLD, 18));
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
        mainPanel.add(membersPanel);
        mainPanel.add(backButton);
        mainPanel.add(newSaleButton);

        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new RecentSales(new JFrame());
    }
}
