package Day3.Day_03_HW;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class School {

    private ArrayList<Student> students;

    public School() {
        students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public boolean removeStudent(int id) {

        for (Student s : students) {

            if (s.getStudentId() == id) {
                students.remove(s);
                System.out.println("Student id deleted");
                return true;
            }
        }
        return false;
    }

    public void displayAllStudents() {

        for (Student s : students) {
            System.out.println("All Students" + s);
        }
    }

    public void sortStudentByName() {
        Collections.sort(students, Comparator.comparing(Student::getName));
    }

    private void sortStudentsById() {
        Collections.sort(students, Comparator.comparingInt(Student::getStudentId));
    }

    public Student findStudentById(int id) {
//        for (Student s : students) {
//
//            if (s.getStudentId() == id)
//                return s;
//        }
//        return null;

        // Ensure the list is sorted by studentId
        sortStudentsById();

        // Perform binary search
        int left = 0;
        int right = students.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            Student student = students.get(mid);

            // Debug output to see the process
            System.out.println("Checking student with ID: " + student.getStudentId());

            if (student.getStudentId() == id) {
                return student; // Found the student
            } else if (student.getStudentId() < id) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return null; // Student not found
    }

    //write on file
//    public void writeStudentsToFile(String filename) throws IOException {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
//            for (Student student : students) {
//                writer.write(student.getDetails());
//                writer.newLine();
//            }
//        }
//    }

    // read from class
//    public void readStudentsFromFile(String filename) throws IOException {
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(", ");
//                String name = parts[0].split("=")[1];
//                int age = Integer.parseInt(parts[1].split("=")[1]);
//                String address = parts[2].split("=")[1];
//                int studentId = Integer.parseInt(parts[3].split("=")[1]);
//                String course = parts[4].split("=")[1];
//                students.add(new Student(name, age, address, studentId, course));
//            }
//        }
//    }

    //clear student
    public void clearStudents() {
        students.clear();
    }

    //write on file
    public void writeStudentsToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.write(student.getName() + "," + student.getAge() + "," + student.getAddress() + ","
                        + student.getStudentId() + "," + student.getCourse());
                writer.newLine();
            }
            System.out.println("Students written to file: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //read from file
    public void readStudentsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 5) {
                    String name = details[0];
                    int age = Integer.parseInt(details[1]);
                    String address = details[2];
                    int studentId = Integer.parseInt(details[3]);
                    String course = details[4];
                    Student student = new Student(name, age, address, studentId, course);
                    addStudent(student);
                }
            }
            System.out.println("Students read from file: " + filename);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
