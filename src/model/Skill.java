package model;

/**
 * M1-5: Skill — represents a single vocational skill in the SkillBridge system.
 *
 * Concepts demonstrated:
 *   - Enums  (SkillLevel: BEGINNER / INTERMEDIATE / ADVANCED)
 *   - Encapsulation via private fields + getters
 *   - A boolean completion flag managed through a dedicated method
 *   - toString() for clean console output
 *
 * ─────────────────────────────────────────────────────────────────────────────
 * YOUR TASKS FOR M1-5
 * Work through every TODO block below in order.
 * Each block explains what to write and why.
 * ─────────────────────────────────────────────────────────────────────────────
 */
public class Skill {

    // -------------------------------------------------------------------------
    // TODO 1 — NESTED ENUM: SkillLevel
    //
    // Define a public enum called SkillLevel INSIDE this class (nested) with
    // three constants: BEGINNER, INTERMEDIATE, ADVANCED.
    //
    // Why an enum instead of plain Strings?
    //   • A String can hold any value — "BEGGINER" (typo) compiles fine and
    //     silently breaks comparisons at runtime.
    //   • An enum is a *closed* set of valid values; a typo is a compile error.
    //   • IDE auto-complete works; Strings don't benefit from that safety.
    //
    // Skeleton:
    //   public enum SkillLevel {
    //       BEGINNER, INTERMEDIATE, ADVANCED
    //   }
    // -------------------------------------------------------------------------
    // TODO 1: declare the SkillLevel enum here


    // -------------------------------------------------------------------------
    // TODO 2 — FIELDS
    // Declare four private fields:
    //   (a) String     skillId      — unique identifier, e.g. "SK-001"
    //   (b) String     skillName    — human-readable label, e.g. "Java Basics"
    //   (c) SkillLevel level        — difficulty of this skill
    //   (d) boolean    isCompleted  — true once the trainee finishes this skill
    //
    // All four should be private — callers must use getters / setters.
    // -------------------------------------------------------------------------
    // TODO 2: declare the four private fields here


    // -------------------------------------------------------------------------
    // TODO 3 — CONSTRUCTOR
    // Write: public Skill(String skillId, String skillName, SkillLevel level)
    //   • Assign skillId, skillName, level from parameters.
    //   • Set isCompleted = false  (a new skill is never completed from the start).
    //
    // Why no isCompleted parameter? Because we always start uncompleted —
    // letting callers pass any value would allow creating a skill that is
    // "already completed" without any work, which is a logic bug.
    // -------------------------------------------------------------------------
    // TODO 3: write the constructor here


    // -------------------------------------------------------------------------
    // TODO 4 — markCompleted()
    // Write: public void markCompleted()
    //   • Set isCompleted = true.
    //   • Print a confirmation message, e.g.:
    //       System.out.println("✅ Skill '" + skillName + "' marked as completed.");
    //
    // Why a dedicated method instead of a plain setter?
    //   A setter setIsCompleted(boolean) allows callers to pass false and
    //   "un-complete" a skill, which might be intentional but is surprising.
    //   A dedicated markCompleted() makes the intent crystal-clear and only
    //   allows one-way transitions (false → true).
    // -------------------------------------------------------------------------
    // TODO 4: write markCompleted() here


    // -------------------------------------------------------------------------
    // TODO 5 — GETTERS
    // Add a getter for each field:
    //   getSkillId(), getSkillName(), getLevel(), isCompleted()
    //
    // Note: for a boolean field, the Java convention is isXxx() not getXxx().
    // -------------------------------------------------------------------------
    // TODO 5: write the four getters here


    // -------------------------------------------------------------------------
    // TODO 6 — toString()
    // Override toString() to return a one-line summary, e.g.:
    //   "Skill{id='SK-001', name='Java Basics', level=BEGINNER, completed=false}"
    //
    // Tip: use String.format() — it keeps formatting readable.
    //   return String.format(
    //       "Skill{id='%s', name='%s', level=%s, completed=%b}",
    //       skillId, skillName, level, isCompleted);
    // -------------------------------------------------------------------------
    // TODO 6: override toString() here
}
