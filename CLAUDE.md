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
| M1 | Core data models & OOP structure | ✅ **Complete** |
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

- [ ] **M2-1** Understand checked vs unchecked exceptions — concept question
- [ ] **M2-2** Complete `AuthService.java` TODOs (login logic, AuthException)
- [ ] **M2-3** Complete `BasicAssessor.java` TODOs (concrete assessor subclass)

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

## ✅ M1-5 & M1-6 Complete — Enum Observation + Review

Great work finishing `Skill.java` and `SkillAssessor.java`! You also made a really sharp observation about enum design:

> *"in an enum based design we will just write another field called EXPERT with string ig same problems as before chances of error"*

### Feedback on the enum observation 📌

You're **half right** — and spotting that nuance is a sign of good engineering instincts.

| What you correctly noticed | The part enums still win at |
|---|---|
| Adding `EXPERT` to an enum still requires a code change and recompilation | A typo like `"EXEPERT"` in a String compiles silently; `SkillLevel.EXEPERT` is a **compile error** |
| Both approaches need the developer to remember the new value | `switch` statements over enums give a compiler warning if you forget to handle a new case |
| Neither prevents forgetting to add EXPERT entirely | With Strings, `"EXPRT"` passes through unnoticed at runtime; enums reject it at compile time |

**The key insight:** enums don't eliminate *intentional* changes — they eliminate *accidental* errors.
When you add `EXPERT` to an enum, every place that uses `SkillLevel` and forgets to handle `EXPERT`
in a `switch` gets a compiler warning. With a String constant, nothing warns you.

---

## 🔓 M2 Unlocked — Certification & Progress Logic

All five model classes are done. Now we build the **service layer** — the business logic that *uses* those models.

M2 introduces two new concepts:
1. **Checked exceptions** (`AuthException`) — enforcing error handling at compile time.
2. **Concrete assessors** (`BasicAssessor`) — fulfilling the abstract contract you defined in M1-6.

### Concept Question for M2-1

> **"Look at `src/service/AuthException.java`. It `extends Exception`, not `RuntimeException`.**
> **What is the practical difference between a *checked* exception and an *unchecked* exception?**
> **Why should an authentication failure be *checked* rather than *unchecked*?"**
>
> *(Hint: think about what the compiler forces the caller to do in each case.)*

---

Once you've answered, open the two new skeleton files and work through them in order:

### M2-2 — `AuthService.java`

Open `src/service/AuthService.java`. There are six TODOs:

**M2-1a — `List<User> userStore` field**
```
// TODO M2-1a: declare a private final List<User> field called userStore
```
- `List<User>` holds both `Trainer` and `Trainee` objects — polymorphism at work.
- `final` because the store reference should never be swapped out after construction.

**M2-1b — Constructor**
```
// TODO M2-1b: validate that userStore is not null, then assign to the field
```
Null check first, then `this.userStore = userStore;`.

**M2-1c / 1d / 1e — `login(String email, String password) throws AuthException`**
```
// TODO M2-1c: iterate over userStore with a for-each loop
// TODO M2-1d: on email match, verify password or throw AuthException
// TODO M2-1e: after the loop, throw AuthException for no match
```
Pattern:
```java
for (User user : userStore) {
    if (user.getEmail().equalsIgnoreCase(email)) {
        if (!checkPassword(user, password)) {
            throw new AuthException("Invalid password for: " + email);
        }
        return user;
    }
}
throw new AuthException("No account found for: " + email);
```

**M2-1f — `checkPassword(User user, String password)` private helper**
```
// TODO M2-1f: return true if password equals user.getPasswordHash()
```
One line: `return password.equals(user.getPasswordHash());`
*(Real hashing with BCrypt comes in Module 3.)*

### M2-3 — `BasicAssessor.java`

Open `src/model/BasicAssessor.java`. There are three TODOs:

**M2-2a — Constructor**
```
// TODO M2-2a: call super(trainee)
```
One line. `SkillAssessor`'s constructor already validates `trainee` — no need to repeat it.

**M2-2b / 2c — `assess(Skill skill)`**
```
// TODO M2-2b: validate skill is not null
// TODO M2-2c: return skill.isCompleted()
```
Pattern:
```java
if (skill == null) throw new IllegalArgumentException("skill must not be null");
return skill.isCompleted();
```

---

**Your task:** Answer the concept question above, then implement all TODOs in
`AuthService.java` and `BasicAssessor.java`.
When done, report back for review and we'll move to M3.

---

## 🗂️ Module Roadmap

### M1 — Files ✅ All complete
1. ~~`src/model/User.java`~~ ✅
2. ~~`src/model/Trainer.java`~~ ✅
3. ~~`src/model/Trainee.java`~~ ✅
4. ~~`src/model/Skill.java`~~ ✅
5. ~~`src/model/SkillAssessor.java`~~ ✅

### M2 — Files (in progress) ← **You are here**
- ~~`src/service/AuthException.java`~~ ✅ (pre-built, read the Javadoc)
- `src/service/AuthService.java` ← TODOs M2-1a to M2-1f
- `src/model/BasicAssessor.java` ← TODOs M2-2a to M2-2c

### M3 — Files (unlocked after M2)
- `src/db/DBConnection.java` (skeleton ready)
- `src/db/UserDAO.java` (persistence layer)
- `db/skillbridge.sql`

### M4 — Files (unlocked after M3)
- `src/gui/LoginApp.java`
- `src/gui/TrainerDashboard.java`
- `src/gui/TraineeDashboard.java`

---

*Last updated automatically. Update the Progress Tracker checkboxes as tasks are completed.*
