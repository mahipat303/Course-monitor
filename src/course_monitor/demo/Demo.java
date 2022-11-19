package course_monitor.demo;

import java.util.Scanner;

import course_monitor.usecases.AdminMenu;
import course_monitor.usecases.FacultyMenu;

public class Demo {

	public static void user() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome To Course Monitor System");
		System.out.println("please select usertype");
		System.out.println("************************");
		System.out.println();
		System.out.println("1.Admin");
		System.out.println("2.Faculty");

		try {
			int type = sc.nextInt();
			if (type == 1) {
				Demo.adminLogin();
			} else {
				Demo.facultyLogin();
			}
		} catch (Exception e) {
			System.out.println("please enter valid input...");
			Demo.user();
		}

	}

	public static void facultyLogin() {

		FacultyMenu fm = new FacultyMenu();
		int num = fm.login();
		if (num == 1) {
			Demo.showFacultyMenu();
		} else {
			Demo.user();
		}

	}

	public static void updatePassword() {

		FacultyMenu fm = new FacultyMenu();
		fm.updatePasswordUseCase();

		Demo.showFacultyMenu();

	}

	public static void getCoursePlanOfFaculty() {

		FacultyMenu fm = new FacultyMenu();
		fm.getCoursePlanUseCase();

		Demo.showFacultyMenu();

	}

	public static void fillPlanDayWise() {

		FacultyMenu fm = new FacultyMenu();
		fm.fillDayWisePlannerUseCase();

		Demo.showFacultyMenu();

	}

	public static void statusChange() {

		FacultyMenu fm = new FacultyMenu();
		fm.changeStatusOfPlanUseCase();

		Demo.showFacultyMenu();

	}

	public static void showFacultyMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("select any operation");
		System.out.println();
		System.out.println("1.update Password");
		System.out.println("2.get course plan");
		System.out.println("3.fill day wise plan");
		System.out.println("4.change course plan status");
		System.out.println("5.logout");

		int res = sc.nextInt();
		if (res == 1) {

			Demo.updatePassword();

		} else if (res == 3) {

			Demo.fillPlanDayWise();

		} else if (res == 2) {

			Demo.getCoursePlanOfFaculty();

		} else if (res == 4) {
			Demo.statusChange();
		} else if (res == 5) {

			Demo.user();
		}
	}

//	************************************

	public static void adminLogin() {
		Scanner sc = new Scanner(System.in);

		AdminMenu Am = new AdminMenu();

		int res = Am.login();

		if (res == 1) {
			Demo.showAdminMenu();
			return;
		}

		if (res == 0) {

			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				Demo.adminLogin();
			} else {
				Demo.user();
			}

		}

	}

	public static void showAdminMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("select any operation");
		System.out.println();
		System.out.println("1.create course");
		System.out.println("2.update course");
		System.out.println("3.view course detail");
		System.out.println("4.create batch");
		System.out.println("5.Allocate faculty to Batch");
		System.out.println("6.view batch detail");
		System.out.println("7.update number of student in batch");
		System.out.println("8.create faculty");
		System.out.println("9.view faculty detail");
		System.out.println("10.update faculty detail");
		System.out.println("11.Course Plan Batch vise");
		System.out.println("12.Day wise course plan of batch");
		System.out.println("13.create course plan");
		System.out.println("14.view All batch detail");
		System.out.println("15.view All course detail");
		System.out.println("16.logout");

		int res = sc.nextInt();
		if (res == 1) {

			Demo.createCourse();

		} else if (res == 2) {

			System.out.println("please select field that you want to update");
			System.out.println("1.update fee");
			System.out.println("2.update Description");
			System.out.println("3.update Name");
			System.out.println("4.previous menu");
			res = sc.nextInt();

			if (res == 1)
				Demo.updateCourseFee();
			else if (res == 2)
				Demo.updateCourseDescription();
			else if (res == 3)
				Demo.updateCourseName();
			else if (res == 4)
				Demo.showAdminMenu();

		} else if (res == 3) {

			Demo.viewCourseDetail();

		} else if (res == 4) {

			Demo.createBatch();
		} else if (res == 5) {
			Demo.AllocateFaculty();
		} else if (res == 6) {

			Demo.viewBatch();
		} else if (res == 7) {

			Demo.batchStudent();
		} else if (res == 8) {

			Demo.createFaculty();
		} else if (res == 9) {

			Demo.facultyDetail();
		} else if (res == 10) {
			System.out.println("please select field that you want to update");
			System.out.println("1.update Name");
			System.out.println("2.update Address");
			System.out.println("3.update Mobile");
			System.out.println("4.previous menu");
			res = sc.nextInt();

			if (res == 1)
				Demo.updateFacultyName();
			else if (res == 2)
				Demo.updateFacultyAddress();
			else if (res == 3)
				Demo.updateFacultyMobile();
			else if (res == 4)
				Demo.showAdminMenu();

		} else if (res == 11) {

			Demo.ViewCoursePlanUpdate();
		} else if (res == 12) {

			Demo.dayWiseCoursePlan();
		} else if (res == 13) {

			Demo.createCourseplan();
		} else if (res == 14) {

			Demo.viewAllBatch();
		} else if (res == 15) {

			Demo.viewAllCourseDetail();
		} else if (res == 16) {

			Demo.user();
		}
	}

	public static void createCourse() {
		Scanner sc = new Scanner(System.in);
		AdminMenu Am = new AdminMenu();
		int res = Am.createCourse();

		if (res == 1) {
			Demo.showAdminMenu();
			return;
		}

		while (res == 0) {

			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				res = Am.createCourse();
			} else {
				Demo.showAdminMenu();
			}

		}

		if (res == 1) {
			Demo.showAdminMenu();
			return;
		}

	}

	public static void updateCourseFee() {
		Scanner sc = new Scanner(System.in);
		AdminMenu Am = new AdminMenu();
		boolean res = Am.updateCourseFee();

		if (res) {
			Demo.showAdminMenu();
			return;
		}

		while (!res) {

			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				res = Am.updateCourseFee();
			} else {
				Demo.showAdminMenu();
			}

		}
		if (res) {
			Demo.showAdminMenu();
			return;
		}

	}

	public static void updateCourseDescription() {
		Scanner sc = new Scanner(System.in);
		AdminMenu Am = new AdminMenu();
		boolean res = Am.updateCourseDescription();

		if (res) {
			Demo.showAdminMenu();
			return;
		}

		while (!res) {

			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				res = Am.updateCourseDescription();
			} else {
				Demo.showAdminMenu();
			}

		}
		if (res) {
			Demo.showAdminMenu();
			return;
		}

	}

	public static void updateCourseName() {
		Scanner sc = new Scanner(System.in);
		AdminMenu Am = new AdminMenu();
		boolean res = Am.updateCourseName();

		if (res) {
			Demo.showAdminMenu();
			return;
		}

		while (!res) {

			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				res = Am.updateCourseName();
			} else {
				Demo.showAdminMenu();
			}

		}
		if (res) {
			Demo.showAdminMenu();
			return;
		}

	}

	public static void viewCourseDetail() {
		Scanner sc = new Scanner(System.in);
		AdminMenu Am = new AdminMenu();
		boolean res = Am.viewCourseDetail();

		if (res) {
			Demo.showAdminMenu();
			return;
		}

		while (!res) {

			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				res = Am.viewCourseDetail();
			} else {
				Demo.showAdminMenu();
			}

		}

		if (res) {
			Demo.showAdminMenu();
			return;
		}

	}

	public static void viewAllCourseDetail() {
		Scanner sc = new Scanner(System.in);
		AdminMenu Am = new AdminMenu();
		boolean res = Am.viewAllCourseDetail();

		if (res) {
			Demo.showAdminMenu();
			return;
		}

		while (!res) {

			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				res = Am.viewAllCourseDetail();
			} else {
				Demo.showAdminMenu();
			}

		}

		if (res) {
			Demo.showAdminMenu();
			return;
		}

	}

	public static void createBatch() {

		Scanner sc = new Scanner(System.in);
		AdminMenu Am = new AdminMenu();
		boolean res = Am.createBatch();

		if (res) {
			Demo.showAdminMenu();
			return;
		}

		while (!res) {

			System.out.println("yes or no");
			System.out.println(":- ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				res = Am.createBatch();
			} else {
				Demo.showAdminMenu();
			}

		}
		if (res) {
			Demo.showAdminMenu();
			return;
		}

	}

	public static void AllocateFaculty() {

		AdminMenu Am = new AdminMenu();
		Am.AllocateFacultyToBatch();

		Demo.showAdminMenu();

	}

	public static void viewBatch() {

		AdminMenu Am = new AdminMenu();
		Am.viewBatchDetail();

		Demo.showAdminMenu();

	}

	public static void viewAllBatch() {

		AdminMenu Am = new AdminMenu();
		Am.viewAllBatchDetail();

		Demo.showAdminMenu();

	}

	public static void batchStudent() {

		AdminMenu Am = new AdminMenu();
		Am.updateNumberOfStudentInBatch();

		Demo.showAdminMenu();

	}

	public static void createFaculty() {

		AdminMenu Am = new AdminMenu();
		Am.createFacultyUseCase();

		Demo.showAdminMenu();

	}

	public static void facultyDetail() {

		AdminMenu Am = new AdminMenu();
		Am.getFacultyDetailUseCase();

		Demo.showAdminMenu();

	}

	public static void updateFacultyName() {

		AdminMenu Am = new AdminMenu();
		Am.updateFacultyNameUseCase();

		Demo.showAdminMenu();

	}

	public static void updateFacultyAddress() {

		AdminMenu Am = new AdminMenu();
		Am.updateFacultyAddressUseCase();

		Demo.showAdminMenu();

	}

	public static void updateFacultyMobile() {

		AdminMenu Am = new AdminMenu();
		Am.updateFacultyMobileUseCase();

		Demo.showAdminMenu();

	}

	public static void ViewCoursePlanUpdate() {

		AdminMenu Am = new AdminMenu();
		Am.getCoursePlanByBatchUseCase();

		Demo.showAdminMenu();

	}

	public static void dayWiseCoursePlan() {

		AdminMenu Am = new AdminMenu();
		Am.getDayWiseCoursePlanofBatchUseCase();

		Demo.showAdminMenu();

	}

	public static void createCourseplan() {

		AdminMenu Am = new AdminMenu();
		Am.createCoursePlanUseCase();

		Demo.showAdminMenu();

	}

	public static void main(String[] args) {

		Demo.user();

	}

}
