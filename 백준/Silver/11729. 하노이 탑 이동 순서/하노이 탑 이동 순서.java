import java.util.Scanner;

public class Main {
	public static int cnt = 0;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();						// 원판 갯수 입력
		
		hanoi(n, 1, 2, 3);							// 재귀함수 호출
		System.out.println(cnt);
		System.out.println(sb);
	}
	
	// 기둥을 시작기둥, 보조기둥, 목표기둥 3개로 나눔
	// 하노이탑은 결국 맨 아래 가장 큰 원판을 목표 기둥으로 옮기고, 나머지 원판들을 보조 기둥, 혹은 시작 기둥에 넣어놓아야 함
	public static void hanoi(int n, int start, int sub, int target) {
		cnt++;
		if (n == 1) {
			sb.append(start);
			sb.append(" ");
			sb.append(target);
			sb.append("\n");
			return;
		}
		
		// 현재 원판의 갯수보다 하나 적은 원판에 대해 보조 기둥으로 모두 이동시킨다
		// 제일 먼저 n = 1로 도착해서 가작 작은 녀석부터 옮긴다
		hanoi(n - 1, start, target, sub);
		sb.append(start);
		sb.append(" ");
		sb.append(target);
		sb.append("\n");
		
		// 현재 원판에 대해 목표 기둥으로 이동
		// 보조 기둥으로 이동한 원판들을 start지점을 사용하여 target으로 이동
		hanoi(n - 1, sub, start, target);
	}
}
