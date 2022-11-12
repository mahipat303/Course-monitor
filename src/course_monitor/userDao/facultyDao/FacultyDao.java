package course_monitor.userDao.facultyDao;

import java.util.List;

import course_monitor.model.CoursePlan;
import course_monitor.utility.CoursePlanException;
import course_monitor.utility.FacultyException;

public interface FacultyDao {

//	•	Login to his/her account
	public String facultyLogin(String username, String password) throws FacultyException;

//	•	Update his/her password.
	public String updatePassword(int facultyId, String password) throws FacultyException;

//	•	View the Course Plan
	public List<CoursePlan> getCoursePlan(String BatchId,int facultyId) throws CoursePlanException;

//	•	Fill up the day wise planner.
	public String fillDayWisePlanner(String batchId, int dayNumber, int facultyId , String topic) throws CoursePlanException;

	public String changeStatusOfPlan(String batchId, int dayNumber, int facultyId)throws CoursePlanException;
	
	
}
