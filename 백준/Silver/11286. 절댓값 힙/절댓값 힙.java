import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// https://velog.io/@robolab1902/Java-Priority-Queue-%EB%A7%A4%EA%B0%9C%EB%B3%80%EC%88%98%EC%97%90-%EB%9E%8C%EB%8B%A4%EC%8B%9D-%EC%93%B0%EB%8A%94-%EC%9D%B4%EC%9C%A0%EA%B0%80-%EB%AD%90%EC%95%BC
		// https://st-lab.tistory.com/243
		// PriorityQueue의 사용법
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) > Math.abs(o2)) {  // 절대값이 앞이 더 크다면
					return Math.abs(o1) - Math.abs(o2);  // 순서를 바꿔준다
				} else if(Math.abs(o1) == Math.abs(o2)) {  // 절대값이 같다면
					return o1 - o2;  // 음수를 앞으로 보내준다
				} else {
					return -1;  // 아니면 -1 반환
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(pq.isEmpty()) {
					sb.append("0\n");
				} else {
					sb.append(pq.poll() + "\n");
				}
			} else {
				pq.offer(x);
			}
		}
		System.out.println(sb);
	}
}
