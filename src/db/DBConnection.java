package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton JDBC connection manager.
 *
 * WHY Singleton?
 *   Opening a new database connection is expensive (network handshake,
 *   authentication). A Singleton ensures the application reuses one
 *   connection rather than creating a new one for every query.
 *
 * Singleton Recipe (classic "lazy initialisation" approach):
 *   1. Private static instance variable.
 *   2. Private constructor (no other class can call new DBConnection()).
 *   3. Public static getInstance() method that creates the instance on
 *      first call and returns it on all subsequent calls.
 *
 * CONCEPTS DEMONSTRATED: Singleton pattern, JDBC, static members,
 * private constructor, SQLException handling.
 */
public class DBConnection {

    // --- DB credentials -------------------------------------------------
    // TODO-1: Declare three private static final String constants:
    //   URL      = "jdbc:mysql://localhost:3306/skillbridge"
    //   DB_USER  = "root"         ← replace with your MySQL username
    //   PASSWORD = "your_password" ← replace with your MySQL password

    // --- Singleton instance ---------------------------------------------
    // TODO-2: Declare: private static DBConnection instance;
    //   This holds the one-and-only DBConnection object.
    //   It starts as null and is assigned in getInstance().

    // --- The real JDBC connection ----------------------------------------
    // TODO-3: Declare: private Connection connection;
    //   This is the actual java.sql.Connection object used to send SQL.

    // --- Private constructor --------------------------------------------
    // TODO-4: Write a private constructor DBConnection() that:
    //   a) Calls DriverManager.getConnection(URL, DB_USER, PASSWORD)
    //      and stores the result in `connection`.
    //   b) Wraps the call in try/catch(SQLException e) and prints the error.
    //   WHY private? Prevents outside code from calling `new DBConnection()`.

    // --- getInstance ----------------------------------------------------
    // TODO-5: Write: public static DBConnection getInstance()
    //   If instance == null, create: instance = new DBConnection();
    //   Return instance.
    //   This is the only way to obtain a DBConnection object.

    // --- getConnection --------------------------------------------------
    // TODO-6: Write: public Connection getConnection()
    //   Simply return the `connection` field.
    //   Callers (like UserDAO) use this to prepare and execute statements.
}
