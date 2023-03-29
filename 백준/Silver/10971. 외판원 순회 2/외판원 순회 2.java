import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[] visited;
	static long min = Integer.MAX_VALUE; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			dfs(i, i, 0);
		}
		
		System.out.println(min);
		
	}
	static void dfs(int start, int end, int sum) {
		if(check()) { 
			if(arr[start][end] != 0) {
				sum += arr[start][end];
				min = Math.min(min, sum);
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(arr[start][i] != 0 && !visited[i]) {
				visited[i] = true;
				dfs(i, end, sum + arr[start][i]);
				visited[i] = false;
			}
		}
	}
	
	static boolean check() {
		for(int i = 0; i < N; i++) {
			if(!visited[i])
				return false;
		}
		return true;
	}

}
