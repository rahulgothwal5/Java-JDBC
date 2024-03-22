# Java-JDBC

Java-JDBC is a repository containing a Java project utilizing JDBC for database interaction. It provides a simple demonstration of connecting Java applications to relational databases using JDBC (Java Database Connectivity).

## Technologies Used

- **Core Java:** Fundamental Java programming language features and libraries.
- **JDBC (Java Database Connectivity):** API for connecting Java applications to databases and executing SQL queries.
- **SQL:** Structured Query Language for managing and manipulating relational databases.
- **SQL DAO (Data Access Object):** Design pattern for separating database access code from business logic.

## Usage

This project demonstrates basic CRUD (Create, Read, Update, Delete) operations using JDBC. You can explore the source code to understand how JDBC is used to interact with the database.

## Getting Started

To run this project locally, ensure you have Java Development Kit (JDK) installed on your system.

1. Clone the repository:

```bash
git clone https://github.com/rahulgothwal5/Java-JDBC.git
```

2. Navigate to the project directory:
```bash
cd Java-JDBC
```

3. Compile the Java files:
```bash
javac -d bin -cp lib/mysql-connector-java-8.0.28.jar src/*.java
```

4. Run the application:
```bash
java -cp bin:lib/mysql-connector-java-8.0.28.jar Main
```

Ensure that you have a MySQL database set up and configure the database connection details in the `src/DBConnection.java` file.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

