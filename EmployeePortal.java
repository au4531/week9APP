import java.awt.*;
import javax.swing.*;

// MODEL
class EmployeeModel {

    String username = "admin";
    String password = "admin123";

    String employeeID = "";
    String employeeName = "";
    String department = "";

    boolean login(String user, String pass) {
        return username.equals(user) && password.equals(pass);
    }

    boolean changePassword(String oldPass, String newPass,
                           String confirmPass) {

        if (!password.equals(oldPass))
            return false;

        if (!newPass.equals(confirmPass))
            return false;

        password = newPass;
        return true;
    }
}

// VIEW + CONTROLLER
public class EmployeePortal {

    static EmployeeModel model = new EmployeeModel();

    public static void main(String[] args) {
        showLogin();
    }

    static void showLogin() {

        JFrame frame = new JFrame("Employee Login");

        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();

        JButton login = new JButton("Login");

        frame.setLayout(new GridLayout(3, 2, 10, 10));
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new JLabel("Username"));
        frame.add(username);

        frame.add(new JLabel("Password"));
        frame.add(password);

        frame.add(login);

        login.addActionListener(e -> {

            String user = username.getText();
            String pass = new String(password.getPassword());

            if (model.login(user, pass)) {

                JOptionPane.showMessageDialog(
                    frame, "Login Successful");

                frame.dispose();
                showMainWindow();

            } else {

                JOptionPane.showMessageDialog(
                    frame, "Invalid Username or Password");
            }
        });

        frame.setVisible(true);
    }

    static void showMainWindow() {

        JFrame frame = new JFrame("Employee Management Portal");

        JMenuBar menuBar = new JMenuBar();

        JMenu employee = new JMenu("Employee");
        JMenu tools = new JMenu("Tools");
        JMenu exit = new JMenu("Exit");

        JMenuItem addEmployee =
            new JMenuItem("Add Employee");

        JMenuItem viewEmployee =
            new JMenuItem("View Employee");

        JMenuItem changePassword =
            new JMenuItem("Change Password");

        JMenuItem logout =
            new JMenuItem("Logout");

        JMenuItem exitApplication =
            new JMenuItem("Exit Application");

        employee.add(addEmployee);
        employee.add(viewEmployee);

        tools.add(changePassword);

        exit.add(logout);
        exit.add(exitApplication);

        menuBar.add(employee);
        menuBar.add(tools);
        menuBar.add(exit);

        frame.setJMenuBar(menuBar);

        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // ADD EMPLOYEE
        addEmployee.addActionListener(e -> {

            JTextField id = new JTextField();
            JTextField name = new JTextField();
            JTextField dept = new JTextField();

            Object[] fields = {
                "Employee ID:", id,
                "Employee Name:", name,
                "Department:", dept
            };

            int option = JOptionPane.showConfirmDialog(
                frame,
                fields,
                "Add Employee",
                JOptionPane.OK_CANCEL_OPTION
            );

            if (option == JOptionPane.OK_OPTION) {

                model.employeeID = id.getText();
                model.employeeName = name.getText();
                model.department = dept.getText();

                JOptionPane.showMessageDialog(
                    frame, "Employee Added Successfully");
            }
        });

        // VIEW EMPLOYEE
        viewEmployee.addActionListener(e -> {

            if (model.employeeID.equals("")) {

                JOptionPane.showMessageDialog(
                    frame, "No Employee Added");

            } else {

                JOptionPane.showMessageDialog(
                    frame,
                    "Employee ID: " + model.employeeID +
                    "\nName: " + model.employeeName +
                    "\nDepartment: " + model.department
                );
            }
        });

        // CHANGE PASSWORD
        changePassword.addActionListener(e -> {

            JPasswordField oldPass =
                new JPasswordField();

            JPasswordField newPass =
                new JPasswordField();

            JPasswordField confirmPass =
                new JPasswordField();

            Object[] fields = {
                "Old Password:", oldPass,
                "New Password:", newPass,
                "Confirm Password:", confirmPass
            };

            int option = JOptionPane.showConfirmDialog(
                frame,
                fields,
                "Change Password",
                JOptionPane.OK_CANCEL_OPTION
            );

            if (option == JOptionPane.OK_OPTION) {

                boolean success =
                    model.changePassword(
                        new String(oldPass.getPassword()),
                        new String(newPass.getPassword()),
                        new String(confirmPass.getPassword())
                    );

                if (success)
                    JOptionPane.showMessageDialog(
                        frame, "Password Changed");
                else
                    JOptionPane.showMessageDialog(
                        frame,
                        "Invalid old password or passwords do not match");
            }
        });

        // LOGOUT
        logout.addActionListener(e -> {

            frame.dispose();
            showLogin();
        });

        // EXIT
        exitApplication.addActionListener(e -> {
            System.exit(0);
        });
    }
}