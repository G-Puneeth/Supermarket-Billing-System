import java.sql.*;

public class TransactionDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    // 1️⃣ INSERT Transaction (Create)
    public static void insertTransaction(int id, int customerId, double amount, String date) {
        String query = "INSERT INTO transactions (id, customer_id, amount, date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setInt(2, customerId);
            stmt.setDouble(3, amount);
            stmt.setString(4, date);
            stmt.executeUpdate();
            System.out.println("Transaction added successfully!");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 2️⃣ READ Transactions (View transaction history)
    public static void fetchTransactions() {
        String query = "SELECT * FROM transactions";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Customer ID: " + rs.getInt("customer_id") +
                        ", Amount: " + rs.getDouble("amount") + ", Date: " + rs.getString("date"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 3️⃣ UPDATE Transaction (Modify)
    public static void updateTransaction(int id, double amount) {
        String query = "UPDATE transactions SET amount=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, amount);
            stmt.setInt(2, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) System.out.println("Transaction updated successfully!");
            else System.out.println("Transaction not found.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 4️⃣ DELETE Transaction
    public static void deleteTransaction(int id) {
        String query = "DELETE FROM transactions WHERE id=?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Transaction deleted successfully!");
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
