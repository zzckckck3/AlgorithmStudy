import java.io.*;
import java.util.*;
import static java.lang.Integer.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken());
			int M = parseInt(st.nextToken());
			int [][] grid = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = parseInt(st.nextToken());
				}
			}
			
			int max = MIN_VALUE;
			for (int i = 0; i < N - M + 1; i++) {			// 파리채 크기를 고려하여 반복을 작성해주어야 한다
				for (int j = 0; j < N - M + 1; j++) {
					int sum = 0;
					for (int k = 0; k < M; k++) {			// 파리채 크기만큼
						for (int k2 = 0; k2 < M; k2++) {
							sum += grid[i + k][j + k2];		// 파리채의 위치에 있는 항목을 더해준닫
						}
					}
					max = Math.max(max, sum);
				}
			}
			System.out.println("#" + test_case + " " + max);
		}
	}
}