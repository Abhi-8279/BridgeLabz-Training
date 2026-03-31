package StudentCourseRegisterationSystem;

public class StudentCourseApp {

	public static void main(String[] args) {
		
		Student s1 = new Student(101, "Harshdeep");
        RegistrationService service = new RegisterationServiceImpl();

        try {
            service.registerCourse(s1, "Java");
            service.registerCourse(s1, "DBMS");
            service.registerCourse(s1, "OOP");
            service.registerCourse(s1, "Cloud");
        } catch (CourseLimitExceededException e) {
            System.out.println(e.getMessage());
        }

        s1.assignGrade("Java", "A");
        s1.assignGrade("DBMS", "B+");

        s1.displayDetails();
        s1.viewGrades();

	}

}
