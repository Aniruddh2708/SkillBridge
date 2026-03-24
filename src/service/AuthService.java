package service;

import model.User;

import java.util.List;

/**
 * BOILERPLATE — Module 2, Task M2-1
 * ──────────────────────────────────
 * AuthService is the LOGIN LAYER of SkillBridge.
 *
 * Responsibility:
 *   Given an email + plain-text password, find the matching User in the
 *   in-memory userStore and verify credentials.  If anything is wrong,
 *   throw AuthException (the checked exception you already have in service/).
 *
 * New Java concepts introduced here:
 *   • Checked exception in a method signature  — "throws AuthException"
 *   • Enhanced for-loop over a List<User>
 *   • Defensive null-checks at service boundaries
 *
 * Why in-memory userStore now (not a DB)?
 *   Module 3 wires in the real JDBC layer.  Here we keep it simple so
 *   you can test the logic without a running MySQL server.
 *
 * YOUR TASKS (marked // TODO):
 *   M2-1a  Declare and assign the userStore field.
 *   M2-1b  Implement login() — search, then verify password.
 *   M2-1c  Implement the private checkPassword() helper.
 */
public class AuthService {

    // ── Field ─────────────────────────────────────────────────────────────────
    // TODO M2-1a: declare a private final List<User> field called userStore

    // ── Constructor ──────────────────────────────────────────────────────────
    /**
     * @param userStore the in-memory list of all registered users (must not be null)
     */
    public AuthService(List<User> userStore) {
        // TODO M2-1b: validate that userStore is not null
        //             (throw IllegalArgumentException("userStore must not be null") if so)
        //             Then assign it to the field.
    }

    // ── Login ─────────────────────────────────────────────────────────────────
    /**
     * Attempts to log in a user.
     *
     * @param email    the user's registered email
     * @param password the plain-text password to check
     * @return the matching User if credentials are valid
     * @throws AuthException if no account is found or the password is wrong
     */
    public User login(String email, String password) throws AuthException {
        // TODO M2-1c: iterate over userStore with a for-each loop.
        //             For each user, check if user.getEmail().equalsIgnoreCase(email).
        //
        // TODO M2-1d: if you find a matching email, call checkPassword(user, password).
        //             If checkPassword returns false,
        //             throw new AuthException("Invalid password for: " + email)
        //             Otherwise return the user.
        //
        // TODO M2-1e: after the loop (no match found),
        //             throw new AuthException("No account found for: " + email)
        return null;
    }

    // ── Password helper ───────────────────────────────────────────────────────
    /**
     * Checks whether a plain-text password matches the stored hash.
     *
     * NOTE: For Module 2 we compare directly.
     *       Module 3 will replace this with a real BCrypt check.
     *
     * @param user     the candidate user
     * @param password the plain-text password entered at login
     * @return true if the password matches
     */
    private boolean checkPassword(User user, String password) {
        // TODO M2-1f: return true if password equals user.getPasswordHash()
        //             Hint: use .equals(), not ==
        return false;
    }
}
