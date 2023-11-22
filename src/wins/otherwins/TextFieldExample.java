package wins.otherwins;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextFieldExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Field Example");
        JTextField textField = new JTextField();

        // Add a DocumentListener to the JTextField
        textField.getDocument().addDocumentListener(new DocumentListener() {
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
                System.out.println("Text changed: " + textField.getText());
            }
        });

        frame.getContentPane().add(textField);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
