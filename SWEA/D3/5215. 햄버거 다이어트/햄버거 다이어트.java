import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int N, L, maxScore;
	public static int[][] burger;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			burger = new int [N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				burger[i][0] = Integer.parseInt(st.nextToken());
				burger[i][1] = Integer.parseInt(st.nextToken());
			}
			
			maxScore = 0;
			combi(0, 0, 0);
			
			System.out.println("#" + testCase + " " + maxScore);
		}
	}
	
	public static void combi(int index, int score, int calo) {
		if(calo > L) {
			return;
		}
		if(calo <= L) {
			maxScore = Math.max(maxScore, score);
		}
		if(index == N) {
			return;
		}
		
		combi(index + 1, score + burger[index][0], calo + burger[index][1]);
		combi(index + 1, score, calo);
	}
}
