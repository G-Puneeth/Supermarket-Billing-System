import java.sql.*;

public class CustomerDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    // 1️⃣ INSERT Customer (CREATE)
    public static void insertCustomer(int id, String name, String email, String phone) {
        String query = "INSERT INTO customers (id, name, email, phone) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, email);
            stmt.setString(4, phone);
            stmt.executeUpdate();
            System.out.println("Customer added successfully!");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 2️⃣ READ Customer (SELECT)
    public static void fetchCustomers() {
        String query = "SELECT * FROM customers";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                        ", Email: " + rs.getString("email") + ", Phone: " + rs.getString("phone"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 3️⃣ UPDATE Customer (MODIFY)
    public static void updateCustomer(int id, String name, String email, String phone) {
        String query = "UPDATE customers SET name=?, email=?, phone=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phone);
            stmt.setInt(4, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) System.out.println("Customer updated successfully!");
            else System.out.println("Customer not found.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 4️⃣ DELETE Customer (REMOVE)
    public static void deleteCustomer(int id) {
        String query = "DELETE FROM customers WHERE id=?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) System.out.println("Customer deleted successfully!");
            else System.out.println("Customer not found.");
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
