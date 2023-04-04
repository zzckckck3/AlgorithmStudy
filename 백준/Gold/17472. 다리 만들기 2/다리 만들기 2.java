import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] board;
	static boolean[][] visited;
	static ArrayList<Node>[] list;
	static PriorityQueue<mstNode> pq;
	static int[] parent;
	
	static class mstNode implements Comparable<mstNode>{
		int n1, n2, length;
		
		public mstNode(int n1, int n2, int length) {
			this.n1 = n1;
			this.n2 = n2;
			this.length = length;
		}
		
		@Override
		public int compareTo(mstNode o) {
			return this.length - o.length;
		}
	}
	
	static class Node{
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		list = new ArrayList[7];
		visited = new boolean[N][M];
		int num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j] && board[i][j] == 1) {
					list[num] = new ArrayList<>();
					bfs(i, j, num);
					num++;
				}
			}
		}
		
		pq = new PriorityQueue<>();
		for (int i = 1; i < num; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				Node island = list[i].get(j);
				for (int k = 0; k < 4; k++) {
					findBridge(island.x, island.y, i, k, -1);
				}
			}
		}
		
		System.out.println(kruskal(num));
	}

	private static void findBridge(int row, int col, int num, int dir, int len) {
		if(board[row][col] != 0 && board[row][col] != num) {
            if(len >= 2) pq.offer(new mstNode(num, board[row][col], len));
            return;
        }
 
        int nr = row + dr[dir];
        int nc = col + dc[dir];
        if(nr < 0 || nc < 0 || nr >= N || nc >= M) return;
        if(board[nr][nc] == num) return;
        findBridge(nr, nc, num, dir, len + 1);
	}

	private static int kruskal(int num) {
		parent = new int[num];
        for(int i = 1; i < num; i++) {
            parent[i] = i;
        }
 
        boolean[] link = new boolean[num];
        int result = 0;
        int bridge = 0;
        while(!pq.isEmpty()) {
            mstNode current = pq.poll();
            
            int p1 = find(current.n1);
            int p2 = find(current.n2);
 
            if(p1 != p2) {
                union(p1, p2);
                link[current.n1] = true;
                link[current.n2] = true;
                result += current.length;
                bridge++;
            }
        }
 
        if(result == 0) return -1;
        if(bridge != num - 2) return -1;
        return result;
	}


	private static void union(int a, int b) {
		parent[a] = b;
	}

	private static int find(int node) {
		if(parent[node] == node) return node;
        else return parent[node] = find(parent[node]);
	}

	private static void bfs(int row, int col, int num) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(row, col));
        visited[row][col] = true;
        
        while(!q.isEmpty()) {
            Node current = q.poll();
 
            board[current.x][current.y] = num;
            list[num].add(new Node(current.x, current.y));
 
            for(int i = 0; i < 4; i++) {
                int nr = current.x + dr[i];
                int nc = current.y + dc[i];
                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(visited[nr][nc] || board[nr][nc] != 1) continue;
                visited[nr][nc] = true;
                q.offer(new Node(nr, nc));
            }
        }
	}
}
