import java.io.*;
import java.util.*;

class Node {
	int idx, cost;

	public Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
}

public class Main {
	static int V, E, start;
	static ArrayList<ArrayList<Node>> graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		graph = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i < V + 1; i++) {  // 정점의 갯수만큼 ArrayList에 ArrayList<Node>추가
			graph.add(new ArrayList<Node>());
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Node(v, w));  // u번째 점에서 v번째로 가는 가중치가w인 점 추가
		}
		
		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

		queue.offer(new Node(start, 0));
		dist[start] = 0;
		while (!queue.isEmpty()) {
			Node curNode = queue.poll();

			if (dist[curNode.idx] < curNode.cost) {  // 저장된 거리가 현재 거리보다 작다면
				continue;
			}

			for (int i = 0; i < graph.get(curNode.idx).size(); i++) {
				Node nxtNode = graph.get(curNode.idx).get(i);
				if (dist[nxtNode.idx] > curNode.cost + nxtNode.cost) {  // 저장된 노드가 현재 거쳐온 노드의 길이보다 길다면
					dist[nxtNode.idx] = curNode.cost + nxtNode.cost;  // 갱신
					queue.offer(new Node(nxtNode.idx, dist[nxtNode.idx]));  // 큐에 집어넣기
				}
			}
		}

		for (int i = 1; i < dist.length; i++) {
			if (dist[i] == Integer.MAX_VALUE) { System.out.println("INF"); }
			else { System.out.println(dist[i]); }
		}
	}
}
