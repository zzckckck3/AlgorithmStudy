import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
			} else if (str.equals("pop")) {
				if(stack.size() == 0) {
					System.out.println("-1");
				} else {
					System.out.println(stack.pop());
				}
			} else if (str.equals("size")) {
				System.out.println(stack.size());
			} else if (str.equals("empty")) {
				if(stack.empty()) {
					System.out.println("1");
				} else {
					System.out.println("0");
				}
			} else if(str.equals("top")) {
				if(stack.empty()) {
					System.out.println("-1");
				} else {
					System.out.println(stack.peek());
				}
			}
		}
	}
}
