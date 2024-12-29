import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConverterGUI {
    private JFrame frame;
    private JTextField textField;
    private JButton cToFButton, fToCButton;
    private JLabel resultLabel;

    public ConverterGUI() {
        frame = new JFrame("Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(250, 200));
        frame.setLayout(new FlowLayout());

        textField = new JTextField(10);
        cToFButton = new JButton("Convert to Fahrenheit");
        fToCButton = new JButton("Convert to Celsius");
        resultLabel = new JLabel("");

        frame.add(new JLabel("Enter temperature:"));
        frame.add(textField);
        frame.add(cToFButton);
        frame.add(fToCButton);
        frame.add(resultLabel);

        cToFButton.addActionListener(e -> convert(1));
        fToCButton.addActionListener(e -> convert(2));

        frame.setVisible(true);
    }

    private void convert(int option) {
        try {
            double value = Double.parseDouble(textField.getText());
            String resultText;
            double result;
            if (option == 1) {
                result = Converter.getTemp(1, value);
                resultText = String.format("%.2f °C = %.2f °F", value, result);
            } else {
                result = Converter.getTemp(2, value);
                resultText = String.format("%.2f °F = %.2f °C", value, result);
            }
            resultLabel.setText(resultText);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Please, try again.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ConverterGUI::new);
    }
}
