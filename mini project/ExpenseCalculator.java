import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class ExpenseCalculator extends JFrame {
    private JTextField expenseField;
    private JTextArea displayArea;
    private ArrayList<Double> dailyExpenses;
    private String filename;

    public ExpenseCalculator(String filename) {
        dailyExpenses = new ArrayList<>();
        this.filename = filename;

        setTitle("Expense Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel expenseLabel = new JLabel("Enter Daily Expense: ");
        expenseField = new JTextField(10);
        JButton addButton = new JButton("Add Expense");
        addButton.addActionListener(new AddExpenseListener());

        inputPanel.add(expenseLabel);
        inputPanel.add(expenseField);
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(scrollPane, BorderLayout.CENTER);

        JButton saveButton = new JButton("Save Expenses");
        saveButton.addActionListener(new SaveExpensesListener());
        add(saveButton, BorderLayout.SOUTH);

        JButton displayButton = new JButton("Display Expenses");
        displayButton.addActionListener(new DisplayExpensesListener());
        add(displayButton, BorderLayout.EAST);
    }

    private void addExpense(double expense) {
        dailyExpenses.add(expense);
        displayArea.append("Added expense: $" + expense + "\n");
    }

    private void saveExpensesToTextFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Double expense : dailyExpenses) {
                writer.println(expense);
            }
            displayArea.append("Expenses saved to " + filename + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            displayArea.append("Error: Unable to save expenses to text file.\n");
        }
    }

    private void displayAllExpenses() {
        displayArea.setText(""); // Clear the display area first
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                double expense = Double.parseDouble(line);
                displayArea.append("Expense: $" + expense + "\n");
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            displayArea.append("Error: Unable to display expenses from text file.\n");
        }
    }

    private class AddExpenseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double expense = Double.parseDouble(expenseField.getText());
                addExpense(expense);
                expenseField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number for expense.");
            }
        }
    }

    private class SaveExpensesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            saveExpensesToTextFile();
        }
    }

    private class DisplayExpensesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            displayAllExpenses();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ExpenseCalculator calculator = new ExpenseCalculator("expenses.txt");
            calculator.setVisible(true);
        });
    }
}
