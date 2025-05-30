# Quiz Application

A Java-based desktop quiz application that allows users to take quizzes, track their scores, and compete on a leaderboard. The application features a user-friendly interface and secure authentication system.

## Features

- User authentication (Login/Registration)
- Quiz selection and playing
- Real-time scoring system
- Personal results tracking
- Global leaderboard
- Clean and intuitive GUI interface
- Data persistence using MySQL database

## Project Structure

```
src/
├── Main.java                # Application entry point
├── dao/                    # Data Access Objects
│   ├── AttemptDAO.java     # Attempt data access
│   ├── QuestionDAO.java    # Question data access
│   ├── QuizDAO.java        # Quiz data access
│   └── UserDAO.java        # User data access
├── db/                     # Database related files
│   ├── insertion.sql       # Sample data insertion script
│   └── schema.sql          # Database schema definition
├── model/                  # Data models
│   ├── Attempt.java        # Attempt model
│   ├── Question.java       # Question model
│   ├── Quiz.java           # Quiz model
│   ├── User.java           # User model
│   └── UserAnswer.java     # User answer model
├── ui/                     # User Interface components
│   ├── DashboardFrame.java # Main dashboard window
│   ├── LeaderboardFrame.java # Global leaderboard window
│   ├── LoginFrame.java     # Login window
│   ├── Main.java           # Application entry point
│   ├── QuizPlayFrame.java  # Quiz playing window
│   ├── QuizSelectionFrame.java # Quiz selection window
│   ├── RegisterFrame.java  # Registration window
│   └── ResultsFrame.java   # User results window
└── util/                   # Utility classes
    └── DBConnection.java    # Database connection manager
```

## Requirements

- Java Development Kit (JDK) 8 or higher
- MySQL Server 5.7 or higher
- MySQL Connector/J (JDBC driver)

## Getting Started

1. Clone the repository:
```bash
git clone https://github.com/ull0sm/QuizApp.git
```

2. Set up the database:
   - Create a MySQL database named `quiz_app`
   - Default database credentials:
     - Username: root
     - Password: simp
   - The database schema will be created automatically

3. Build and run the application:
   - Compile the Java files:
   ```bash
   javac src/*.java src/ui/*.java src/dao/*.java src/model/*.java src/util/*.java
   ```
   - Run the application:
   ```bash
   java src.ui.Main
   ```

## Usage

1. Launch the application
2. Login or Register a new account
3. After logging in, you'll see the dashboard with options to:
   - Play a Quiz: Select from available quizzes and start playing
   - View Results: Check your quiz scores and performance
   - View Leaderboard: See global rankings of all players

## How It Works

The application follows a modular architecture with:
- Java Swing for the GUI interface
- MySQL database for storing users, quizzes, and scores
- DAO pattern for database operations
- MVC-like pattern for code organization

Data flow:
1. User logs in through the authentication system
2. User selects a quiz from the available options
3. Questions are loaded from the database
4. User answers questions in real-time
5. Scores are calculated and stored
6. Results are displayed in the dashboard
7. Scores are updated in the leaderboard

## Contribution

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request