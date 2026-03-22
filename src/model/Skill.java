package model;

/**
 * Represents a skill or course offered in the SkillBridge system.
 *
 * <p>Skills are the core unit of the vocational training programme.  Trainers
 * assign skills to their curriculum; Trainees are enrolled in skills and track
 * their completion status per skill.</p>
 */
public class Skill {

    // ------------------------------------------------------------------ fields

    /** Unique identifier stored in the database. */
    private int skillId;

    /** Short name for the skill (e.g. "Basic Electrical Wiring"). */
    private String skillName;

    /** Detailed description of what the skill covers. */
    private String description;

    /**
     * Completion status for this skill.
     *
     * <p><strong>Module 1 simplification:</strong> In a fully normalised
     * design, completion is per-trainee and should live in a separate
     * {@code TraineeSkillEnrollment} association class (linking a
     * {@link Trainee} to a {@link Skill} with its own status field).  For now
     * this flag is kept here to keep the model simple while we focus on OOP
     * fundamentals; it will be refactored when we introduce the database
     * layer in Module 3.</p>
     */
    private boolean completed;

    // --------------------------------------------------------------- constructor

    /**
     * Creates a new Skill.
     *
     * @param skillId     unique identifier (0 for unsaved)
     * @param skillName   short display name
     * @param description detailed description
     */
    public Skill(int skillId, String skillName, String description) {
        this.skillId     = skillId;
        this.skillName   = skillName;
        this.description = description;
        this.completed   = false;
    }

    // --------------------------------------------------------------- accessors

    /** @return unique skill ID */
    public int getSkillId() { return skillId; }

    /** @return short display name */
    public String getSkillName() { return skillName; }

    /** @return detailed description */
    public String getDescription() { return description; }

    /** @return {@code true} if the skill has been completed */
    public boolean isCompleted() { return completed; }

    /**
     * Marks this skill as completed or incomplete.
     *
     * @param completed {@code true} to mark complete
     */
    public void setCompleted(boolean completed) { this.completed = completed; }

    // ----------------------------------------------------------------- utility

    @Override
    public String toString() {
        return "Skill [id=" + skillId + ", name=" + skillName
                + ", completed=" + completed + "]";
    }
}
