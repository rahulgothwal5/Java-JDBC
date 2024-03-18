package JDBCusingdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    Connection connection;

    private void connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/university";
        String user = "root";
        String pass = "Rg331186#";
        connection = DriverManager.getConnection(url, user, pass);
    }

    private void disconnect() throws SQLException {
        connection.close();
    }

    public List<Student> getStudents() throws Exception {
        connect();
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("SELECT * FROM university.students;");
        ArrayList<Student> list = new ArrayList<>();
        while (set.next()) {
            Student student = new Student();
            student.age = set.getInt("age");
            student.email = set.getString("email");
            student.name = set.getString("name");
            student.id = set.getInt("id");
            String genderString = set.getString("gender");
            student.gender = Student.Gender.valueOf(genderString.toUpperCase());
            list.add(student);
        }
        statement.close();
        disconnect();
        return list;
    }

    public Student getStudent(int id) throws Exception {
        connect();
        String studentFetchQuery = "SELECT * FROM university.students where id = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(studentFetchQuery);
        preparedStatement.setInt(1, id);
        ResultSet set = preparedStatement.executeQuery();

        Student student = new Student();
        set.next();

        student.age = set.getInt("age");
        student.email = set.getString("email");
        student.name = set.getString("name");
        student.id = set.getInt("id");
        String genderString = set.getString("gender");
        student.gender = Student.Gender.valueOf(genderString.toUpperCase());

        preparedStatement.close();
        disconnect();
        return student;
    }

    public int addStudent(String studentName, int studentAge, Student.Gender studentGender, String studentEmail) throws Exception {
        String insertQuery = "INSERT INTO students (name, age, gender, email) \n" +
                "VALUES (?, ?, ?, ?);";
        connect();
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, studentName);
        preparedStatement.setInt(2, studentAge);
        preparedStatement.setString(3, studentGender.name());
        preparedStatement.setString(4, studentEmail);

        int count = preparedStatement.executeUpdate();
        preparedStatement.close();
        disconnect();
        System.out.println(count + " rows affected");
        return count;
    }
}
