package Day2.Day_02_HW;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        StudentManager manager = new StudentManager();

        Student s1 = new Student("Raghad",1);
        Student s2 = new Student("Sara",2);

        manager.addStudent(s1);
        manager.addStudent(s2);

        // Retrieve and display a student by their ID
        System.out.println("Get student by ID 2:");
        Student student = manager.getStudentById(2);
        if (student != null) {
            System.out.println("Name: " + student.getName() + ", ID: " + student.getId());
        }
        else {
            System.out.println("Student not found.");
        }

        // Display all students
        System.out.println("\nAll students:");
        for (Student s : manager.getAllStudents()) {
            System.out.println("Name: " + s.getName() + ", ID: " + s.getId());
        }

        // Remove a student by their ID
        System.out.println("\nRemoving student with ID 2:");
        boolean removed = manager.removeStudentById(2);
        if (removed) {
            System.out.println("Student removed.");
        }
        else {
            System.out.println("Student not found.");
        }

        // Display all students after removal
        System.out.println("\nAll students after removal:");
        for (Student s : manager.getAllStudents()) {
            System.out.println("Name: " + s.getName() + ", ID: " + s.getId());
        }
    }
}
