import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str, " "); 
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 누적합 배열 생성
		int[][] arr = new int[N][N + 1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				arr[i][j] += arr[i][j - 1] + Integer.parseInt(st.nextToken());  // 누적합 넣어주기
			}
		}
		
		for (int i = 0; i < M; i++) {
			str = br.readLine();
			st = new StringTokenizer(str, " "); 
			int x1 = Integer.parseInt(st.nextToken());			// x1,x2,y1,y2 선언
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			for (int j = (x1 - 1); j <= (x2 - 1); j++) {		// 
				sum += arr[j][y2] - arr[j][y1 - 1];				// 누적합 계산
			}
			
			sb.append(sum);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}