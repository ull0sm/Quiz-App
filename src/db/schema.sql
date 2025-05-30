CREATE DATABASE IF NOT EXISTS quiz_app;
USE quiz_app;

-- User table
CREATE TABLE users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(255) NOT NULL
);

-- Quiz table
CREATE TABLE quizzes (
    name VARCHAR(100) PRIMARY KEY
);

-- Question table
CREATE TABLE questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    quiz VARCHAR(100),
    text TEXT,
    optionA VARCHAR(255),
    optionB VARCHAR(255),
    optionC VARCHAR(255),
    optionD VARCHAR(255),
    correctOption VARCHAR(1),
    FOREIGN KEY (quiz) REFERENCES quizzes(name) ON DELETE CASCADE
);

-- Attempt table
CREATE TABLE attempts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    quiz VARCHAR(100),
    score INT,
    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE,
    FOREIGN KEY (quiz) REFERENCES quizzes(name) ON DELETE CASCADE
);

-- Optional: User answers (for analytics or review)
CREATE TABLE user_answers (
    attempt_id INT,
    question_id INT,
    selected_option VARCHAR(1),
    FOREIGN KEY (attempt_id) REFERENCES attempts(id) ON DELETE CASCADE,
    FOREIGN KEY (question_id) REFERENCES questions(id) ON DELETE CASCADE
);
