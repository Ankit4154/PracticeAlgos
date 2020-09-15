public class Factorial{

	public static void main(String args[]){
		
		int fact=1, n=6;
		System.out.println("\n\n Factorial of a number(6) using loop");
		for(int i=1;i<=n;i++){
			fact = fact * i;
		}
		System.out.println(fact);
		
		System.out.println("\n\n Factorial of a number(6) using recusion");
		System.out.println(fact(n));
		
	}
	
	public static int fact(int n){
		if(n==1||n==0)
			return 1;
		else
			return n*fact(n-1);
	}
}