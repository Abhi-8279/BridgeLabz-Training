package StudentCourseRegisterationSystem;

public abstract class RegistrationService {
	abstract void registerCourse(Student student, String course) throws CourseLimitExceededException;

    abstract void dropCourse(Student student, String course);
}
