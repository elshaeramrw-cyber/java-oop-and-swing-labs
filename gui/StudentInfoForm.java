import javax.swing.*;
import java.awt.*;

public class StudentInfoForm {
    public static void main(String[] args) {
        // 1. Create the main frame
        JFrame frame = new JFrame("Student Information Form");
        frame.setLayout(new BorderLayout());

        // 2. Create a main panel to hold all rows vertically
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // --- Row 1: Name (JLabel + JTextField) ---
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblName = new JLabel("Name:");
        JTextField tfName = new JTextField(15);
        namePanel.add(lblName);
        namePanel.add(tfName);
        mainPanel.add(namePanel);

        // --- Row 2: Gender (JRadioButton) ---
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblGender = new JLabel("Gender:");
        JRadioButton rbMale = new JRadioButton("Male");
        JRadioButton rbFemale = new JRadioButton("Female");
        
        // Group radio buttons so only one can be selected at a time
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);
        
        genderPanel.add(lblGender);
        genderPanel.add(rbMale);
        genderPanel.add(rbFemale);
        mainPanel.add(genderPanel);

        // --- Row 3: Course (JComboBox) ---
        JPanel coursePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblCourse = new JLabel("Course:");
        String[] courses = {"Computer Science", "Computer Engineering", "Information Technology"};
        JComboBox<String> cboCourse = new JComboBox<>(courses);
        coursePanel.add(lblCourse);
        coursePanel.add(cboCourse);
        mainPanel.add(coursePanel);

        // --- Row 4: Hobbies (JCheckBox) ---
        JPanel hobbyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblHobbies = new JLabel("Hobbies:");
        JCheckBox chkReading = new JCheckBox("Reading");
        JCheckBox chkSports = new JCheckBox("Sports");
        hobbyPanel.add(lblHobbies);
        hobbyPanel.add(chkReading);
        hobbyPanel.add(chkSports);
        mainPanel.add(hobbyPanel);

        // --- Row 5: Buttons (JButton) ---
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnSubmit = new JButton("Submit");
        JButton btnClear = new JButton("Clear");
        buttonPanel.add(btnSubmit);
        buttonPanel.add(btnClear);
        mainPanel.add(buttonPanel);

        // Add the main panel to the frame
        frame.add(mainPanel, BorderLayout.CENTER);

        // ==========================================
        // PART B: Event Handling
        // ==========================================

        // 1. Submit Button Logic
        btnSubmit.addActionListener(e -> {
            // Gather data
            String name = tfName.getText();
            
            String gender = "Not selected";
            if (rbMale.isSelected()) gender = "Male";
            else if (rbFemale.isSelected()) gender = "Female";
            
            String course = (String) cboCourse.getSelectedItem();
            
            String hobbies = "";
            if (chkReading.isSelected()) hobbies += "Reading ";
            if (chkSports.isSelected()) hobbies += "Sports ";
            if (hobbies.isEmpty()) hobbies = "None";

            // Display data using JOptionPane
            String message = "Student Information:\n" +
                             "-------------------------\n" +
                             "Name: " + name + "\n" +
                             "Gender: " + gender + "\n" +
                             "Course: " + course + "\n" +
                             "Hobbies: " + hobbies;
                             
            JOptionPane.showMessageDialog(frame, message, "Student Details", JOptionPane.INFORMATION_MESSAGE);
        });

        // 2. Clear Button Logic
        btnClear.addActionListener(e -> {
            tfName.setText("");                // Clear text field
            genderGroup.clearSelection();      // Clear radio buttons
            cboCourse.setSelectedIndex(0);     // Reset combo box to first item
            chkReading.setSelected(false);     // Unselect check boxes
            chkSports.setSelected(false);
        });

        // Final frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}