package course_monitor.usecases;

import java.util.Scanner;

import course_monitor.model.Course;
import course_monitor.userDao.adminDao.AdminDao;
import course_monitor.userDao.adminDao.AdminDaoImpl;
import course_monitor.utility.AdminException;
import course_monitor.utility.CourseException;

public class AdminMenu {

	public int login() {
		int num = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Admin username :- ");
		String username = sc.next();

		System.out.println("Enter Admin password :- ");
		String password = sc.next();

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
		String id = sc.next();

		System.out.println("Enter course Name :- ");
		String name = sc.next();

		System.out.println("Enter course fee :- ");
		int fee = sc.nextInt();

		System.out.println("Enter course Description :- ");
		String Desc = sc.next();

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

}
