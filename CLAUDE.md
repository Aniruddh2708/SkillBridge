# CLAUDE.md — SkillBridge Progress Tracker

This file is the **living progress log** for the SkillBridge Java PBL project.
Update it after completing each task.

---

## Module 1 — Core OOP Models

| Task | File | Concepts | Status |
|------|------|----------|--------|
| M1-1 | `src/model/User.java` | abstract class, 4 fields, constructor, abstract methods | ✅ Done |
| M1-2 | `src/model/Trainer.java` | extends User, super() call, ArrayList roster, enrollTrainee() | ✅ Done |
| M1-3 | `src/model/Trainee.java` | extends User, Serializable, fields, constructor, methods | 🔄 In Progress |

### M1-3 Checklist (Trainee.java TODOs)

- [ ] **TODO 1** — Declare 4 private fields (`enrolledSkills`, `trainerId`, `completionPercent`, `isCertified`)
- [ ] **TODO 2** — Write constructor calling `super()`, initialise all fields
- [ ] **TODO 3** — Override `login(String password)`
- [ ] **TODO 4** — Override `getRole()` → return `"TRAINEE"`
- [ ] **TODO 5** — Implement `enrollInSkill(String skillName)`
- [ ] **TODO 6** — Implement `updateProgress(int percent)` with auto-certification
- [ ] **TODO 7** — Implement `exportPortfolio()` console output
- [ ] **TODO 8** — Add getters for all 4 fields
- [ ] **TODO 9** — Override `toString()` (optional but recommended)

---

## Module 2 — Certification & Progress Logic  ⬜ Pending

| Task | File | Concepts |
|------|------|----------|
| M2-1 | `src/model/Skill.java` | POJO, fields, constructor, getters |
| M2-2 | `src/model/SkillAssessor.java` | abstract class, polymorphism |
| M2-3 | `src/service/PortfolioExporter.java` | File I/O, Serializable |

---

## Module 3 — Data Persistence (JDBC + MySQL)  ⬜ Pending

| Task | File | Concepts |
|------|------|----------|
| M3-1 | `src/db/DBConnection.java` | Singleton, JDBC |
| M3-2 | `src/db/UserDAO.java` | PreparedStatement, CRUD |
| M3-3 | `src/service/AuthException.java` | Custom exception |

---

## Module 4 — JavaFX GUI  ⬜ Pending

| Task | File | Concepts |
|------|------|----------|
| M4-1 | `src/gui/LoginApp.java` | JavaFX, event handling |
| M4-2 | `src/gui/TrainerDashboard.java` | Role-based UI |
| M4-3 | `src/gui/TraineeDashboard.java` | Role-based UI |

---

## Next Steps After M1-3

1. **Compile & test** your Trainee class:
   ```bash
   javac src/model/*.java
   ```
2. Write a quick `Main.java` smoke test:
   ```java
   import model.Trainer;
   import model.Trainee;

   public class Main {
       public static void main(String[] args) {
           Trainer t = new Trainer("Mr. Sharma", "sharma@geu.ac.in", "TR01");
           Trainee alice = new Trainee("Alice", "alice@geu.ac.in", "TN01", "TR01");
           alice.enrollInSkill("Electrician");
           alice.updateProgress(100);
           alice.exportPortfolio();
           t.enrollTrainee(alice);
           t.printRoster();
       }
   }
   ```
3. Once M1-3 is done, move on to **M2-1: Skill.java** (simple POJO).
