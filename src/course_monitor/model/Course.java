package course_monitor.model;

public class Course {

	private String courseId;
	private String CourseName;
	private int courseFee;
	private String courseDescription;

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(String courseId, String courseName, int courseFee, String courseDescription) {
		super();
		this.courseId = courseId;
		CourseName = courseName;
		this.courseFee = courseFee;
		this.courseDescription = courseDescription;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public int getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", CourseName=" + CourseName + ", courseFee=" + courseFee
				+ ", courseDescription=" + courseDescription + "]";
	}

}
