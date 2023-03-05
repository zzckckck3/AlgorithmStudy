import java.util.*;
import java.io.*;

public class Solution {
	static int[][] visited;
	static int[][] map;
	static int N, M, C;
	static int ans;
	static int[] max = new int[3];

	static void comb(int cnt, int row, int col, int sum, int depth) {
		if(sum > C) {
			return;
		}
		
		max[cnt] = Math.max(max[cnt],depth);
		
		if(col >= N) {
			return;
		}
		if(visited[row][col] != cnt) {
			return;
		}
		comb(cnt, row, col+1 ,sum+map[row][col], depth + map[row][col]*map[row][col]);
		comb(cnt, row, col+1, sum, depth);
	}
	
	
	static void setSelect(int cnt, int r, int c) {
		for(int i=0; i<M; i++) {
			if(visited[r][c+i] == 0) {
				visited[r][c+i] = cnt;  // visited 설정
			}
			else{
				visited[r][c+i] = 0;  // visited 해제
			}
		}
	}
	
	static void setMax() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j] == 1) {  // 방문한 곳이라면 (1)
					if(max[1]!=0) {
						continue;  // 패스
					}
					comb(1, i, j, 0, 0);
				}
				else if(visited[i][j] == 2) {  // 방문한 곳이라면 (2) 
					if(max[2] != 0) {
						continue;  // 패스
					}
					comb(2, i, j, 0, 0);
				}
			}
		}
	}
	
	static void backTrack(int cnt, int idx) {
		if(cnt==3) { // 두개 팀이 만들어 졌다면
			max[1] = max[2] = 0;  // max 초기화
			setMax();
			ans = Math.max(ans, max[1] + max[2]);
			return;
		}
		// 갈 수가 없다면
		if(idx >= N*N) {
			return;
		}
		
		int row = idx / N;
		int col = idx % N;
		
		if(col+M > N) { // 갈 수가 없다면 패스
			backTrack(cnt, (idx+M) - (idx+M)%N);
		}
		else {
			setSelect(cnt, row, col);
			backTrack(cnt+1, idx+M);
			setSelect(cnt, row, col);
			backTrack(cnt, idx+1);
		}
	}

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			visited = new int[N][N];
			map = new int[N][N];
			ans = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			backTrack(1,0);
			
			sb.append("#" + testCase+ " " + ans + "\n");
		}
		System.out.println(sb);
	}
}