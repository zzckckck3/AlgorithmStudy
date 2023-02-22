import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;

class Point {
    int x;
    int y;
 
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
	static int[][] map = new int[101][101];
	static int result[];
    static boolean visited[];
    static int N, sum, homeX, homeY, companyX, companyY;
    static ArrayList<Point> arr;
    static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			min = Integer.MAX_VALUE;
            N = parseInt(br.readLine());
            result = new int[N];
            visited = new boolean[N];
            arr = new ArrayList<>();
            
            st = new StringTokenizer(br.readLine());
            companyX = parseInt(st.nextToken());
            companyY = parseInt(st.nextToken());
            homeX = parseInt(st.nextToken());
            homeY = parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                arr.add(new Point(parseInt(st.nextToken()), parseInt(st.nextToken())));
            }
			
            dfs(0);
            System.out.println("#" + testCase + " " + min);
		}
	}
	
	private static void dfs(int depth) {
		if(depth == N) {
			
			sum = 0;
			for (int i = 0; i < depth; i++) {
				if(i == 0) {
					sum += Math.abs(companyX - arr.get(result[i]).x) + Math.abs(companyY - arr.get(result[i]).y);
				}
				if(i == depth - 1) {
					sum += Math.abs(homeX - arr.get(result[i]).x) + Math.abs(homeY - arr.get(result[i]).y);
				} else {
					sum += Math.abs(arr.get(result[i]).x - arr.get(result[i + 1]).x)
							+ Math.abs(arr.get(result[i]).y - arr.get(result[i + 1]).y);
				}
			}
			min = Math.min(min, sum);
		}
			
		for (int i = 0; i < arr.size(); i++) {
            if (visited[i])
                continue;
            result[depth] = i;
            visited[i] = true;
            dfs(depth + 1);
            visited[i] = false;
        }
	}
}