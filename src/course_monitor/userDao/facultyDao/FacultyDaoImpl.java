package course_monitor.userDao.facultyDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import course_monitor.exception.CoursePlanException;
import course_monitor.exception.FacultyException;
import course_monitor.model.CoursePlan;
import course_monitor.utility.CourseConnection;

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

	@Override
	public List<CoursePlan> getCoursePlan(String batchId, int facultyId) throws CoursePlanException {
		List<CoursePlan> planList = new ArrayList<>();

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps1 = conn.prepareStatement("select * from batch where batchId = ? AND facultyId = ?");

			ps1.setString(1, batchId);
			ps1.setInt(2, facultyId);

			ResultSet rs2 = ps1.executeQuery();

			if (rs2.next()) {
				PreparedStatement ps = conn.prepareStatement("select * from courseplan where batchId = ? ");

				ps.setString(1, batchId);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					planList.add(new CoursePlan(rs.getInt("planId"), rs.getString("batchId"), rs.getInt("dayNumber"),
							rs.getString("topic"), rs.getString("status")));
				}

			} else {
				throw new CoursePlanException("you dont have access to this batch");
			}

		} catch (SQLException e) {

			throw new CoursePlanException(e.getMessage());

		}

		return planList;
	}

	@Override
	public String facultyLogin(String username, String password) throws FacultyException {
		String message = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from faculty where email = ? and password = ?");

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				message = "welcome back " + rs.getString("Name")+" your ID is "+rs.getInt("facultyId");
			} else {
				throw new FacultyException("invalid user");
			}

		} catch (SQLException e) {

			throw new FacultyException(e.getMessage());

		}

		return message;
	}

	@Override
	public String fillDayWisePlanner(String batchId, int dayNumber, int facultyId, String topic)
			throws CoursePlanException {
		String message = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from batch where batchId = ? AND facultyId = ?");

			ps.setString(1, batchId);
			ps.setInt(2, facultyId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				PreparedStatement ps2 = conn
						.prepareStatement("update courseplan set topic = ? where dayNumber = ? and batchId = ?");

				ps2.setString(1, topic);
				ps2.setInt(2, dayNumber);
				ps2.setString(3, batchId);

				int row = ps2.executeUpdate();
				if (row > 0) {
					message = "plan filled successful";
				}

			} else {
				message = "you dont have access to this batch";
			}

		} catch (SQLException e) {

			throw new CoursePlanException(e.getMessage());

		}

		return message;
	}

	@Override
	public String changeStatusOfPlan(String batchId, int dayNumber, int facultyId) throws CoursePlanException {
		String message = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from batch where batchId = ? AND facultyId = ?");

			ps.setString(1, batchId);
			ps.setInt(2, facultyId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				PreparedStatement ps2 = conn.prepareStatement(
						"update courseplan set status = 'completed' where dayNumber = ? and batchId = ?");
				ps2.setInt(1, dayNumber);
				ps2.setString(2, batchId);

				int row = ps2.executeUpdate();

				if (row > 0) {
					message = "status changed successful";
				}

			} else {
				message = "you dont have access to this batch";
			}

		} catch (SQLException e) {

			throw new CoursePlanException(e.getMessage());

		}

		return message;
	}

}
