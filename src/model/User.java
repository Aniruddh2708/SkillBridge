package model;

/**
 * User is the ROOT of the SkillBridge class hierarchy.
 *
 * WHY abstract?
 *   A raw "User" has no meaning on its own — every real user is either
 *   a Trainer or a Trainee.  Making the class abstract:
 *     1. Prevents accidental instantiation of a role-less object.
 *     2. Forces every subclass to declare its role via getRole().
 *     3. Lets the rest of the app work against the User type
 *        (polymorphism) without knowing the concrete subclass.
 */
public abstract class User {

    // ── Fields ───────────────────────────────────────────────────────────────
    // Why private? Encapsulation: subclasses read them through getters,
    // preventing accidental mutation from outside the hierarchy.

    private String userId;       // unique identifier, e.g. "TR-001"
    private String name;
    private String email;
    private String passwordHash; // stored as a hash, never plain-text


    // ── Constructor ──────────────────────────────────────────────────────────
    // protected — only subclass constructors (via super(...)) should call this.

    /**
     * @param userId       unique system-assigned ID
     * @param name         full name of the user
     * @param email        login email address
     * @param passwordHash SHA-256 (or bcrypt) hash of the user's password
     */
    protected User(String userId, String name, String email, String passwordHash) {
        this.userId       = userId;
        this.name         = name;
        this.email        = email;
        this.passwordHash = passwordHash;
    }


    // ── Abstract Method ───────────────────────────────────────────────────────
    // This is the CONTRACT every subclass must honour.
    // Trainer will return "TRAINER"; Trainee will return "TRAINEE".

    /**
     * Returns the role label for this user.
     * @return "TRAINER" or "TRAINEE"
     */
    public abstract String getRole();


    // ── Getters ───────────────────────────────────────────────────────────────
    // No setters for userId / email / passwordHash — those should not
    // change casually; updates go through a dedicated service method.

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // NOTE: We deliberately do NOT expose getPasswordHash() as a public getter.
    // Password verification is done inside a service method that has package access.

    /**
     * Package-private: only classes in the same package (e.g., UserDAO) may
     * read the hash for verification purposes.
     */
    String getPasswordHash() {
        return passwordHash;
    }


    // ── toString ─────────────────────────────────────────────────────────────
    // Useful for logging and debugging.  Never include the passwordHash here!

    /**
     * @return a human-readable summary, e.g.:
     *         "User{id='TR-001', name='Riya', role='TRAINER'}"
     */
    @Override
    public String toString() {
        return String.format("User{id='%s', name='%s', role='%s'}", userId, name, getRole());
    }
}
