package model;

/**
 * Abstract base class for skill assessment strategies in SkillBridge.
 *
 * <h2>A second example of an abstract class</h2>
 *
 * <p>Just like {@link User}, {@code SkillAssessor} is abstract because the
 * concept of "some assessor" is too vague to instantiate directly.  The system
 * supports different assessment approaches — a basic pass/fail check and a
 * more advanced rubric-based evaluation — and each approach is captured by a
 * concrete subclass ({@code BasicAssessor} and {@code AdvancedAssessor},
 * to be implemented in a later module).</p>
 *
 * <p>Declaring {@link #assess(Trainee, Skill)} as {@code abstract} forces every
 * subclass to define its own scoring algorithm, while the
 * {@link #printResult(Trainee, Skill, boolean)} helper is shared by all of
 * them — demonstrating the same DRY benefit seen in {@code User}.</p>
 */
public abstract class SkillAssessor {

    /**
     * Assesses whether the given trainee has completed the given skill.
     *
     * <p>Concrete subclasses define the actual evaluation logic:
     * <ul>
     *   <li>{@code BasicAssessor} — simple binary pass/fail based on
     *       completion flag</li>
     *   <li>{@code AdvancedAssessor} — rubric-based scoring with a minimum
     *       threshold (to be implemented)</li>
     * </ul>
     * </p>
     *
     * @param trainee the trainee being assessed
     * @param skill   the skill being evaluated
     * @return {@code true} if the trainee passes the assessment
     */
    public abstract boolean assess(Trainee trainee, Skill skill);

    /**
     * Prints a standardised result message after an assessment.
     *
     * <p>Because this logic is the same regardless of the assessment strategy,
     * it is implemented once here and reused by all subclasses.</p>
     *
     * @param trainee the trainee who was assessed
     * @param skill   the skill that was evaluated
     * @param passed  {@code true} if the trainee passed
     */
    public void printResult(Trainee trainee, Skill skill, boolean passed) {
        String result = passed ? "PASSED" : "FAILED";
        System.out.println("[Assessment] " + trainee.getName()
                + " | Skill: " + skill.getSkillName()
                + " | Result: " + result);
    }
}
