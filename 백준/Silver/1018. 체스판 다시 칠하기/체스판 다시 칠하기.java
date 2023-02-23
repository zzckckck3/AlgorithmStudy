import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static boolean [][] arr;
	static int min = 64;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if(str.charAt(j) == 'W') {
					arr[i][j] = true; // true == 흰색 W
				} else {
					arr[i][j] = false; // false == 검은색 B
				}
			}
		}
		
		int N_row = N - 7;
		int M_col = M - 7;
		
		for (int i = 0; i < N_row; i++) {
			for (int j = 0; j < M_col; j++) {
				find(i, j);
			}
		}
		System.out.println(min);
	}
	
	static void find(int x, int y) {
		int end_x = x + 8;
		int end_y = y + 8;
		int cnt = 0;
		
		boolean TF = arr[x][y];
		
		for (int i = x; i < end_x; i++) {
			for (int j = y; j < end_y; j++) {
				if(arr[i][j] != TF) {
					cnt++;
				}
				TF = !TF;
			}
			TF = !TF;
		}
		
		cnt = Math.min(cnt, 64 - cnt);
		
		min = Math.min(min, cnt);
	}
}
