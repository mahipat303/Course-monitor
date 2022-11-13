package course_monitor.usecases;

import java.util.List;
import java.util.Scanner;

import course_monitor.exception.AdminException;
import course_monitor.exception.BatchException;
import course_monitor.exception.CourseException;
import course_monitor.exception.CoursePlanException;
import course_monitor.exception.FacultyException;
import course_monitor.model.Batch;
import course_monitor.model.Course;
import course_monitor.model.CoursePlan;
import course_monitor.model.Faculty;
import course_monitor.userDao.adminDao.AdminDao;
import course_monitor.userDao.adminDao.AdminDaoImpl;

public class AdminMenu {

	public int login() {
		int num = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Admin username :- ");
		String username = sc.nextLine();

		System.out.println("Enter Admin password :- ");
		String password = sc.nextLine();

		AdminDao ado = new AdminDaoImpl();

		try {
			String message = ado.adminLogin(username, password);

			System.out.println(message);

			num = 1;

		} catch (AdminException e) {

			System.out.println(e.getMessage());
			System.out.println("Want to Try again?");
			num = 0;

		}
//		sc.close();

		return num;
	}

	public int createCourse() {

		int num = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter course Id :- ");
		String id = sc.nextLine();

		System.out.println("Enter course Name :- ");
		String name = sc.nextLine();

		System.out.println("Enter course fee :- ");
		int fee = sc.nextInt();

		System.out.println("Enter course Description :- ");
		sc.nextLine();
		String Desc = sc.nextLine();

		AdminDao ado = new AdminDaoImpl();
		Course course = new Course(id, name, fee, Desc);

		try {
			String message = ado.createCourse(course);

			System.out.println(message);

			num = 1;

		} catch (CourseException e) {

			System.out.println(e.getMessage());
			System.out.println("Want to Try again?");
			num = 0;

		}
//		sc.close();

		return num;

	}

	public boolean updateCourseFee() {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter course Id :- ");
		String id = sc.nextLine();

		System.out.println("Enter course fee :- ");
		int fee = sc.nextInt();

		AdminDao ado = new AdminDaoImpl();

		try {
			String message = ado.updateCourseFee(id, fee);

			System.out.println(message);

			flag = true;

		} catch (CourseException e) {

			System.out.println(e.getMessage());
			System.out.println("Want to Try again?");
			flag = false;

		}
//		sc.close();

		return flag;
	}

	public boolean updateCourseDescription() {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter course Id :- ");
		String id = sc.nextLine();

		System.out.println("Enter course Description :- ");
		String description = sc.nextLine();

		AdminDao ado = new AdminDaoImpl();

		try {
			String message = ado.updateCourseDescription(id, description);

			System.out.println(message);

			flag = true;

		} catch (CourseException e) {

			System.out.println(e.getMessage());
			System.out.println("Want to Try again?");
			flag = false;

		}
//		sc.close();

		return flag;
	}

	public boolean updateCourseName() {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter course Id :- ");
		String id = sc.nextLine();

		System.out.println("Enter course Name :- ");
		String name = sc.nextLine();

		AdminDao ado = new AdminDaoImpl();

		try {
			String message = ado.updateCourseName(id, name);

			System.out.println(message);

			flag = true;

		} catch (CourseException e) {

			System.out.println(e.getMessage());
			System.out.println("Want to Try again?");
			flag = false;

		}
//		sc.close();

		return flag;
	}

	public boolean viewCourseDetail() {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter course Id :- ");
		String id = sc.nextLine();

		AdminDao ado = new AdminDaoImpl();

		try {
			Course course = ado.getCourseDetail(id);

			System.out.println(course);
			System.out.println();

			flag = true;

		} catch (CourseException e) {

			System.out.println(e.getMessage());
			System.out.println("Want to Try again?");
			flag = false;

		}
//		sc.close();

		return flag;
	}

	public boolean createBatch() {

		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter batch Id :- ");
		String bId = sc.nextLine();

		System.out.println("Enter course Id :- ");
		String cId = sc.nextLine();

		System.out.println("Enter number of students :- ");

		int students = sc.nextInt();

		System.out.println("Enter batch start date :- ");
		sc.nextLine();
		String date = sc.nextLine();

		System.out.println("Enter duration in days :- ");
		
		int duration = sc.nextInt();

		AdminDao ado = new AdminDaoImpl();

		Batch batch = new Batch(bId, cId, students, date, duration);

		try {
			String message = ado.createBatch(batch);

			System.out.println(message);

			flag = true;

		} catch (BatchException e) {

			System.out.println(e.getMessage());
			System.out.println("Want to Try again?");
			flag = false;

		}

		return flag;
	}

	public boolean AllocateFacultyToBatch() {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter batch Id :- ");
		String bId = sc.nextLine();

		System.out.println("Enter faculty Id :- ");
		int fId = sc.nextInt();

		AdminDao ado = new AdminDaoImpl();

		try {
			String message = ado.AllocateFacultyToBatch(fId, bId);

			System.out.println(message);

			flag = true;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("Want to Try again?");
			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = AllocateFacultyToBatch();
			} else {
				flag = false;
			}

		}

		return flag;
	}

	public boolean viewBatchDetail() {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Batch Id :- ");
		String id = sc.nextLine();

		AdminDao ado = new AdminDaoImpl();

		try {
			Batch batch = ado.getBatchDetail(id);

			System.out.println(batch);
			System.out.println();

			flag = true;

		} catch (BatchException e) {

			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("Want to Try again?");
			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = viewBatchDetail();
			} else {
				flag = false;
			}

		}

		return flag;
	}

	public boolean updateNumberOfStudentInBatch() {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Batch Id :- ");
		String id = sc.nextLine();

		System.out.println("Enter number of student :- ");
		int number = sc.nextInt();

		AdminDao ado = new AdminDaoImpl();

		try {
			String message = ado.updateNumberOfStudentInBatch(number, id);

			System.out.println(message);
			System.out.println();

			flag = true;

		} catch (BatchException e) {

			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("Want to Try again?");
			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = updateNumberOfStudentInBatch();
			} else {
				flag = false;
			}

		}

		return flag;
	}

	public boolean createFacultyUseCase() {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter faculty name :- ");
		String name = sc.next();

		System.out.println("Enter faculty address :- ");
		String address = sc.next();

		System.out.println("Enter faculty mobile :- ");
		String mobile = sc.next();

		System.out.println("Enter faculty email :- ");
		String email = sc.next();

		System.out.println("Enter faculty password :- ");
		String password = sc.next();

		AdminDao ado = new AdminDaoImpl();
		Faculty faculty = new Faculty(name, address, mobile, email, password);
		try {
			String message = ado.createFaculty(faculty);

			System.out.println(message);
			System.out.println();

			flag = true;

		} catch (FacultyException e) {

			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("Want to Try again?");
			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = createFacultyUseCase();
			} else {
				flag = false;
			}

		}

		return flag;
	}

	public boolean getFacultyDetailUseCase() {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter faculty Id :- ");
		int Id = sc.nextInt();

		AdminDao ado = new AdminDaoImpl();

		try {
			Faculty faculty = ado.getFacultyDetail(Id);

			System.out.println(faculty);
			System.out.println();

			flag = true;

		} catch (FacultyException e) {

			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("Want to Try again?");
			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = getFacultyDetailUseCase();
			} else {
				flag = false;
			}

		}

		return flag;
	}

	public boolean updateFacultyNameUseCase() {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter faculty Id :- ");
		int Id = sc.nextInt();

		System.out.println("Enter faculty Name :- ");
		String name = sc.next();

		AdminDao ado = new AdminDaoImpl();

		try {
			String message = ado.updateFacultyName(Id, name);

			System.out.println(message);
			System.out.println();

			flag = true;

		} catch (FacultyException e) {

			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("Want to Try again?");
			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = updateFacultyNameUseCase();
			} else {
				flag = false;
			}

		}

		return flag;

	}

	public boolean updateFacultyAddressUseCase() {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter faculty Id :- ");
		int Id = sc.nextInt();

		System.out.println("Enter faculty Address :- ");
		String address = sc.next();

		AdminDao ado = new AdminDaoImpl();

		try {
			String message = ado.updateFacultyAddress(Id, address);

			System.out.println(message);
			System.out.println();

			flag = true;

		} catch (FacultyException e) {

			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("Want to Try again?");
			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = updateFacultyAddressUseCase();
			} else {
				flag = false;
			}

		}

		return flag;

	}

	public boolean updateFacultyMobileUseCase() {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter faculty Id :- ");
		int Id = sc.nextInt();

		System.out.println("Enter faculty Mobile :- ");
		String mobile = sc.next();

		AdminDao ado = new AdminDaoImpl();

		try {
			String message = ado.updateFacultyMobile(Id, mobile);

			System.out.println(message);
			System.out.println();

			flag = true;

		} catch (FacultyException e) {

			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("Want to Try again?");
			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = updateFacultyMobileUseCase();
			} else {
				flag = false;
			}

		}

		return flag;

	}

	public boolean getCoursePlanByBatchUseCase() {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter batch Id :- ");
		String Id = sc.next();

		AdminDao ado = new AdminDaoImpl();

		try {
			List<CoursePlan> cpList = ado.getCoursePlanByBatch(Id);

			if (cpList.isEmpty()) {
				System.out.println("no plan available for this batch");
			} else {
				for (CoursePlan coursePlan : cpList) {
					System.out.println(coursePlan);
				}
				System.out.println();
			}

			flag = true;

		} catch (CoursePlanException e) {

			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("Want to Try again?");
			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = getCoursePlanByBatchUseCase();
			} else {
				flag = false;
			}

		}

		return flag;
	}

	public boolean getDayWiseCoursePlanofBatchUseCase() {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter batch Id :- ");
		String Id = sc.next();

		System.out.println("Enter day :- ");
		int day = sc.nextInt();

		AdminDao ado = new AdminDaoImpl();

		try {
			CoursePlan cp = ado.getDayWiseCoursePlanofBatch(Id, day);

			System.out.println(cp);

			System.out.println();

			flag = true;

		} catch (CoursePlanException e) {

			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("Want to Try again?");
			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = getDayWiseCoursePlanofBatchUseCase();
			} else {
				flag = false;
			}

		}

		return flag;
	}

	public boolean createCoursePlanUseCase() {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter batch Id :- ");
		String Id = sc.next();

		System.out.println("Enter day :- ");
		int day = sc.nextInt();

		System.out.println("Enter day topic :- ");
		String topic = sc.next();

		AdminDao ado = new AdminDaoImpl();
		CoursePlan cp = new CoursePlan(Id, day, topic);

		try {
			String message = ado.createCoursePlan(cp);

			System.out.println(message);

			System.out.println();

			flag = true;

		} catch (CoursePlanException e) {

			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("Want to Try again?");
			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = createCoursePlanUseCase();
			} else {
				flag = false;
			}

		}

		return flag;
	}
}
