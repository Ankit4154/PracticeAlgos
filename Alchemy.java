import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Alchemy {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int stones = in.nextInt();
		Instant start2 = Instant.now();
		
		for (int i = 1; i <= stones; i++) {
			Instant start3 = Instant.now();
			int nShards = in.nextInt();
			in.nextLine();
			int countA=0, countB=0;
			StringBuilder shards = new StringBuilder(in.nextLine());
			System.out.print("Case #" + i + ": ");
			for (int j = 0; j < shards.length(); j++) {
					if(shards.charAt(j) == 'A')
						countA++;
					if(shards.charAt(j) == 'B')
						countB++;
			}
			if (Math.abs(countA-countB) == 1)
				System.out.println("Y");
			else
				System.out.println("N");
			Instant end3 = Instant.now();
			Duration elp3 = Duration.between(start3, end3);
			System.out.println("ellapsed time 1 : " + elp3.toMillis());
		}
		Instant end2 = Instant.now();
		Duration elp2 = Duration.between(start2, end2);
		System.out.println("ellapsed time 2 : " + elp2.toMillis());
	}
}
