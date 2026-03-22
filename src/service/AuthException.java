package service;

/**
 * Custom checked exception thrown when authentication fails.
 *
 * WHY a custom exception?
 *   - Gives callers a specific type to catch (catch (AuthException e))
 *     instead of a generic Exception.
 *   - Makes the API self-documenting: if a method declares
 *     "throws AuthException", you immediately know it can fail due to auth.
 *
 * WHY extend Exception (not RuntimeException)?
 *   - Checked exceptions FORCE the caller to handle or declare them.
 *   - Auth failures are predictable (wrong password) — we want the compiler
 *     to ensure every call site deals with that case.
 *
 * CONCEPTS DEMONSTRATED: Custom exceptions, checked vs unchecked, super().
 */
public class AuthException extends Exception {

    // TODO-1: Declare serialVersionUID (good practice for Throwable subclasses).
    //   private static final long serialVersionUID = 1L;

    // TODO-2: Write a constructor AuthException(String message).
    //   Body: super(message);
    //   This passes your descriptive message to Exception's constructor,
    //   so callers can call e.getMessage() to find out what went wrong.

    // TODO-3: Write an overloaded constructor AuthException(String message, Throwable cause).
    //   Body: super(message, cause);
    //   Used when you catch a lower-level exception (e.g. SQLException)
    //   and want to wrap it in an AuthException while preserving the root cause.
}
