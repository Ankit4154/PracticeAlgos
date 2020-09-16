import java.io.*;

public class ReducedString {

	// Complete the superReducedString function below.
	static String superReducedString(String s) {
		StringBuilder sb = new StringBuilder(s);
        
        while (sb.length() != 0) {
            int prev = sb.length();
            
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.replace(i, i + 2, "");
                }
            }
            if(prev == sb.length()) {
                break;
            }
        }
        if (sb.length() == 0)
            return "Empty String";
        else
            return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String s = "aabccdd";// bufferedReader.readLine();

		String result = superReducedString(s);

		System.out.println(result);
		bufferedReader.close();
	}
}
