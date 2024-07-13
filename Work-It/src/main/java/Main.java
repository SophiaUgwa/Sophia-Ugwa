import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener 
{
    private JTextField weight, height;
    private JComboBox<String> gender;
    private JButton calculateBMIButton;
    private JLabel bmiResultLabel;
    private JTextField exerciseName, sets, reps, time;
    private JButton addButton, clearButton;
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton logoutButton;

    //Constructor 
    public Main() {
        setTitle("Fitness App");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        // Create inputs for BMI calculator
        weight=new JTextField(10);
        height=new JTextField(10);
        gender=new JComboBox<>(new String[]{"Female", "Male", "Other"});
        calculateBMIButton= new JButton("Calculate BMI");
        bmiResultLabel=new JLabel();

        // Create button listeners
        calculateBMIButton.addActionListener(this);

        // Create inputs for exercise tracker
        exerciseName = new JTextField(20);
        sets= new JTextField(5);
        reps= new JTextField(5);
        time=new JTextField(5);

        // Create buttons for exercise tracker
        addButton= new JButton("Add Exercise");
        clearButton=new JButton("Clear Fields");
        logoutButton= new JButton("Return to Home page");
        logoutButton.addActionListener(this);

        // Create columns for the exercise tracker
        tableModel=new DefaultTableModel();
        tableModel.addColumn("Exercise");
        tableModel.addColumn("Sets");
        tableModel.addColumn("Reps");
        tableModel.addColumn("Time (min)");
        table = new JTable(tableModel);

        // Create the main panel
        JPanel mainPanel= new JPanel(new BorderLayout());

        // Create the BMI calculator panel
        JPanel bmiPanel= new JPanel(new GridLayout(4,2,5,5));
        bmiPanel.setBorder(BorderFactory.createTitledBorder("BMI Calculator"));
        bmiPanel.add(new JLabel("Weight (kg):"));
        bmiPanel.add(weight);
        bmiPanel.add(new JLabel("Height (m):"));
        bmiPanel.add(height);
        bmiPanel.add(new JLabel("Gender:"));
        bmiPanel.add(gender);
        bmiPanel.add(calculateBMIButton);
        bmiPanel.add(bmiResultLabel);

        // Create exercise tracker panel
        JPanel exercisePanel= new JPanel(new BorderLayout());
        exercisePanel.setBorder(BorderFactory.createTitledBorder("Exercise Tracker"));
        JPanel inputPanel=new JPanel(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx= 0;
        gbc.gridy= 0;
        inputPanel.add(new JLabel("Exercise Name:"),gbc);
        gbc.gridx= 1;
        inputPanel.add(exerciseName,gbc);
        gbc.gridx=0;
        gbc.gridy= 1;
        inputPanel.add(new JLabel("Sets:"),gbc);
        gbc.gridx= 1;
        inputPanel.add(sets, gbc);
        gbc.gridx= 0;
        gbc.gridy= 2;
        inputPanel.add(new JLabel("Reps:"),gbc);
        gbc.gridx= 1;
        inputPanel.add(reps, gbc);
        gbc.gridx= 0;
        gbc.gridy=3;
        inputPanel.add(new JLabel("Time (min):"),gbc);
        gbc.gridx=1;
        inputPanel.add(time,gbc);
        gbc.gridx= 0;
        gbc.gridy= 4;
        gbc.gridwidth= 2;

        gbc.anchor=GridBagConstraints.CENTER;
        inputPanel.add(addButton,gbc);
        gbc.gridy = 5;
        inputPanel.add(clearButton, gbc);
        exercisePanel.add(inputPanel,BorderLayout.NORTH);
        exercisePanel.add(new JScrollPane(table), BorderLayout.CENTER);

        // Add the BMI calculator and the exercise tracker panels to main panel
        mainPanel.add(bmiPanel,BorderLayout.NORTH);
        mainPanel.add(exercisePanel,BorderLayout.CENTER);

        // Add logout button to main panel
        mainPanel.add(logoutButton,BorderLayout.SOUTH);

        add(mainPanel);
    }
//An ActionListener is an object that listens for events in the application . When an event occurs, the actionPerformed() method is called
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== calculateBMIButton) {
            calculateBMI();
        } 
        else if (e.getSource()== addButton) {
            addExercise();
        } 
        else if (e.getSource()== clearButton) {
            clearFields();
        } 
        else if (e.getSource()== logoutButton) 
        {
            // Open the MainPage window
            HomePage.main(new String[]{});
            // Close the current Main window
            dispose();
        }
    }

//Create method to calculate the BMI
    private void calculateBMI() {
        try {
            double weight1=Double.parseDouble(weight.getText());
            double height1=Double.parseDouble(height.getText());
            String gender1=(String) gender.getSelectedItem();

            double bmi =weight1 /(height1*height1);

            String status;
            if (bmi < 18.5) {
                status ="underweight";
            } 
            else if (bmi >= 18.5 && bmi < 25) {
                status ="average weight";
            } 
            else 
            {
                status ="overweight";
            }
//bmiResultLabel.setText("Your BMI is: " +bmi+"\nYou are "+status);
            bmiResultLabel.setText("Your BMI is: " + String.format("%.2f", bmi) + ". You are " + status + ".");
        } 
        catch (NumberFormatException ex) 
            {
            JOptionPane.showMessageDialog(this, "Please enter valid numerical values for weight and height.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addExercise() 
    {
        String exerciseName1 = exerciseName.getText();
        String sets1 = sets.getText();
        String reps1 = reps.getText();
        String time1 = time.getText();

        // Check if any of the fields are empty
        if (exerciseName1.isEmpty() || sets1.isEmpty() || reps1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all exercise fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Add exercise to the table
        tableModel.addRow(new String[]{exerciseName1, sets1, reps1, time1});

        // Clear the input fields
        clearFields();
    }

    private void clearFields()
    {
        exerciseName.setText("");
        sets.setText("");
        reps.setText("");
        time.setText("");
    }

    private void logout() 
    {
        // Here you can add code to perform logout actions
        System.exit(0); // For simplicity, let's just exit the application
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            Main app = new Main();
            app.setVisible(true);
        });
    }
}
