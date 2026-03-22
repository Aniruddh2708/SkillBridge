package model;

/**
 * Abstract base class representing a user in the SkillBridge system.
 *
 * <h2>Why is User abstract?</h2>
 *
 * <p>In the real world every person who logs into SkillBridge is either a
 * <strong>Trainer</strong> or a <strong>Trainee</strong> — a plain "User" by
 * itself has no meaning and should never exist on its own.  Making this class
 * {@code abstract} enforces that design decision at the compiler level.</p>
 *
 * <ol>
 *   <li><strong>Prevents meaningless instantiation.</strong>  Writing
 *       {@code new User(...)} would be a programming error — the system has no
 *       concept of a role-less user.  {@code abstract} makes that a
 *       compile-time error rather than a silent runtime bug.</li>
 *
 *   <li><strong>Defines a contract via abstract methods.</strong>  Methods like
 *       {@link #getRole()} and {@link #getDashboardTitle()} are declared here
 *       but left without a body.  Every concrete subclass <em>must</em> provide
 *       its own implementation, guaranteeing that role-specific behaviour is
 *       always present.</li>
 *
 *   <li><strong>Enables polymorphism.</strong>  Code that only needs to work
 *       with a generic user — for example, an authentication service — can
 *       accept a {@code User} reference and call {@code login()} without caring
 *       whether the underlying object is a Trainer or a Trainee.  At runtime
 *       Java dispatches the correct concrete behaviour automatically.</li>
 *
 *   <li><strong>Avoids code duplication (DRY principle).</strong>  Fields that
 *       every user shares — {@code userId}, {@code name}, {@code email},
 *       {@code password} — and common logic such as {@code login()} /
 *       {@code logout()} are written once here.  Subclasses inherit them for
 *       free instead of copy-pasting the same code.</li>
 * </ol>
 *
 * <p>In short: {@code abstract} is the tool Java provides to say
 * <em>"this class exists only to be extended — never to be used directly."</em>
 * </p>
 */
public abstract class User {

    // ------------------------------------------------------------------ fields

    /** Unique identifier stored in the database (auto-generated). */
    protected int userId;

    /** Full name of the user. */
    protected String name;

    /** Email address used for login. */
    protected String email;

    /** Hashed password — never stored as plain text. */
    protected String password;

    // --------------------------------------------------------------- constructor

    /**
     * Initialises the common fields shared by every concrete user type.
     *
     * <p>This constructor can only be called via {@code super(...)} from a
     * subclass — another consequence of the class being abstract.</p>
     *
     * @param userId   unique identifier (use 0 for a new, unsaved user)
     * @param name     full name
     * @param email    login email
     * @param password hashed password
     */
    public User(int userId, String name, String email, String password) {
        this.userId   = userId;
        this.name     = name;
        this.email    = email;
        this.password = password;
    }

    // ---------------------------------------------------------- abstract methods

    /**
     * Returns the role label for this user (e.g. {@code "Trainer"} or
     * {@code "Trainee"}).
     *
     * <p>Declared {@code abstract} so that each subclass is <em>forced</em> to
     * identify itself — there is no sensible default the base class could
     * supply.</p>
     *
     * @return role string
     */
    public abstract String getRole();

    /**
     * Returns the title shown at the top of the role-specific dashboard.
     *
     * <p>Trainers and Trainees see completely different dashboards.  By making
     * this method abstract we let the GUI code ask any {@code User} for its
     * title without needing to know the concrete type.</p>
     *
     * @return dashboard title string
     */
    public abstract String getDashboardTitle();

    // ---------------------------------------------------------- concrete methods

    /**
     * Validates the supplied password against the stored (hashed) value and
     * returns {@code true} on success.
     *
     * <p>The login algorithm is the same for all user types, so it lives here
     * rather than being duplicated in Trainer and Trainee.</p>
     *
     * <p><strong>⚠ Security note:</strong> The current implementation is a
     * <em>placeholder only</em>.  Plain-text password comparison must
     * <strong>never</strong> be used in production.  The {@code password} field
     * must store a salted hash (e.g. BCrypt), and this method must verify the
     * input against that hash using the same library.  This will be addressed
     * in the authentication module.</p>
     *
     * @param inputPassword the plain-text password entered by the user
     * @return {@code true} if credentials match
     */
    public boolean login(String inputPassword) {
        // TODO (SECURITY): replace with BCrypt.checkpw(inputPassword, this.password)
        return this.password.equals(inputPassword);
    }

    /**
     * Performs any cleanup needed when the user ends their session.
     *
     * <p>Currently a stub — will be expanded to invalidate session tokens once
     * the session-management layer is added in a later module.</p>
     */
    public void logout() {
        // TODO: invalidate session / clear sensitive data from memory
        System.out.println(name + " has logged out.");
    }

    // --------------------------------------------------------------- accessors

    /** @return the unique user ID */
    public int getUserId() { return userId; }

    /** @return the user's full name */
    public String getName() { return name; }

    /** @return the user's email address */
    public String getEmail() { return email; }

    // ----------------------------------------------------------------- utility

    /**
     * Returns a human-readable summary of this user.
     *
     * <p>Because {@code getRole()} is abstract, this single {@code toString}
     * implementation works correctly for both Trainers and Trainees — a classic
     * example of polymorphism in action.</p>
     */
    @Override
    public String toString() {
        return getRole() + " [id=" + userId + ", name=" + name + ", email=" + email + "]";
    }
}
