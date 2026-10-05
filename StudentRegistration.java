import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistration extends JFrame {

    JTextField nameField;
    JTextField regField;

    JRadioButton male;
    JRadioButton female;

    JComboBox<String> department;

    JButton submit;

    public StudentRegistration() {

        setTitle("Student Registration");
        setSize(400, 350);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Student Name
        add(new JLabel("Student Name:"));
        nameField = new JTextField(20);
        add(nameField);

        // Register Number
        add(new JLabel("Register Number:"));
        regField = new JTextField(20);
        add(regField);

        // Gender
        add(new JLabel("Gender:"));

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        add(male);
        add(female);

        // Department
        add(new JLabel("Department:"));

        String departments[] = {
            "CSE",
            "ECE",
            "EEE",
            "Mechanical",
            "Civil"
        };

        department = new JComboBox<>(departments);
        add(department);

        // Submit Button
        submit = new JButton("Submit");
        add(submit);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                String reg = regField.getText();

                String gender;

                if (male.isSelected())
                    gender = "Male";
                else if (female.isSelected())
                    gender = "Female";
                else
                    gender = "Not Selected";

                String dept = (String) department.getSelectedItem();

                JOptionPane.showMessageDialog(
                    StudentRegistration.this,
                    "Student Name: " + name +
                    "\nRegister Number: " + reg +
                    "\nGender: " + gender +
                    "\nDepartment: " + dept
                );
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}