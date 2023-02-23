import java.io.*;
import java.util.*;

public class Main {
	static int r; 
	static int c; 
	static int[][] map; 
	static boolean[] visited = new boolean[26]; 
	static int[] dx = {1, -1, 0, 0}; 
	static int[] dy = {0, 0, 1, -1};
	static int ans = 0; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()); 
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c]; 

			for(int i = 0; i < r; i++) {
				String str = br.readLine();
				for(int j = 0; j < c; j++){
					map[i][j] = str.charAt(j) - 'A';
				}
			}
			
			dfs(0,0,0);
			
			System.out.println(ans);		
	}
	
	static void dfs(int x, int y, int count) {
		if (visited[map[x][y]]) { 
			ans = Math.max(ans, count); 
			return; 
		} else {
			visited[map[x][y]] = true; 
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
					dfs(nx, ny, count+1);
				}
			}
			
			visited[map[x][y]] = false;
		}
	}
}