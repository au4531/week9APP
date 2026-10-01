import java.sql.*;
import java.util.*;

public class ProductManagement {

    static final String URL =
        "jdbc:mysql://localhost:3306/storedb";

    static final String USER = "root";
    static final String PASSWORD = "root";

    static Connection getConnection() throws Exception {

        return DriverManager.getConnection(
            URL, USER, PASSWORD);
    }

    // INSERT PRODUCT
    static void insertProduct() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = getConnection();

            String sql =
                "INSERT INTO Product VALUES (?, ?, ?, ?)";

            PreparedStatement ps =
                con.prepareStatement(sql);

            System.out.print("Product ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Product Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);

            ps.executeUpdate();

            System.out.println("Product inserted.");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // RETRIEVE PRODUCT
    static void getProduct() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = getConnection();

            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();

            String sql =
                "SELECT * FROM Product WHERE ProductID=?";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                    "Product ID: " +
                    rs.getInt("ProductID"));

                System.out.println(
                    "Product Name: " +
                    rs.getString("ProductName"));

                System.out.println(
                    "Price: " +
                    rs.getDouble("Price"));

                System.out.println(
                    "Quantity: " +
                    rs.getInt("Quantity"));

            } else {

                System.out.println("Product not found.");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // UPDATE QUANTITY
    static void updateQuantity() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = getConnection();

            System.out.print("Product ID: ");
            int id = sc.nextInt();

            System.out.print("New Quantity: ");
            int quantity = sc.nextInt();

            String sql =
                "UPDATE Product SET Quantity=? WHERE ProductID=?";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setInt(1, quantity);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Quantity updated.");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // LOW STOCK PRODUCTS
    static void lowStock() {

        try {

            Connection con = getConnection();

            String sql =
                "SELECT * FROM Product WHERE Quantity < 10";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\nLow Stock Products:");

            while (rs.next()) {

                System.out.println(
                    rs.getInt("ProductID") + " " +
                    rs.getString("ProductName") + " " +
                    rs.getDouble("Price") + " " +
                    rs.getInt("Quantity")
                );
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Insert Product");
            System.out.println("2. Get Product");
            System.out.println("3. Update Quantity");
            System.out.println("4. Low Stock Products");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    insertProduct();
                    break;

                case 2:
                    getProduct();
                    break;

                case 3:
                    updateQuantity();
                    break;

                case 4:
                    lowStock();
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}