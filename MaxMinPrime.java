import java.util.Scanner;
public class MaxMinPrime {
    public static int minPrime(int n) {
		int min = 0;
        for(int k=n;k>=2;k--){
            if(k == 2)
                return 2;
            else if(k%2 == 0)
                continue;
            else {
                int i = 3;
                boolean flag = true;
                for(i=3;i<=Math.ceil(Math.sqrt(k));i+=2){
                    if(k%i == 0){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    min = k;
                    return min; 
                }
            }
        }
        return min;
    }
	public static int maxPrime(int n) {
		int k = n;
		int max = 0;
        while(k>=n) {
            if(k == 2)
                return 2;
            else if(k%2 == 0){
                k++;
                continue;
            }
            else {
                int i = 3;
                boolean flag = true;
                for(i=3;i<=Math.ceil(Math.sqrt(k));i+=2){
                    if(k%i == 0){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    max = k;
                    break;
                }
            }
			k++;
        }
        return max; 
    }
	public static boolean isPrime(int n){
		if(n == 2)
			return true;
		else if(n%2 == 0 || n < 2)
			return false;
		else {
			int i=3;
			for(i=3;i<Math.floor(Math.sqrt(n));i+=2){
				if(n%i == 0)
					return false;
			}
			return true;
		}
	}
    public static void main(String args[]) {
        
		Scanner in = new Scanner(System.in);
		int iprime = 0,jprime = 0,min = 0, max = 0;
		/*int k = in.nextInt();
		int N = in.nextInt();
		int arr[] = new int[N];
		for(int i=0;i<N;i++){
			arr[i] = in.nextInt();
		}*/
		int k = 2;
		int N = 5;
		int arr[] = {2,8,4,5,6};
		boolean flag = true;
		for(int i=0;i<N && (i+k) < N;i++){
			iprime = arr[i];
			jprime = arr[i+k];
			if(isPrime(iprime) && isPrime(jprime)){
				flag = true;
				continue;
			}else if(isPrime(iprime)) {
				min = minPrime(jprime);
				max = maxPrime(jprime);
				if(isPrime(iprime + (jprime - min))){
					arr[i+k] = min;
					arr[i] = iprime + (jprime - min);
				}else if(isPrime(iprime - (max - jprime))){
					arr[i+k] = max;
					arr[i] = iprime - (max - jprime);
				}else {
					flag = false;
					break;
				}
			}else if(isPrime(jprime)) {
				min = minPrime(iprime);
				max = maxPrime(iprime);
				if(isPrime(jprime + (iprime - min))){
					arr[i+k] = jprime + (iprime - min);
					arr[i] = min;
				}else if(isPrime(jprime - (max - iprime))) {
					arr[i+k] = jprime - (max - iprime);
					arr[i] = max;
				}else {
					flag = false;
					break;
				}
			}else {
				int min_i = minPrime(iprime);
				int min_j = minPrime(jprime);
				int max_i = maxPrime(iprime);
				int max_j = maxPrime(jprime);
				if((iprime - min_i) == (max_j - jprime)) {
					arr[i] = min_i;
					arr[i+k] = max_j;
				}else if((max_i - iprime) == (jprime - min_j)) {
					arr[i] = max_i;
					arr[i+k] = min_j;
				}else {
					flag = false;
					break;
				}
			}
		}
		if(flag)
			System.out.println(1);
		else
			System.out.println(-1);
    }
}
