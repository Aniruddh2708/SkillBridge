package model;

/**
 * Represents a Trainer (instructor/NGO staff) in SkillBridge.
 *
 * Inherits userId, name, password from User.
 * Adds: trainerCode — the institution-issued code that verifies the trainer.
 *
 * CONCEPTS DEMONSTRATED: Inheritance, super() constructor call,
 * method overriding (getRole).
 */
public class Trainer extends User {

    // --- Additional field -----------------------------------------------
    // TODO-1: Declare a private String field called trainerCode.
    //   This is unique to Trainer — User does not have it.

    // --- Constructor ----------------------------------------------------
    // TODO-2: Write a constructor: Trainer(userId, name, password, trainerCode)
    //   First line MUST be: super(userId, name, password);
    //   Then assign trainerCode.
    //   WHY super()? Because User's constructor initialises the shared fields.

    // --- getRole --------------------------------------------------------
    // TODO-3: Override getRole() and return the string "TRAINER".
    //   Use @Override annotation — the compiler will warn you if the
    //   method signature doesn't match the abstract method in User.

    // --- Getter ---------------------------------------------------------
    // TODO-4: Add a public getter for trainerCode.

    // --- toString (optional bonus) --------------------------------------
    // TODO-5 (bonus): Call super.toString() and append " | Code: " + trainerCode.
}
