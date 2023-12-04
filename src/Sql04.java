import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//use JDBC for executing a query on the jdbc:mysql://localhost:3306/newdb database that:
//adds a new string column of 30 chars called country to the students table
//populate the new column with Italy for 2 students and Germany for the other 2 students

public class Sql04 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/newdb";
    private static final String USER = "root";
    private static final String PASSWORD = "123";

    public static void addColumnCountry() {
        String query = "ALTER TABLE students ADD COLUMN country VARCHAR(30)";

        try (
            //jdbc connection
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            //statement
            Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(query);

            //populating the column
            statement.executeUpdate("UPDATE students SET country = 'Italy' WHERE student_id IN (1, 2)");
            statement.executeUpdate("UPDATE students SET country = 'Germany' WHERE student_id IN (3, 4)");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
