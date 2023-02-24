import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int arr[][];
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		
		list = new ArrayList[N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			list[n1].add(n2);
			list[n2].add(n1);
		}
		
		for(int i = 0; i < N; i++) {
			if(ans == 0)
				dfs(i, 1);
		}
		System.out.println(ans);
	}
	
	static void dfs(int start, int depth) {
		if(depth == 5) {
			ans = 1;
			return;
		}
		
		visited[start] = true;
		for(int i : list[start]) {
			int next = i;
			if(!visited[next]) {
				dfs(next, depth+1);
			}
		}
		visited[start] = false;
	}
}
