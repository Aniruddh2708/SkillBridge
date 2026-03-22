package model;

/**
 * Abstract assessor — demonstrates abstraction and polymorphism.
 *
 * The abstract class defines the CONTRACT (what every assessor must do)
 * without specifying HOW. The two concrete subclasses provide different
 * algorithms for calculating a trainee's score.
 *
 * CONCEPTS DEMONSTRATED: Abstract classes, polymorphism, method overriding,
 * strategy-like pattern (different assessment algorithms).
 *
 * Usage example (you'll write this in Main.java later):
 *   SkillAssessor assessor = new BasicAssessor();
 *   int result = assessor.assess(trainee, skill);  // calls BasicAssessor.assess()
 *
 *   assessor = new AdvancedAssessor();
 *   result = assessor.assess(trainee, skill);       // now calls AdvancedAssessor.assess()
 *   // Same variable, different behaviour — that's runtime polymorphism!
 */
public abstract class SkillAssessor {

    // --- Abstract method ------------------------------------------------
    // TODO-1: Declare the abstract method:
    //   public abstract int assess(Trainee trainee, Skill skill);
    //
    //   It takes a Trainee and a Skill, and returns a score (0–100).
    //   Both BasicAssessor and AdvancedAssessor MUST implement this.

    // --- Concrete helper (shared by all subclasses) ---------------------
    // TODO-2: Write: public boolean isPassing(int score)
    //   Return true if score >= 60.
    //   This is a CONCRETE method in an abstract class — legal in Java!
    //   Subclasses inherit it for free.

    // ====================================================================
    // INNER CLASS: BasicAssessor
    // ====================================================================
    /**
     * Simple assessor — scores based solely on the trainee's self-reported
     * completion percentage stored on the Skill.
     */
    public static class BasicAssessor extends SkillAssessor {

        // TODO-3: Implement assess(trainee, skill):
        //   Return skill.getScore() directly.
        //   (Basic: trust the score already stored on the skill object.)
    }

    // ====================================================================
    // INNER CLASS: AdvancedAssessor
    // ====================================================================
    /**
     * Advanced assessor — applies a weighted formula:
     *   score × 0.7  +  bonus points for completing all skills.
     *
     * (Simulates a real grading rubric with participation bonus.)
     */
    public static class AdvancedAssessor extends SkillAssessor {

        // TODO-4: Implement assess(trainee, skill):
        //   1. Start with baseScore = skill.getScore() * 0.7
        //   2. If trainee.isEligibleForCertificate(), add 30 bonus points.
        //   3. Cap the total at 100.
        //   4. Return as int (cast from double).
        //   Hint: Math.min(100, (int)(baseScore + bonus))
    }
}
