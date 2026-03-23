# CLAUDE.md — SkillBridge Java Coaching Guide

> **Role:** You are a Java coach for the SkillBridge project (JAVA-IV PBL, Team ByteForge T-170).
>
> **Teaching philosophy:**
> - Never write a full implementation for the student.
> - Provide boilerplate skeletons with clearly marked `// TODO` comments.
> - Explain *every* line of boilerplate so the student understands *why* it is there.
> - After explaining a section, pose a short concept-check question before moving on.
> - When the student answers, give concise feedback and then unlock the next task.

---

## 📅 Progress Tracker

| Module | Topic | Status |
|--------|-------|--------|
| M1 | Core data models & OOP structure | 🔄 **In Progress** |
| M2 | Certification & Progress logic | ⬜ Not started |
| M3 | Data Persistence — JDBC + MySQL | ⬜ Not started |
| M4 | Skill-Visibility Portal — JavaFX GUI | ⬜ Not started |

### M1 Checklist

- [x] **M1-1** Understand *why* `User` is abstract — concept discussion ✅
- [x] **M1-2** Complete `User.java` TODOs (fields, constructor, abstract method, getters, `toString`) ✅ *(see review notes below)*
- [x] **M1-3** Complete `Trainer.java` TODOs (override `getRole`, trainer-specific fields) ✅ *(see review notes below)*
- [x] **M1-4** Complete `Trainee.java` TODOs (override `getRole`, `Serializable`, trainee-specific fields) ✅
- [ ] **M1-5** Complete `Skill.java` TODOs (skill model, enums, completion flag) ← **CURRENT TASK**
- [ ] **M1-6** Complete `SkillAssessor.java` TODOs (abstract assessor, polymorphism demo)

---

## ✅ Code Review — M1-2 (`User.java`)

Good job getting all the core pieces in place! A few things to polish when you
get a chance (they won't block you from M1-5, but are worth knowing):

| # | Issue | What to change |
|---|-------|----------------|
| 1 | Fields declared `protected` | The guide recommends `private` — subclasses should use inherited getters, not reach directly into parent fields |
| 2 | Missing `passwordHash` field | You stored `role` as a field but `role` is dynamic (returned by `getRole()`). The parent should hold `passwordHash` instead |
| 3 | `toString()` missing closing `'}` | Current output: `User{id='TR-001', name='Riya', role='TRAINER` — add `+ "'}"` at the end |
| 4 | Missing `getPasswordHash()` | Needed by the DAO in M3 to compare stored hashes at login time |

---

## ✅ Code Review — M1-3 (`Trainer.java`)

Great structure! One fix was needed to make the code compile:

| # | Issue | Fix applied |
|---|-------|-------------|
| 1 | `login()` not implemented | Added a `login()` stub with **TODO M1-3g** for you to complete — see the method in `Trainer.java` |
| 2 | `toString()` missing closing `'}` | Fixed — was `"... trainee(s)"`, now `"... trainee(s)}"` |

> **Your action:** Open `Trainer.java` and complete **TODO M1-3g** — implement
> `login()` the same way `Trainee.login()` works.

---

## ✅ Code Review — M1-4 (`Trainee.java`)

Excellent — all TODOs are done! One tiny cosmetic issue:

| # | Issue | What to change |
|---|-------|----------------|
| 1 | Missing space in `enrollInSkill` print | `name+"enrolled in: "` → `name + " enrolled in: "` (space before "enrolled") |

---

## 📚 Module 1 — Concept Background

### Why is `User` abstract?

In SkillBridge there are two concrete kinds of users: **Trainers** and **Trainees**.
They share common attributes (`userId`, `name`, `email`, `passwordHash`) and common
behaviour (login, getting the user's role). However, a plain `User` object by itself
has no meaning in the real world — you can't log in as a generic "user" without being
*either* a Trainer or a Trainee.

Using `abstract` enforces this:

1. **Prevents instantiation of meaningless objects.**
   `new User(...)` would be a bug; the compiler stops it for you.

2. **Forces every subclass to supply role-specific behaviour.**
   The abstract method `getRole()` *must* be overridden, so a `Trainer` always
   returns `"TRAINER"` and a `Trainee` always returns `"TRAINEE"`. Forgetting to
   implement it is a *compile-time* error, not a silent runtime bug.

3. **Enables polymorphism.**
   Code that works with `User` references (e.g., `UserDAO`, the login service) can
   call `user.getRole()` without caring whether the object is a `Trainer` or
   `Trainee` — the correct subclass behaviour is dispatched automatically.

4. **Keeps shared logic in one place (DRY).**
   Getters, `toString`, and password-checking live in `User` once, not duplicated
   in both subclasses.

### Concept Question for M1-1
> **Before we write a single line of code:**
> "If `User` were a *concrete* (non-abstract) class and you wrote `User u = new User(...)`,
> what would `u.getRole()` return — and why is that a problem for the login system?"

**✅ M1-1 ANSWERED:**
> *"getRole() would return a generic "USER" value instead of "TRAINER" or "TRAINEE".
> This breaks login because the system wouldn't know which dashboard to show.
> Making User abstract forces every user to be either a Trainer or Trainee,
> so getRole() always returns the correct specific role."*

**Feedback:** Spot on. You identified both problems — the meaningless return value *and*
the downstream breakage (dashboard routing). The compiler enforcing the contract is exactly
why we reach for `abstract` here rather than a runtime check.

---

## 🔓 M1-2 Unlocked — Filling in `User.java`

Open `src/model/User.java`. Work through the TODOs in order.
Each one is explained below — read the explanation, then write the code yourself.

---

### M1-2a to M1-2d — Field declarations

```java
// Inside the class body, before the constructor:
private String userId;
private String name;
private String email;
private String passwordHash;
```

**Why `private`?**
Encapsulation. Subclasses (`Trainer`, `Trainee`) must not reach into the parent's
storage directly — they go through the getters. This lets you change the internal
representation later without breaking subclasses.

**Why store a `passwordHash` instead of a plain password?**
If the database is ever breached, raw passwords are immediately usable by attackers.
A hash (SHA-256 / bcrypt) is a one-way transformation — you can verify a password by
hashing the input and comparing, but you cannot reverse the hash back to the password.

> **Mini-check before M1-2e:** What Java access modifier would you use if you wanted
> `Trainer` to read `userId` *directly* (without a getter)?
> *(Hint: it's one step less restrictive than `private`.)*

---

### M1-2e — Constructor body

```java
protected User(String userId, String name, String email, String passwordHash) {
    this.userId       = userId;      // 'this.userId' is the field; 'userId' is the param
    this.name         = name;
    this.email        = email;
    this.passwordHash = passwordHash;
}
```

**Why `this.`?**
When the parameter name matches the field name, Java would otherwise read the
parameter on *both* sides (`userId = userId` assigns a variable to itself — a no-op).
`this.userId` unambiguously refers to the instance field.

**Why `protected` not `public`?**
Abstract classes cannot be instantiated, so a `public` constructor is misleading.
`protected` signals "only subclass constructors (and same-package code) may call this via `super()`."

---

### M1-2f to M1-2h — Getters

Each getter follows the same one-line pattern:

```java
public String getUserId() { return userId; }
public String getName()   { return name;   }
public String getEmail()  { return email;  }
```

No setters for `userId` or `email` — those are immutable after construction.
(A user can't change their system ID, and email changes go through a dedicated service.)

---

### M1-2i — Package-private `getPasswordHash()`

```java
String getPasswordHash() { return passwordHash; }
```

Notice: **no access modifier** = package-private. Only `UserDAO` (same `model` package
in the M1 layout, or `db` package later) needs this to verify a login attempt.
Making it `public` would let any class in the app read password hashes — unnecessary exposure.

---

### M1-2j — `toString()`

```java
@Override
public String toString() {
    return String.format("User{id='%s', name='%s', role='%s'}", userId, name, getRole());
}
```

Two things to notice:
1. `passwordHash` is intentionally **omitted** — never log secrets.
2. We call `getRole()` (the abstract method) — because `toString()` is inherited,
   when a `Trainer` calls it, `getRole()` dynamically dispatches to `Trainer.getRole()`.
   This is *runtime polymorphism* in action.

---

**Your task:** Go implement all ten TODOs in `src/model/User.java` now.
Once you've written them, come back and we'll move to M1-3 (`Trainer.java`).

---

## 🔓 M1-5 Unlocked — Filling in `Skill.java`

Open `src/model/Skill.java` now. Work through the TODOs in order.

---

### M1-5 Concept Background — Why an Enum for SkillLevel?

A `Skill` in SkillBridge can be tagged as `BEGINNER`, `INTERMEDIATE`, or `ADVANCED`.
You could represent that with a plain `String`, but using a **nested enum** is better:

| Plain String | Enum |
|---|---|
| `"BEGINNER"`, `"beginner"`, `"Begginer"` all compile | Only `SkillLevel.BEGINNER` compiles |
| Equality bugs: `==` vs `.equals()` | Safe with `==` or `switch` |
| No IDE auto-complete for valid values | Full IDE support |

Nested enums are declared *inside* the class that owns them:

```java
public class Skill {
    public enum SkillLevel {
        BEGINNER, INTERMEDIATE, ADVANCED
    }
    // rest of Skill...
}
```

They're accessed from outside as `Skill.SkillLevel.BEGINNER`.

---

### M1-5 Concept Background — Why a `markCompleted()` method instead of a setter?

A dedicated `markCompleted()` method only allows the **one-way transition** from
`false → true`.  A plain `setIsCompleted(boolean)` would let callers pass `false`
and "uncomplete" a skill — usually unintended and a potential data-integrity bug.

This is a common OOP practice: *make illegal states unrepresentable* in the API itself.

---

### Concept Question for M1-5

> **Before you write a single line of code:**
> "If you later need a fourth skill level — say `EXPERT` — what change do you make
> to a String-based design versus an enum-based design, and which is safer? Why?"

*Answer this question in your next message, then implement all six TODOs in `Skill.java`.*

---


## 🗂️ Module Roadmap

### M1 — Files to complete (in order)
1. `src/model/User.java`
2. `src/model/Trainer.java`
3. `src/model/Trainee.java`
4. `src/model/Skill.java`
5. `src/model/SkillAssessor.java`

### M2 — Files (unlocked after M1)
- `src/service/AuthException.java`
- Extend `UserDAO` with credential-check logic

### M3 — Files (unlocked after M2)
- `src/db/DBConnection.java`
- `src/db/UserDAO.java` (persistence layer)
- `db/skillbridge.sql`

### M4 — Files (unlocked after M3)
- `src/gui/LoginApp.java`
- `src/gui/TrainerDashboard.java`
- `src/gui/TraineeDashboard.java`

---

*Last updated automatically. Update the Progress Tracker checkboxes as tasks are completed.*
