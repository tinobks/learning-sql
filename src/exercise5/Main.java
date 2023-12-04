package exercise5;
//create a class Student that has:
//2 string properties: name, surname
//a constructor for setting the 2 values, getters

//use JDBC for executing the following queries on the jdbc:mysql://localhost:3306/newdb database:
//create a view italian_students that gets all the name and surname of the Italian students
//create a view german_students that gets all the name and surname of the German students
//execute a select using the italian_students and put the result in an ArrayList of Student objects called italianStudents
//execute a select using the german_students and put the result in an ArrayList of Student objects called germanStudents

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            //create a view italian_students that gets all the name and surname of the Italian students
            DbManager.createViewsCountry("italian_students", "Italy");
            //create a view german_students that gets all the name and surname of the German students
            DbManager.createViewsCountry("german_students", "Germany");

            //execute a select using the italian_students and put the result in an ArrayList of Student objects called italianStudents
            ArrayList<Student> italianStudents = DbManager.listStudent("italian_students");
            ArrayList<Student> germanStudents = DbManager.listStudent("german_students");

            //printing the arraylists
            System.out.println("Italian students:");
            printArrayStudents(italianStudents);

            System.out.println("--------------------");
            System.out.println("German students:");
            printArrayStudents(germanStudents);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //print method
    public static void printArrayStudents(ArrayList<Student> studentList) {
        for (Student student : studentList) {
            System.out.println(student.getName() + " " + student.getSurname());
        }
    }
}
