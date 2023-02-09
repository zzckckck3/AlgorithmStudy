import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int N;
	public static int[][] grid;
	public static boolean[] visited;
	public static int ans;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			ans = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine());
			grid = new int[N][N];
			visited = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Combi(0, 0);
			
			sb.append("#" + test_case + " " + ans);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void Combi(int idx, int cnt) {
		if(cnt == N/2) {
			ans = Math.min(ans, cal());
			return;
		}
		
		for (int i = idx; i < N; i++) {
			visited[i] = true;
			Combi(i + 1, cnt + 1);
			visited[i] = false;
		}
	}

	private static int cal() {
		int x = 0;
		int y = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i == j) { continue; }
				if (visited[i] && visited[j]) {
					x += grid[i][j];
				} else if (!visited[i] && !visited[j]) {
					y += grid[i][j];
				}
			}
		}
		return Math.abs(x - y);
	}
}
