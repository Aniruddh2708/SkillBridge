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
| M1 | Core data models & OOP structure | ✅ **Done** |
| M2 | Certification & Progress logic | 🔄 **In Progress** |
| M3 | Data Persistence — JDBC + MySQL | ⬜ Not started |
| M4 | Skill-Visibility Portal — JavaFX GUI | ⬜ Not started |

### M1 Checklist

- [x] **M1-1** Understand *why* `User` is abstract — concept discussion ✅
- [x] **M1-2** Complete `User.java` TODOs (fields, constructor, abstract method, getters, `toString`) ✅
- [x] **M1-3** Complete `Trainer.java` TODOs (override `getRole`, trainer-specific fields) ✅
- [x] **M1-4** Complete `Trainee.java` TODOs (override `getRole`, `Serializable`, trainee-specific fields) ✅
- [x] **M1-5** Complete `Skill.java` TODOs (skill model, enums, completion flag) ✅
- [x] **M1-6** Complete `SkillAssessor.java` TODOs (abstract assessor, polymorphism demo) ✅

### M2 Checklist

- [ ] **M2-1** Complete `BasicAssessor.java` TODOs (first concrete SkillAssessor, bridges M1 → M2)
- [ ] **M2-2** Complete `AuthService.java` TODOs (login service, throws AuthException)
- [ ] **M2-3** Complete `UserDAO.java` TODOs (in-memory store + credential check)

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

## ✅ M1-2 Complete — `User.java` Review

Great work! Your `User.java` implementation is correct. Here is a line-by-line code review:

### What you got right ✅

| TODO | Your implementation | Why it's correct |
|------|--------------------|--------------------|
| M1-2a to 2d | `private String userId / name / email / passwordHash` | All four fields are `private` — encapsulation is preserved |
| M1-2e | `this.userId = userId; ...` (four assignments) | `this.` disambiguation avoids the silent no-op bug |
| M1-2f to 2h | `return userId; / return name; / return email;` | Clean single-expression getters |
| M1-2i | `String getPasswordHash() { return passwordHash; }` | No access modifier = package-private; hash is not exposed outside the package |
| M1-2j | `String.format("User{id='%s', name='%s', role='%s'}", userId, name, getRole())` | `passwordHash` omitted (good!) and `getRole()` uses runtime polymorphism |

### One thing to note 📌

In `toString()` you call `getRole()` — an abstract method — inside the *parent* class.
This is safe and intentional: by the time `toString()` runs on any real object, that
object is a concrete subclass (`Trainer` or `Trainee`), so `getRole()` is always
resolved. This is a textbook example of **late binding / dynamic dispatch**.

### Security reminder 🔒

`getPasswordHash()` is package-private, not `public`. If someone later adds
`public` by mistake, it widens the attack surface. In a real project you would
add a unit test that uses reflection to assert the method is *not* public:

```java
// Example guard (not required now — just good to know):
Method m = User.class.getDeclaredMethod("getPasswordHash");
assertNotEquals(Modifier.PUBLIC, m.getModifiers() & Modifier.PUBLIC);
```

---

## 🔓 M1-3 Unlocked — `Trainer.java`

Before we look at the code skeleton, answer this concept question:

### Concept Question for M1-3

> **"When `Trainer`'s constructor calls `super(userId, name, email, passwordHash)`,
> what does `super(...)` actually do — and what would happen if you forgot to call it?"**
>
> *(Hint: think about which class owns those four fields and how they get initialised.)*

---

Once you've answered, open `src/model/Trainer.java` and work through the six TODOs in order:

### M1-3a — `List<Trainee> roster` field

```
// TODO M1-3a: declare a private List<Trainee> field called roster
```

- `List` (the interface) is the declared type — programming to the interface, not
  the implementation. Callers only know it's a List.
- The concrete type (`ArrayList`) is chosen inside the constructor.

### M1-3b — Constructor

```
// TODO M1-3b: call super(...) with all four parameters
//             Then initialise the roster field to a new ArrayList<>()
```

Two lines:
1. `super(userId, name, email, passwordHash);` — delegates field assignment to `User`.
2. `this.roster = new ArrayList<>();` — empty list ready for enrolments.

### M1-3c — `getRole()`

```
// TODO M1-3c: return the string "TRAINER"
```

One line. This satisfies the abstract contract from `User`.

### M1-3d — `enrollTrainee(Trainee trainee)`

```
// TODO M1-3d: validate that trainee is not null (throw IllegalArgumentException if so)
//             Then add trainee to the roster list.
```

Pattern:
```java
if (trainee == null) throw new IllegalArgumentException("trainee must not be null");
roster.add(trainee);
```

Why validate? Null entries in the roster would cause NullPointerExceptions later when
iterating — catch the bad input at the boundary.

### M1-3e — `getRoster()`

```
// TODO M1-3e: return Collections.unmodifiableList(roster)
//             Remember to import java.util.Collections
```

`Collections.unmodifiableList` wraps the list so callers can read it but cannot
call `add()` or `remove()` on it directly. All mutations must go through
`enrollTrainee()`, which enforces the null-check.

### M1-3f — `toString()`

```
// TODO M1-3f: use super.toString() for the User part, then append roster size.
```

Pattern:
```java
return String.format("Trainer{base=%s, roster=%d trainee(s)}", super.toString(), roster.size());
```

Calling `super.toString()` reuses the User representation without duplicating it.

---

**Your task:** Implement all six TODOs in `src/model/Trainer.java`.
When you're done, report back and we'll review it and move to M1-4 (`Trainee.java`).

---

## ✅ M1-3 to M1-6 Complete — Module 1 Finished! 🎉

You've completed all six M1 tasks. Here's a quick summary of what you built:

| Task | File | Key concept reinforced |
|------|------|------------------------|
| M1-3 | `Trainer.java` | Inheritance + `super()`, defensive null-check, unmodifiable list |
| M1-4 | `Trainee.java` | `Serializable` marker interface, list management |
| M1-5 | `Skill.java` | `enum` for type-safe categories, `boolean` flag, immutable fields |
| M1-6 | `SkillAssessor.java` | Abstract class as a strategy contract, late binding in `describeResult()` |

---

## 💡 Your Enum Observation — Trade-offs of Enum vs Polymorphism

You noted: *"In an enum-based design, adding EXPERT is just adding another constant to the
enum — same kind of change-and-hope fragility as raw Strings."*

**That's a sharp observation.** Let's break down when each design wins:

### When enums ARE the right call ✅

| Situation | Why enum wins |
|-----------|---------------|
| Small, **stable**, well-known set of values | Compile-time safety — `Category.ELECTRRICAL` (typo!) fails at compile time; `"ELECTRRICAL"` as a String would not |
| You want exhaustive `switch` coverage | Java warns/errors if you miss a case |
| Values carry no *behaviour* — just identity | Enum is lightweight; no extra class files |

`Skill.Category` (ELECTRICAL, PLUMBING, CARPENTRY …) is a good enum:
the vocational categories are known at design time and don't carry separate logic.

### When enums hit their limits ❌

| Situation | Why enum struggles |
|-----------|--------------------|
| Values need to be **added by third-party code** | You can't extend a sealed enum |
| Each value needs **different behaviour** | An enum method with a big `switch` is fragile |
| The set **grows at runtime** (config-driven) | Enums are fixed at compile time |

### What SkillAssessor does instead 🔑

Notice that the assessment *strategy* (basic vs advanced) is **not** an enum constant
— it is a **class hierarchy**:

```
SkillAssessor (abstract)
  ├── BasicAssessor    ← simple: passes if skill.isCompleted()
  └── AdvancedAssessor ← weighted score + threshold (M2-2)
```

Adding an `ExpertAssessor` later means writing **one new class** — existing code is
untouched. This is the **Open/Closed Principle**: open for extension, closed for modification.

The general rule of thumb:
> Use an **enum** when the set is fixed and values are *identities*.  
> Use a **class hierarchy** (or interface) when each variant has *different behaviour*
> that may need to grow.

---

## 🔓 M2-1 Unlocked — `BasicAssessor.java`

Before you touch the code, answer this concept question:

### Concept Question for M2-1

> **"`BasicAssessor` does NOT override `describeResult()` — it only overrides `assess()`.
> When you call `assessor.describeResult(skill)` on a `BasicAssessor` instance,
> trace the exact call chain: which method in which class runs first, second, and third?"**
>
> *(Hint: start at the call site and follow the method calls through `SkillAssessor`
> and then back down into `BasicAssessor`.)*

---

Once you've answered, open `src/model/BasicAssessor.java` and work through the two TODOs:

### M2-1a — Constructor

```
// TODO M2-1a: implement the constructor.
//             It receives a Trainee and passes it straight to super(...)
```

One line: `super(trainee);`

`BasicAssessor` has no extra state of its own — it is a *pure strategy*.
All state (the trainee reference) lives in the parent `SkillAssessor`.

### M2-1b — `assess(Skill skill)`

```
// TODO M2-1b: implement assess(Skill skill).
//             A basic assessment simply checks whether the skill is completed.
//             Return true if skill.isCompleted(), false otherwise.
```

One line: `return skill.isCompleted();`

Why so simple? `BasicAssessor` is the entry-level strategy — it trusts the
`markCompleted()` flag that the Trainer sets on a Skill.
`AdvancedAssessor` (M2-2) will add weighted scores for a more rigorous check.

### What you do NOT need to write 📌

`describeResult()` is already implemented in `SkillAssessor` and is **inherited**
automatically. Once `assess()` is in place, calling
`assessor.describeResult(skill)` will use your `assess()` via late binding.

---

**Your task:** Implement the two TODOs in `src/model/BasicAssessor.java`.
When you're done, report back and we'll review it and move to M2-2 (`AuthService.java`).

---

## 🗂️ Module Roadmap

### M1 — Files (complete ✅)
1. ~~`src/model/User.java`~~ ✅
2. ~~`src/model/Trainer.java`~~ ✅
3. ~~`src/model/Trainee.java`~~ ✅
4. ~~`src/model/Skill.java`~~ ✅
5. ~~`src/model/SkillAssessor.java`~~ ✅

### M2 — Files (unlocked) ← **You are here**
1. `src/model/BasicAssessor.java` ← **current task**
2. `src/service/AuthService.java`
3. `src/model/UserDAO.java`

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
