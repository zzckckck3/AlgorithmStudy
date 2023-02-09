import java.util.Scanner;

public class Main {
	public static int[] arr;
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();				// n
		int m = sc.nextInt();				// m
		arr = new int[m];					// 출력될 배열 선언
		
		permutation(n, m, 0, 1);				// 재귀 호출
	}
 
	public static void permutation(int n, int m, int depth, int at) {
		if (depth == m) {									// 깊이가 m에 도달했다면 순서대로 출력
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
 
		for (int i = at; i <= n; i++) {
			arr[depth] = i;									// 현재 깊이에 있는 수를 i로 받아준 뒤,
			permutation(n, m, depth + 1, i + 1);			// 깊이를 하나 증가시키고, 호출되는 수도 하나 증가시켜준다. 이런식으로 구성하면 visited를 사용 할 필요 없이 이미 고른 수들이 걸러진다
		}
	}
}