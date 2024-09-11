package calculator.evaluator;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {

    private JTextField expressionTextField = new JTextField();
    private JPanel buttonPanel = new JPanel();

    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // bText[] array contains the text for corresponding buttons
    private static final String[] buttonText = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "(", "0", ")", "/",
            "C", "CE", "=", "^"
    };

    /**
     * C  is for clear, clears entire expression
     * CE is for clear expression, clears last entry up until the last operator.
     */

    public static void main(String argv[]) {
        new EvaluatorUI();
    }

    public EvaluatorUI() {
        setLayout(new BorderLayout());
        this.expressionTextField.setPreferredSize(new Dimension(600, 50));
        this.expressionTextField.setFont(new Font("Courier", Font.BOLD, 24));
        this.expressionTextField.setHorizontalAlignment(JTextField.CENTER);

        add(expressionTextField, BorderLayout.NORTH);
        expressionTextField.setEditable(false);

        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 4));

        //create 20 buttons with corresponding text in bText[] array
        JButton jb;
        for (String s : EvaluatorUI.buttonText) {
            jb = new JButton(s);
            jb.setFont(new Font("Courier", Font.BOLD, 24));
            jb.addActionListener(this);
            this.buttonPanel.add(jb);
        }

        setTitle("Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * This function is called anytime a button is pressed
     * on our Calculator GUI.
     *
     * @param actionEventObject Event object generated when a
     *                          button is pressed.
     */
    public void actionPerformed(ActionEvent actionEventObject) {
        String command = actionEventObject.getActionCommand();

        switch (command) {
            case "=":
                try {
                    Evaluator evaluator = new Evaluator();
                    String result = String.valueOf(evaluator.evaluateExpression(expressionTextField.getText()));
                    expressionTextField.setText(result);
                } catch (InvalidTokenException ex) {
                    expressionTextField.setText("Error");
                }
                break;

            case "C":
                // Clear entire expression
                expressionTextField.setText("");
                break;

            case "CE":
                // Clear last entry
                String currentText = expressionTextField.getText();
                if (!currentText.isEmpty()) {
                    expressionTextField.setText(currentText.substring(0, currentText.length() - 1));
                }
                break;

            default:
                // For all other buttons, append their text to the expression
                expressionTextField.setText(expressionTextField.getText() + command);
                break;

        }
    }
}
