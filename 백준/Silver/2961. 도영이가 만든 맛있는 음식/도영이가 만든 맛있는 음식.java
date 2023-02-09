
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int min;
	public static int N;
	public static int[][] arr;
	public static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		arr = new int[N][2];
		isSelected = new boolean[N];
		min = Integer.MAX_VALUE;  // 신맛과 쓴맛을 비교하기 위한 변수 선언
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		subSet(0, 1, 0);
		
		System.out.println(min);
	}
	
	public static void subSet(int depth, int sour, int bitter) {
		if(depth == N) {
			int cnt = 0;		// 재료를 사용하지 않을 경우 더해줄 변수 선언
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) {
					continue;
				}
				cnt++;
			}
			if(cnt == N) {		// 하나도 쓰지 않는 경우에는 return
				return;
			}
			min = Math.min(min, Math.abs(sour - bitter)); // 신맛과 쓴맛의 차를 계산
			return;
		}
		
		// 현재 원소를 부분집합의 구성에 포함
		isSelected[depth] = true;
		subSet(depth + 1, sour * arr[depth][0], bitter + arr[depth][1]);
		// 현재 원소를 부분집합의 구성에 미포함
		isSelected[depth] = false;
		subSet(depth + 1, sour, bitter);
		
		
	}
}
