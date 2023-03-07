import java.io.*;
import java.util.*;

public class Solution {	
	static int N, K;
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			String arr[] = br.readLine().split("");
			//HashSet<String> hset = new HashSet<>(Collections.reverseOrder()); 해시셋은 정렬이 안된다..
			TreeSet<String> set = new TreeSet<>(Collections.reverseOrder());
			for(int i = 0; i < N/4; i++) {
				String tmp = arr[N-1];
				for (int j = N-1; j > 0; j--) {
					arr[j] = arr[j-1];
				}
				arr[0] = tmp;
				
				for (int j = 0; j < arr.length; j += N/4) {
					StringBuilder sb = new StringBuilder();
					for (int k = j; k < j + (N/4); k++) {
						sb.append(arr[k]);
					}
					set.add(sb.toString());
				}
			}
			String answer[] = set.toArray(new String[set.size()]);
			System.out.println("#" + testCase + " " + Long.parseLong(answer[K-1], 16));
		}
		
	}
}
