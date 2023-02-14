import java.io.*;
import java.util.*;

public class Main {
	
	class Node {
		char val;
		Node left;
		Node right;
		
		public Node(char val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public static int N;
	public static int [][] tree;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		tree = new int [N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int parentNode = st.nextToken().charAt(0) - 'A';
			int leftNode = st.nextToken().charAt(0) - 'A';
			int rightNode = st.nextToken().charAt(0) - 'A';
			

			if(leftNode == -19) {  // A와 .은 아스키코드상 19의 차이가 난다
				tree[parentNode][0] = -1;  // 입력받은 문자가 .이라면 해당 노드 정보에 -1 저장(자식 노드가 없다는 뜻
			} else {
				tree[parentNode][0] = leftNode;
			}
			
			if(rightNode == -19) {
				tree[parentNode][1] = -1;
			} else {
				tree[parentNode][1] = rightNode;
			}
		}
		preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);

        System.out.println(sb);
		
	}
	static void preOrder(int s) {
		if (s == -1) {  // 자식 노드가 없다면 return
			return;
		}
		sb.append((char) (s + 'A'));  // 자신 순회
		preOrder(tree[s][0]);  // 왼쪽 순회
		preOrder(tree[s][1]);  // 오른쪽 순회
	}

	static void inOrder(int s) {
		if (s == -1) {
			return;
		}
		inOrder(tree[s][0]);  // 왼쪽 순회
		sb.append((char) (s + 'A'));  // 자기 순회
		inOrder(tree[s][1]);  // 오른쪽 순회
	}

	static void postOrder(int s) {
		if (s == -1) {
			return;
		}
		postOrder(tree[s][0]);  // 왼쪽 순회
	    postOrder(tree[s][1]);  // 오른쪽 순회
	    sb.append((char) (s + 'A'));  // 자기 순회
	}
}