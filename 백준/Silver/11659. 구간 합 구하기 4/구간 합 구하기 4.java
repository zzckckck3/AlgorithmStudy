import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		String nm = br.readLine();								// N, M을 받을 문자열 입력
		int N, M;
		StringTokenizer st = new StringTokenizer(nm, " ");		// N, M을 공백 단위로 쪼개주기 위한 st
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];
		arr[0] = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i < N + 1; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		int A, B;
		for (int i = 0; i < M; i++) {
			nm = br.readLine();
			st = new StringTokenizer(nm, " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			sb.append(arr[B] - arr[A - 1]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
