import java.util.*;
import java.io.*;

public class Main {
	static int M, N;
	static int [][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int max = Integer.MIN_VALUE;
	
	static class Tomato {
		int row, col;

		public Tomato(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		Queue<Tomato> queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					queue.add(new Tomato(i, j));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Tomato now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now.row + dr[i];
				int nc = now.col + dc[i];
				
				if(nr < 0 || nr > N-1 || nc < 0 || nc > M-1) {
					continue;
				}
				if(map[nr][nc] != 0) {
					continue;
				}
				map[nr][nc] = map[now.row][now.col] + 1;
				queue.add(new Tomato(nr, nc));
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
				max = Math.max(max, map[i][j]);
			}
		}
		System.out.println(max - 1);

	}
	
//	static void printArr() {
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j] + " ");
//				//System.out.print("(" + i + "," + j + ")");
//			}
//			System.out.println();
//		}
//	}
}
