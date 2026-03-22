package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Trainee (rural-youth learner) in SkillBridge.
 *
 * Inherits from User and additionally implements Serializable so that
 * a Trainee object can be written to a file as a byte stream (M2 portfolio export).
 *
 * CONCEPTS DEMONSTRATED: Inheritance, Serializable, ArrayList, Collections.
 */
public class Trainee extends User implements Serializable {

    // Serializable requires a version stamp so Java can detect class changes
    // during deserialization. Always declare this when implementing Serializable.
    private static final long serialVersionUID = 1L;

    // --- Additional fields ----------------------------------------------
    // TODO-1: Declare a private int field called enrollmentYear.
    //   Stores the year the trainee joined the programme (e.g. 2024).

    // TODO-2: Declare a private List<Skill> field called skills.
    //   This will hold all skills assigned to this trainee.
    //   Initialise it as: new ArrayList<>()
    //   A List lets us add/remove skills without knowing the count upfront.

    // --- Constructor ----------------------------------------------------
    // TODO-3: Write: Trainee(userId, name, password, enrollmentYear)
    //   Call super(userId, name, password) first.
    //   Assign enrollmentYear.
    //   Initialise the skills list here too (new ArrayList<>()).

    // --- getRole --------------------------------------------------------
    // TODO-4: Override getRole() and return "TRAINEE".

    // --- Skills management ----------------------------------------------
    // TODO-5: Write a method: public void addSkill(Skill skill)
    //   It should call skills.add(skill).
    //   This is how a Trainer assigns a skill to this trainee.

    // TODO-6: Write a getter: public List<Skill> getSkills()
    //   Return the skills list.

    // --- Certificate eligibility ----------------------------------------
    // TODO-7: Write: public boolean isEligibleForCertificate()
    //   Return true if ALL skills in the list have completion status "COMPLETED".
    //   Hint: loop through skills and check each one's status.
    //   (You'll fill this in during M2 once Skill.java is complete.)

    // --- Getter ---------------------------------------------------------
    // TODO-8: Add a getter for enrollmentYear.
}
