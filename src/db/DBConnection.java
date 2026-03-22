package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * BOILERPLATE — Module 3 (preview skeleton)
 * ──────────────────────────────────────────
 * DBConnection is a SINGLETON that manages the single shared JDBC connection.
 *
 * Why singleton?
 *   Opening a database connection is expensive.  Sharing one instance across
 *   the application avoids the overhead of creating/closing connections on
 *   every DB call.
 *
 * NOTE: Update the three constants below before Module 3.
 *
 * YOUR TASKS (will be activated in Module 3):
 *   • Fill in your MySQL credentials.
 *   • Understand the singleton pattern used here.
 *   • Add connection pooling or try-with-resources where appropriate.
 */
public class DBConnection {

    // ── Change these before Module 3 ─────────────────────────────────────────
    private static final String URL      = "jdbc:mysql://localhost:3306/skillbridge";
    private static final String DB_USER  = "your_mysql_username";
    private static final String PASSWORD = "your_mysql_password";

    // The single shared connection instance.
    private static Connection instance = null;

    // Private constructor — no one else may instantiate this class.
    private DBConnection() { }

    /**
     * Returns the shared Connection, creating it on first call.
     *
     * @return a live JDBC Connection
     * @throws SQLException if the connection cannot be established
     */
    public static Connection getInstance() throws SQLException {
        if (instance == null || instance.isClosed()) {
            instance = DriverManager.getConnection(URL, DB_USER, PASSWORD);
        }
        return instance;
    }

    /**
     * Closes the shared connection.  Call this when the application exits.
     */
    public static void close() {
        if (instance != null) {
            try {
                instance.close();
            } catch (SQLException e) {
                System.err.println("Warning: could not close DB connection — " + e.getMessage());
            }
        }
    }
}
