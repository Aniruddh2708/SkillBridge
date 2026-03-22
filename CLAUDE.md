# SkillBridge — Java Coaching Progress Tracker

> **Role:** Java Coach (boilerplate + TODOs only — no full implementations)  
> **Project:** SkillBridge — Digital Skill Portfolio System for Rural Youth  
> **Team:** ByteForge (T-170) | Course: JAVA-IV | Institution: GEU  

---

## 📍 Where We Left Off

**Current Milestone:** M1 — Core data models and OOP structure (🔄 In Progress)

### Session Log

| Session | Date | Topic Covered | Status |
|---------|------|---------------|--------|
| S1 | (first session) | Repo setup, README walk-through, project structure created | ✅ Done |

### Next Up
- Work through `src/model/User.java` (abstract class scaffold)
- Then `Trainee.java` and `Trainer.java` (inheritance)
- Then `Skill.java` and `SkillAssessor.java` (polymorphism)

---

## 📋 Milestone Checklist

### M1 — Core Data Models & OOP Structure
- [ ] `User.java` — abstract base class (fields, constructor, abstract `getRole()`)
- [ ] `Trainer.java` — extends User, adds `trainerCode`
- [ ] `Trainee.java` — extends User, implements Serializable, adds `skills` list
- [ ] `Skill.java` — plain model: name, category, completionStatus, score
- [ ] `SkillAssessor.java` — abstract class + `BasicAssessor` / `AdvancedAssessor` inner stubs
- [ ] `AuthException.java` — custom checked exception

### M2 — Certification & Progress Logic
- [ ] `PortfolioExporter.java` — File I/O: write trainee profile to `.txt`
- [ ] Add `isEligibleForCertificate()` logic in `Trainee`
- [ ] Implement `assess()` in `BasicAssessor` and `AdvancedAssessor`

### M3 — Data Persistence (JDBC + MySQL)
- [ ] `skillbridge.sql` — create tables (users, trainers, trainees, skills, enrollments)
- [ ] `DBConnection.java` — singleton pattern, `getConnection()`
- [ ] `UserDAO.java` — `findByUsername()`, `save()`, `update()`

### M4 — Skill Visibility Portal (JavaFX GUI)
- [ ] `LoginApp.java` — JavaFX scene, login form, role-based routing
- [ ] `TrainerDashboard.java` — enroll trainee, assign skill, view roster
- [ ] `TraineeDashboard.java` — view skills, export portfolio
- [ ] `Main.java` — launch JavaFX application

---

## 💡 Concept Questions Bank

> Before each coding session, answer one of these to warm up:

1. *(Session 1 warm-up — answer before touching User.java)*  
   **"What is the difference between an `abstract class` and an `interface` in Java? When would you choose one over the other?"**

2. What does `implements Serializable` do? Why does `Trainee` need it but not `Trainer`?
3. What is the Singleton pattern? Why is it appropriate for `DBConnection`?
4. What is a `PreparedStatement` and why is it safer than a plain `Statement`?
5. What is `Task<T>` in JavaFX and why do we run DB calls in a background thread?

---

## 📝 Coach Notes

- All source files contain **boilerplate + TODO comments only** — the student fills in logic.
- Every TODO is numbered and has a brief explanation of what goes there.
- Compile check: `javac src/model/*.java` (no JavaFX/JDBC needed for M1).
- When a TODO is completed, mark it done here and move to the next item.
