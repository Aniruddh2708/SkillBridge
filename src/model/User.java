package model;

/**
 * BOILERPLATE — Module 1, Task M1-2
 * ──────────────────────────────────
 * User is the ROOT of the SkillBridge class hierarchy.
 *
 * WHY abstract?
 *   A raw "User" has no meaning on its own — every real user is either
 *   a Trainer or a Trainee.  Making the class abstract:
 *     1. Prevents accidental instantiation of a role-less object.
 *     2. Forces every subclass to declare its role via getRole().
 *     3. Lets the rest of the app work against the User type
 *        (polymorphism) without knowing the concrete subclass.
 *
 * YOUR TASKS (marked // TODO):
 *   • Fill in the field declarations.
 *   • Complete the constructor body.
 *   • Implement every getter.
 *   • Implement toString().
 *   • Do NOT touch the abstract method signature — that belongs to subclasses.
 */
public abstract class User {

    // ── Fields ───────────────────────────────────────────────────────────────
    // Why private? Encapsulation: subclasses read them through getters,
    // preventing accidental mutation from outside the hierarchy.

    // TODO M1-2a: declare a private String field called userId
    //             (unique identifier, e.g., "TR-001")

    // TODO M1-2b: declare a private String field called name

    // TODO M1-2c: declare a private String field called email

    // TODO M1-2d: declare a private String field called passwordHash
    //             (we store a HASH, not plain-text — why is that important?)


    // ── Constructor ──────────────────────────────────────────────────────────
    // protected — only subclass constructors (via super(...)) should call this.
    // Why not public? Because abstract classes cannot be instantiated anyway,
    // but protected signals intent more clearly.

    /**
     * @param userId       unique system-assigned ID
     * @param name         full name of the user
     * @param email        login email address
     * @param passwordHash SHA-256 (or bcrypt) hash of the user's password
     */
    protected User(String userId, String name, String email, String passwordHash) {
        // TODO M1-2e: assign each parameter to the matching field using  this.field = param;
    }


    // ── Abstract Method ───────────────────────────────────────────────────────
    // This is the CONTRACT every subclass must honour.
    // Trainer will return "TRAINER"; Trainee will return "TRAINEE".
    // The compiler enforces this — you CANNOT forget to implement it.

    /**
     * Returns the role label for this user.
     * @return "TRAINER" or "TRAINEE"
     */
    public abstract String getRole();


    // ── Getters ───────────────────────────────────────────────────────────────
    // No setters for userId / email / passwordHash — those should not
    // change casually; updates go through a dedicated service method.

    // TODO M1-2f: implement getUserId()  — returns userId
    public String getUserId() {
        return null; // replace null with the correct return statement
    }

    // TODO M1-2g: implement getName()  — returns name
    public String getName() {
        return null; // replace null with the correct return statement
    }

    // TODO M1-2h: implement getEmail()  — returns email
    public String getEmail() {
        return null; // replace null with the correct return statement
    }

    // NOTE: We deliberately do NOT expose getPasswordHash() as a public getter.
    // Why? Because exposing the hash widens the attack surface unnecessarily.
    // Password verification is done inside a service method that has package access.

    /**
     * Package-private: only classes in the same package (e.g., UserDAO) may
     * read the hash for verification purposes.
     */
    String getPasswordHash() {
        // TODO M1-2i: return the passwordHash field
        return null;
    }


    // ── toString ─────────────────────────────────────────────────────────────
    // Useful for logging and debugging.  Never include the passwordHash here!

    /**
     * @return a human-readable summary, e.g.:
     *         "User{id='TR-001', name='Riya', role='TRAINER'}"
     */
    @Override
    public String toString() {
        // TODO M1-2j: build and return the string shown in the Javadoc above.
        // Hint: use String.format() or a StringBuilder.
        return null;
    }
}
