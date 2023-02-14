import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int [][] grid = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int set = Math.min(N, M) / 2;						// 배열의 세트 수 구하기
		
		for (int i = 0; i < R; i++) { 						// 배열 돌리기..
			for (int j = 0; j < set; j++) {
				int temp = grid[j][j]; 						// 맨 처음 요소의 오른쪽 부터 돌리는데, 이렇게 돌릴 시 첫 값이 말소되기에 따로 저장해준다
				
				for(int k = j + 1; k < M - j; k++) {
					grid[j][k - 1] = grid[j][k];
				}
				
				for(int k = j + 1; k < N - j; k++) {
					grid[k - 1][M - 1 - j] = grid[k][M - 1 - j];
				}
				
				for(int k = M - 2 - j; k >= j; k--) {
					grid[N - 1 - j][k + 1] = grid[N - 1 - j][k];
				}
				
				for(int k = N - 2 - j; k >= j; k--) {
					grid[k + 1][j] = grid[k][j];
				}
					
				
				grid[j + 1][j] = temp;						// 따로 빼놓은 값 저장
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
}
