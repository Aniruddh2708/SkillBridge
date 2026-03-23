package service;

/**
 * BOILERPLATE — Module 2 (preview skeleton)
 * ──────────────────────────────────────────
 * AuthException is a CHECKED custom exception thrown when login fails.
 *
 * Why a custom exception instead of just using Exception or RuntimeException?
 *   1. It gives callers a specific type to catch — the UI can show a
 *      friendly "Wrong password" message instead of a generic error box.
 *   2. It communicates intent clearly in method signatures:
 *        public User login(String email, String password) throws AuthException
 *
 * Why CHECKED (extends Exception, not RuntimeException)?
 *   Authentication failure is a foreseeable, recoverable condition.
 *   Checked exceptions force callers to explicitly handle or declare it —
 *   you can't accidentally swallow an auth error.
 *
 * YOUR TASKS (will be activated in Module 2):
 *   • Understand the two constructors (message-only vs message+cause).
 *   • In Module 2 you will throw this from the login service.
 */
public class AuthException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * @param message human-readable explanation, e.g. "Invalid credentials"
     */
    public AuthException(String message) {
        super(message);
    }

    /**
     * Wraps another exception (e.g. a SQLException from the DB layer).
     *
     * @param message human-readable explanation
     * @param cause   the underlying exception
     */
    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }
}
