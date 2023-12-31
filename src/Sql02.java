import java.sql.*;

//create a connection to the newdb database
//create a table students if not already existing with
//the following columns:
//student_id as integer (10 digits) that is NOT NULL AUTO_INCREMENT
//last_name as string (max 30 characters)
//first_name as string (max 30 characters)
//the constraint that students_pk is the PRIMARY KEY using only the column student_id
//populate the table with 4 random students

public class Sql02 {
    //db parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/newdb";
    private static final String USER = "root";
    private static final String PASSWORD = "123";

    //method for creating connection to the newdb database, creating a table students if not already existing
    //
    public static void createTableStudents() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            //creating statement
            Statement statement = connection.createStatement();

            //executing query
            String query = "CREATE TABLE IF NOT EXISTS students (" +
                    "student_id INT(10) NOT NULL AUTO_INCREMENT, " +
                    "last_name VARCHAR(30), " +
                    "first_name VARCHAR(30), " +
                    "PRIMARY KEY (student_id)" +
                    ")";
            statement.executeUpdate(query);

            //populating with 4 students
            String student1 = "INSERT INTO students (last_name, first_name) VALUES ('Bokoshev', 'Tino')";
            String student2 = "INSERT INTO students (last_name, first_name) VALUES ('Savini', 'Luca')";
            String student3 = "INSERT INTO students (last_name, first_name) VALUES ('Buonanno', 'Antonio')";
            String student4 = "INSERT INTO students (last_name, first_name) VALUES ('Baudo', 'Pippo')";
            statement.executeUpdate(student1);
            statement.executeUpdate(student2);
            statement.executeUpdate(student3);
            statement.executeUpdate(student4);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}