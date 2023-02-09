import java.util.Scanner;

public class Main {
	public static int[] arr;
	public static boolean[] visited;
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
 
		int n = in.nextInt();				// n
		int m = in.nextInt();				// m
		arr = new int[m];					// 출력될 배열 선언
		visited = new boolean[n];			// 방문 여부 판단 배열 선언
		
		permutation(n, m, 0);				// 재귀 호출
	}
 
	public static void permutation(int n, int m, int depth) {
		// 재귀의 깊이가 m과 같다면 배열 출력
		if (depth == m) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
 
		// 해당 값이 방문하지 않은 값이라면
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;				// 값을 방문처리 해주고	
				arr[depth] = i + 1;				// 해당 깊이를 index로 해서 i+1저장
				permutation(n, m, depth + 1);	// 다음 방문을 위해 depth 1 증가
				visited[i] = false;				// 다음 탐색을 위해 방문처리 해제
			}
		}
	}
}