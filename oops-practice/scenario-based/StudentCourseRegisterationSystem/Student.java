package StudentCourseRegisterationSystem;

public class Student extends Person {
	private String courses[] = new String[3];
	private String grades[] = new String[3];
	private int count = 0;
	
	
	public Student(int id,String name) {
		super(id,name);
	}
	
	public void addCourse(String course) throws CourseLimitExceededException{
		if(count >=3) {
			throw new CourseLimitExceededException("Maximum 3 courses allowed");
		}
		courses[count] = course;
		grades[count] = "Not Assigned";
		count++;
	}
	
	public void assignGrade(String course,String grade) {
		for(int i = 0;i<count;i++) {
			if(course.equals(courses[i])) {
				grades[i] = grade;
				break;
			}
		}
	}
	
	public void dropCourse(String course) {
        for (int i = 0; i < count; i++) {
            if (courses[i].equals(course)) {
                courses[i] = courses[count - 1];
                grades[i] = grades[count - 1];
                count--;
                break;
            }
        }
    }
	
	public void viewGrades() {
        for (int i = 0; i < count; i++) {
            System.out.println(courses[i] + " : " + grades[i]);
        }
    }
	
	@Override
    public void displayDetails() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Courses Enrolled:");
        for (int i = 0; i < count; i++) {
            System.out.println("- " + courses[i]);
        }
    }
}
