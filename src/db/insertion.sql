USE quiz_app;

-- Insert quizzes
INSERT INTO quizzes (name) VALUES
('DBMS'),
('JAVA'),
('PYTHON');

-- DBMS Questions
INSERT INTO questions (quiz, text, optionA, optionB, optionC, optionD, correctOption) VALUES
('DBMS', 'What does DBMS stand for?', 'Database Management System', 'Data Base Management System', 'Database Management Service', 'Data Base Management Service', 'A'),
('DBMS', 'Which language is used to manage relational databases?', 'HTML', 'SQL', 'C++', 'Java', 'B'),
('DBMS', 'What is the primary key?', 'Unique identifier', 'Foreign key', 'Index', 'Null value', 'A'),
('DBMS', 'Which normal form is concerned with transitive dependency?', '1NF', '2NF', '3NF', 'BCNF', 'C'),
('DBMS', 'What is the full form of ACID in databases?', 'Atomicity, Consistency, Isolation, Durability', 'Accuracy, Consistency, Integrity, Durability', 'Atomicity, Consistency, Integrity, Durability', 'Atomicity, Control, Isolation, Durability', 'A'),
('DBMS', 'Which command is used to remove rows from a table?', 'DELETE', 'DROP', 'REMOVE', 'ERASE', 'A'),
('DBMS', 'In SQL, which keyword is used to retrieve unique records?', 'UNIQUE', 'DISTINCT', 'DIFFERENT', 'ONLY', 'B'),
('DBMS', 'Which of these is a database constraint?', 'PRIMARY KEY', 'METHOD', 'VARIABLE', 'ALIAS', 'A'),
('DBMS', 'What does a foreign key do?', 'Ensures uniqueness', 'Creates an index', 'Links two tables', 'Stores data', 'C'),
('DBMS', 'What is a join in SQL?', 'Combine rows from two tables', 'Delete rows', 'Update rows', 'Create a new table', 'A');

-- JAVA Questions
INSERT INTO questions (quiz, text, optionA, optionB, optionC, optionD, correctOption) VALUES
('JAVA', 'Which of these is a valid Java keyword?', 'interface', 'unsigned', 'extends', 'implement', 'A'),
('JAVA', 'What is the size of int in Java?', '2 bytes', '4 bytes', '8 bytes', 'Depends on platform', 'B'),
('JAVA', 'Which method is the entry point of a Java program?', 'main()', 'start()', 'run()', 'init()', 'A'),
('JAVA', 'Which keyword is used for inheritance?', 'extends', 'implements', 'inherits', 'super', 'A'),
('JAVA', 'Which package contains the Random class?', 'java.util', 'java.lang', 'java.io', 'java.net', 'A'),
('JAVA', 'What does JVM stand for?', 'Java Virtual Machine', 'Java Vendor Machine', 'Java Visual Machine', 'Java Variable Machine', 'A'),
('JAVA', 'Which exception is thrown when dividing by zero?', 'NullPointerException', 'ArithmeticException', 'IOException', 'ArrayIndexOutOfBoundsException', 'B'),
('JAVA', 'Which operator is used for comparison?', '==', '=', '!=', '<=', 'A'),
('JAVA', 'What is the default value of boolean in Java?', 'true', 'false', 'null', '0', 'B'),
('JAVA', 'Which keyword is used to create an object?', 'class', 'new', 'create', 'object', 'B');

-- PYTHON Questions
INSERT INTO questions (quiz, text, optionA, optionB, optionC, optionD, correctOption) VALUES
('PYTHON', 'Which keyword is used to create a function in Python?', 'def', 'func', 'function', 'lambda', 'A'),
('PYTHON', 'What data type is returned by the input() function?', 'int', 'str', 'float', 'bool', 'B'),
('PYTHON', 'How do you start a comment in Python?', '#', '//', '/*', '--', 'A'),
('PYTHON', 'Which of these is a mutable data type?', 'tuple', 'list', 'string', 'int', 'B'),
('PYTHON', 'What does the len() function do?', 'Returns the length', 'Deletes an item', 'Counts characters', 'Adds an item', 'A'),
('PYTHON', 'How do you declare a variable?', 'var x = 5', 'x = 5', 'int x = 5', 'declare x = 5', 'B'),
('PYTHON', 'Which operator is used for exponentiation?', '^', '**', '%', '//', 'B'),
('PYTHON', 'What is the output of: print(2 // 3)?', '0', '0.66', '1', 'Error', 'A'),
('PYTHON', 'Which keyword is used for conditional branching?', 'if', 'for', 'while', 'switch', 'A'),
('PYTHON', 'How to import a module?', 'include module', 'import module', '#import module', 'using module', 'B');