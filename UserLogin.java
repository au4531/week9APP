import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserLogin extends JFrame {

    JTextField username;
    JPasswordField password;

    JCheckBox rememberMe;
    JCheckBox notifications;

    JButton login;

    public UserLogin() {

        setTitle("User Login");
        setSize(350, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Username
        add(new JLabel("Username:"));

        username = new JTextField(20);
        add(username);

        // Password
        add(new JLabel("Password:"));

        password = new JPasswordField(20);
        add(password);

        // Checkboxes
        rememberMe = new JCheckBox("Remember Me");
        notifications = new JCheckBox("Receive Notifications");

        add(rememberMe);
        add(notifications);

        // Login button
        login = new JButton("Login");
        add(login);

        login.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String user = username.getText();
                String pass = new String(password.getPassword());

                if (user.equals("admin") && pass.equals("1234")) {

                    JOptionPane.showMessageDialog(
                        UserLogin.this,
                        "Login Successful!"
                    );

                } else {

                    JOptionPane.showMessageDialog(
                        UserLogin.this,
                        "Invalid Username or Password"
                    );
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new UserLogin();
    }
}