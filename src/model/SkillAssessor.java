package model;

/**
 * BOILERPLATE — Module 1, Task M1-6
 * ──────────────────────────────────
 * SkillAssessor is an ABSTRACT CLASS that demonstrates polymorphism.
 *
 * The system has two kinds of assessment:
 *   • BasicAssessor  — simple pass/fail by completion flag.
 *   • AdvancedAssessor — weighted score + threshold (introduced in Module 2).
 *
 * This class holds the shared state (the Trainee being assessed) and
 * declares the abstract contract (assess) that every concrete assessor
 * must fulfil.
 *
 * Why abstract here too (same reasoning as User)?
 *   An "assessor" with no assessment logic is meaningless — you always
 *   need a specific strategy.  The abstract method forces the strategy to
 *   be provided at compile time.
 *
 * YOUR TASKS (marked // TODO):
 *   • Add the trainee field.
 *   • Complete the constructor.
 *   • Implement getTrainee().
 *   • Leave the abstract method signature unchanged.
 *   • Implement the concrete helper describeResult().
 */
public abstract class SkillAssessor {

    // ── Field ─────────────────────────────────────────────────────────────────
    // TODO M1-6a: declare a private final Trainee field called trainee

    // ── Constructor ──────────────────────────────────────────────────────────
    /**
     * @param trainee the Trainee whose skills are being assessed
     */
    protected SkillAssessor(Trainee trainee) {
        // TODO M1-6b: validate trainee is not null, then assign to field
    }

    // ── Getter ───────────────────────────────────────────────────────────────
    public Trainee getTrainee() {
        // TODO M1-6c: return the trainee field
        return null;
    }

    // ── Abstract method ───────────────────────────────────────────────────────
    /**
     * Runs the assessment for a specific skill.
     *
     * @param skill the Skill to assess
     * @return true if the trainee passes the assessment for this skill
     */
    public abstract boolean assess(Skill skill);

    // ── Concrete helper ───────────────────────────────────────────────────────
    /**
     * Returns a human-readable result string using the result of assess().
     * This method is CONCRETE because all assessors describe results the same way.
     *
     * @param skill the Skill that was assessed
     * @return e.g. "Riya PASSED Electrical Wiring" or "Riya FAILED Plumbing Basics"
     */
    public String describeResult(Skill skill) {
        // TODO M1-6d: call assess(skill) and build the result string.
        // Hint: trainee.getName() + (assess(skill) ? " PASSED " : " FAILED ") + skill.getSkillName()
        return null;
    }
}
