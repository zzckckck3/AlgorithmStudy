import java.util.Scanner;

public class Main {
	public static double N;
	public static double M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for (int i = 0; i < testCase; i++) {
			N = sc.nextDouble();
			M = sc.nextDouble();
			
			System.out.printf("%.0f\n", dfs(M, N));
		}
	}
	
	public static double dfs(double n, double r) {
		double a = 1;
		double b = 1;
		
		for(double i = n; i > n - r; i--) {
			a = a * i;
		}
		for(double i = r; i > 0; i--) {
			b = b * i;
		}
		
		return a / b;
	}
}
