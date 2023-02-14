import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		for (int i = 1; i <= 10; i++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 1;
			
			for (int j = 1; j <= N; j++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				char input = st.nextToken().charAt(0);
				if(st.hasMoreTokens()) {
					if(input >= '0' && input <= '9') {
						ans = 0;
					} 
				} else {
					if(input < '0' || input > '9') {
						ans = 0;
					}
				}
			}
			sb.append("#" + i + " " + ans + "\n");
		}
		System.out.println(sb);
	}
}
