import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			double sum = 0;
			double[] std = new double[N];
			for (int j = 0; j < N; j++) {
				std[j] = Double.parseDouble(st.nextToken());
				sum += std[j];
			}
			
			
			double lowStd = 0;
			for (int j = 0; j < N; j++) {
				if (std[j] > sum / N) {
					lowStd++;
				}
			}
			System.out.printf("%.3f", lowStd / (double)N * 100);
			System.out.print("%");
			System.out.println();
		}
	}
}