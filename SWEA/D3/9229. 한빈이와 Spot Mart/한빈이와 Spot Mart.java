import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					sum = arr[i] + arr[j];
					if(sum <= M && max < sum) {
						max = sum;
					}
				}
			}
			if(max == 0) {
				System.out.println("#" + testCase + " -1");
			} else {
				System.out.println("#" + testCase + " " + max);
			}
		}
	}
}
