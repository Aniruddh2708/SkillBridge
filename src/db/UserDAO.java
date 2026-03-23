package db;

import model.Trainee;
import model.Trainer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * BOILERPLATE — Module 3 (preview skeleton)
 * ──────────────────────────────────────────
 * UserDAO (Data Access Object) isolates all SQL for User-related operations.
 *
 * DAO pattern: keeps SQL out of model/service classes so that:
 *   • Swapping MySQL for another DB only changes this class.
 *   • Model classes stay clean and testable without a real DB.
 *
 * YOUR TASKS (will be activated in Module 3):
 *   • Complete findByEmail() using a PreparedStatement.
 *   • Complete save() for both Trainer and Trainee.
 *   • Add findAll() returning List<model.User>.
 */
public class UserDAO {

    /**
     * Looks up a Trainee by email address.
     *
     * @param email the user's email
     * @return the Trainee, or null if not found
     * @throws SQLException if a DB error occurs
     */
    public Trainee findTraineeByEmail(String email) throws SQLException {
        // TODO M3-1: write a PreparedStatement SELECT query against the
        //            'trainees' table.  Use DBConnection.getInstance().
        //            Map the ResultSet row to a new Trainee object.
        return null;
    }

    /**
     * Looks up a Trainer by email address.
     *
     * @param email the trainer's email
     * @return the Trainer, or null if not found
     * @throws SQLException if a DB error occurs
     */
    public Trainer findTrainerByEmail(String email) throws SQLException {
        // TODO M3-2: similar to findTraineeByEmail but for the 'trainers' table
        return null;
    }

    /**
     * Persists a new Trainee to the database.
     *
     * @param trainee the Trainee to save
     * @throws SQLException if a DB error occurs
     */
    public void saveTrainee(Trainee trainee) throws SQLException {
        // TODO M3-3: INSERT INTO trainees using a PreparedStatement
    }

    /**
     * Persists a new Trainer to the database.
     *
     * @param trainer the Trainer to save
     * @throws SQLException if a DB error occurs
     */
    public void saveTrainer(Trainer trainer) throws SQLException {
        // TODO M3-4: INSERT INTO trainers using a PreparedStatement
    }
}
