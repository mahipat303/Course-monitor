package course_monitor.model;


public class Batch {

	private String batchId;
	private String CourseId;
	private int facultyId;
	private int numberOfStudent;
	private String startDate;
	private int durationDays;

	public Batch() {

	}

	public Batch(String batchId, String courseId, int facultyId, int numberOfStudent, String startDate,
			int durationDays) {
		super();
		this.batchId = batchId;
		this.CourseId = courseId;
		this.facultyId = facultyId;
		this.numberOfStudent = numberOfStudent;
		this.startDate = startDate;
		this.durationDays = durationDays;
	}
	
	public Batch(String batchId, String courseId, int numberOfStudent, String startDate,
			int durationDays) {
		
		this.batchId = batchId;
		this.CourseId = courseId;
		this.numberOfStudent = numberOfStudent;
		this.startDate = startDate;
		this.durationDays = durationDays;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getCourseId() {
		return CourseId;
	}

	public void setCourseId(String courseId) {
		CourseId = courseId;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public int getNumberOfStudent() {
		return numberOfStudent;
	}

	public void setNumberOfStudent(int numberOfStudent) {
		this.numberOfStudent = numberOfStudent;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public int getDurationDays() {
		return durationDays;
	}

	public void setDurationDays(int durationDays) {
		this.durationDays = durationDays;
	}

	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", CourseId=" + CourseId + ", facultyId=" + facultyId
				+ ", numberOfStudent=" + numberOfStudent + ", startDate=" + startDate + ", durationDays=" + durationDays
				+ "]";
	}

}
