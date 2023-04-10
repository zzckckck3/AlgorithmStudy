import java.io.*;
import java.util.*;

public class Main {
	static int[][] map; 
	static int[] paper = { 5, 5, 5, 5, 5 };
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[10][10];

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		DFS(0, 0, 0);

		if (result == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(result);
		}
	}

	public static void DFS(int row, int col, int cnt) {
		if (row >= 9 && col > 9) {
			result = Math.min(result, cnt);
			return;
		}

		if (cnt >= result) {
			return;
		}

		if (col > 9) {
			DFS(row + 1, 0, cnt);
			return;
		}

		if (map[row][col] == 1) {
			for (int i = 4; i >= 0; i--) {
				if(paper[i]>0 && possible(row, col, i+1)) {
					attach(row, col, i+1);
					paper[i]--;
					
					DFS(row, col+1, cnt+1);
					detach(row, col, i+1);
					
					paper[i]++;					
				}
			}
		} else {
			DFS(row, col + 1, cnt);
		}
	}

	public static void attach(int row, int col, int size) {
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				map[i][j] = 0;
			}
		}
	}

	public static void detach(int row, int col, int size) {
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				map[i][j] = 1;
			}
		}
	}
	
	public static boolean possible(int row, int col, int size) {
		for(int i = row; i < row + size; i++) {
			for(int j = col; j < col + size; j++) {
				if(!isIn(i, j) || map[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean isIn(int row, int col) {
		return row >= 0 && col >= 0 && row < 10 && col < 10;
	}
}