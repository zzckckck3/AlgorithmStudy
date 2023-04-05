import java.util.*;
import java.io.*;

public class Main {

	static int R, C;
	static char grid[][];
	static boolean visited[][];
	static Queue<int[]> hedge = new LinkedList<int[]>();
	static Queue<int[]> water = new LinkedList<int[]>();
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		grid = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				grid[i][j] = str.charAt(j);
                if (grid[i][j] == 'S') { 
                	hedge.add(new int[] {i, j, 0});
                } else if (grid[i][j] == '*') { 
                	water.add(new int[] {i, j});
                }
			}
		}
		
		BFS();
		
		if(ans == Integer.MAX_VALUE) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(ans);
		}
	}
	
	static void BFS() {
		
		while(!hedge.isEmpty()) {
			int waterSize = water.size();
			for (int i = 0; i < waterSize; i++) {
				int[] nowWater = water.poll();
				for (int j = 0; j < 4; j++) {
					int nr = nowWater[0] + dr[j];
					int nc = nowWater[1] + dc[j];
					if(nr >= 0 && nr < R && nc >= 0 && nc < C && grid[nr][nc] == '.') {
						grid[nr][nc] = '*';
						water.add(new int[] {nr, nc});
					}
				}
			}
			
			int hedgeSize = hedge.size();
			for (int i = 0; i < hedgeSize; i++) {
				int[] nowHedge = hedge.poll();
				
				for (int j = 0; j < 4; j++) {
					int nr = nowHedge[0] + dr[j];
					int nc = nowHedge[1] + dc[j];
					int time = nowHedge[2];
					
					if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
						if(grid[nr][nc] == 'D') {
							ans = Math.min(ans, time+1);
							return;
						} else if (grid[nr][nc] == '.') {
							grid[nr][nc] = 'S';
							hedge.add(new int[] {nr, nc, time+1});
						}
					} 
				}
			}
		}
	}
	
}
