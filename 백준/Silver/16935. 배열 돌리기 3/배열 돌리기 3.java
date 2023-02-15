import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr;
	public static int[][] newArr;
	public static int N, M, R;
	
	public static void main(String[] args) throws IOException {
		//===================================================
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N, M은 짝수
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		int[] cal = new int[R];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			cal[i] = Integer.parseInt(st.nextToken());
		}
		//===================================================
		
		for (int i = 0; i < R; i++) {
			switch (cal[i]) {
			case 1:
				reverseUD();
				break;
			case 2:
				reverseLR();
				break;
			case 3:
				right90();
				break;
			case 4:
				left90();
				break;
			case 5:
				groupClock();
				break;
			case 6:
				groupRClock();
				break;
			default:
				break;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	/** 1번 연산 : 상하 반전 */
	public static void reverseUD() {
		int [] tempArr = new int[M];
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M; j++) {
				tempArr[j] = arr[i][j];
				
				arr[i][j] = arr[N - 1 - i][j];
				arr[N - 1 - i][j] = tempArr[j];
			}
		}
	}
	
	/** 2번 연산 : 좌우 반전 */
	public static void reverseLR() {
		int [] tempArr = new int[M];
		for (int j = 0; j < M / 2; j++) {
			for (int i = 0; i < N; i++) {
				tempArr[j] = arr[i][j];
				
				arr[i][j] = arr[i][M - 1 - j];
				arr[i][M - 1 - j] = tempArr[j];
			}
		}
	}
	
	/** 3번 연산 : 오른쪽 90도 */
	public static void right90() {
		newArr = new int[M][N];
		
		int newN = N - 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newArr[j][newN] = arr[i][j]; 
			}
			newN--;
		}
		
		int temp = N;
		N = M;
		M = temp;
		arr = newArr;
	}
	
	/** 4번 연산 : 왼쪽 90도 */
	public static void left90() {
		newArr = new int[M][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newArr[M - j - 1][i] = arr[i][j]; 
			}
		}
		
		int temp = N;
		N = M;
		M = temp;
		arr = newArr;
	}
	
	/** 5번 연산 : 그룹 시계 */
	public static void groupClock() {
		int[][] tempArr = new int[N / 2][M / 2];
		
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				tempArr[i][j] = arr[i][j];
				arr[i][j] = arr[i + (N / 2)][j];
				arr[i + (N / 2)][j] = arr[i + (N / 2)][j + (M / 2)];
				arr[i + (N / 2)][j + (M / 2)] = arr[i][j + (M / 2)];
				arr[i][j + (M / 2)] = tempArr[i][j];
			}
		}
	}
	
	/** 6번 연산 : 그룹 반시계 */
	public static void groupRClock() {
		int[][] tempArr = new int[N / 2][M / 2];
		
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				tempArr[i][j] = arr[i + (N / 2)][j];
				arr[i + (N / 2)][j] = arr[i][j];
				arr[i][j] = arr[i][j + (M / 2)];
				arr[i][j + (M / 2)] = arr[i + (N / 2)][j + (M / 2)];
				arr[i + (N / 2)][j + (M / 2)] = tempArr[i][j]; 
			}
		}
	}
}
