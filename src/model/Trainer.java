package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a vocational Trainer in the SkillBridge system.
 *
 * <p>Trainers can enroll trainees, assign skills/courses, and assess progress.
 * This class extends {@link User} and provides its own implementations of the
 * abstract methods, proving the "contract" defined in the base class.</p>
 *
 * <p>Because {@code User} is abstract, you cannot write {@code new User(...)}.
 * Instead you write {@code new Trainer(...)}, which clearly communicates
 * <em>what kind</em> of user is being created.</p>
 */
public class Trainer extends User {

    // ------------------------------------------------------------------ fields

    /** Skills/courses this trainer is qualified to teach. */
    private List<Skill> assignedSkills;

    // --------------------------------------------------------------- constructor

    /**
     * Creates a new Trainer.
     *
     * @param userId   unique identifier (0 for unsaved)
     * @param name     full name
     * @param email    login email
     * @param password hashed password
     */
    public Trainer(int userId, String name, String email, String password) {
        super(userId, name, email, password);
        this.assignedSkills = new ArrayList<>();
    }

    // ----------------------------------- implementation of User abstract methods

    /**
     * {@inheritDoc}
     *
     * <p>A Trainer's role is {@code "Trainer"}.  This method <em>must</em>
     * exist here because {@link User#getRole()} is abstract — the compiler
     * will not allow a concrete subclass that leaves it unimplemented.</p>
     */
    @Override
    public String getRole() {
        return "Trainer";
    }

    /**
     * {@inheritDoc}
     *
     * <p>Trainers land on the Trainer Portal dashboard after login.</p>
     */
    @Override
    public String getDashboardTitle() {
        return "Trainer Portal — Welcome, " + name;
    }

    // ---------------------------------------------------------- trainer actions

    /**
     * Enrolls a trainee into this trainer's roster.
     *
     * @param trainee the {@link Trainee} to enroll
     */
    public void enrollTrainee(Trainee trainee) {
        // TODO: persist the enrolment relationship in the database via UserDAO
        System.out.println(name + " enrolled trainee: " + trainee.getName());
    }

    /**
     * Assigns a skill to this trainer's course list.
     *
     * @param skill the {@link Skill} to assign
     */
    public void assignSkill(Skill skill) {
        assignedSkills.add(skill);
        System.out.println(name + " assigned skill: " + skill.getSkillName());
    }

    /**
     * Displays a progress report for a given trainee.
     *
     * @param trainee the {@link Trainee} whose progress to assess
     */
    public void assessProgress(Trainee trainee) {
        // TODO: query progress data from the database
        System.out.println(name + " is assessing progress for: " + trainee.getName());
    }

    // --------------------------------------------------------------- accessors

    /** @return unmodifiable view of skills assigned to this trainer */
    public List<Skill> getAssignedSkills() {
        return java.util.Collections.unmodifiableList(assignedSkills);
    }
}
