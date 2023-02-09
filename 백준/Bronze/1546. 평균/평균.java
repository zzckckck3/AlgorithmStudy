
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static double[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(reader.readLine());
		
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
		
		arr = new double[n];
		double max = Double.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			arr[i] = Double.parseDouble(tokenizer.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		double sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i] / max * 100;
		}
		
		System.out.println(sum / n);
	}
}