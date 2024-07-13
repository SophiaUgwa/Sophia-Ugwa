import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePage {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createMainPage();
        });
    }

    private static void createMainPage() {
        JFrame mainFrame = new JFrame("Main Page");
        mainFrame.setSize(800, 500); // Set the size to 800x500
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null); // Center the window

        // Set the background color to pink
        mainFrame.getContentPane().setBackground(Color.PINK);

        mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));

        JButton bmiButton = new JButton("BMI Calculator");
        JButton workoutsButton = new JButton("Workouts");
        JButton videosButton = new JButton("Videos"); // New button for videos
        JButton logoutButton = new JButton("Log out");

        // Set preferred size for buttons to make them equally sized
        Dimension buttonSize = new Dimension(200, 40);
        bmiButton.setPreferredSize(buttonSize);
        workoutsButton.setPreferredSize(buttonSize);
        videosButton.setPreferredSize(buttonSize);
        logoutButton.setPreferredSize(buttonSize);

        // Add vertical glue to equally space buttons
        mainFrame.add(Box.createVerticalGlue());

        // Add buttons with rigid areas to maintain spacing
        mainFrame.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing
        mainFrame.add(bmiButton);
        mainFrame.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing
        mainFrame.add(workoutsButton);
        mainFrame.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing
        mainFrame.add(videosButton); // Add videos button
        mainFrame.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing
        mainFrame.add(logoutButton);
        mainFrame.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing

        // Add vertical glue to equally space buttons
        mainFrame.add(Box.createVerticalGlue());

        // Add JLabel for real-time display
        JLabel timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainFrame.add(timeLabel);

        mainFrame.setVisible(true);

        // ActionListener for the "BMI Calculator" button
        bmiButton.addActionListener(e -> {
            // Open the Main window when the "BMI Calculator" button is clicked
            Main main = new Main();
            main.setVisible(true);
            mainFrame.dispose(); // Close the HomePage window
        });

        // ActionListener for the "Workouts" button
        workoutsButton.addActionListener(e -> {
            // Open the WorkoutWindow when the "Workouts" button is clicked
            WorkoutWindow workoutWindow = new WorkoutWindow(mainFrame);
            mainFrame.setVisible(false); // Hide the main frame
        });

        // ActionListener for the "Videos" button
        videosButton.addActionListener(e -> {
            // Add action to open videos window or perform another action
            JOptionPane.showMessageDialog(mainFrame, "do you want to watch videos?");
        });

        // ActionListener for the real-time display
        Timer timer = new Timer(1000, event -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            timeLabel.setText("Current Time: " + dateFormat.format(new Date()));
        });
        timer.start();
    }
}
