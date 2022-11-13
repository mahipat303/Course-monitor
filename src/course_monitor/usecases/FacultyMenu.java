package course_monitor.usecases;

import java.util.List;
import java.util.Scanner;

import course_monitor.exception.CoursePlanException;
import course_monitor.exception.FacultyException;
import course_monitor.model.CoursePlan;
import course_monitor.userDao.facultyDao.FacultyDao;
import course_monitor.userDao.facultyDao.FacultyDaoImpl;

public class FacultyMenu {

	public int login() {

		int num = 0;
		String username;
		String password;

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter faculty email :- ");
		username = sc.nextLine();

		System.out.println("Enter faculty password :- ");

		password = sc.nextLine();

		FacultyDao fdo = new FacultyDaoImpl();

		try {
			String message = fdo.facultyLogin(username, password);

			System.out.println(message);

			num = 1;

		} catch (FacultyException e) {

			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("Want to Try again?");
			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				num = login();
			} else {
				num = 0;
			}
		}

		return num;
	}

	public int updatePasswordUseCase() {
		int num = 0;
		int id=0;
		String password;
		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter faculty ID :- ");
			id = sc.nextInt();

			System.out.println("Enter new password :- ");
			password = sc.next();
		} catch (Exception e1) {
			System.out.println("Enter valid input..");
			return 0;
		}
		FacultyDao fdo = new FacultyDaoImpl();

		try {
			String message = fdo.updatePassword(id, password);

			System.out.println(message);

			num = 1;

		} catch (FacultyException e) {
			Scanner sc = new Scanner(System.in);
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("Want to Try again?");
			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				num = updatePasswordUseCase();
			} else {
				num = 0;
			}
		}

		return num;
	}

	public int getCoursePlanUseCase() {
		int num = 0;
		int fId;
		String bId;
		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter faculty ID :- ");
			fId = sc.nextInt();

			System.out.println("Enter batch ID :- ");
			sc.nextLine();
			bId = sc.nextLine();
		} catch (Exception e1) {
			System.out.println("enter valid input..");
			return 0;
		}

		FacultyDao fdo = new FacultyDaoImpl();

		try {
			List<CoursePlan> cpList = fdo.getCoursePlan(bId, fId);
			for (CoursePlan coursePlan : cpList) {
				System.out.println(coursePlan);
			}
			if (cpList.isEmpty()) {
				System.out.println("no plan available...");
			}

			num = 1;

		} catch (CoursePlanException e) {
			Scanner sc = new Scanner(System.in);
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("Want to Try again?");
			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				num = getCoursePlanUseCase();
			} else {
				num = 0;
			}
		}

		return num;
	}

	public int fillDayWisePlannerUseCase() {
		int num = 0;
		String bId = null;
		int day = 0;
		int fId = 0;
		String topic = null;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter batch ID :- ");
			bId = sc.nextLine();

			System.out.println("Enter day :- ");
			day = sc.nextInt();

			System.out.println("Enter faculty ID :- ");
			fId = sc.nextInt();

			System.out.println("Enter topic :- ");
			sc.nextLine();
			topic = sc.next();

		} catch (Exception e) {
			System.out.println("enter valid input");
			return 0;
		}

		FacultyDao fdo = new FacultyDaoImpl();

		try {
			String message = fdo.fillDayWisePlanner(bId, day, fId, topic);

			System.out.println(message);

			num = 1;

		} catch (CoursePlanException e) {

			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("Want to Try again?");
			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				num = fillDayWisePlannerUseCase();
			} else {
				num = 0;
			}
		}

		return num;
	}

	public int changeStatusOfPlanUseCase() {
		int num = 0;
		String bId = null;
		int day = 0;
		int fId = 0;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter batch ID :- ");
			bId = sc.nextLine();

			System.out.println("Enter day :- ");
			day = sc.nextInt();

			System.out.println("Enter faculty ID :- ");
			fId = sc.nextInt();
		} catch (Exception e) {
			System.out.println("enter valid input...");
			return 0;
		}

		FacultyDao fdo = new FacultyDaoImpl();

		try {
			String message = fdo.changeStatusOfPlan(bId, day, fId);

			System.out.println(message);

			num = 1;

		} catch (CoursePlanException e) {

			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("Want to Try again?");
			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				num = changeStatusOfPlanUseCase();
			} else {
				num = 0;
			}
		}

		return num;
	}

}
