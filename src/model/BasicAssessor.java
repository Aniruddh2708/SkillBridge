package model;

/**
 * BOILERPLATE — Module 2, Task M2-2
 * ──────────────────────────────────
 * BasicAssessor is the first CONCRETE subclass of SkillAssessor.
 *
 * Assessment strategy: a trainee PASSES a skill if and only if
 * skill.isCompleted() returns true.  That's it — no score, no threshold.
 *
 * Why does this belong in Module 2 and not Module 1?
 *   SkillAssessor (M1-6) defined the *abstract* contract.
 *   BasicAssessor *fulfils* that contract.  You need both model.Skill
 *   (M1-5) and model.SkillAssessor (M1-6) complete before you can write
 *   a working concrete subclass.
 *
 * New Java concepts reinforced here:
 *   • @Override on a method inherited from an abstract parent.
 *   • Guard clause (null-check) at the top of a method.
 *   • Delegating to an inherited concrete method (describeResult).
 *
 * YOUR TASKS (marked // TODO):
 *   M2-2a  Complete the constructor (one line: super call).
 *   M2-2b  Implement assess(Skill skill) — null-check, then return isCompleted().
 */
public class BasicAssessor extends SkillAssessor {

    // ── Constructor ──────────────────────────────────────────────────────────
    /**
     * @param trainee the Trainee whose skills this assessor will evaluate
     */
    public BasicAssessor(Trainee trainee) {
        // TODO M2-2a: call super(trainee)
        //             That single call handles the null-check AND field assignment —
        //             SkillAssessor's constructor already validates trainee.
    }

    // ── Override abstract method ──────────────────────────────────────────────
    /**
     * Passes the skill if and only if it is marked completed.
     *
     * @param skill the Skill to assess (must not be null)
     * @return true if skill.isCompleted() is true, false otherwise
     * @throws IllegalArgumentException if skill is null
     */
    @Override
    public boolean assess(Skill skill) {
        // TODO M2-2b: validate that skill is not null
        //             (throw new IllegalArgumentException("skill must not be null"))
        //
        // TODO M2-2c: return skill.isCompleted()
        return false;
    }
}
