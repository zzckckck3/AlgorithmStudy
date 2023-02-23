import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static Stack<Integer> stack = new Stack<>();
	static Stack<Integer> ansStack = new Stack<>();
	static int[] arr; 
	static int[] ansArr;
	static int index, N;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int [N];
		ansArr = new int[N];
		index = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		goStack(1);
		System.out.println(sb);
	}

	private static void goStack(int num) {
		if(ansStack.size() == N) {
			return;
		}
		if(num > N + 1) {
			System.out.println("NO");
			System.exit(0);
		}
		
		if(stack.isEmpty() || stack.peek() != arr[index]) {
			stack.add(num++);
			sb.append("+\n");
			goStack(num);
		} else {
			ansStack.add(stack.pop());
			sb.append("-\n");
			index++;
			goStack(num);
		}
	}
}
