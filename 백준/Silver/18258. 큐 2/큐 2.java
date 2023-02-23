import java.util.*;
import java.io.*;

public class Main {
	static Queue<Integer> queue = new LinkedList<Integer>();
	static int N;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int num = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("push")) {
				num = Integer.parseInt(st.nextToken());
				queue.offer(num);
			} else if (str.equals("front")) {
				if(queue.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(queue.peek()).append("\n");
				}
			} else if (str.equals("pop")) {
				if(queue.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(queue.poll()).append("\n");
				}
			} else if (str.equals("size")) {
				sb.append(queue.size()).append("\n");
			} else if (str.equals("empty")) {
				if(queue.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
			} else if (str.equals("back")) {
				if(queue.isEmpty()) sb.append("-1\n");
				else sb.append(num).append("\n");
			}
		}
		System.out.println(sb);
	}
}
