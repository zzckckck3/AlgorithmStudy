import java.io.*;
import java.util.*;

public class Solution {
    static int[][] dxy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우
    static int[][] grid;
    static int N;
 
    static int ansNum;
    static int ansMove;
 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(in.readLine());
 
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(in.readLine());
            grid = new int[N][N];
            ansNum = 0;
            ansMove = 0;
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            for (int i = 0; i < N; i++) {  // 각 요소마다 탐색 실행
                for (int j = 0; j < N; j++) {
                    moveRoom(i, j, 1);
                }
            }
            sb.append("#").append(testCase).append(" ");
            sb.append(ansNum).append(" ").append(ansMove).append("\n");
        }
        System.out.print(sb);
    }
 
    private static int moveRoom(int i, int j, int cnt) {
        for (int d = 0; d < 4; d++) {
            int ni = i + dxy[d][0];  // 사방탐색 행, 렬 설정
            int nj = j + dxy[d][1];
 
            if (ni < 0 || ni >= N || nj < 0 || nj >= N) {  // 벽에 부딛히면 패스
            	continue;
            }
            else if (grid[i][j] + 1 != grid[ni][nj]) {  // 연속된 숫자가 아니라면 패스
            	continue;
            }
 
            cnt = moveRoom(ni, nj, cnt + 1);  // 다음걸로 움직일 때 다음 행, 열과 cnt를 보내준다
 
            if (ansMove < cnt) {
                ansMove = cnt;
                ansNum = grid[i][j];
            } else if (ansMove == cnt && ansNum > grid[i][j]) {
                ansNum = grid[i][j];
            }
 
            break;
        }
 
        return cnt;
    }
}