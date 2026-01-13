package StudentCourseRegisterationSystem;

public class RegisterationServiceImpl extends RegistrationService{
	 @Override
	 public void registerCourse(Student student, String course) throws CourseLimitExceededException {
	        student.addCourse(course);
	        System.out.println("Registered: " + course);
	 }

	 @Override
	 public void dropCourse(Student student, String course) {
	     student.dropCourse(course);
	     System.out.println("Dropped: " + course);
	  }
}
