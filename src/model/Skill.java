package model;

import java.io.Serializable;

/**
 * Represents a single vocational skill or course unit.
 *
 * A Skill is the core data unit of SkillBridge. Trainees collect Skills.
 * Trainers create and assign Skills.
 *
 * Serializable because Skill objects live inside a Trainee which is Serializable —
 * all nested objects must also be Serializable for portfolio export to work.
 *
 * CONCEPTS DEMONSTRATED: Plain Java object (POJO), enums (optional),
 * encapsulation, Serializable.
 */
public class Skill implements Serializable {

    private static final long serialVersionUID = 1L;

    // --- Fields ---------------------------------------------------------
    // TODO-1: Declare these private fields:
    //   String skillId     — unique ID like "SK001"
    //   String name        — e.g. "Basic Electrical Wiring"
    //   String category    — e.g. "Electrical", "Mechanical", "IT"
    //   String status      — completion status: "PENDING", "IN_PROGRESS", "COMPLETED"
    //   int score          — assessment score out of 100 (0 if not yet assessed)

    // --- Constructor ----------------------------------------------------
    // TODO-2: Write a constructor Skill(skillId, name, category).
    //   Set status to "PENDING" and score to 0 by default.
    //   We don't know the score at creation time — defaults make sense here.

    // --- Getters & Setters ----------------------------------------------
    // TODO-3: Add getters for all five fields.

    // TODO-4: Add setters for status and score only.
    //   skillId, name, and category should never change after creation.

    // --- Helper method --------------------------------------------------
    // TODO-5: Write: public boolean isCompleted()
    //   Return true if status.equals("COMPLETED").
    //   Trainee.isEligibleForCertificate() will call this.

    // --- toString -------------------------------------------------------
    // TODO-6: Override toString() to return:
    //   "Skill[SK001 | Basic Electrical Wiring | COMPLETED | 85/100]"
}
