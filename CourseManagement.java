import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class CourseManagement extends JFrame {

    JList<String> courseList;
    JTable table;

    DefaultTableModel model;

    JButton addButton;
    JButton removeButton;

    JTextField studentName;

    public CourseManagement() {

        setTitle("Student Course Management");
        setSize(700, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Student Name
        JPanel topPanel = new JPanel();

        topPanel.add(new JLabel("Student Name:"));

        studentName = new JTextField(15);
        topPanel.add(studentName);

        add(topPanel, BorderLayout.NORTH);

        // Course List
        String courses[] = {
            "Java Programming",
            "Data Structures",
            "Database Management",
            "Operating Systems",
            "Computer Networks"
        };

        courseList = new JList<>(courses);

        JScrollPane courseScroll =
                new JScrollPane(courseList);

        courseScroll.setBorder(
                BorderFactory.createTitledBorder("Available Courses")
        );

        add(courseScroll, BorderLayout.WEST);

        // Table
        String columns[] = {
            "Student Name",
            "Selected Course",
            "Status"
        };

        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        JScrollPane tableScroll =
                new JScrollPane(table);

        add(tableScroll, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();

        addButton = new JButton("Add Course");
        removeButton = new JButton("Remove Course");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Add Course
        addButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String name = studentName.getText();
                String course = courseList.getSelectedValue();

                if (name.isEmpty() || course == null) {

                    JOptionPane.showMessageDialog(
                        CourseManagement.this,
                        "Enter student name and select a course"
                    );

                } else {

                    model.addRow(new Object[]{
                        name,
                        course,
                        "Enrolled"
                    });
                }
            }
        });

        // Remove Course
        removeButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int row = table.getSelectedRow();

                if (row != -1) {
                    model.removeRow(row);
                } else {
                    JOptionPane.showMessageDialog(
                        CourseManagement.this,
                        "Select a row to remove"
                    );
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new CourseManagement();
    }
}