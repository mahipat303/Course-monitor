package course_monitor.userDao.adminDao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import course_monitor.model.Batch;
import course_monitor.model.Course;
import course_monitor.model.CoursePlan;
import course_monitor.model.Faculty;
import course_monitor.utility.AdminException;
import course_monitor.utility.BatchException;
import course_monitor.utility.CourseConnection;
import course_monitor.utility.CourseException;
import course_monitor.utility.CoursePlanException;
import course_monitor.utility.FacultyException;

public class AdminDaoImpl implements AdminDao {

	@Override
	public String adminLogin(String username, String password) throws AdminException {
		String message = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from admin where username = ? and password = ?");

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				message = "welcome back " + username;
			} else {
				throw new AdminException("invalid Admin");
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
	public Course getCourseDetail(String CourseId) throws CourseException {
		Course course = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from course where courseId = ?");

			ps.setString(1, CourseId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				rs.getInt("courseFee");

				course = new Course(rs.getString("courseId"), rs.getString("coursename"), rs.getInt("courseFee"),
						rs.getString("description"));
			} else {
				throw new CourseException("no course available with this ID");
			}

		} catch (SQLException e) {

			throw new CourseException(e.getMessage());

		}

		return course;
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
			ps.setString(5, batch.getStartDate());
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
	public Batch getBatchDetail(String batchId) throws BatchException {
		Batch batch = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from batch where batchId = ?");

			ps.setString(1, batchId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				batch = new Batch(rs.getString("batchId"), rs.getString("courseId"), rs.getInt("facultyId"),
						rs.getInt("numberOfStudent"), rs.getString("startdate"), rs.getInt("durationInDays"));
			} else {
				throw new BatchException("no batch available with this ID");
			}

		} catch (SQLException e) {

			throw new BatchException(e.getMessage());

		}

		return batch;
	}

	@Override
	public String updateNumberOfStudentInBatch(int number, String batchId) throws BatchException {
		String message = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update batch set numberOfStudent = ? where batchId = ?");

			ps.setInt(1, number);
			ps.setString(2, batchId);

			int row = ps.executeUpdate();

			if (row > 0) {
				message = "students updated successfuly...";
			} else {
				throw new BatchException("no Batch available of this ID");
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

	@Override
	public Faculty getFacultyDetail(int facultyId) throws FacultyException {
		Faculty faculty = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from faculty where facultyId = ?");

			ps.setInt(1, facultyId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				faculty = new Faculty(rs.getInt("facultyId"), rs.getString("name"), rs.getString("address"),
						rs.getString("mobile"), rs.getString("email"), rs.getString("password"));
			} else {
				throw new FacultyException("no faculty available with this ID");
			}

		} catch (SQLException e) {

			throw new FacultyException(e.getMessage());

		}

		return faculty;
	}

	@Override
	public String updateFacultyName(int facultyId, String facultyName) throws FacultyException {
		String message = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update faculty set name = ? where facultyId = ?");

			ps.setString(1, facultyName);
			ps.setInt(2, facultyId);

			int row = ps.executeUpdate();

			if (row > 0) {
				message = "name updated successfuly...";
			}

		} catch (SQLException e) {

			throw new FacultyException(e.getMessage());

		}

		return message;
	}

	@Override
	public String updateFacultyAddress(int facultyId, String facultyAddress) throws FacultyException {
		String message = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update faculty set Address = ? where facultyId = ?");

			ps.setString(1, facultyAddress);
			ps.setInt(2, facultyId);

			int row = ps.executeUpdate();

			if (row > 0) {
				message = "Address updated successfuly...";
			}

		} catch (SQLException e) {

			throw new FacultyException(e.getMessage());

		}

		return message;
	}

	@Override
	public String updateFacultyMobile(int facultyId, String facultyMobile) throws FacultyException {
		String message = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update faculty set Mobile = ? where facultyId = ?");

			ps.setString(1, facultyMobile);
			ps.setInt(2, facultyId);

			int row = ps.executeUpdate();

			if (row > 0) {
				message = "Mobile updated successfuly...";
			}

		} catch (SQLException e) {

			throw new FacultyException(e.getMessage());

		}

		return message;
	}

	@Override
	public CoursePlan getCoursePlanByBatch(String batchId) throws CoursePlanException {
		CoursePlan cp = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from CoursePlan where batchId = ?");

			ps.setString(1, batchId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				cp = new CoursePlan(rs.getInt("planId"), rs.getString("batchId"), rs.getInt("dayNumber"),
						rs.getString("topic"), rs.getString("status"));

			} else {
				throw new CoursePlanException("no course Plan is there for this ID");
			}

		} catch (SQLException e) {

			throw new CoursePlanException(e.getMessage());

		}

		return cp;
	}

	@Override
	public CoursePlan getDayWiseCoursePlanofBatch(String batchId, int day) throws CoursePlanException {
		CoursePlan cp = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from CoursePlan where batchId = ? and dayNumber =?");

			ps.setString(1, batchId);
			ps.setInt(2, day);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				cp = new CoursePlan(rs.getInt("planId"), rs.getString("batchId"), rs.getInt("dayNumber"),
						rs.getString("topic"), rs.getString("status"));

			} else {
				throw new CoursePlanException("no plan for this day");
			}

		} catch (SQLException e) {

			throw new CoursePlanException(e.getMessage());

		}

		return cp;
	}

	@Override
	public String createCoursePlan(CoursePlan courseplan) throws CoursePlanException {
		String message = null;

		try (Connection conn = CourseConnection.provideConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("insert in coursePlan(batchId,dayNumber,topic) values(?,?,?,?,?)");

			ps.setString(1, courseplan.getBatchId());
			ps.setInt(2, courseplan.getDayNumber());
			ps.setString(3, courseplan.getTopic());

			int row = ps.executeUpdate();

			if (row > 0) {
				message = "CoursePlan created successfuly...";
			}

		} catch (SQLException e) {

			throw new CoursePlanException(e.getMessage());

		}

		return message;
	}

}
