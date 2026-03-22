package db;

import model.User;
import model.Trainer;
import model.Trainee;
import service.AuthException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Data Access Object (DAO) for User-related database operations.
 *
 * WHY a DAO?
 *   Keeps all SQL in one place. The GUI and service layers never write SQL —
 *   they just call methods like findByUsername(). If the DB schema changes,
 *   you only update this file.
 *
 * CONCEPTS DEMONSTRATED: JDBC PreparedStatement, ResultSet, DAO pattern,
 * custom exception (AuthException), polymorphic return type (User).
 */
public class UserDAO {

    // --- Connection reference -------------------------------------------
    private Connection conn;

    // TODO-1: Write a constructor UserDAO() that:
    //   Assigns conn = DBConnection.getInstance().getConnection();
    //   This fetches the singleton connection established at startup.

    // --- Find by username and password ----------------------------------
    /**
     * Looks up a user by username and password.
     * Returns the correct subtype (Trainer or Trainee) based on the role column.
     *
     * @param username The login username.
     * @param password The login password.
     * @return A Trainer or Trainee object.
     * @throws AuthException If no matching user is found.
     * @throws SQLException  If the query fails.
     */
    public User findByCredentials(String username, String password)
            throws AuthException, SQLException {

        // TODO-2: Write a SQL string:
        //   "SELECT * FROM users WHERE username = ? AND password = ?"
        //   The ? placeholders are filled in by PreparedStatement — this
        //   prevents SQL injection attacks.

        // TODO-3: Use try-with-resources:
        //   try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        //       stmt.setString(1, username);   // first ?
        //       stmt.setString(2, password);   // second ?
        //       ResultSet rs = stmt.executeQuery();

        // TODO-4: If rs.next() is true, a row was found. Read columns:
        //   String userId = rs.getString("user_id");
        //   String name   = rs.getString("name");
        //   String role   = rs.getString("role");  // "TRAINER" or "TRAINEE"
        //
        //   If role is "TRAINER", create and return a new Trainer(...)
        //   If role is "TRAINEE", create and return a new Trainee(...)
        //   (You'll need the extra columns for each subtype too.)

        // TODO-5: If rs.next() returns false, throw:
        //   throw new AuthException("Invalid username or password.");

        return null; // placeholder — remove once TODOs are complete
    }

    // --- Save a new user ------------------------------------------------
    /**
     * Inserts a new user record into the database.
     *
     * @param user The User (Trainer or Trainee) to persist.
     * @throws SQLException If the insert fails.
     */
    public void save(User user) throws SQLException {
        // TODO-6: Write INSERT SQL and use PreparedStatement to execute it.
        //   INSERT INTO users (user_id, name, password, role) VALUES (?, ?, ?, ?)
        //   Use stmt.executeUpdate() (not executeQuery) for INSERT/UPDATE/DELETE.
    }
}
