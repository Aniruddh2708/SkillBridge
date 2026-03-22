package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * BOILERPLATE — Module 1, Task M1-4
 * ──────────────────────────────────
 * Trainee IS-A User who is enrolled in vocational training.
 *
 * Extra interface: Serializable
 *   Implementing Serializable lets Java convert a Trainee object into a
 *   byte stream — we use this in Module 4 to export a trainee's portfolio
 *   to disk.  It requires no method implementation; it is a MARKER interface.
 *   The serialVersionUID constant pins the class version so a saved file
 *   doesn't break if the class changes slightly later.
 *
 * YOUR TASKS (marked // TODO):
 *   • Add trainee-specific fields (skills list, enrolledCourse).
 *   • Complete the constructor.
 *   • Override getRole() to return "TRAINEE".
 *   • Implement addSkill(Skill s) and getSkills().
 *   • Implement getEnrolledCourse() / setEnrolledCourse().
 *   • Implement toString().
 */
public class Trainee extends User implements Serializable {

    // Required when implementing Serializable.
    // If you change the class fields later, increment this number so that
    // previously-serialised files are rejected gracefully instead of corrupting.
    private static final long serialVersionUID = 1L;


    // ── Trainee-specific fields ───────────────────────────────────────────────

    // TODO M1-4a: declare a private List<Skill> field called skills
    //             (the skills this trainee has been assigned or completed)

    // TODO M1-4b: declare a private String field called enrolledCourse
    //             (e.g. "Electrical Wiring Basics")


    // ── Constructor ──────────────────────────────────────────────────────────
    /**
     * @param userId          unique trainee ID, e.g. "TN-042"
     * @param name            trainee's full name
     * @param email           trainee's login email
     * @param passwordHash    hashed password
     * @param enrolledCourse  name of the vocational course
     */
    public Trainee(String userId, String name, String email,
                   String passwordHash, String enrolledCourse) {
        // TODO M1-4c: call super(...) with userId, name, email, passwordHash
        //             Then initialise the skills list and assign enrolledCourse.
    }


    // ── Override abstract method ─────────────────────────────────────────────
    /**
     * @return "TRAINEE"
     */
    @Override
    public String getRole() {
        // TODO M1-4d: return the string "TRAINEE"
        return null;
    }


    // ── Skill management ─────────────────────────────────────────────────────

    /**
     * Assigns a new Skill to this trainee.
     * @param skill the Skill to add (must not be null)
     * @throws IllegalArgumentException if skill is null
     */
    public void addSkill(Skill skill) {
        // TODO M1-4e: validate skill is not null, then add it to the list
    }

    /**
     * Returns the trainee's skill list (read-only).
     * @return unmodifiable List of Skills
     */
    public List<Skill> getSkills() {
        // TODO M1-4f: return Collections.unmodifiableList(skills)
        return null;
    }


    // ── Enrolled course ──────────────────────────────────────────────────────

    public String getEnrolledCourse() {
        // TODO M1-4g: return enrolledCourse
        return null;
    }

    public void setEnrolledCourse(String enrolledCourse) {
        // TODO M1-4h: assign the parameter to the field
        //             (a trainee CAN switch course, so a setter is appropriate here)
    }


    // ── toString ─────────────────────────────────────────────────────────────
    /**
     * @return e.g. "Trainee{base=..., course='Electrical Wiring Basics', skills=3}"
     */
    @Override
    public String toString() {
        // TODO M1-4i: use super.toString() and append course + skills count
        return null;
    }
}
