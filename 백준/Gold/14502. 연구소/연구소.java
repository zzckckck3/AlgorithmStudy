import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map, mapCopy;
	static int N, M, maxNum= 0;
	static int[] combarr = new int[3];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static ArrayList<Pos> safe = new ArrayList<Pos>();
	static Deque<Pos> virus = new ArrayDeque<Pos>();
	static int safeCnt = 0;
	static boolean flag = false;
	
	static class Pos{
		int row;
		int col;
		
		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		mapCopy = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				mapCopy[i][j] = map[i][j];
				
				if(map[i][j] == 0) {
					safe.add(new Pos(i, j));
				}
			}
		}
		
		comb(0, 0);
		System.out.println(maxNum);
		
	}

	private static void comb(int cnt, int start) {
		if(cnt == 3) {
			mapInit();
			for(int i: combarr) {
				map[safe.get(i).row][safe.get(i).col]= 1; 
			}
			spread();
			maxNum = Math.max(maxNum, cntZero());
			return;
		}

		for(int i = start; i < safe.size(); i++) {
			combarr[cnt] = i;
			comb(cnt+1, i+1);
		}
	}

	private static void mapInit() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = mapCopy[i][j];
				if(map[i][j] == 2) {
					virus.add(new Pos(i, j));
				}
			}
		}
	}
	
	private static void spread() {
		int nr, nc;
		Pos pos;
		while(!virus.isEmpty()) {
			pos = virus.poll();
			for(int i = 0; i < 4;i++) {
				nr = pos.row + dr[i];
				nc = pos.col + dc[i];
				if(!isRange(nr, nc) || map[nr][nc] > 0) {
					continue;
				}
				map[nr][nc] = 2;
				virus.add(new Pos(nr, nc));
			}
		}
	}
	
	private static boolean isRange(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= M ? false : true;
	}
	
	private static int cntZero() {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}
}