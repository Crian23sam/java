import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ExpenseCalculatorBackup extends JFrame {
    private JTextField expenseField;
    private JTextField descriptionField;
    private JTextArea displayArea;
    private ArrayList<Expense> dailyExpenses;

    public ExpenseCalculatorBackup() {
        dailyExpenses = new ArrayList<>();

        setTitle("Expense Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));

        JLabel expenseLabel = new JLabel("Expense Amount: ");
        expenseField = new JTextField(10);
        JLabel descriptionLabel = new JLabel("Description: ");
        descriptionField = new JTextField(10);
        JButton addButton = new JButton("Add Expense");
        addButton.addActionListener(new AddExpenseListener());

        inputPanel.add(expenseLabel);
        inputPanel.add(expenseField);
        inputPanel.add(descriptionLabel);
        inputPanel.add(descriptionField);
        inputPanel.add(addButton); // Add the Add button to the input panel

        add(inputPanel, BorderLayout.NORTH);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(); // Create a new panel for the buttons
        buttonPanel.setLayout(new FlowLayout());

        JButton saveButton = new JButton("Save Expenses");
        saveButton.addActionListener(new SaveExpensesListener());
        buttonPanel.add(saveButton); // Add the Save button to the button panel

        JButton displayButton = new JButton("Display Expenses");
        displayButton.addActionListener(new DisplayExpensesListener());
        buttonPanel.add(displayButton); // Add the Display button to the button panel

        JButton totalButton = new JButton("Display Total");
        totalButton.addActionListener(new DisplayTotalListener());
        buttonPanel.add(totalButton); // Add the Total button to the button panel

        add(buttonPanel, BorderLayout.SOUTH); // Add the button panel to the frame
    }

    // Add expense to the list and display it
    private void addExpense(double expense, String description) {
        LocalDate date = LocalDate.now();
        dailyExpenses.add(new Expense(expense, description, date));
        displayArea.append("Added expense: $" + expense + " - " + description + " on " + date + "\n");
        System.out.println("Added expense: $" + expense + " - " + description + " on " + date);
    }

    // Save expenses from the list to a text file
    private void saveExpensesToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("expenses.txt", true))) {
            for (Expense expense : dailyExpenses) {
                writer.println(expense.getAmount() + ";" + expense.getDescription() + ";" + expense.getDate());
            }
            dailyExpenses.clear(); // Clear the list after saving to the file
            displayArea.append("Expenses saved to file.\n");
            System.out.println("Expenses saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
            displayArea.append("Error: Unable to save expenses to file.\n");
            System.out.println("Error: Unable to save expenses to file.");
        }
    }

    // Display all expenses from the text file
    private void displayAllExpenses() {
        displayArea.setText(""); // Clear the display area first
        try (BufferedReader reader = new BufferedReader(new FileReader("expenses.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Reading line: " + line); // Debug statement
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    double expense = Double.parseDouble(parts[0]);
                    String description = parts[1];
                    String date = parts[2];
                    displayArea.append("Expense: $" + expense + " - " + description + " on " + date + "\n");
                    System.out.println("Expense: $" + expense + " - " + description + " on " + date);
                } else {
                    System.out.println("Invalid line format: " + line); // Debug statement
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            displayArea.append("Error: Unable to display expenses from file.\n");
            System.out.println("Error: Unable to display expenses from file.");
        }
    }

    // Calculate and display the total expenses by reading from the file
    private void displayTotalExpenses() {
        double total = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("expenses.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    total += Double.parseDouble(parts[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            displayArea.append("Error: Unable to calculate total expenses.\n");
            System.out.println("Error: Unable to calculate total expenses.");
        }
        displayArea.append("Total expenses: $" + total + "\n");
        System.out.println("Total expenses: $" + total);
    }

    // Listener for adding expense
    private class AddExpenseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double expense = Double.parseDouble(expenseField.getText());
                String description = descriptionField.getText();
                addExpense(expense, description);
                expenseField.setText("");
                descriptionField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number for expense.");
                System.out.println("Invalid number format for expense.");
            }
        }
    }

    // Listener for saving expenses to file
    private class SaveExpensesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            saveExpensesToFile();
        }
    }

    // Listener for displaying all expenses
    private class DisplayExpensesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            displayAllExpenses();
        }
    }

    // Listener for displaying total expenses
    private class DisplayTotalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            displayTotalExpenses();
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ExpenseCalculatorBackup calculator = new ExpenseCalculatorBackup();
            calculator.setVisible(true);
        });
    }
}

// Expense class to represent an expense
class Expense {
    private double amount;
    private String description;
    private LocalDate date;

    public Expense(double amount, String description, LocalDate date) {
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }
}
