package course_monitor.model;

import java.sql.Date;

public class Batch {

	private String batchId;
	private String CourseId;
	private int facultyId;
	private int numberOfStudent;
	private Date startDate;
	private int durationDays;

	public Batch() {

	}

	public Batch(String batchId, String courseId, int facultyId, int numberOfStudent, Date startDate,
			int durationDays) {
		super();
		this.batchId = batchId;
		CourseId = courseId;
		this.facultyId = facultyId;
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

	public Date getStartDate() {
		return startDate;
	}
	

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getDurationDays() {
		return durationDays;
	}

	public void setDurationDays(int durationDays) {
		this.durationDays = durationDays;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", CourseId=" + CourseId + ", facultyId=" + facultyId
				+ ", numberOfStudent=" + numberOfStudent + ", startDate=" + startDate.getDate() + ", durationDays=" + durationDays
				+ "]";
	}

}
