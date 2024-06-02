package Day3.Day_03_HW;

public class Person extends PersonRecord {

     private String name;
     private int age;
     private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    //if we set age is not between 0 and 150. we have IllegalArgumentException
    public void setAge(int age) {
        if(age < 0 || age > 150 ) {
            throw new
                    IllegalArgumentException("Age must be between 0 and 150.");
        }
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getDetails() {
        return "Name: " + getName() + " -Age: " + getAge() + " -Address: " + getAddress() ;
    }

    public static void main(String[] args) {

        // Create and display details of two Person objects.
        Person p1 = new Person("Raghad", 27, "Riyadh Safa");
        Person p2 = new Person("Nora", 23, "Riyadh");

        System.out.println("Details of Person p1: ");
        System.out.println("Name: " + p1.getName());
        System.out.println("Age before: " + p1.getAge());

        //if we set age is not between 0 and 150. we have IllegalArgumentException
        p1.setAge(30);
        System.out.println("Age after: " + p1.getAge());
        System.out.println("Address: " + p1.getAddress());
        System.out.println("Address: " + p1.getDetails());
        System.out.println("-------------------");

        System.out.println("Details of Person p2: ");
        System.out.println("Name: " + p2.getName());
        System.out.println("Age before: " + p2.getAge());

        //if we set age is not between 0 and 150. we have IllegalArgumentException
        p1.setAge(25);
        System.out.println("Age after: " + p2.getAge());
        System.out.println("Address: " + p2.getAddress());
        System.out.println("Address: " + p2.getDetails());
        System.out.println("-------------------");

        // Create and display details of two Student objects.
        Student s1 = new Student("Sara",20,"Jeedah",1,"SQL");
        Student s2 = new Student("Asma",25,"Jeedah",2,"Java");

        System.out.println("Details of Student s1: ");
        System.out.println("Name: " + s1.getName());
        System.out.println("Age: " + s1.getAge());
        System.out.println("Address: " + s1.getAddress());
        System.out.println("StudentId befor: " + s1.getStudentId());

        //check the studentId matches the given id or not
        s1.compareById(1);

//      Age must be between 0 and 150.
        s1.setStudentId(1);
        System.out.println("StudentId after: " + s1.getStudentId());
        System.out.println("Course: " + s1.getCourse());
        System.out.println("Student Information: \n" + s1.toString());
        System.out.println("Details: " + p1.getDetails());
        System.out.println("-------------------");

        System.out.println("Details of Student s2: ");
        System.out.println("Name: " + s2.getName());
        System.out.println("Age: " + s2.getAge());
        System.out.println("Address: " + s2.getAddress());
        System.out.println("StudentId befor: " + s2.getStudentId());

        //check the studentId matches the given id or not
        s2.compareById(1);

//      Age must be between 0 and 150.
        s2.setStudentId(2);
        System.out.println("StudentId after: " + s2.getStudentId());
        System.out.println("Course: " + s2.getCourse());
        System.out.println("Student Information: \n" + s2.toString());
        System.out.println("Details: " + s2.getDetails());

        System.out.println("-------------------");

        // Polymorphism object Person type of Student

        Student s3 = new Student("Rafa",21,"Jeedah",3,"Python");

        System.out.println("Details of Student s3: ");
        System.out.println("Name: " + s3.getName());
        System.out.println("Age: " + s3.getAge());
        System.out.println("Address: " + s3.getAddress());
        System.out.println("StudentId: " + s3.getStudentId());
        System.out.println("Course: " + s3.getCourse());
        System.out.println("Student Information: \n" + s2.toString());
        System.out.println("-------------------");

        // Polymorphism object Person type of Student
        Person s4 = new Student("Nora",21,"Jeedah",4,"Back Development");
        printPerDetails(s4);

        //CallSchool methods
        School school = new School();

        //Add students
        school.addStudent(s1);
        school.addStudent(s2);
        school.addStudent(s3);
        school.addStudent((Student) s4);
        System.out.println("-------------------");

        // All student
        System.out.println("All student: ");
        school.displayAllStudents();
        System.out.println("-------------------");

        // add student
        System.out.println("Add student s5: ");
        Student s5 = new Student("Ghada",30,"Jeedah",5,"Front Development");
        school.addStudent(s5);
        System.out.println("-------------------");

        // All student after add student
        System.out.println("All student after add student: ");
        school.displayAllStudents();
        System.out.println("-------------------");

        // remove student
        System.out.println("Remove student: ");
        school.removeStudent(5);
        System.out.println("-------------------");

        // All student after remove student
        System.out.println("All student after remove student: ");
        school.displayAllStudents();
        System.out.println("-------------------");

        // Sort students by name and display them
        System.out.println("Students sorted by name:");
        school.sortStudentByName();
        System.out.println("All student after sort them: ");
        school.displayAllStudents();
        System.out.println("-------------------");

        // Find a student by studentId using binary search
        System.out.println("Finding student with ID 2:");
        Student s = school.findStudentById(2);
        if (s != null) {
            System.out.println("Found: " + s.getDetails());
        } else {
            System.out.println("Student with ID 2 not found.");
        }

        Student s6 = new Student("Afnan",26,"Riyadh",6,"C++");
        Student s7 = new Student("Raghad",19,"Abha",7,"C#");

        school.addStudent(s6);
        school.addStudent(s7);

        // Write students to file
        school.writeStudentsToFile("students.txt");

        // Clear the current list of students
        school.clearStudents();

        // Read students from file
        school.readStudentsFromFile("students.txt");

        // Display all students read from file
        System.out.println("\nStudents read from file:");
        school.displayAllStudents();

    }

    public static void printPerDetails(Person per) {
        System.out.println("Name: " + per.getName());
        System.out.println("Age: " + per.getAge());
        System.out.println("Address: " + per.getAddress());
        System.out.println("Student Information: \n" + per.toString());
        System.out.println("--------------");

    }

}


