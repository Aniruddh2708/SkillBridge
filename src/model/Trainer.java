package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;                          
/**
 * BOILERPLATE — Module 1, Task M1-3
 * ──────────────────────────────────
 * Trainer IS-A User who can enrol trainees and assign skills.
 *
 * Key OOP point: Trainer EXTENDS User, so it inherits all User fields
 * (userId, name, email, passwordHash) and must call super(...) to initialise
 * them — it does NOT redeclare them.
 *
 * YOUR TASKS (marked // TODO):
 *   • Add a trainer-specific field: a List<Trainee> for the trainee roster.
 *   • Complete the constructor (call super, initialise the list).
 *   • Override getRole() to return "TRAINER".
 *   • Implement enrollTrainee(Trainee t).
 *   • Implement getRoster() — returns an unmodifiable view.
 *   • Implement toString() — extend super.toString().
 */
public class Trainer extends User {
    private List<Trainee> roster;

    // ── Trainer-specific field ────────────────────────────────────────────────
    // TODO M1-3a: declare a private List<Trainee> field called roster
    //             Why ArrayList? Fast index access; trainer rosters are
    //             typically iterated, not searched by key.


    // ── Constructor ──────────────────────────────────────────────────────────
    /**
     * @param userId       unique trainer ID, e.g. "TR-001"
     * @param name         trainer's full name
     * @param email        trainer's login email
     * @param passwordHash hashed password
     */
    public Trainer(String userId, String name, String email, String passwordHash) {
        super(userId,name,email,passwordHash);
        this.roster=new ArrayList<>();
        // TODO M1-3b: call super(...) with all four parameters
        //             Then initialise the roster field to a new ArrayList<>()
    }


    // ── Override abstract method ─────────────────────────────────────────────
    /**
     * Returns the role label for a Trainer.
     * @return "TRAINER"
     */
    @Override
    public String getRole() {
        // TODO M1-3c: return the string "TRAINER"
        return "TRAINER";
    }


    // ── Trainer behaviour ─────────────────────────────────────────────────────

    /**
     * Adds a Trainee to this trainer's roster.
     * @param trainee the Trainee to enrol (must not be null)
     * @throws IllegalArgumentException if trainee is null
     */
    public void enrollTrainee(Trainee trainee) {
        // TODO M1-3d: validate that trainee is not null (throw IllegalArgumentException if so)
        //             Then add trainee to the roster list.
        if(trainee==null)
        {
            throw new IllegalArgumentException("Trainee cannot be null");
        }
        this.roster.add(trainee);
    }

    /**
     * Returns a read-only view of the trainer's roster.
     * Why unmodifiable? Callers should not add trainees except through
     * enrollTrainee(), which enforces the null-check.
     *
     * @return unmodifiable List of Trainees
     */
    public List<Trainee> getRoster() {

        // TODO M1-3e: return Collections.unmodifiableList(roster)
        //             Remember to import java.util.Collections
        return Collections.unmodifiableList(roster);
    }


    // ── toString ─────────────────────────────────────────────────────────────
    /**
     * @return e.g. "Trainer{base=User{id='TR-001', name='Riya', role='TRAINER'}, roster=2 trainee(s)}"
     */
    @Override
    public String toString() {
        // TODO M1-3f: use super.toString() for the User part, then append roster size.
        return "Trainer{base="+super.toString()+", roster="+this.roster.size()+" trainee(s)";
    }
}
