package wins.otherwins;

import wins.Welcome;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewMembers {
    private JFrame previousWindow;
    public ViewMembers(JFrame previousWindow) {
        JFrame frame = new JFrame();
        frame.setTitle("Club Members");
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcTop = new GridBagConstraints();
        gbcTop.insets = new Insets(10, 10, 10, 10);
        gbcTop.anchor = GridBagConstraints.WEST;

        JLabel membersLabel = new JLabel("CLUB MEMBERSHIP MANAGEMENT");
        membersLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        membersLabel.setFocusable(false);
        gbcTop.gridx = 0;
        gbcTop.gridy = 2;
        topPanel.add(membersLabel, gbcTop);

        frame.add(topPanel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();

        JPanel membersPanel = new JPanel(new BorderLayout());
        JLabel minorsLabel = new JLabel("Minor Members");
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

            ResultSet resultSet = statement.executeQuery("select `Full_Name`, `Year_of_Birth`, `Contact_Details`,`School`, `Gender`, `Membership`, `Fee` from members where Year_of_Birth between 2006 and 2012");

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
        table.setPreferredScrollableViewportSize(new Dimension(750, 100));
        table.setEnabled(false);
        table.setFont(new Font("Arial", Font.BOLD, 12));
        table.setFillsViewportHeight(true);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int i = table.getSelectedRow();
            }
        });

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);

        membersPanel.add(scrollPane);

        table.addRowSelectionInterval(0,table.getRowCount()-1);

        frame.add(mainPanel, BorderLayout.CENTER);

        JPanel gamesPlayedPanel = new JPanel(new BorderLayout());

        DefaultTableModel tableModel1 = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select `Full_Name`, `Year_of_Birth`, `Contact_Details`,`School`, `Gender`, `Membership`, `Fee` from members where Year_of_Birth between 1998 and 2005");

            tableModel1 = new DefaultTableModel();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel1.addColumn(metaData.getColumnLabel(columnIndex));
            }

            while ((resultSet.next())) {

                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                tableModel1.addRow(rowData);
            }

            resultSet.close();
            connection.close();

        } catch (Exception e1) {
            System.out.println(e1);
            e1.printStackTrace();
        }

        JTable table1 = new JTable(tableModel1);
        table1.setPreferredScrollableViewportSize(new Dimension(750, 100));
        table1.setEnabled(false);
        table1.setFont(new Font("Arial", Font.BOLD, 12));
        table1.setFillsViewportHeight(true);

        ListSelectionModel selectionModel = table1.getSelectionModel();
//        selectionModel.addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                if (!e.getValueIsAdjusting()) {
//                    int selectedRow = table.getSelectedRow();
//                    if (selectedRow != -1) {
//                        // Show the selected row data
//                        System.out.println("Selected Row: " + selectedRow);
//                        for (int i = 0; i < tableModel1.getColumnCount(); i++) {
//                            System.out.print(tableModel1.getColumnName(i) + ": " + tableModel1.getValueAt(selectedRow, i) + "  ");
//                        }
//                        System.out.println();
//                    }
//                }
//            }
//        });

        JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setViewportView(table1);

        gamesPlayedPanel.setSize(400, 300);

        JLabel gamesPlayedLabel = new JLabel("Middle Group");
        gamesPlayedLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        gamesPlayedLabel.setFocusable(false);
        gamesPlayedPanel.add(gamesPlayedLabel, BorderLayout.NORTH);
        gamesPlayedPanel.add(scrollPane1);

        JPanel seniorsPanel = new JPanel(new BorderLayout());


        DefaultTableModel tableModel2 = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select `Full_Name`, `Year_of_Birth`, `Contact_Details`,`School`, `Gender`, `Membership`, `Fee` from members WHERE Year_of_Birth between 1989 and 1997");

            tableModel2 = new DefaultTableModel();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel2.addColumn(metaData.getColumnLabel(columnIndex));
            }

            while ((resultSet.next())) {

                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                tableModel2.addRow(rowData);
            }

            resultSet.close();
            connection.close();

        } catch (Exception e1) {
            System.out.println(e1);
            e1.printStackTrace();
        }

        JTable table2 = new JTable(tableModel2);
        table2.setPreferredScrollableViewportSize(new Dimension(750, 100));
        table2.setEnabled(false);
        table2.setFont(new Font("Arial", Font.BOLD, 12));
        table2.setFillsViewportHeight(true);

        table2.addRowSelectionInterval(0,table2.getRowCount()-1);

        JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setViewportView(table2);

        //table2.getColumnModel().getColumn(0).setPreferredWidth(5);
        seniorsPanel.setSize(400, 300);

        JLabel seniorsLabel = new JLabel("Senior Members");
        seniorsLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        seniorsLabel.setFocusable(false);
        seniorsPanel.add(seniorsLabel, BorderLayout.NORTH);
        seniorsPanel.add(scrollPane2);

        JButton addMemberButton = new JButton("NEW MEMBER");
        addMemberButton.setFocusable(false);
        addMemberButton.setFont(new Font("Arial", Font.BOLD, 18));
        addMemberButton.setPreferredSize(new Dimension(200, 50));
        addMemberButton.setBackground(new Color(50, 64, 64));
        addMemberButton.setForeground(Color.green);
        addMemberButton.setBorderPainted(false);
        addMemberButton.setFocusPainted(false);

        addMemberButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                addMemberButton.setBorderPainted(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                addMemberButton.setBorderPainted(false);
            }
        });

        addMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterMember(frame);
            }
        });

        JButton backButton = new JButton("BACK");
        backButton.setFocusable(false);
        backButton.setFont(new Font("Arial", Font.BOLD, 18));
        backButton.setPreferredSize(new Dimension(200, 50));
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

        JButton deleteMemberButton = new JButton("DELETE");
        deleteMemberButton.setFocusable(false);
        deleteMemberButton.setFont(new Font("Arial", Font.BOLD, 18));
        deleteMemberButton.setPreferredSize(new Dimension(150, 50));
        deleteMemberButton.setBackground(new Color(50, 64, 64));
        deleteMemberButton.setForeground(Color.red);
        deleteMemberButton.setBorderPainted(false);
        deleteMemberButton.setFocusPainted(false);

        deleteMemberButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                deleteMemberButton.setBorderPainted(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deleteMemberButton.setBorderPainted(false);
            }
        });
        mainPanel.add(membersPanel);
        mainPanel.add(gamesPlayedPanel);
        mainPanel.add(seniorsPanel);
        mainPanel.add(backButton);
        mainPanel.add(addMemberButton);
        mainPanel.add(deleteMemberButton);

        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new ViewMembers(new JFrame());
    }
}
