package Day3.Day_03_HW;

public class Student extends Person implements ComparableById {

    private int studentId;
    private String course;

    public Student(String name, int age, String address, int studentId, String course) {
        super(name, age, address);
        this.studentId = studentId;
        this.course = course;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        if( studentId <= 0) {
            throw new
                    IllegalArgumentException("studentId must be positive integer.");
        }
        this.studentId = studentId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student Id: " + studentId  +  " -Name: " + getName() + " -Age: " + getAge() + " -Address: " + getAddress() +  " -Course: " + course;
    }

    @Override
    public String getDetails() {
        return "Student Id: " + studentId  +  " -Name: " + getName() + " -Age: " + getAge() + " -Address: " + getAddress() +  " - Course: " + course;
    }

    @Override
    public boolean compareById(int id) {

        if(this.studentId == id) {

            System.out.println("studentId " + this.studentId + " matches the given id. " + id);
            return true;
        }
        else {
            System.out.println("studentId " + this.studentId + " is not matches the given id." + id);
            return false;
        }
    }
}
