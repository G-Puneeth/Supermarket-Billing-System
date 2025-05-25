import java.sql.*;

public class EmployeeDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    // 1️⃣ INSERT Employee (Create)
    public static void insertEmployee(int id, String name, String role, double salary) {
        String query = "INSERT INTO employees (id, name, role, salary) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, role);
            stmt.setDouble(4, salary);
            stmt.executeUpdate();
            System.out.println("Employee added successfully!");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 2️⃣ READ Employees (Retrieve all employees)
    public static void fetchEmployees() {
        String query = "SELECT * FROM employees";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                        ", Role: " + rs.getString("role") + ", Salary: " + rs.getDouble("salary"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 3️⃣ UPDATE Employee (Modify Employee Details)
    public static void updateEmployee(int id, String name, String role, double salary) {
        String query = "UPDATE employees SET name=?, role=?, salary=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, role);
            stmt.setDouble(3, salary);
            stmt.setInt(4, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) System.out.println("Employee updated successfully!");
            else System.out.println("Employee not found.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 4️⃣ DELETE Employee
    public static void deleteEmployee(int id) {
        String query = "DELETE FROM employees WHERE id=?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) System.out.println("Employee deleted successfully!");
            else System.out.println("Employee not found.");
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
