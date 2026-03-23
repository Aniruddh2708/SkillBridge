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
- [x] **M1-2** Complete `User.java` TODOs (fields, constructor, abstract method, getters, `toString`) ✅
- [x] **M1-3** Complete `Trainer.java` TODOs (override `getRole`, trainer-specific fields) ✅
- [ ] **M1-4** Complete `Trainee.java` TODOs (override `getRole`, `Serializable`, trainee-specific fields)
- [ ] **M1-5** Complete `Skill.java` TODOs (skill model, enums, completion flag)
- [ ] **M1-6** Complete `SkillAssessor.java` TODOs (abstract assessor, polymorphism demo)

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

## ✅ M1-3 Complete — `Trainer.java` Review

### Concept Question for M1-3 — Answered ✅

> **"When `Trainer`'s constructor calls `super(userId, name, email, passwordHash)`,
> what does `super(...)` actually do — and what would happen if you forgot to call it?"**

**✅ M1-3 ANSWERED:**
> *"`super(...)` calls the `User` constructor, which initialises the four inherited fields
> (`userId`, `name`, `email`, `passwordHash`). Those fields belong to `User`, so only `User`'s
> constructor can set them. If you forgot `super(...)`, Java would emit a compile-time error
> because every subclass constructor must (explicitly or implicitly) invoke a parent
> constructor. Without it, the inherited fields would never be assigned — all User getters
> would return `null`."*

**Feedback:** Exactly right. Java *enforces* the super-constructor call at compile time,
which is why there is no silent null-field bug to hunt down at runtime. You also correctly
noted that the fields live in `User`, not in `Trainer` — that ownership is the reason
`Trainer` cannot initialise them directly.

---

### What you got right ✅

| TODO | Your implementation | Why it's correct |
|------|--------------------|--------------------|
| M1-3a | `private List<Trainee> roster` | Declared as the `List` interface — programming to the interface, not the implementation |
| M1-3b | `super(...); this.roster = new ArrayList<>()` | Delegates field init to `User`; creates an empty, ready-to-use roster |
| M1-3c | `return "TRAINER";` | Satisfies the abstract contract; string literal matches what the login router expects |
| M1-3d | null-check + `roster.add(trainee)` | Catches bad input at the boundary; prevents silent `NullPointerException` later |
| M1-3e | `Collections.unmodifiableList(roster)` | Encapsulates the list; callers can read but not mutate directly |
| M1-3f | `super.toString()` + roster size | Reuses `User`'s representation (DRY); `size()` gives a concise summary |

### One thing to note 📌

`getRoster()` returns an *unmodifiable view* — it wraps the original list rather than
copying it. That means:
- Reads (iteration, `get(i)`) work fine.
- Any write call (`add`, `remove`) throws `UnsupportedOperationException` at runtime.
- The underlying `roster` field itself is still mutable via `enrollTrainee()`.

This pattern (expose a restricted view, keep the real list private) is called
**defensive copying** in spirit, and is standard practice for collection-returning getters.

---

## 🔓 M1-4 Unlocked — `Trainee.java`

Before we look at the code skeleton, answer this concept question:

### Concept Question for M1-4

> **"`Trainee` implements `Serializable` — but `Serializable` has no methods to implement.
> What is a *marker interface*, why does Java use them, and what does `serialVersionUID`
> protect against?"**
>
> *(Hint: think about what the JVM checks before writing an object to a file, and what
> happens if you load that file after adding a new field to the class.)*

---

Once you've answered, open `src/model/Trainee.java` and work through the nine TODOs in order:

### M1-4a — `List<Skill> skills` field

```
// TODO M1-4a: declare a private List<Skill> field called skills
```

- Same pattern as `Trainer`'s roster: declare the interface type (`List`), initialise
  with `ArrayList` in the constructor.
- This list holds every `Skill` assigned to or completed by the trainee.

### M1-4b — `String enrolledCourse` field

```
// TODO M1-4b: declare a private String field called enrolledCourse
```

- Stores the name of the vocational course the trainee is enrolled in
  (e.g. `"Electrical Wiring Basics"`).
- Not `final` — a trainee *can* switch courses (the setter in M1-4h handles this).

### M1-4c — Constructor

```
// TODO M1-4c: call super(...) with userId, name, email, passwordHash
//             Then initialise the skills list and assign enrolledCourse.
```

Three lines:
1. `super(userId, name, email, passwordHash);` — delegates the four inherited fields to `User`.
2. `this.skills = new ArrayList<>();` — empty list, ready for skill assignment.
3. `this.enrolledCourse = enrolledCourse;` — stores the course name.

### M1-4d — `getRole()`

```
// TODO M1-4d: return the string "TRAINEE"
```

One line. Satisfies the abstract contract from `User`, symmetric with `Trainer.getRole()`.

### M1-4e — `addSkill(Skill skill)`

```
// TODO M1-4e: validate skill is not null, then add it to the list
```

Pattern (identical reasoning to `enrollTrainee` in Trainer):
```java
if (skill == null) throw new IllegalArgumentException("skill must not be null");
skills.add(skill);
```

### M1-4f — `getSkills()`

```
// TODO M1-4f: return Collections.unmodifiableList(skills)
```

Same defensive-view pattern as `getRoster()` in `Trainer`.
Remember to import `java.util.Collections` if it is not already imported.

### M1-4g — `getEnrolledCourse()`

```
// TODO M1-4g: return enrolledCourse
```

Simple single-expression getter — one line.

### M1-4h — `setEnrolledCourse(String enrolledCourse)`

```
// TODO M1-4h: assign the parameter to the field
```

One line: `this.enrolledCourse = enrolledCourse;`
The `this.` prefix is required here because the parameter name shadows the field name.

### M1-4i — `toString()`

```
// TODO M1-4i: use super.toString() and append course + skills count
```

Pattern:
```java
return String.format("Trainee{base=%s, course='%s', skills=%d}",
        super.toString(), enrolledCourse, skills.size());
```

Reuses `User`'s `toString()` (which already includes id, name, role), then adds the
Trainee-specific information without repeating any of the parent's fields.

---

**Your task:** Implement all nine TODOs in `src/model/Trainee.java`.
When you're done, report back and we'll review it and move to M1-5 (`Skill.java`).

---

## 🗂️ Module Roadmap

### M1 — Files to complete (in order)
1. ~~`src/model/User.java`~~ ✅ Done
2. ~~`src/model/Trainer.java`~~ ✅ Done
3. `src/model/Trainee.java` ← **You are here**
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
