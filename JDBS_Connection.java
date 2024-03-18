import java.sql.*;

public class JDBS_Connection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/university";
        String user = "root";
        String pass = "Rg331186#";

        String studentName = "Alice Johnson";
        int studentAge = 20;
        String studentGender = "Female";
        String studentEmail = "alice@example.com";


        String insertQuery = "INSERT INTO students (name, age, gender, email) \n" +
                "VALUES (?, ?, ?, ?);";

        Connection conn = DriverManager.getConnection(url,user,pass);
        Statement statement = conn.createStatement();
        ResultSet set = statement.executeQuery("SELECT * FROM university.students;");

        while (set.next()){
            System.out.println("Roll no. "+set.getInt("id")+" Name: "+set.getString("name"));
        }
        PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
        preparedStatement.setString(1,studentName);
        preparedStatement.setInt(2,studentAge);
        preparedStatement.setString(3,studentGender);
        preparedStatement.setString(4,studentEmail);

        int count = preparedStatement.executeUpdate();
        System.out.println(count+" rows affected");

        statement.close();
        conn.close();
    }
}
