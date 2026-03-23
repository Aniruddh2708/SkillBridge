package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * M1-3: Trainee — extends User, implements Serializable.
 *
 * Represents a vocational trainee in the SkillBridge system.
 * Concepts demonstrated:
 *   - Inheritance (extends User)
 *   - Interface implementation (Serializable — needed for portfolio file export in M2)
 *   - ArrayList collection for enrolled skills
 *   - Encapsulation via private fields + getters/setters
 *
 * ────────────────────────────────────────────────────────────────────────────
 * YOUR TASKS FOR M1-3
 * Work through every TODO block below in order.  Each block tells you exactly
 * what to type and which Java concept it demonstrates.
 * ────────────────────────────────────────────────────────────────────────────
 */
public class Trainee extends User implements Serializable {

    // Required by Serializable — keeps the serialized format stable.
    private static final long serialVersionUID = 1L;

    // -------------------------------------------------------------------------
    // TODO 1 — FIELDS
    // Declare four private fields:
    //   (a) ArrayList<String>  enrolledSkills   — skills this trainee is studying
    //   (b) String             trainerId        — ID of the Trainer who manages them
    //   (c) int                completionPercent — overall progress 0–100
    //   (d) boolean            isCertified      — true once all skills are complete
    //
    // Example first line (uncomment and fill in the rest):
    //   private ArrayList<String> enrolledSkills;
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    // TODO 2 — CONSTRUCTOR
    // Write a constructor:  Trainee(String name, String email, String userId, String trainerId)
    //   • Call super(name, email, userId, "TRAINEE") — this sets the inherited fields.
    //   • Initialise enrolledSkills to a new empty ArrayList.
    //   • Set this.trainerId = trainerId.
    //   • Set completionPercent = 0 and isCertified = false.
    //
    // Replace the stub below with your full implementation.
    // -------------------------------------------------------------------------
    public Trainee(String name, String email, String userId, String trainerId) {
        super(name, email, userId, "TRAINEE");  // TODO 2: super() call is done — now init the rest
        // TODO 2: initialise enrolledSkills, trainerId, completionPercent, isCertified
    }

    // -------------------------------------------------------------------------
    // TODO 3 — OVERRIDE login()
    // The abstract method login(String password) from User must be implemented.
    // For now, return true if password is not null and not empty — real auth
    // will come in M3 with JDBC.
    //
    // Replace the stub body below with your implementation:
    //   return password != null && !password.isEmpty();
    // -------------------------------------------------------------------------
    @Override
    public boolean login(String password) {
        // TODO 3: replace this stub with your real check
        return password != null && !password.isEmpty();
    }

    // -------------------------------------------------------------------------
    // TODO 4 — OVERRIDE getRole()
    // Return the string "TRAINEE".
    //
    // Replace the stub body below with:
    //   return "TRAINEE";
    // -------------------------------------------------------------------------
    @Override
    public String getRole() {
        // TODO 4: replace this stub with the correct return value
        return "";
    }

    // -------------------------------------------------------------------------
    // TODO 5 — enrollInSkill(String skillName)
    // Add skillName to enrolledSkills if it is not already present.
    // Print a confirmation message.
    //
    //   public void enrollInSkill(String skillName) {
    //       if (!enrolledSkills.contains(skillName)) {
    //           enrolledSkills.add(skillName);
    //           System.out.println(name + " enrolled in: " + skillName);
    //       }
    //   }
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    // TODO 6 — updateProgress(int percent)
    // Set completionPercent to percent (clamp between 0 and 100).
    // If percent >= 100, also set isCertified = true and print a
    // congratulations message.
    //
    //   public void updateProgress(int percent) {
    //       this.completionPercent = Math.max(0, Math.min(100, percent));
    //       if (this.completionPercent >= 100) {
    //           isCertified = true;
    //           System.out.println("🏅 " + name + " is now certified!");
    //       }
    //   }
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    // TODO 7 — exportPortfolio()
    // Print a formatted summary of this trainee's portfolio to the console.
    // Real file export will come in M2 (PortfolioExporter.java).
    //
    //   public void exportPortfolio() {
    //       System.out.println("=== Portfolio: " + name + " ===");
    //       System.out.println("Email  : " + email);
    //       System.out.println("Skills : " + enrolledSkills);
    //       System.out.println("Progress: " + completionPercent + "%");
    //       System.out.println("Certified: " + isCertified);
    //   }
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    // TODO 8 — GETTERS
    // Add getters for all four fields you declared in TODO 1:
    //   getEnrolledSkills(), getTrainerId(), getCompletionPercent(), isCertified()
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    // TODO 9 — toString()  (optional but recommended)
    // Override toString() to return a one-line summary, e.g.:
    //   "[TRAINEE] Alice <alice@example.com> (ID: T001) — 75% complete"
    // -------------------------------------------------------------------------
}
