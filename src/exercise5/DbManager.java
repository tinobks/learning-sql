package exercise5;

import java.sql.*;
import java.util.ArrayList;

//use JDBC for executing the following queries on the jdbc:mysql://localhost:3306/newdb database:
//create a view italian_students that gets all the name and surname of the Italian students
//create a view german_students that gets all the name and surname of the German students
//execute a select using the italian_students and put the result in an ArrayList of Student objects called italianStudents
//execute a select using the german_students and put the result in an ArrayList of Student objects called germanStudents

public class DbManager {
    private static final String url = "jdbc:mysql://localhost:3306/newdb";
    private static final String user = "root";
    private static final String password = "123";

    public static Statement createStatementForDb() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createViewsCountry(String viewName, String country) throws SQLException {
        String query = "CREATE OR REPLACE VIEW "+viewName+ " AS SELECT first_name, last_name FROM students WHERE country = '" +country+ "'";
        try (Statement statement = createStatementForDb();) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Student> listStudent(String viewName) throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
        String query = "SELECT first_name, last_name FROM " + viewName;

        try (Statement statement = createStatementForDb();) {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString("first_name");
                String surname = resultSet.getString("last_name");
                students.add(new Student(name, surname));
            }

            return students;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
