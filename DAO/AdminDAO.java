import java.sql.*;
import database.DatabaseConnection;

public class AdminDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "Project1";
    private static final String PASSWORD = "Pg@12345";

    // 1️⃣ INSERT Admin (Create)
    public static void insertAdmin(int id, String username, String password) {
        String query = "INSERT INTO admins (id, username, password) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.executeUpdate();
            System.out.println("Admin added successfully!");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 2️⃣ READ Admins (Retrieve all admin users)
    public static void fetchAdmins() {
        String query = "SELECT * FROM admins";
        try (Connection conn = DatabaseConnection.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Username: " + rs.getString("username"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 3️⃣ UPDATE Admin Credentials
    public static void updateAdmin(int id, String username, String password) {
        String query = "UPDATE admins SET username=?, password=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setInt(3, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) System.out.println("Admin updated successfully!");
            else System.out.println("Admin not found.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 4️⃣ DELETE Admin (Remove Admin)
    public static void deleteAdmin(int id) {
        String query = "DELETE FROM admins WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) System.out.println("Admin deleted successfully!");
            else System.out.println("Admin not found.");
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
