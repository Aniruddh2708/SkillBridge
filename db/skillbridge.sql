-- ============================================================
-- SkillBridge Database Schema
-- Run with: mysql -u root -p < db/skillbridge.sql
-- ============================================================

-- TODO-1: Create and select the database.
--   CREATE DATABASE IF NOT EXISTS skillbridge;
--   USE skillbridge;

-- ============================================================
-- TABLE: users
-- Stores shared fields for both Trainers and Trainees.
-- The `role` column distinguishes the two types.
-- ============================================================

-- TODO-2: Create the users table.
--   Columns needed:
--     user_id    VARCHAR(20)  PRIMARY KEY   — e.g. "T001", "TR001"
--     username   VARCHAR(50)  NOT NULL UNIQUE
--     password   VARCHAR(100) NOT NULL      — store hashed in production!
--     name       VARCHAR(100) NOT NULL
--     role       ENUM('TRAINER','TRAINEE') NOT NULL

-- ============================================================
-- TABLE: trainers
-- Extra columns specific to Trainer (extends users).
-- ============================================================

-- TODO-3: Create the trainers table.
--   Columns needed:
--     user_id       VARCHAR(20) PRIMARY KEY
--     trainer_code  VARCHAR(20) NOT NULL UNIQUE
--   FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
--
--   WHY a separate table? Normalisation — trainer-only data lives here,
--   not duplicated in the users table.

-- ============================================================
-- TABLE: trainees
-- Extra columns specific to Trainee.
-- ============================================================

-- TODO-4: Create the trainees table.
--   Columns needed:
--     user_id          VARCHAR(20) PRIMARY KEY
--     enrollment_year  YEAR NOT NULL
--   FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE

-- ============================================================
-- TABLE: skills
-- Master list of all available skills/courses.
-- ============================================================

-- TODO-5: Create the skills table.
--   Columns needed:
--     skill_id   VARCHAR(20)  PRIMARY KEY   — e.g. "SK001"
--     name       VARCHAR(100) NOT NULL
--     category   VARCHAR(50)  NOT NULL       — e.g. "Electrical"

-- ============================================================
-- TABLE: trainee_skills
-- Junction table: which trainee has which skill, and their progress.
-- ============================================================

-- TODO-6: Create the trainee_skills table.
--   Columns needed:
--     id          INT AUTO_INCREMENT PRIMARY KEY
--     user_id     VARCHAR(20) NOT NULL
--     skill_id    VARCHAR(20) NOT NULL
--     status      ENUM('PENDING','IN_PROGRESS','COMPLETED') DEFAULT 'PENDING'
--     score       INT DEFAULT 0
--   FOREIGN KEY (user_id)  REFERENCES trainees(user_id) ON DELETE CASCADE
--   FOREIGN KEY (skill_id) REFERENCES skills(skill_id)  ON DELETE CASCADE

-- ============================================================
-- SEED DATA (optional — for testing)
-- ============================================================

-- TODO-7: Insert one sample Trainer and one sample Trainee so you can
--   test the login screen without writing a registration UI first.
--
--   INSERT INTO users VALUES ('TR001','trainer1','pass123','Aniruddh Negi','TRAINER');
--   INSERT INTO trainers VALUES ('TR001','GEU-2024');
--
--   INSERT INTO users VALUES ('T001','trainee1','pass123','Krishna Bhardwaj','TRAINEE');
--   INSERT INTO trainees VALUES ('T001', 2024);
