package model;

/**
 * BOILERPLATE — Module 2, Task M2-1
 * ──────────────────────────────────
 * BasicAssessor is the FIRST CONCRETE subclass of SkillAssessor.
 *
 * Strategy: a trainee passes a skill if (and only if) they have called
 * markCompleted() on it.  No scoring, no weighting — just the completion flag.
 *
 * New Java concept introduced here:
 *   • Concrete class extending an abstract class — you MUST provide a body
 *     for every abstract method declared in the parent.  The compiler will
 *     refuse to compile BasicAssessor until assess() is implemented.
 *
 * Notice what you do NOT write:
 *   • No extra fields  — all state (the trainee reference) lives in SkillAssessor.
 *   • No describeResult() override — that concrete method is INHERITED as-is.
 *     Your assess() will be called by it automatically through late binding.
 *
 * YOUR TASKS (marked // TODO):
 *   • Implement the constructor (one line: super call).
 *   • Implement assess(Skill skill) (one line: check the completion flag).
 */
public class BasicAssessor extends SkillAssessor {

    // ── Constructor ──────────────────────────────────────────────────────────
    /**
     * @param trainee the Trainee whose skills are being assessed
     */
    public BasicAssessor(Trainee trainee) {
        // TODO M2-1a: pass trainee to the parent constructor using super(...)
    }

    // ── Abstract method implementation ────────────────────────────────────────
    /**
     * A basic assessment passes if the skill has been marked completed.
     *
     * @param skill the Skill to assess
     * @return true if skill.isCompleted() is true, false otherwise
     */
    @Override
    public boolean assess(Skill skill) {
        // TODO M2-1b: return whether the skill is completed
        //             Hint: skill.isCompleted()
        return false;
    }

    // NOTE: describeResult(Skill skill) is inherited from SkillAssessor.
    // Once assess() is implemented above, calling describeResult() on a
    // BasicAssessor will automatically use your assess() via late binding.
}
