import java.io.*;
import java.util.*;

class Node {
	int row, col, wallB, cnt;

	public Node(int row, int col, int wallB, int cnt) {
		this.row = row;
		this.col = col;
		this.wallB = wallB;
		this.cnt = cnt;
	}
}

public class Main {
	static int N, M, K;
	static int[][] grid;
	static boolean [][][] visited;
	static int[][] dxy = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static Queue<Node> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		
		visited = new boolean[K + 1][N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				grid[i][j] = str.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs());
	}

	private static int bfs() {
		queue.add(new Node(0, 0, 0, 1));
		visited[0][0][0] = true;
		
		//int c = 0;
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			
			if(current.row == N-1 && current.col == M-1) {
				return current.cnt;
			}
			
			for (int i = 0; i < 4; i++) {
				int dx = current.row + dxy[i][0];
				int dy = current.col + dxy[i][1];
				int wall = current.wallB;
				if (dx < 0 || dx >= N || dy < 0 || dy >= M || visited[wall][dx][dy]) {
                    continue;
                }
				if (grid[dx][dy] == 0) { 
                    visited[wall][dx][dy] = true;
                    queue.add(new Node(dx, dy, wall, current.cnt + 1));
                } else if (grid[dx][dy] == 1 && wall < K) {
                    visited[wall][dx][dy] = true;
                    queue.add(new Node(dx, dy, wall + 1, current.cnt + 1));
                }
			}
		}
		
		return -1;
	}
}
