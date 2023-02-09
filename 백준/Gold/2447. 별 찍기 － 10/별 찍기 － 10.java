import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String[][] grid;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		grid = new String[n][n];
		
		for (int i = 0; i < n; i++) {			// 배열에 일단 모두 공백 입력
			for (int j = 0; j < n; j++) {		// 나중에 조건에 맞을 시 *을 넣어주기 위함
				grid[i][j] = " ";
			}
		}
		
		Recursive(0, 0, n);							// 재귀함수 호출
		StringBuilder sb = new StringBuilder();		// 케이스가 너무 많아지면 sysout으로는 너무 느려지므로 StringBuilder 사용
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(grid[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	// 출력의 모양을 보면, 가장 최소 3x3 grid를 봤을 때, 중앙만 뻥 뚫려있음 > 이는 index (1, 1)에 구멍을 뚫어주면 된다
	// 사진 첨부했습니다!
	public static void Recursive(int row, int col, int n) {
		if(n == 1) {					// 조건에 맞으면 별을 찍고 해당 재귀함수 탈출
			grid[row][col] = "*";
			return;
		}
		
		int value = n / 3;						// 가장 작은 칸부터 채우기위해 3씩 나눈다
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i == 1 && j == 1) {
					continue;					// 중앙 칸에서는 별을 찍지 않기 위해 continue
				} else {
					// 해당 정사각형의 시작 좌표와 n을 3으로 나눈 value를 인자로 보내줌
					// 결국, 3의 제곱수인 정사각형에서 시작하여 가장 작은 정사각형까지 쪼개 들어가 해당 정사각형부터 채워나가는 식으로 함수가 진행된다
					Recursive(row + (value * i), col + (value * j), value);		
				}
			}
		}
	}
}