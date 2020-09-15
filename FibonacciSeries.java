import java.time.Duration;
import java.time.Instant;

public class FibonacciSeries{

	public static void main(String args[]){

		int x=0,y=1,next=0;
		Instant start,end;
		Duration elp;
		System.out.println("\n\n Fibonacci Series of n(10) numbers using loop");
		//Printing the current/initial value in x(first).
		//Calculating the values of next variables(next & n)
		//to be printed out in next iterations by swapping with x.
		
		for(int i=1;i<=10;i++){
			System.out.print(x+" ");
			next=x+y;
			x=y;
			y=next;
		}
		
		System.out.println("\n\n Fibonacci Series till x(100) numbers using loop");
		
		for(x=0,y=1,next=0;x<=100;next=x+y,x=y,y=next){
			System.out.print(x+" ");
		}
		
		System.out.println("\n\n Fibonacci Series of n(10) numbers from i=1 using recusion");
		
		// If user wants to iterate from i=1 i.e. fib(1),
		// then the condition in method fib will change
		// as if n<=1 return 0 and if n==2 return 1.
		// Because, in this case, we will never be
		// printing out fib(0) == 0
		// Changes done in fib2(int n) method
		for(int i=1;i<=10;i++){
			System.out.print(fib2(i)+" ");
		}
		
		System.out.println("\n\n Fibonacci Series of n(41) numbers from i=0 using recusion");
		start = Instant.now();
		for(int i=0;i<41;i++){
			System.out.print(fib(i)+" ");
		}
		end = Instant.now();
		elp = Duration.between(start, end);
		System.out.println("\n\n Ellapsed time for recursion : " + elp.toMillis());
		

		System.out.println("\n\n Fibonacci Series of n(45) numbers using dp memoization");
		start = Instant.now();
		for(int i=0;i<45;i++){
			System.out.print(fibdp(i,new int[46])+" ");
		}
		end = Instant.now();
		elp = Duration.between(start, end);
		System.out.println("\n\n Ellapsed time for dp : " + elp.toMillis());

	}
	
	public static int fib(int n){

		if(n==0)
			return 0;
		// an optimization can be done in below if condition
		// by adding (OR)|| n == 2 as if(n==1||n==2)
		// This will avoid another recursive function call for fib(2)
		if(n==1)
			return 1;
		else
			return fib(n-1)+fib(n-2);
	}

	public static int fib2(int n){
		//for iterating i=1 in main method.
		if(n<=1)
			return 0;
		if(n==2)
			return 1;
		else
			return fib2(n-1)+fib2(n-2);
	}	
	
	public static int fibdp(int n,int memo[]){
		
		if(memo[n]!=0)
			return memo[n];
		if(n==0)
			return 0;
		if(n==1)
			return 1;

		return	memo[n] = fibdp(n-1,memo)+fibdp(n-2,memo);
		
	}
	
	public static int fibdpWithMsg(int n,int memo[], String msg){
		
		System.out.println("memo["+n+"]  : "+memo[n]+"  "+msg);
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		if(memo[n]==0){
			memo[n] = fibdpWithMsg(n-1,memo,"n-1, n :"+(n-1)+"\t\t")+fibdpWithMsg(n-2,memo,"\t\t n-2, n: "+(n-2));
			System.out.println("\nAssigned memo["+n+"] : "+memo[n]+"");
		}
		return memo[n];
	}
}
