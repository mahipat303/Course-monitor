package course_monitor.userDao.adminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import course_monitor.model.Batch;
import course_monitor.model.Course;
import course_monitor.model.Faculty;
import course_monitor.utility.AdminException;
import course_monitor.utility.BatchException;
import course_monitor.utility.CourseConnection;
import course_monitor.utility.CourseException;
import course_monitor.utility.FacultyException;

public class AdminDaoImpl implements AdminDao {

	@Override
	public String AdminLogin(String username, String password) throws AdminException {
		String message = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from admin where username = ? and password = ?");

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				message = "welcome back " + username;
			} else {
				message = "invalid Admin";
			}

		} catch (SQLException e) {

			throw new AdminException(e.getMessage());

		}

		return message;
	}

	@Override
	public String createCourse(Course course) throws CourseException {

		String message = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("insert into course values(?,?,?,?)");

			ps.setString(1, course.getCourseId());
			ps.setString(2, course.getCourseName());
			ps.setInt(3, course.getCourseFee());
			ps.setString(4, course.getCourseDescription());

			int row = ps.executeUpdate();

			if (row > 0) {
				message = "course created successfuly...";
			}

		} catch (SQLException e) {

			throw new CourseException(e.getMessage());

		}

		return message;
	}

	@Override
	public String updateCourseFee(String courseId, int fee) throws CourseException {
		String message = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update course set courseFee = ? where courseId = ?");

			ps.setInt(1, fee);
			ps.setString(2, courseId);

			int row = ps.executeUpdate();

			if (row > 0) {
				message = "course fee updated successfuly...";
			}

		} catch (SQLException e) {

			throw new CourseException(e.getMessage());

		}

		return message;
	}

	@Override
	public String updateCourseDescription(String courseId, String description) throws CourseException {
		String message = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update course set description = ? where courseId = ?");

			ps.setString(1, description);
			ps.setString(2, courseId);

			int row = ps.executeUpdate();

			if (row > 0) {
				message = "course description updated successfuly...";
			}

		} catch (SQLException e) {

			throw new CourseException(e.getMessage());

		}

		return message;
	}

	@Override
	public String updateCourseName(String courseId, String courseName) throws CourseException {
		String message = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update course set description = ? where courseId = ?");

			ps.setString(1, courseName);
			ps.setString(2, courseId);

			int row = ps.executeUpdate();

			if (row > 0) {
				message = "course Name updated successfuly...";
			}

		} catch (SQLException e) {

			throw new CourseException(e.getMessage());

		}

		return message;
	}

	@Override
	public String AllocateFacultyToBatch(int facultyId, String batchId) throws BatchException, FacultyException {
		String message = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update batch set facultyId = ? where batchId = ?");

			ps.setInt(1, facultyId);
			ps.setString(1, batchId);

			int row = ps.executeUpdate();

			if (row > 0) {
				message = "Allocation successful...";
			}

		} catch (SQLException e) {

			throw new BatchException(e.getMessage());

		}

		return message;
	}

	@Override
	public String createBatch(Batch batch) throws BatchException {
		String message = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("insert in batch values(?,?,?,?,?,?)");

			ps.setString(1, batch.getBatchId());
			ps.setString(2, batch.getCourseId());
			ps.setInt(3, batch.getFacultyId());
			ps.setInt(4, batch.getNumberOfStudent());
			ps.setString(5, batch.getStartDate().toString());
			ps.setInt(6, batch.getDurationDays());

			int row = ps.executeUpdate();

			if (row > 0) {
				message = "Batch created successfuly...";
			}

		} catch (SQLException e) {

			throw new BatchException(e.getMessage());

		}

		return message;
	}

	@Override
	public String createFaculty(Faculty faculty) throws FacultyException {
		String message = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement(
					"insert into faculty('name','address','mobile','email','password') values(?,?,?,?,?)");

			ps.setString(1, faculty.getFacultyname());
			ps.setString(2, faculty.getFacultyaddress());
			ps.setString(3, faculty.getMobile());
			ps.setString(4, faculty.getEmail());
			ps.setString(5, faculty.getPassword());

			int row = ps.executeUpdate();

			if (row > 0) {
				message = "course created successfuly...";
			}

		} catch (SQLException e) {

			throw new FacultyException(e.getMessage());

		}

		return message;
	}

}
