package course_monitor.usecases;

import java.util.List;
import java.util.Random;
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
		String id;
		String name = null;
		int num = 0;
		int fee = 0;
		String Desc = null;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter course Id :- ");
			id = sc.nextLine();

			System.out.println("Enter course Name :- ");
			name = sc.nextLine();

			System.out.println("Enter course fee :- ");
			fee = sc.nextInt();

			System.out.println("Enter course Description :- ");
			sc.nextLine();
			Desc = sc.nextLine();
		} catch (Exception e) {
			System.out.println("enter valid input...");
			return 0;
		}

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
		String id = null;
		int fee = 0;
		try {
			System.out.println("Enter course Id :- ");
			id = sc.nextLine();

			System.out.println("Enter course fee :- ");
			fee = sc.nextInt();
		} catch (Exception e) {
			System.out.println("enter valid input...");
			return false;
		}

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

	public boolean viewAllCourseDetail() {
		boolean flag = false;

		AdminDao ado = new AdminDaoImpl();

		try {
			List<Course> course = ado.getAllCourseDetail();

			for (Course course2 : course) {
				System.out.println(course2);
			}

			System.out.println();

			flag = true;

		} catch (CourseException e) {

			System.out.println(e.getMessage());
			System.out.println("Want to Try again?");
			flag = false;

		}

		return flag;
	}

	public boolean createBatch() {

		boolean flag = false;
		String bId = null;
		String cId = null;
		int students = 0;
		String date = null;
		int duration = 0;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter batch Id :- ");
			bId = sc.nextLine();

			System.out.println("Enter course Id :- ");
			cId = sc.nextLine();

			System.out.println("Enter number of students :- ");

			students = sc.nextInt();

			System.out.println("Enter batch start date :- ");
			sc.nextLine();
			date = sc.nextLine();

			System.out.println("Enter duration in days :- ");
			duration = sc.nextInt();

		} catch (Exception e) {
			System.out.println("enter valid input...");
			return false;
		}

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
		String bId = null;
		int fId = 0;
		try {
			System.out.println("Enter batch Id :- ");
			bId = sc.nextLine();

			System.out.println("Enter faculty Id :- ");
			fId = sc.nextInt();
		} catch (Exception e) {
			System.out.println("enter valid input...");
			return false;
		}

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

	public boolean viewAllBatchDetail() {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		AdminDao ado = new AdminDaoImpl();

		try {
			List<Batch> batch = ado.getAllBatchDetail();

			for (Batch batch2 : batch) {
				System.out.println(batch2);
			}

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
		String id = null;
		int number = 0;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter Batch Id :- ");
			id = sc.nextLine();

			System.out.println("Enter number of student :- ");
			number = sc.nextInt();
		} catch (Exception e) {
			System.out.println("enter valid input...");
			return false;
		}

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
		
//		***********
		Random rand = new Random(62);

		// Characters to be included
		String chrs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		// Generate n characters from above set and
		// add these characters to captcha.
		String tempId2 = "";
		int n = 5;
		while (n-- != 0) {
			int index = (int) (Math.random() * 62);
			tempId2 += chrs.charAt(index);
		}

//		***********
		String password = tempId2;

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

		AdminDao ado = new AdminDaoImpl();

		try {
			List<Faculty> faculty = ado.getFacultyDetail();

			for (Faculty faculty2 : faculty) {
				System.out.println(faculty2);
			}

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
		int Id = 0;
		String name = null;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter faculty Id :- ");
			Id = sc.nextInt();

			System.out.println("Enter faculty Name :- ");
			name = sc.next();

		} catch (Exception e) {
			System.out.println("enter valid input...");
			return false;
		}

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
