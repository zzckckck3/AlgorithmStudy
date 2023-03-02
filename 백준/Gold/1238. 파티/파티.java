import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, X;
	static ArrayList<ArrayList<Node>> goGraph;
	static ArrayList<ArrayList<Node>> backGraph;
	
	static class Node implements Comparable<Node>{
		int idx, cost;

		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  // V
		M = Integer.parseInt(st.nextToken());  // E
		X = Integer.parseInt(st.nextToken());  // start
		
		goGraph = new ArrayList<ArrayList<Node>>();
		backGraph = new ArrayList<ArrayList<Node>>();
		
		for (int i = 0; i <= N; i++) {
			goGraph.add(new ArrayList<>());
			backGraph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			goGraph.get(n).add(new Node(m, t));
			backGraph.get(m).add(new Node(n, t));
		}
		
		int max = Integer.MIN_VALUE;
		int goResult[] = dijkstra(goGraph);
		int backResult[] = dijkstra(backGraph);

		for(int i=1; i<=N; i++) {
			max = Math.max(max,  goResult[i] + backResult[i]);
		}

		System.out.println(max);
	}
	
	static int[] dijkstra(ArrayList<ArrayList<Node>> list) {
		PriorityQueue<Node> queue = new PriorityQueue<>();	

		boolean visit[] = new boolean[N + 1];
		int dist[] = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;

		queue.offer(new Node(X, 0));

		while( !queue.isEmpty() ) {
			Node queNode = queue.poll();
			int num = queNode.idx;

			if(visit[num]) continue;

			visit[num] = true;
			for(Node node : list.get(num)) {
				if( !visit[node.idx] && dist[node.idx] > (dist[num] + node.cost)  ) {
					dist[node.idx] = dist[num] + node.cost;
					queue.offer(new Node(node.idx, dist[node.idx]));
				}
			}

		}

		return dist;
	}
}
