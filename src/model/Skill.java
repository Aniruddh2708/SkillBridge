package model;

/**
 * BOILERPLATE — Module 1, Task M1-5
 * ──────────────────────────────────
 * Skill represents a single vocational skill or micro-course
 * (e.g. "Electrical Wiring", "Plumbing Basics").
 *
 * New Java concepts introduced here:
 *   • enum  — a fixed set of named constants (better than raw Strings for status).
 *   • boolean completed — simple flag to track whether the trainee finished.
 *
 * YOUR TASKS (marked // TODO):
 *   • Add fields: skillId, skillName, category, completed.
 *   • Complete the constructor.
 *   • Implement getters.
 *   • Implement markCompleted() — sets completed = true.
 *   • Implement toString().
 */
public class Skill {

    // ── Status enum ──────────────────────────────────────────────────────────
    // Using an enum instead of String prevents typos like "Commplete" at compile time.
    public enum Category {
        ELECTRICAL,
        PLUMBING,
        CARPENTRY,
        TAILORING,
        DIGITAL_LITERACY,
        OTHER
    }


    // ── Fields ───────────────────────────────────────────────────────────────

    // TODO M1-5a: declare a private final String field called skillId
    //             (final because a Skill's ID should never change)

    // TODO M1-5b: declare a private final String field called skillName

    // TODO M1-5c: declare a private final Category field called category

    // TODO M1-5d: declare a private boolean field called completed
    //             (default Java value for boolean is false — appropriate here)


    // ── Constructor ──────────────────────────────────────────────────────────
    /**
     * @param skillId   unique ID, e.g. "SK-07"
     * @param skillName human-readable name, e.g. "Electrical Wiring"
     * @param category  one of the Category enum values
     */
    public Skill(String skillId, String skillName, Category category) {
        // TODO M1-5e: assign all three parameters to their fields.
        //             Note: completed starts as false automatically.
    }


    // ── Getters ──────────────────────────────────────────────────────────────

    // TODO M1-5f: implement getSkillId()
    public String getSkillId() {
        return null;
    }

    // TODO M1-5g: implement getSkillName()
    public String getSkillName() {
        return null;
    }

    // TODO M1-5h: implement getCategory()  — returns a Category enum value
    public Category getCategory() {
        return null;
    }

    // TODO M1-5i: implement isCompleted()  — note: boolean getters are named "is..."
    public boolean isCompleted() {
        return false; // replace with correct return
    }


    // ── Behaviour ────────────────────────────────────────────────────────────

    /**
     * Marks this skill as completed by the trainee.
     * Once completed, a skill cannot be un-completed
     * (credentials are final — see Module 2 for the certification flow).
     */
    public void markCompleted() {
        // TODO M1-5j: set completed = true
    }


    // ── toString ─────────────────────────────────────────────────────────────
    /**
     * @return e.g. "Skill{id='SK-07', name='Electrical Wiring', category=ELECTRICAL, completed=true}"
     */
    @Override
    public String toString() {
        // TODO M1-5k: build and return the string shown above
        return null;
    }
}
