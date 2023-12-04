package exercise5;
//create a class Student that has:
//2 string properties: name, surname
//a constructor for setting the 2 values, getters

public class Student {
    private String name;
    private String surname;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
