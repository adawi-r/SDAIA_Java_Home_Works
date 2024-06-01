package Day2.HW;

import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager(){
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

//    public Student getStudent(Student student){
//        student.getName();
//    }

    public Student getStudentById(int id) {

        for (Student student : students) {

            if (student.getId() == id)
                return student;
        }
        return null;
    }

    public ArrayList<Student> getAllStudents(){
        return students;
    }

    public boolean removeStudentById(int id){

        for (Student student : students) {

            if (student.getId() == id){
                students.remove(student);
                return true;
            }
        }
        return false;
    }

}
