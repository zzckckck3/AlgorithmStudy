import java.io.*;
import java.util.*;

public class Main {
	static int [] dr = {1, -1, 0, 0};
	static int [] dc = {0, 0, 1, -1};
	static boolean visited[][];
	static int map[][];
	static int size[][];
	
	static int N, nr, nc;
	
	static class Node implements Comparable<Node>{
		int row, col, size;
		
		public Node(int x, int y, int size) {
			this.row = x;
			this.col = y;
			this.size = size;
		}

		@Override
		public int compareTo(Node o) {
			return size - o.size;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		
		while (true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			map = new int[N][N];
			visited = new boolean[N][N];
			size = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					size[i][j] = Integer.MAX_VALUE;
				}
			}
			
			bfs(0, 0, map[0][0]);
			sb.append("Problem " + cnt + ": " + size[N-1][N-1]).append('\n');
			cnt++;
		}
		
		System.out.println(sb);
	}

	static void bfs(int row, int col, int roopy) {
		PriorityQueue<Node> pqueue = new PriorityQueue<>();
		visited[row][col] = true;
		pqueue.offer(new Node(row, col, roopy));
		
		while (!pqueue.isEmpty()) {
			Node node = pqueue.poll();
			
			for (int i = 0; i < 4; i++) {
				nr = node.row + dr[i];
				nc = node.col + dc[i];
				
				if(check() && !visited[nr][nc] && size[nr][nc] > (map[nr][nc] + node.size)) {
					size[nr][nc] = map[nr][nc] + node.size;
					visited[nr][nc] = true;
					pqueue.offer(new Node(nr, nc, size[nr][nc]));
				}
			}
		}
	}
	
	static boolean check() {
		return (nr >= 0 && nc >= 0 && nr < N && nc < N);
	}
}
