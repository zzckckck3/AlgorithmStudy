import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		int T;
		T = sc.nextInt(); 								// 테스트케이스 수 입력
		int[][] board = new int[100][100]; 		// 도화지 선언
		//int[][] conf = new int[10][10];			// 색종이 선언
		int sum = 0;
		
		for (int test_case = 0; test_case < T; test_case++) { 	//테스트케이스 반복
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			for (int i = n1 ; i < n1 + 10; i++) {
				for (int j = n2; j < n2 + 10; j++) {
					if(i > 99 || j > 99) {
						continue;
					} else {
						board[i][j] = 1;
					}
				}
			}
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(board[i][j] == 1) {
					sum = sum + 1;
				}
			}
		}
		System.out.println(sum);
	}
}
