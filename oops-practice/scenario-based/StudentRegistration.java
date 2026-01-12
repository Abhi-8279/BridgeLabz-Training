import java.util.*;

// ---------------- CUSTOM EXCEPTION ----------------
class CourseLimitExceededException extends Exception {
    public CourseLimitExceededException(String message) {
        super(message);
    }
}

// ---------------- INHERITANCE ----------------
class Person {
    protected int id;
    protected String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// ---------------- ENCAPSULATION ----------------
class Student extends Person {
    private final int MAX_COURSES = 3;
    private List<Course> enrolledCourses;
    private Map<String, String> grades;

    public Student(int id, String name) {
        super(id, name);
        enrolledCourses = new ArrayList<>();
        grades = new HashMap<>();
    }

    public List<Course> getEnrolledCourses() {
        return Collections.unmodifiableList(enrolledCourses);
    }

    public void enrollCourse(Course course) throws CourseLimitExceededException {
        if (enrolledCourses.size() >= MAX_COURSES) {
            throw new CourseLimitExceededException("Course limit exceeded! Max allowed: " + MAX_COURSES);
        }
        enrolledCourses.add(course);
        System.out.println(name + " enrolled in " + course.getCourseName());
    }

    public void dropCourse(String courseCode) {
        enrolledCourses.removeIf(c -> c.getCourseCode().equals(courseCode));
        grades.remove(courseCode);
        System.out.println(name + " dropped course " + courseCode);
    }

    public void assignGrade(String courseCode, String grade) {
        grades.put(courseCode, grade);
    }

    public void viewGrades() {
        System.out.println("Grades for " + name + ":");
        for (Map.Entry<String, String> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}

// ---------------- COURSE CLASS ----------------
class Course {
    private String courseCode;
    private String courseName;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }
}

// ---------------- ABSTRACTION ----------------
abstract class RegistrationService {
    abstract void registerStudent(Student student);
    abstract void enroll(Student student, Course course);
    abstract void drop(Student student, String courseCode);
}

// ---------------- IMPLEMENTATION ----------------
class RegistrationServiceImpl extends RegistrationService {

    public void registerStudent(Student student) {
        System.out.println("Student Registered: " + student.name + " (ID: " + student.id + ")");
    }

    public void enroll(Student student, Course course) {
        try {
            student.enrollCourse(course);
        } catch (CourseLimitExceededException e) {
            System.out.println("Enrollment Failed: " + e.getMessage());
        }
    }

    public void drop(Student student, String courseCode) {
        student.dropCourse(courseCode);
    }
}

// ---------------- MAIN CLASS ----------------
public class StudentRegistration {
    public static void main(String[] args) {

        RegistrationService service = new RegistrationServiceImpl();

        Student student = new Student(101, "Abhishek");
        service.registerStudent(student);

        Course java = new Course("CS101", "Java Programming");
        Course dbms = new Course("CS102", "DBMS");
        Course os = new Course("CS103", "Operating Systems");
        Course cn = new Course("CS104", "Computer Networks");

        // Enroll courses
        service.enroll(student, java);
        service.enroll(student, dbms);
        service.enroll(student, os);

        // Exceed limit (Exception case)
        service.enroll(student, cn);

        System.out.println("----------------------");

        // Grade assignment
        student.assignGrade("CS101", "A");
        student.assignGrade("CS102", "B+");
        student.assignGrade("CS103", "A+");

        student.viewGrades();

        System.out.println("----------------------");

        // Drop course
        service.drop(student, "CS102");
        student.viewGrades();
    }
}
