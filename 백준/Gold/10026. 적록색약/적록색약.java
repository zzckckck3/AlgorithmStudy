import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
	static char[][] arr, arrRG;
	static boolean[][] visited, visitedRG;
	static int N;
	static int ansNormal = 0;
	static int ansRG = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];  // 정상인 배열
		arrRG = new char[N][N];  // 색약 배열
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
				if(str.charAt(j) == 'G') { arrRG[i][j] = 'R'; } // 색약에게 G가 들어간다면 R로 변환 
				else { arrRG[i][j] = str.charAt(j); }
			}
		}

		visited = new boolean[N][N]; 
		ansNormal = 0; // 정상인  
		visitedRG = new boolean[N][N]; 
		ansRG = 0; // 색약
		// DFS
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (!visited[i][j]) { // 방문하지 않았다면
//					// 적록색약이 아닌 사람
//					dfs(i, j, visited, arr, arr[i][j]);
//					ansNormal++;
//				}
//				if (!visitedRG[i][j]) {
//					// 적록색약인 사람
//					dfs(i, j, visitedRG, arrRG, arrRG[i][j]);
//					ansRG++;
//				}
//			}
//		}
		
		//BFS
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(new Point(i, j), visited, arr);
                    ansNormal++;
                }
            }
        }
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitedRG[i][j]) {
                    bfs(new Point(i, j), visitedRG, arrRG);
                    ansRG++;
                }
            }
        }
		System.out.println(ansNormal + " " + ansRG);
		
	}
	
	static void dfs(int row, int col, boolean[][] visited, char[][] grid, char color) {
		visited[row][col] = true; // 방문처리
		for (int i = 0; i < 4; i++) {
			int nr = row + dx[i];
			int nc = col + dy[i];
			if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc] && grid[nr][nc] == color) {
				dfs(nr, nc, visited, grid, color);
			}
		}
	}
	
	
	static void bfs(Point point, boolean[][] visited, char[][] arr) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(point); // 큐에 추가
		visited[point.x][point.y] = true; // 넣음과 동시에 방문 배열 표시
		while (!queue.isEmpty()) { // 큐가 모두 소진될 때 까지
			Point newPoint = queue.poll(); // 새로운 포인트를 만들어 큐에 넣고
			for (int i = 0; i < 4; i++) { // 사방탐색
				int nr = newPoint.x + dx[i];
				int nc = newPoint.y + dy[i];
				// nr, nc가 범위를 벗어나지 않고 방문하지 않았다면 큐에 넣음과 동시에 방문 배열 표시
				if(0 <= nr && nr < N && 0 <= nc && nc < N && arr[newPoint.x][newPoint.y] == arr[nr][nc] && !visited[nr][nc]) {
					queue.offer(new Point(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
	}
	
	
}
