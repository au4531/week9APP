import java.awt.*;
import javax.swing.*;


class StudentModel {
    String name;
    int mark1, mark2, mark3;
    int total;
    double average;
    String grade;

    void calculate(String name, int m1, int m2, int m3) {
        this.name = name;
        mark1 = m1;
        mark2 = m2;
        mark3 = m3;

        total = mark1 + mark2 + mark3;
        average = total / 3.0;

        if (average >= 90)
            grade = "A";
        else if (average >= 75)
            grade = "B";
        else if (average >= 60)
            grade = "C";
        else if (average >= 50)
            grade = "D";
        else
            grade = "F";
    }
}


class StudentView extends JFrame {
    JTextField nameField = new JTextField();
    JTextField mark1Field = new JTextField();
    JTextField mark2Field = new JTextField();
    JTextField mark3Field = new JTextField();

    JButton calculateButton = new JButton("Calculate Result");

    JLabel result = new JLabel("Result will appear here");

    StudentView() {
        setTitle("Student Grade Calculator");
        setSize(400, 350);
        setLayout(new GridLayout(6, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Student Name:"));
        add(nameField);

        add(new JLabel("Mark 1:"));
        add(mark1Field);

        add(new JLabel("Mark 2:"));
        add(mark2Field);

        add(new JLabel("Mark 3:"));
        add(mark3Field);

        add(calculateButton);
        add(result);

        setVisible(true);
    }
}


class StudentController {
    StudentModel model;
    StudentView view;

    StudentController(StudentModel model, StudentView view) {
        this.model = model;
        this.view = view;

        view.calculateButton.addActionListener(e -> calculate());
    }

    void calculate() {
        try {
            String name = view.nameField.getText();

            int m1 = Integer.parseInt(view.mark1Field.getText());
            int m2 = Integer.parseInt(view.mark2Field.getText());
            int m3 = Integer.parseInt(view.mark3Field.getText());

            model.calculate(name, m1, m2, m3);

            view.result.setText(
                "<html>Total: " + model.total +
                "<br>Average: " + model.average +
                "<br>Grade: " + model.grade + "</html>"
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Enter valid marks");
        }
    }
}


public class StudentGradeCalculator {
    public static void main(String[] args) {
        StudentModel model = new StudentModel();
        StudentView view = new StudentView();
        new StudentController(model, view);
    }
}