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

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter faculty email :- ");
		String username = sc.nextLine();

		System.out.println("Enter faculty password :- ");
		
		String password = sc.nextLine();

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
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter faculty ID :- ");
		int id = sc.nextInt();

		System.out.println("Enter new password :- ");
		String password = sc.next();

		FacultyDao fdo = new FacultyDaoImpl();

		try {
			String message = fdo.updatePassword(id, password);

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
				num = updatePasswordUseCase();
			} else {
				num = 0;
			}
		}

		return num;
	}

	public int getCoursePlanUseCase() {
		int num = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter faculty ID :- ");
		int fId = sc.nextInt();

		System.out.println("Enter batch ID :- ");
		sc.nextLine();
		String bId = sc.nextLine();

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
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter batch ID :- ");
		String bId = sc.nextLine();

		System.out.println("Enter day :- ");
		int day = sc.nextInt();

		System.out.println("Enter faculty ID :- ");
		int fId = sc.nextInt();

		System.out.println("Enter topic :- ");
		sc.nextLine();
		String topic = sc.next();

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
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter batch ID :- ");
		String bId = sc.nextLine();

		System.out.println("Enter day :- ");
		int day = sc.nextInt();

		System.out.println("Enter faculty ID :- ");
		int fId = sc.nextInt();

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
