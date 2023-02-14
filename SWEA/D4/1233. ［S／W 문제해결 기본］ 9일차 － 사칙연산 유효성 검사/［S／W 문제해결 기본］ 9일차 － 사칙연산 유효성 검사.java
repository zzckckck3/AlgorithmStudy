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
				if(st.hasMoreTokens()) {  // 자식 노드가 있을 때
					if(input >= '0' && input <= '9') {  // 숫자라면
						ans = 0;  // false
					} 
					st.nextToken();
					if(!st.hasMoreTokens()) {
						ans = 0;
					}
				} else {  // 자식 노드가 없을 때
					if(input < '0' || input > '9') { // 연산이라면
						ans = 0;  // false
					}
				}
			}
			sb.append("#" + i + " " + ans + "\n");
		}
		System.out.println(sb);
	}
}
