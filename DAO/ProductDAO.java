import java.sql.*;

public class ProductDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    // 1️⃣ INSERT Product
    public static void insertProduct(int id, String name, double price, int stock) {
        String query = "INSERT INTO products (id, name, price, stock) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setDouble(3, price);
            stmt.setInt(4, stock);
            stmt.executeUpdate();
            System.out.println("Product added successfully!");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 2️⃣ READ Products
    public static void fetchProducts() {
        String query = "SELECT * FROM products";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                        ", Price: " + rs.getDouble("price") + ", Stock: " + rs.getInt("stock"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 3️⃣ UPDATE Product
    public static void updateProduct(int id, String name, double price, int stock) {
        String query = "UPDATE products SET name=?, price=?, stock=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setDouble(2, price);
            stmt.setInt(3, stock);
            stmt.setInt(4, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) System.out.println("Product updated successfully!");
            else System.out.println("Product not found.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 4️⃣ DELETE Product
    public static void deleteProduct(int id) {
        String query = "DELETE FROM products WHERE id=?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) System.out.println("Product deleted successfully!");
            else System.out.println("Product not found.");
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
