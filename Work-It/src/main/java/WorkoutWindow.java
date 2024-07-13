import javax.swing.*;
import java.awt.*;

public class WorkoutWindow extends JFrame {
    private String[] armsExercises = {"Bicep Curls", "Tricep Dips", "Hammer Curls", "Tricep Kickbacks", "Push-ups"};
    private String[] chestExercises = {"Push-ups", "Bench Press", "Dumbbell Flyes", "Chest Dips", "Incline Bench Press"};
    private String[] absExercises = {"Crunches", "Leg Raises", "Planks", "Russian Twists", "Mountain Climbers"};
    private String[] glutesExercises = {"Squats", "Lunges", "Deadlifts", "Glute Bridges", "Fire Hydrants"};
    private String[] legsExercises = {"Squats", "Lunges", "Leg Press", "Deadlifts", "Calf Raises"};

    private String[][] exercises = {armsExercises, chestExercises, absExercises, glutesExercises, legsExercises};
    private String[][][] tips = {
            {   // Tips for Arms exercises
                {"When you're doing biceps curls, don't swing your arm or elbow.", "Be careful to keep your wrist straight and rigid.", " If you flex your wrist as you bend your elbow, you won't target the biceps well."},
                {"Sit on the ground with your knees bent and feet flat on the floor.", "Lower your body down to the ground by bending your elbows.", "Lift your hips off the ground your weight should be in your hands and feet."},
                {"Ensure that your core is engaged, and that your back is straight.", "Keeping your right elbow in a stable position.", "Your arm should be at a 45-degree angle, keeping your elbow stable."},
                {"Bend forward slightly at the waist so your torso is almost parallel to the floor.", "Engage your core and keep your head, neck, and spine in one line.", "Engage your triceps as you slowly extend your arm back as far as you can."},
                {"Bend your elbows to lower your entire body toward the ground.", "Your elbows shouldn't point directly to the sides or to the back, but somewhere in between.", "Make sure your body moves together as one unit."}
            },
            {   // Tips for Chest exercises
                {"Keep your core tight and don't let your back arch or your legs swing.", "Point your toes and hold this position at the top of the pullup for as long as you can.", "Lower down into the negative."},
                {"Grip bar correctly.", "Keep feet planted.", "Steady your head, neck and shoulders to avoid injuring yourself."},
                {"Lift arms up above the head so they're extended but not locked out.", "There should be a slight bend at your elbow, and your palms and dumbbells should be facing each other.", "Inhale and slowly lower dumbbells in an arc motion until they're in line with the chest."},
                {"Position your body so that your feet are off the ground and arms are straight.", "Begin the chest dip by bending at the elbows and lowering your body down.", "Maintain a slight forward lean to emphasize the strain on your chest."},
                {"Grip bar correctly.", "Keep feet planted.", "Maintain a slight forward lean to emphasize the strain on your chest."}
            },
            {   // Tips for Abs exercises
                {"Lie down on the floor. Bend your knees and plant your feet on the floor.", "Contract your abs and inhale. Using your core, raise your head and neck keeping your neck straight.", "Return to starting position."},
                {"Lie face-up on an exercise mat with your legs straight and feet together.", "Raise your legs until your knees are directly over your hips.", "Your legs should form a 90-degree angle with your upper body."},
                {"Begin in the plank position, face down with your forearms and toes on the floor.", "Engage your ab muscles, drawing your navel toward your spine and hold.", "Over time work up to 30, 45, or 60 seconds."},
                {"Sit back slightly, keeping your spine straight.", "Exhale as you twist to the left, punching your right arm over to the left side.", "Inhale back to center, and then do the opposite side."},
                {"Get into a plank position, making sure to distribute your weight evenly between your hands and your toes.", "Your hands should be about shoulder-width apart, back flat, abs engaged, and head in alignment.", "Alternate inhaling and exhaling with each leg change."}
            },
            {   // Tips for Glutes exercises
                {"Stand with your feet a little wider than your hips.", "Sink your hips back and descend into a squat whilst the knees travel in line with the toes.", "The thighs should hit parallel or lower and your elbows should come in between your knees."},
                {"Try to avoid leaning forward too much.", "Don't overextend your leg when you lunge forward, which can cause your back to arch.", "Try to step out enough so your body is comfortable vertically."},
                {"Squat down, bending at the knees.", "Grasp the bar just outside the line of the knees with an overhand or mixed grip.", "The arms stay extended under tension while gripping the bar as the legs push up."},
                {"Your feet should be hip-width apart with your toes pointed straight ahead.", "Your heels should be about 6-8 inches away from your glutes.", "Squeeze your glutes and your abs as you start to lift your hips toward the ceiling."},
                {"Keep your knee bent during the entire movement.", "Hold this position for a few seconds, squeezing your glute muscles together as you do so.", "Bring your knee back to the starting position."}
            },
            {   // Tips for Legs exercises
                {"Stand with your feet a little wider than your hips.", "Sink your hips back and descend into a squat whilst the knees travel in line with the toes.", "The thighs should hit parallel or lower and your elbows should come in between your knees."},
                {"Try to avoid leaning forward too much.", "Don't overextend your leg when you lunge forward, which can cause your back to arch.", "Try to step out enough so your body is comfortable vertically."},
                {"Your legs should form an angle of about 90 degrees at the knees. ", "Your knees should be in line with your feet and neither be bowed inward nor outward.", "As you press, make sure to keep this alignment."},
                {"Squat down, bending at the knees.", "Grasp the bar just outside the line of the knees with an overhand or mixed grip.", "The arms stay extended under tension while gripping the bar as the legs push up."},
                {"Stand with your feet shoulder-width apart.","Raise your heels slowly, keeping your knees extended (but not locked).", "Pause for one second when you're standing as much on the tips of your toes as you can."}
            }
    };

    public WorkoutWindow(JFrame mainFrame) {
        setTitle("Workout Window");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK); // Set the background color to pink
        panel.setLayout(new GridLayout(0, 1, 5, 5));

        JButton armsButton = new JButton("Arms");
        JButton backButton = new JButton("Back");
        JButton chestButton = new JButton("Chest");
        JButton absButton = new JButton("Abs");
        JButton glutesButton = new JButton("Glutes");
        JButton legsButton = new JButton("Legs");
        JButton backButtonMain = new JButton("Back to Main Page");

        panel.add(armsButton);
        panel.add(chestButton);
        panel.add(absButton);
        panel.add(glutesButton);
        panel.add(legsButton);
        panel.add(backButtonMain);

        add(panel);
        setVisible(true);

        armsButton.addActionListener(e -> openExerciseTab("Arms"));
        chestButton.addActionListener(e -> openExerciseTab("Chest"));
        absButton.addActionListener(e -> openExerciseTab("Abs"));
        glutesButton.addActionListener(e -> openExerciseTab("Glutes"));
        legsButton.addActionListener(e -> openExerciseTab("Legs"));
        backButtonMain.addActionListener(e -> {
            dispose(); // Close the workout window
            mainFrame.setVisible(true); // Make the main frame visible again

        });
    }

    private void openExerciseTab(String muscleGroup) {
        JFrame exerciseFrame = new JFrame(muscleGroup + " Exercises");
        exerciseFrame.setSize(600, 400);
        exerciseFrame.setLocationRelativeTo(this); // Center the frame relative to the main window
        exerciseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel exercisePanel = new JPanel();
        exercisePanel.setLayout(new GridLayout(0, 1));

        JLabel exerciseLabel = new JLabel("Exercises for " + muscleGroup);
        exercisePanel.add(exerciseLabel);

        int index = getMuscleIndex(muscleGroup);
        if (index != -1) {
            String[] muscleExercises = exercises[index];
            String[][] muscleTips = tips[index];
            for (int i = 0; i < muscleExercises.length; i++) {
                JLabel exerciseName = new JLabel(muscleExercises[i]);
                exercisePanel.add(exerciseName);
                for (int j = 0; j < muscleTips[i].length; j++) {
                    exercisePanel.add(new JLabel("  - " + muscleTips[i][j]));
                }
            }
        }

        exerciseFrame.add(new JScrollPane(exercisePanel));
        exerciseFrame.setVisible(true);

    }


    private int getMuscleIndex(String muscleGroup) {
        switch (muscleGroup) {
            case "Arms":
                return 0;
            case "Chest":
                return 1;
            case "Abs":
                return 2;
            case "Glutes":
                return 3;
            case "Legs":
                return 4;
            default:
                return -1;
        }
    }
}
