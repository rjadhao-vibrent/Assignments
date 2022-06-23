import java.util.Scanner;

public class Assignment3 {
	public static void main(String[] args) {
		// I have a string "I am learning Java". Reverse the string without using any
		// system provided functions.

		Scanner scan = new Scanner(System.in);

		String s = scan.next();
		String rev = "";
		for (int i = 0; i < s.length(); i++) {
			rev = s.charAt(i) + rev;
		}

		System.out.println(rev);
	}
}
