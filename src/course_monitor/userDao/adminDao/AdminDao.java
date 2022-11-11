package course_monitor.userDao.adminDao;

import course_monitor.model.Batch;
import course_monitor.model.Course;
import course_monitor.model.Faculty;
import course_monitor.utility.AdminException;
import course_monitor.utility.BatchException;
import course_monitor.utility.CourseException;
import course_monitor.utility.FacultyException;

public interface AdminDao {

	// • Login to his account
	public String AdminLogin(String username, String password) throws AdminException;

	// • Create, Update, View Course.
	public String createCourse(Course course) throws CourseException;

	public String updateCourseFee(String courseId, int fee) throws CourseException;

	public String updateCourseDescription(String courseId, String description) throws CourseException;

	public String updateCourseName(String courseId, String courseName) throws CourseException;

	// • Create, Update, View Batch. A batch is related to a course
	public String createBatch(Batch batch) throws BatchException;
	
	

	// • Allocate faculty to a batch.
	public String AllocateFacultyToBatch(int facultyId, String batchId) throws BatchException, FacultyException;

	public String createFaculty(Faculty faculty) throws FacultyException;

}

//•	Login to his account

//• Create, Update, View Course.

//•	Create, Update, View Faculty.

//•	Allocate faculty to a batch.

//•	Create, Update, View Batch. A batch is related to a course
