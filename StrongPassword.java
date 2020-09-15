import java.io.*;
import java.util.Scanner;

public class StrongPassword {

	// Complete the minimumNumber function below.
	static int minimumNumber(int n, String password) {

		int strong[] = new int[4];
		int count = 0;
		String special = "!@#$%^&*()-+";

		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z' && strong[0] == 0) {
				count++;
				strong[0] = 1;
			}else if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z' && strong[1] == 0) {
				count++;
				strong[1] = 1;
			}else if (password.charAt(i) >= '0' && password.charAt(i) <= '9' && strong[2] == 0) {
				count++;
				strong[2] = 1;
			}else if (special.indexOf(password.charAt(i)) !=-1 && strong[3] == 0) {
				count++;
				strong[3] = 1;
			}
		}
		if (count < 4 && password.length() >= 6)
			return 4 - count;
		else if (count == 4 && password.length() < 6)
			return 6 - password.length();
		else if(count < 4 && password.length() < 6) {
			if(4-count + password.length() < 6)
				return 6 - password.length();
			else
				return 4-count;
		}
		return 0;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();

		String password = scanner.nextLine();

		int answer = minimumNumber(password.length(), password);

		System.out.println(answer);

		scanner.close();
	}
}
