package course_monitor.demo;

import java.util.Scanner;

import course_monitor.usecases.AdminMenu;

public class Demo {

	public static void user() {
		Scanner sc = new Scanner(System.in);

		System.out.println("please select usertype");
		System.out.println("************************");
		System.out.println();
		System.out.println("1.Admin");
		System.out.println("2.Faculty");

		int type = sc.nextInt();
		if (type == 1) {
			Demo.adminLogin();
		}
	}

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
		System.out.println("1.create course");
		System.out.println("2.logout");

		int res = sc.nextInt();
		if (res == 1) {
			Demo.createCourse();
		} else if (res == 2) {
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

	}

	public static void main(String[] args) {

		Demo.user();

	}

}
