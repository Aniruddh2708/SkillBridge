package model;

/**
 * Abstract base class for all users in SkillBridge.
 *
 * WHY abstract? Because a plain "User" never exists on its own —
 * every real user is either a Trainer or a Trainee. Making the class
 * abstract forces every subclass to provide a concrete getRole().
 *
 * CONCEPTS DEMONSTRATED: Abstract classes, encapsulation, constructors,
 * method overriding (toString).
 */
public abstract class User {

    // --- Fields ---------------------------------------------------------
    // TODO-1: Declare three private fields:
    //   String userId  — unique identifier (e.g. "T001")
    //   String name    — full name
    //   String password — stored password (plain text for now; hash in M3)
    // Tip: private fields + public getters = encapsulation.

    // --- Constructor ----------------------------------------------------
    // TODO-2: Write a constructor that accepts (userId, name, password)
    //   and assigns each parameter to the matching field.
    //   Remember: use `this.fieldName = paramName` when names clash.

    // --- Abstract method ------------------------------------------------
    // TODO-3: Declare an abstract method:
    //   public abstract String getRole();
    //   Subclasses MUST override this. Trainer returns "TRAINER",
    //   Trainee returns "TRAINEE". This is the simplest form of polymorphism.

    // --- Getters --------------------------------------------------------
    // TODO-4: Add public getters for userId, name, and password.
    //   (No setters for userId — it should never change after creation.)

    // --- toString -------------------------------------------------------
    // TODO-5: Override toString() to return something like:
    //   "[TRAINER] Aniruddh (T001)"
    //   Hint: use getRole() — it will call the subclass version at runtime.
    //   This is runtime polymorphism in action!
}
