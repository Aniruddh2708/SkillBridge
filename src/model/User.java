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

    // --- Abstract methods (subclasses MUST implement) ---

    /** Authenticate the user. Returns true if credentials are valid. */
    public abstract boolean login(String password);

    /** Returns the role string for this user ("TRAINER" or "TRAINEE"). */
    public abstract String getRole();

    // --- Concrete getters / setters ---

    public String getName()    { 
        return name; 
    }
    public String getEmail()   { 
        return email; 
    }
    public String getUserId()  { 
        return userId; 
    }

    public void setName(String name)    { 
        this.name  = name; 
    }
    public void setEmail(String email)  { 
        this.email = email; 
    }

    // --- toString ---User{id='TR-001', name='Riya', role='TRAINER'}
    @Override
    public String toString() {
        return "User{id='"+userId+"', name='"+name+"', role='"+getRole();
    }
}
