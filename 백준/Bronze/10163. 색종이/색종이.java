import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int [][] paper = new int[N][4];
		int [][] grid = new int[1000][1000];
		int [] ans = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			for (int j = row; j < row + width; j++) {
				for (int k = col; k < col + height; k++) {
					grid[j][k] = i;
				}
			}
		}
		
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				ans[grid[i][j]]++;			
			}
		}
		for (int i = 1; i <= N; i++) {
			sb.append(ans[i]).append("\n");
		}
		
		System.out.println(sb);
	}
}
