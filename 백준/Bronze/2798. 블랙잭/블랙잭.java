import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int M;
	public static int [] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		int max = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(comb());
	}

	private static int comb() {
		int max = 0;
		
		for (int i = 0; i < N - 2; i++) {
			if(arr[i] > M) continue;
			for (int j = i + 1; j < N - 1; j++) {
				if(arr[j] > M) continue;
				for (int k = j + 1; k < N; k++) {
					if(arr[k] > M) continue;
					int temp = arr[i] + arr[j] + arr[k];
					if (temp == M) {
						return temp;
					}
					
					if(temp <= M &&  max < temp) {
						max = temp;
					}
				}
			}
		}
		
		return max;
	}
}
