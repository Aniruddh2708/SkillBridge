-- SkillBridge Database Schema
-- Module 3 — activate when JDBC layer is implemented
-- Run: mysql -u root -p < db/skillbridge.sql

CREATE DATABASE IF NOT EXISTS skillbridge;
USE skillbridge;

-- ── Trainers ──────────────────────────────────────────────────────────────────
CREATE TABLE IF NOT EXISTS trainers (
    user_id       VARCHAR(20)  PRIMARY KEY,
    name          VARCHAR(100) NOT NULL,
    email         VARCHAR(150) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    created_at    TIMESTAMP    DEFAULT CURRENT_TIMESTAMP
);

-- ── Trainees ──────────────────────────────────────────────────────────────────
CREATE TABLE IF NOT EXISTS trainees (
    user_id          VARCHAR(20)  PRIMARY KEY,
    name             VARCHAR(100) NOT NULL,
    email            VARCHAR(150) NOT NULL UNIQUE,
    password_hash    VARCHAR(255) NOT NULL,
    enrolled_course  VARCHAR(200),
    trainer_id       VARCHAR(20)  REFERENCES trainers(user_id),
    created_at       TIMESTAMP    DEFAULT CURRENT_TIMESTAMP
);

-- ── Skills ────────────────────────────────────────────────────────────────────
CREATE TABLE IF NOT EXISTS skills (
    skill_id    VARCHAR(20)  PRIMARY KEY,
    skill_name  VARCHAR(150) NOT NULL,
    category    ENUM('ELECTRICAL','PLUMBING','CARPENTRY',
                     'TAILORING','DIGITAL_LITERACY','OTHER') NOT NULL
);

-- ── Trainee-Skill mapping ─────────────────────────────────────────────────────
CREATE TABLE IF NOT EXISTS trainee_skills (
    trainee_id  VARCHAR(20) REFERENCES trainees(user_id),
    skill_id    VARCHAR(20) REFERENCES skills(skill_id),
    completed   BOOLEAN     DEFAULT FALSE,
    updated_at  TIMESTAMP   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (trainee_id, skill_id)
);
