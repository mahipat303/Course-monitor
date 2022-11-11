package course_monitor.userDao.facultyDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import course_monitor.utility.CourseConnection;
import course_monitor.utility.FacultyException;

public class FacultyDaoImpl implements FacultyDao {

	@Override
	public String updatePassword(int facultyId, String password) throws FacultyException {
		String message = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update faculty set password = ? where facultyId = ?");

			ps.setString(1, password);
			ps.setInt(2, facultyId);

			int row = ps.executeUpdate();

			if (row > 0) {
				message = "password updated successfuly...";
			}

		} catch (SQLException e) {

			throw new FacultyException(e.getMessage());

		}

		return message;
	}

}
