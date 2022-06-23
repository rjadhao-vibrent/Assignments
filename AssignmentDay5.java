package assignment3;

import java.util.Scanner;

public class AssignmentDay5 {
	static Scanner scan = new Scanner(System.in);
	static int deductCount = 0;

	public static void main(String[] args) {
		/*
		 * Create a simple quiz. User is asked 10 questions with choices given and he
		 * answers by inputting the choices via console. Once answered, user should be
		 * moved to next question. At the end show the user how much did he score out of
		 * 10. User inputs should be validated. Any invalid input should lead to user
		 * being prompted to enter the valid answer choice again for the same question.
		 * Add an extra check that program terminates and lets the user know he failed
		 * when he gets 4 answers wrong. For example, if an user gets 4 out of first 6
		 * itself wrong then do not show the remaining questions and exit out telling
		 * the user that he failed
		 *
		 */

		int count = 0;
		int correctAns = 0;
		boolean pass = false;
		while (count <= 10) {
			if (deductCount == 4) {
				count = 11;
				System.out.println("Sorry, you are failed in the exam!");
			}

			if (deductCount == 0) {
				pass = true;
			}
			++count;
			boolean ans = choices(count);
			if (ans) {
				correctAns++;
			}

		}

		if (pass == true) System.out.println("Congratulations! You have Scored 10/10");
			 
		System.out.println("\n\n Total Correct Answers given:- " + correctAns);
		System.out.println("\n\n Total Wrong answers given :- " + deductCount);
		scan.close();
	}

	public static boolean choices(int count) {

		switch (count) {
		case 1:
			System.out.println("What is 2+2?");
			int ans = scan.nextInt();
			
			if (ans == 4) {
				return true;
			} else
				System.out.println("Wrong ans");
			deductCount++;
			return false;
		case 2:
			System.out.println("what is the square of 3?");
			int ans1 = scan.nextInt();
			if (ans1 == 9) {
				return true;
			} else
				System.out.println("Wrong ans");
			deductCount++;
			return false;
		case 3:
			System.out.println("what is 45-45?");
			int ans2 = scan.nextInt();
			if (ans2 == 0) {
				return true;
			} else
				System.out.println("Wrong ans");
			deductCount++;
			return false;
		case 4:
			System.out.println("what is 5 multiplied by 25?");
			int ans3 = scan.nextInt();
			if (ans3 == 125) {
				return true;
			} else
				System.out.println("Wrong ans");
			deductCount++;
			return false;
		case 5:
			System.out.println("what is 5+67?");
			int ans4 = scan.nextInt();
			if (ans4 == 72) {
				return true;
			} else
				System.out.println("Wrong ans");
			deductCount++;
			return false;
		case 6:
			System.out.println("what is square of 9?");
			int ans5 = scan.nextInt();
			if (ans5 == 81) {
				return true;
			} else
				System.out.println("Wrong ans");
			deductCount++;
			return false;
		case 7:
			System.out.println("what is the square of 16?");
			int ans6 = scan.nextInt();
			if (ans6 == 256) {
				return true;
			} else
				System.out.println("Wrong ans");
			deductCount++;
			return false;
		case 8:
			System.out.println("what is the sum of first five natural numbers?");
			int ans7 = scan.nextInt();
			if (ans7 == 15) {
				return true;
			} else
				System.out.println("Wrong ans");
			deductCount++;
			return false;
		case 9:
			System.out.println("what is the square of 5?");
			int ans8 = scan.nextInt();
			if (ans8 == 25) {
				return true;
			} else
				System.out.println("Wrong ans");
			deductCount++;
			return false;
		case 10:
			System.out.println("what is the square of 1?");
			int ans9 = scan.nextInt();
			if (ans9 == 1) {
				return true;
			} else
				System.out.println("Wrong ans");
			deductCount++;
			return false;

		}
		return false;
	}

}
