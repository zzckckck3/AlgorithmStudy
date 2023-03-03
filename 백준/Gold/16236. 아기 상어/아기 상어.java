import java.io.*;
import java.util.*;

public class Main {
	static class Fish {
		int row, col, time;

		public Fish(int row, int col, int time) {
			super();
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}
	
	static int N;
	static int [][] map;
	static boolean [][] visited;
	static int[] dr = {-1, 1, 0, 0}; 
    static int[] dc = {0, 0, -1, 1};
    
    static Fish shark;
    static int size = 2;
    static int eat = 0;
    static ArrayList<Fish> list = new ArrayList<>();
    static int ans;

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark = new Fish(i, j, 0);
					map[i][j] = 0;
				}
			}
		}
		
		bfs();
		System.out.println(ans);
	}
	
	static void bfs() {
		Queue<Fish> queue = new LinkedList<>();
		queue.add(shark);
		visited[shark.row][shark.col] = true;
		while(true) {
			while(!queue.isEmpty()) {
				Fish now = queue.poll();
				int time = now.time;
				
				for (int i = 0; i < 4; i++) {
					int nr = now.row + dr[i];
					int nc = now.col + dc[i];
					
					if(!(0 <= nr && nr < N && 0 <= nc && nc < N) || visited[nr][nc]) {
						continue; // 탐색할 때 범위 밖으로 나갈 시 continue
					}
					
					// 식사 가능
					if(map[nr][nc] < size && map[nr][nc] != 0) {
						queue.add(new Fish(nr, nc, time+1));
						visited[nr][nc] = true;
						list.add(new Fish(nr, nc, time+1));
					}
					
					// 이동만 가능
					if(map[nr][nc] == size || map[nr][nc] == 0) {
						queue.add(new Fish(nr, nc, time+1));
						visited[nr][nc] = true;
					}
				}
			}
			if(!list.isEmpty()) {
				eat();
				// 식사가 끝났으면 방문 배열 초기화
				
				queue.clear();
				visited = new boolean[N][N];

				// 큐에 현재 상어 추가
				queue.add(shark);
				visited[shark.row][shark.col] = true;
			} else {
				return;
			}
		}
	}
	
	static void eat() {
		Collections.sort(list, new Comparator<Fish>() {
			@Override
			public int compare(Fish o1, Fish o2) {
				if(o1.time == o2.time) {
					if(o1.row == o2.row) {
						if(o1.col > o2.col) {
							return 1;
						} else {
							return -1;
						}
					} else {
						if(o1.row > o2.row) {
							return 1;
						} else {
							return -1;
						}				
					}
				} else if(o1.time > o2.time){
					return 1;
				} else {
					return -1;
				}
			};
		});

		Fish now = list.get(0);
		
		// 상어 위치 이동, 상어가 먹은 횟수 증가, 상어 걸린 시간 증가
		shark.row = now.row;
		shark.col = now.col;
		
		if(++eat == size) {
			size++;
			eat = 0;
		}
		
		ans += now.time;
		
		// 지도 위에 해당 위치 0
		map[now.row][now.col] = 0;
		
		// 먹이 리스트 초기화
		list.clear();
	}
	
	static void printMap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
