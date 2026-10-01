import java.sql.*;
import java.util.*;

public class CourseRegistration {

    static final String URL =
        "jdbc:mysql://localhost:3306/collegedb";

    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            // CONNECT TO DATABASE
            Connection con =
                DriverManager.getConnection(
                    URL, USER, PASSWORD);

            System.out.print("Enter Course Code: ");
            String courseCode = sc.nextLine();

            // SQL QUERY
            String sql =
                "SELECT * FROM CourseRegistration " +
                "WHERE CourseCode=?";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setString(1, courseCode);

            ResultSet rs =
                ps.executeQuery();

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println(
                    "\nStudent ID: " +
                    rs.getInt("StudentID"));

                System.out.println(
                    "Student Name: " +
                    rs.getString("StudentName"));

                System.out.println(
                    "Course Code: " +
                    rs.getString("CourseCode"));

                System.out.println(
                    "Course Name: " +
                    rs.getString("CourseName"));

                System.out.println(
                    "Semester: " +
                    rs.getInt("Semester"));
            }

            if (!found) {

                System.out.println(
                    "No students registered for this course.");
            }

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}
