import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, R;
	public static int[][] grid;
	public static int[][] gridCpy;
	public static List<int[]> list = new ArrayList<>();
	public static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		grid = new int[N][M];
		gridCpy = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				gridCpy[i][j] = grid[i][j]; // 배열의 복사본 저장
			}
		}
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1; // 문제에서의 배열의 시작이 1, 1이기 때문에 1 감소
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			
			list.add(new int[] {r, c, s});
		}
		
		ans = Integer.MAX_VALUE;
		perm(0, new int[R], new boolean[R]);
		System.out.println(ans);
	}

	public static void newGrid() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				gridCpy[i][j] = grid[i][j];
			}
		}
	}
	
	private static void perm(int newR, int[] selected, boolean[] visited) {
		// TODO Auto-generated method stub
		if(newR == R) {
			newGrid();
			for (int i = 0; i < R; i++) {
				int index = selected[i];
				rotate(list.get(index));
			}
			
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += gridCpy[i][j];
				}
				ans = Math.min(ans, sum);
			}
			return;
		}
		
		for (int i = 0; i < R; i++) {
			if(!visited[i]) {
				visited[i] = true;
				selected[newR] = i;
				perm(newR + 1, selected, visited);
				visited[i] = false;
			}
		}
	}

	private static void rotate(int[] num) {
		// TODO Auto-generated method stub
		int r = num[0];
		int c = num[1];
		int s = num[2];
		
		int sx = r - s;
		int sy = c - s;
		int ex = r + s;
		int ey = c + s;
		
		int g = s;
		
		int[] dx = { 1, 0, -1, 0 }; // 우, 하, 상, 좌
		int[] dy = { 0, 1, 0, -1 };
		for (int i = 0; i < g; i++) {
			int x = sx + i;
			int y = sy + i;
			int d = 0;
			int temp = gridCpy[x][y];
			while (d < 4) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= sx + i && nx <= ex - i && ny >= sy + i && ny <= ey - i) {
					gridCpy[x][y] = gridCpy[nx][ny];
					x = nx;
					y = ny;
				} else {
					d++;
				}
			}
			gridCpy[x][y + 1] = temp;
		}
	}
}
