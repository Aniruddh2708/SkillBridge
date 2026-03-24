package service;

import model.User;

/**
 * BOILERPLATE — Module 2, Task M2-2 (preview skeleton)
 * ──────────────────────────────────────────────────────
 * AuthService handles login for SkillBridge users.
 *
 * New Java concepts introduced here:
 *   • Checked custom exception (AuthException) in a method signature.
 *   • Static factory methods vs constructors — AuthService is used as
 *     a singleton-style utility; no instance state is needed.
 *   • Basic credential verification against a UserDAO in-memory store.
 *
 * Design decision — why a separate service class?
 *   Keeping authentication logic here (not in User, Trainer, or Trainee)
 *   follows the Single Responsibility Principle:
 *     - User knows about its own data.
 *     - AuthService knows about the login process.
 *   If we later swap in JDBC-backed login, only AuthService changes.
 *
 * YOUR TASKS (will be activated in Module 2, Task M2-2):
 *   • Implement login(String email, String password) — look up the user
 *     by email in the UserDAO, verify the password hash, throw AuthException
 *     on failure.
 *   • Implement hashPassword(String plainText) — simple SHA-256 helper.
 */
public class AuthService {

    // ── Login ────────────────────────────────────────────────────────────────
    /**
     * Validates credentials and returns the matching User.
     *
     * @param email    the user's login email
     * @param password the plain-text password entered by the user
     * @return the authenticated User (Trainer or Trainee)
     * @throws AuthException if no user with that email exists, or the
     *                       password does not match
     */
    public static User login(String email, String password) throws AuthException {
        // TODO M2-2a: look up the user by email using UserDAO.findByEmail(email)
        //             If not found, throw new AuthException("User not found")
        // TODO M2-2b: hash the incoming password with hashPassword(password)
        //             Compare it to user.getPasswordHash()
        //             If they don't match, throw new AuthException("Invalid credentials")
        // TODO M2-2c: return the authenticated user
        throw new AuthException("AuthService.login() not yet implemented");
    }

    // ── Password hashing helper ───────────────────────────────────────────────
    /**
     * Returns the SHA-256 hex digest of the given plain-text string.
     * In production you would use bcrypt; SHA-256 is used here for simplicity.
     *
     * @param plainText the raw password
     * @return 64-character lowercase hex string
     */
    public static String hashPassword(String plainText) {
        // TODO M2-2d: use java.security.MessageDigest to compute SHA-256
        //             Convert the byte array to a lowercase hex string and return it
        //             Hint: MessageDigest.getInstance("SHA-256").digest(plainText.getBytes(...))
        return null;
    }
}
