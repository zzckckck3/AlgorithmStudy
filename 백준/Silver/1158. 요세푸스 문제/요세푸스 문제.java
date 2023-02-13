import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		sb.append("<");
		while (!queue.isEmpty()) {
			for (int i = 0; i < K - 1; i++) {
				queue.add(queue.poll());
			}
			if (queue.size() < 2) {
				sb.append(queue.poll() + ">");
			} else {
				sb.append(queue.poll() + ", ");
			}
		}
		System.out.println(sb);
	}
}
