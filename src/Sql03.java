import java.sql.*;
import java.util.ArrayList;

public class Sql03 {
    //db parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/newdb";
    private static final String USER = "root";
    private static final String PASSWORD = "123";

    //method to take names and surnames of all students using ResultSet next()
    //print names and assign surnames to an arraylist
    //after query print surnames
    public static void printAndAssing() throws SQLException {
        //sql query to get names and surnames
        String query = "SELECT first_name, last_name FROM students";

        //arraylist that will contain surnames
        ArrayList<String> surnames = new ArrayList<>();

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("Names:");
            while (resultSet.next()) {
                //get and print names
                System.out.println(resultSet.getString("first_name"));

                //get and add surnames to arraylist
                surnames.add(resultSet.getString("last_name"));
            }

            System.out.println("----------------");

            //printing surnames
            System.out.println("Surnames:");
            for (String surname : surnames) {
                System.out.println(surname);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
