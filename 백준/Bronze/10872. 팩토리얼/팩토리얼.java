import java.util.Scanner;

public class Main {
	public static int ans = 1;
	
	public static void factorial(int n) {
		if(n < 1) {
			return;
		}
		ans = ans * n;
		factorial(n-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		factorial(n);
		
		System.out.println(ans);
	}
}
