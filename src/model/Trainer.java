package model;

import java.util.ArrayList;

/**
 * M1-2: Trainer — extends User.
 *
 * A Trainer can enroll Trainees into their roster and manage their progress.
 * Concepts demonstrated: inheritance, super() constructor call, ArrayList collection.
 */
public class Trainer extends User {

    // Roster of trainees managed by this trainer
    private ArrayList<Trainee> roster;

    // --- Constructor ---
    public Trainer(String name, String email, String userId) {
        super(name, email, userId, "TRAINER");   // M1-2: super() call
        this.roster = new ArrayList<>();
    }

    // --- Overrides ---

    @Override
    public boolean login(String password) {
        // Placeholder: real authentication will use JDBC in M3
        return password != null && !password.isEmpty();
    }

    @Override
    public String getRole() {
        return "TRAINER";
    }

    // --- Roster management ---

    /**
     * Enroll a Trainee into this trainer's roster.
     * M1-2: enrollTrainee method
     *
     * @param trainee the Trainee to add
     */
    public void enrollTrainee(Trainee trainee) {
        if (trainee != null && !roster.contains(trainee)) {
            roster.add(trainee);
            System.out.println("Enrolled: " + trainee.getName() + " under trainer " + this.name);
        }
    }

    /** Returns the full trainee roster. */
    public ArrayList<Trainee> getRoster() {
        return roster;
    }

    /** Prints all trainees in the roster. */
    public void printRoster() {
        System.out.println("=== Roster for Trainer: " + name + " ===");
        if (roster.isEmpty()) {
            System.out.println("  (no trainees enrolled)");
        } else {
            for (Trainee t : roster) {
                System.out.println("  - " + t);
            }
        }
    }
}
