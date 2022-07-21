package oka;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ExersiseSystemAssignment {
	static Scanner scan = new Scanner(System.in);
	String name;
	int totalDuration;
	String date;
	int calories;
	static int users;
	HashMap<String, Integer> map = new HashMap<String, Integer>();

	public static void main(String args[]) {
		try {
			boolean cont = true;
			List<ExersiseSystemAssignment> list = new ArrayList<ExersiseSystemAssignment>();
			System.out.println("How many user are there?");
			users = scan.nextInt();
			while (users > 0) {
				ExersiseSystemAssignment obj = new ExersiseSystemAssignment();
				obj.user();
				int cal = 0;
				List<Integer> a = new ArrayList<Integer>();
				do {
					System.out.println("Exercise");
					if (a.contains(1)) {
						System.out.println("Which  type of a exercise \n2.running\n3.cycling");
					} else if (a.contains(2)) {
						System.out.println("Which  type of a exercise\n1.walking\n3.cycling");
					} else if (a.contains(3)) {
						System.out.println("Which type of a exercise\n1.walking\n2.running");

					} else
						System.out.println("Which type of a exercise\n1.walking\n2.running\n3.cycling");
					int c1 = scan.nextInt();
					a.add(c1);
					switch (c1) {
					case 1:
						int var1 = obj.walkingFunc();
						obj.map.put("walking", var1);
						cal = cal + var1;
						break;
					case 2:
						int var2 = obj.runningFunc();
						obj.map.put("running", var2);
						cal = cal + var2;
						break;
					case 3:
						int var3 = obj.cyclingFunc();
						obj.map.put("cycling", var3);
						cal = cal + var3;
						break;
					}
					System.out.println(
							"Do you want to add more exercise in the list?\nEnter 1 to add. \nEnter 2 to continue");
					int cc = scan.nextInt();
					if (cc == 1)
						cont = true;
					else
						cont = false;
				} while (cont);
				obj.calories = cal;
				list.add(obj);
				users--;
				a.clear();
			}
			System.out.println("Display Date in \n1.Aggregate list \n2.Detailed list");
			int choice = scan.nextInt();
			for (ExersiseSystemAssignment e : list) {
				if (choice == 1)
					ExersiseSystemAssignment.printUserDetails(e);
				else if (choice == 2)
					ExersiseSystemAssignment.printUser(e);
				else {
					System.out.println("Wrong data entered,Printing in Aggregate list ");
					ExersiseSystemAssignment.printUserDetails(e);
				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void user() {
		int dd = 0;
		int mm = 0;
		String yy = "";
		System.out.println("Enter name of a user");
		name = scan.next();
		int day;
		System.out.println("Press 1 to enter the date or 0 to generate date");
		day = scan.nextInt();
		String string;
		if (day == 1) {
			boolean cont = true;
			while (cont) {
				System.out.println("Enter day");
				dd = scan.nextInt();
				if (dd < 0 || dd > 31) {
					System.out.println("Please add day properly");

				} else {
					cont = false;
				}

			}

			cont = true;

			while (cont) {
				System.out.println("Enter the Month");
				mm = scan.nextInt();
				if (mm < 0 || mm > 12) {
					System.out.println("Please add month properly");

				} else {
					cont = false;
				}

			}
			cont = true;
			while (cont) {
				System.out.println("Enter the year");
				yy = scan.next();

				if (yy.length() != 4) {
					System.out.println("Please add year properly");

				} else {
					cont = false;
				}
			}

			string = dd + "/" + mm + "/" + yy;
			date = string;
		} else {
			LocalDateTime t1 = LocalDateTime.now();
			DateTimeFormatter fd = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			date = t1.format(fd);
		}
	}

	static void printUserDetails(ExersiseSystemAssignment ExersiseSystemAssignment) {

		System.out.println("Name:- " + ExersiseSystemAssignment.name);
		System.out.println("Calories Burnt:- " + ExersiseSystemAssignment.calories);
	}

	static void printUser(ExersiseSystemAssignment exercise) {
		System.out.println("Name:" + exercise.name);
		System.out.println("Date:" + exercise.date);
		if (exercise.map.containsKey("walking"))
			System.out.println("Calories burnt in walking:" + exercise.map.get("walking"));
		if (exercise.map.containsKey("running"))
			System.out.println("Calories burnt in running:" + exercise.map.get("running"));
		if (exercise.map.containsKey("cycling")) {

			System.out.println("Calories burnt in cycling:- " + exercise.map.get("cycling"));
		}

		System.out.println("Total Calories Burnt :- " + exercise.calories);
	}

	public int walkingFunc() {

		System.out.println("How much time for walking");
		totalDuration = scan.nextInt();
		int cal = 2000 / totalDuration;
		return cal;
	}

	public int runningFunc() {

		System.out.println("How much time for running");
		totalDuration = scan.nextInt();
		int cal = 5000 / totalDuration;
		return cal;
	}

	public int cyclingFunc() {

		System.out.println("How much time for cycling");
		totalDuration = scan.nextInt();
		int cal = 6000 / totalDuration;
		return cal;
	}

	public ExersiseSystemAssignment() {
		name = null;
		totalDuration = 0;
		date = null;
		calories = 0;
	}

}