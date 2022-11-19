package course_monitor.userDao.adminDao;

import java.util.List;

import course_monitor.exception.AdminException;
import course_monitor.exception.BatchException;
import course_monitor.exception.CourseException;
import course_monitor.exception.CoursePlanException;
import course_monitor.exception.FacultyException;
import course_monitor.model.Batch;
import course_monitor.model.Course;
import course_monitor.model.CoursePlan;
import course_monitor.model.Faculty;

public interface AdminDao {

	// • Login to his account
	public String adminLogin(String username, String password) throws AdminException;

	// • Create, Update, View Course.
	public String createCourse(Course course) throws CourseException;

	public String updateCourseFee(String courseId, int fee) throws CourseException;

	public String updateCourseDescription(String courseId, String description) throws CourseException;

	public String updateCourseName(String courseId, String courseName) throws CourseException;
	
	public Course getCourseDetail(String CourseId) throws CourseException;
	
	public List<Course> getAllCourseDetail() throws CourseException;

	// • Create, Update, View Batch. A batch is related to a course
	public String createBatch(Batch batch) throws BatchException;
	
	public Batch getBatchDetail(String batchId) throws BatchException;
	
	public List<Batch> getAllBatchDetail() throws BatchException;
	
	public String updateNumberOfStudentInBatch(int number , String batchId) throws BatchException;
	
	// • Allocate faculty to a batch.
	public String AllocateFacultyToBatch(int facultyId, String batchId) throws BatchException, FacultyException;

	//•	Create, Update, View Faculty.
	public String createFaculty(Faculty faculty) throws FacultyException;
	
	public List<Faculty> getFacultyDetail() throws FacultyException;
	
	public String updateFacultyName(int facultyId , String facultyName) throws FacultyException;
	
	public String updateFacultyAddress(int facultyId , String facultyAddress) throws FacultyException;
	
	public String updateFacultyMobile(int facultyId , String facultyMobile) throws FacultyException;
	
	//•	Create plan.
	public String createCoursePlan(CoursePlan courseplan) throws CoursePlanException;
	
	//•	 Generate Report for every batch.
	public List<CoursePlan> getCoursePlanByBatch(String batchId) throws CoursePlanException;
	
	
	//•	View the Day wise update of every batch.
	public CoursePlan getDayWiseCoursePlanofBatch(String batchId , int day) throws CoursePlanException;
		
}




