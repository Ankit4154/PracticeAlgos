import java.util.Scanner;
public class TravelRestriction {
    public static void main(String args[] ) throws Exception {
		Scanner in = new Scanner(System.in);
        int airlines = in.nextInt();
		for(int i=1;i<=airlines;i++) {
			int countries = in.nextInt();
			in.nextLine();
			String incoming = in.nextLine();
			String outgoing = in.nextLine();
			String possibleTrips[][] = new String[countries][countries];
			System.out.println("Case #"+i+": ");
			for(int k=0; k < possibleTrips.length; k++){
				for(int j=0; j < possibleTrips[k].length; j++){
					if(k == j) {
						possibleTrips[j][k]="Y";
					}else if(Math.abs(k-j) == 1){
						if(outgoing.charAt(k) == 'N'){
							possibleTrips[j][k]="N";
						}else if (incoming.charAt(j) == 'N'){
								possibleTrips[j][k]="N";
						}else if(outgoing.charAt(k) == 'Y' && incoming.charAt(j) == 'Y') {
							possibleTrips[j][k]="Y";
						}
					}else {
						possibleTrips[j][k]="N";
					}
					System.out.print(possibleTrips[j][k]);
				}
				System.out.println();				
			}
		}
   }
}