package model;

/**
 * M1-1: Abstract base class for all users in the SkillBridge system.
 *
 * Concepts demonstrated: abstract classes, encapsulation, inheritance foundation.
 */
public abstract class User {

    // --- Fields ---
    protected String name;
    protected String email;
    protected String userId;
    protected String role;     // "TRAINER" or "TRAINEE"

    // --- Constructor ---
    public User(String name, String email, String userId, String role) {
        this.name   = name;
        this.email  = email;
        this.userId = userId;
        this.role   = role;
    }

    // --- Methods ---

    /** Authenticate the user. Subclasses override this for real auth (M3). */
    public boolean login(String password) {
        return false;
    }

    /** Returns the role string for this user ("TRAINER" or "TRAINEE"). */
    public abstract String getRole();

    // --- Concrete getters / setters ---

    public String getName()    { return name; }
    public String getEmail()   { return email; }
    public String getUserId()  { return userId; }

    public void setName(String name)    { this.name  = name; }
    public void setEmail(String email)  { this.email = email; }

    // --- toString ---
    @Override
    public String toString() {
        return "[" + getRole() + "] " + name + " <" + email + "> (ID: " + userId + ")";
    }
}
