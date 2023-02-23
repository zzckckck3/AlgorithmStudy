import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V;
	static int [][] check;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		check = new int[1001][1001];
		visited = new boolean[1001];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			check[x][y] = check[y][x] = 1;
		}
		
		dfs(V);
		
		visited = new boolean[1001];
		sb.append("\n");
		
		bfs();
		System.out.println(sb);
	}
	
	static void dfs(int start) {
		visited[start] = true;
		sb.append(start).append(" ");
		
		for (int i = 1; i <= N; i++) {
			if(check[start][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(V);
		visited[V] = true;
		sb.append(V).append(" ");
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			for (int i = 1; i <= N; i++) {
				if(check[temp][i] == 1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					sb.append(i).append(" ");
				}
				
			}
		}
	}
}
