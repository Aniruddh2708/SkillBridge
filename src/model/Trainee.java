package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a vocational Trainee in the SkillBridge system.
 *
 * <p>Trainees can view assigned skills, submit assignments, and export their
 * digital portfolio.  This class extends {@link User} and also implements
 * {@link Serializable} so that a trainee's portfolio object can be saved to a
 * file (covered in the File I/O module).</p>
 *
 * <p>Like {@link Trainer}, this class must provide concrete implementations of
 * the abstract methods declared in {@code User}; failing to do so would be a
 * compile-time error — yet another benefit of making {@code User} abstract.</p>
 */
public class Trainee extends User implements Serializable {

    /** Serialization version — update if the class structure changes. */
    private static final long serialVersionUID = 1L;

    // ------------------------------------------------------------------ fields

    /** Skills enrolled for this trainee. */
    private List<Skill> enrolledSkills;

    /** Overall completion percentage (0–100). */
    private int progressPercent;

    // --------------------------------------------------------------- constructor

    /**
     * Creates a new Trainee.
     *
     * @param userId   unique identifier (0 for unsaved)
     * @param name     full name
     * @param email    login email
     * @param password hashed password
     */
    public Trainee(int userId, String name, String email, String password) {
        super(userId, name, email, password);
        this.enrolledSkills  = new ArrayList<>();
        this.progressPercent = 0;
    }

    // ----------------------------------- implementation of User abstract methods

    /**
     * {@inheritDoc}
     *
     * <p>A Trainee's role is {@code "Trainee"}.  Providing this implementation
     * satisfies the abstract contract defined in {@link User}.</p>
     */
    @Override
    public String getRole() {
        return "Trainee";
    }

    /**
     * {@inheritDoc}
     *
     * <p>Trainees see the Trainee Portal dashboard after login.</p>
     */
    @Override
    public String getDashboardTitle() {
        return "Trainee Portal — Welcome, " + name;
    }

    // ---------------------------------------------------------- trainee actions

    /**
     * Displays the list of skills currently enrolled for this trainee.
     */
    public void viewSkills() {
        if (enrolledSkills.isEmpty()) {
            System.out.println(name + " has no enrolled skills yet.");
        } else {
            System.out.println(name + "'s enrolled skills:");
            for (Skill skill : enrolledSkills) {
                System.out.println("  - " + skill.getSkillName());
            }
        }
    }

    /**
     * Simulates submitting an assignment for a skill module.
     *
     * @param skillName name of the skill the assignment relates to
     */
    public void submitAssignment(String skillName) {
        // TODO: record submission in the database
        System.out.println(name + " submitted assignment for: " + skillName);
    }

    /**
     * Exports this trainee's skill portfolio as a text file.
     *
     * @param filePath destination file path
     */
    public void exportPortfolio(String filePath) {
        // TODO: implement full export via PortfolioExporter (Module: File I/O)
        System.out.println("Exporting portfolio for " + name + " to: " + filePath);
    }

    // --------------------------------------------------------------- accessors

    /** @return unmodifiable view of enrolled skills */
    public List<Skill> getEnrolledSkills() {
        return java.util.Collections.unmodifiableList(enrolledSkills);
    }

    /** @return current completion percentage */
    public int getProgressPercent() { return progressPercent; }

    /**
     * Adds a skill to this trainee's enrolment list.
     *
     * @param skill the skill to add
     */
    public void addSkill(Skill skill) {
        enrolledSkills.add(skill);
    }

    /**
     * Updates the trainee's overall progress percentage.
     *
     * @param percent value between 0 and 100
     */
    public void setProgressPercent(int percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Progress must be between 0 and 100.");
        }
        this.progressPercent = percent;
    }
}
