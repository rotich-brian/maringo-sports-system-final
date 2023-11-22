package wins.otherwins;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewSale extends JFrame {
    private JCheckBox[] itemCheckboxes;
    private JTextField[] quantityFields;
    private JLabel[] priceLabels;
    private JButton calculateButton;
    private JLabel totalCostLabel;
    private JLabel discountLabel;

    public NewSale() {
        setTitle("Maringo Sports Store Shopping Cart");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // List of items and their prices
        String[] items = {
                "Bloomer (250)",
                "Gameshorts (750)",
                "Hockeystick (2000)",
                "Socks (350)",
                "Tracksuit (1000)",
                "Tshirt (800)",
                "Wrapper (450)"
        };

        itemCheckboxes = new JCheckBox[items.length];
        quantityFields = new JTextField[items.length];
        priceLabels = new JLabel[items.length];

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        for (int i = 0; i < items.length; i++) {
            String item = items[i];
            itemCheckboxes[i] = new JCheckBox(item.split("\\(")[0]);
            quantityFields[i] = new JTextField("1", 2);
            priceLabels[i] = new JLabel("Price: Ksh. " + item.split("\\(")[1].replaceAll("[^0-9]", ""));
            gbc.gridx = 0;
            gbc.gridy = i;
            add(itemCheckboxes[i], gbc);
            gbc.gridx = 1;
            add(quantityFields[i], gbc);
            gbc.gridx = 2;
            add(priceLabels[i], gbc);
        }

        calculateButton = new JButton("Calculate Total Cost");
        calculateButton.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = items.length;
        gbc.gridwidth = 3;
        add(calculateButton, gbc);

        discountLabel = new JLabel("Discount: Ksh. 0"); // New discount label
        discountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = items.length + 1;
        gbc.gridwidth = 3;
        add(discountLabel, gbc); // Add the discount label to the frame

        totalCostLabel = new JLabel("Total Cost: Ksh. 0");
        totalCostLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = items.length + 2;
        gbc.gridwidth = 3;
        add(totalCostLabel, gbc);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int totalCost = 0;
                int discount = 0; // Initialize discount to zero

                for (int i = 0; i < itemCheckboxes.length; i++) {
                    if (itemCheckboxes[i].isSelected()) {
                        int quantity = Integer.parseInt(quantityFields[i].getText());
                        String item = items[i];
                        int itemPrice = Integer.parseInt(item.split("\\(")[1].replaceAll("[^0-9]", ""));
                        int itemTotalPrice = quantity * itemPrice;
                        totalCost += itemTotalPrice;

                        // Example: Apply a 5% discount if the item price is over 500 Ksh.
                        if (itemPrice > 500) {
                            discount += (itemTotalPrice * 5) / 100;
                        }
                    }
                }

                discountLabel.setText("Discount: Ksh. " + discount); // Update the discount label
                totalCostLabel.setText("Total Cost: Ksh. " + totalCost);
            }
        });

        pack();
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NewSale());
    }
}

