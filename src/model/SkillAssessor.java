package model;

/**
 * M1-6: SkillAssessor — abstract base for grading strategies.
 *
 * Concepts demonstrated:
 *   - Second use of abstract classes (reinforcement)
 *   - Template-method pattern: the concrete assess() calls abstract helpers
 *   - Polymorphism: code that works with SkillAssessor works for every
 *     concrete assessor (PracticalAssessor, WrittenAssessor, etc.)
 *
 * ─────────────────────────────────────────────────────────────────────────────
 * YOUR TASKS FOR M1-6
 * Work through every TODO block below in order.
 * ─────────────────────────────────────────────────────────────────────────────
 */
public abstract class SkillAssessor {

    // -------------------------------------------------------------------------
    // TODO 1 — FIELDS
    // Declare two protected fields:
    //   (a) String  assessorId   — unique ID for this assessor instance
    //   (b) String  assessorName — human-readable name, e.g. "Written Test"
    //
    // Why protected (not private)?
    //   Concrete subclasses (PracticalAssessor, WrittenAssessor) may need to
    //   include these in their own toString() or logging — protected lets them
    //   read the values directly without forcing a getter call chain.
    //   (Compare with User.java where fields were private and subclasses
    //   use inherited getters — that's a stricter encapsulation style.)
    // -------------------------------------------------------------------------
    // TODO 1: declare the two protected fields here


    // -------------------------------------------------------------------------
    // TODO 2 — CONSTRUCTOR
    // Write: protected SkillAssessor(String assessorId, String assessorName)
    //   • Assign both fields with this.xxx = xxx.
    //   • Mark it protected — same reasoning as User's protected constructor:
    //     an abstract class cannot be instantiated, so public is misleading.
    // -------------------------------------------------------------------------
    // TODO 2: write the protected constructor here


    // -------------------------------------------------------------------------
    // TODO 3 — ABSTRACT METHOD: evaluate(Trainee trainee, Skill skill)
    // Declare:
    //   public abstract int evaluate(Trainee trainee, Skill skill);
    //
    // This returns a score 0–100.  Each subclass decides HOW to compute it
    // (practical demo, written test, portfolio review, etc.).
    //
    // Why abstract?
    //   There is no single correct way to assess every skill type — the
    //   algorithm must be supplied by each concrete subclass.
    // -------------------------------------------------------------------------
    // TODO 3: declare the abstract evaluate() method here


    // -------------------------------------------------------------------------
    // TODO 4 — CONCRETE METHOD: assess(Trainee trainee, Skill skill)
    // Write a concrete method that:
    //   1. Calls evaluate(trainee, skill) to get the score.
    //   2. If score >= 80, calls skill.markCompleted() and calls
    //      trainee.updateProgress(score).
    //   3. Prints the result either way, e.g.:
    //        "Assessment by <assessorName>: <trainee.getName()> scored <score>/100"
    //   4. Returns the score (int).
    //
    // This is the TEMPLATE METHOD pattern:
    //   • assess() defines the skeleton of the algorithm (call evaluate →
    //     check threshold → update state → print result).
    //   • evaluate() is the "hot spot" — the part that varies per subclass.
    //   • Callers only ever call assess(); they never call evaluate() directly.
    // -------------------------------------------------------------------------
    // TODO 4: write the concrete assess() method here


    // -------------------------------------------------------------------------
    // TODO 5 — GETTERS
    // Add getters: getAssessorId(), getAssessorName()
    // -------------------------------------------------------------------------
    // TODO 5: write the two getters here


    // -------------------------------------------------------------------------
    // TODO 6 — toString()
    // Return a one-line summary, e.g.:
    //   "SkillAssessor{id='SA-001', name='Written Test'}"
    // -------------------------------------------------------------------------
    // TODO 6: override toString() here
}
