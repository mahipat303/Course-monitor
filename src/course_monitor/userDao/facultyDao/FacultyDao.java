package course_monitor.userDao.facultyDao;

import course_monitor.utility.FacultyException;

public interface FacultyDao {

	public String updatePassword(int facultyId, String password) throws FacultyException;

}
