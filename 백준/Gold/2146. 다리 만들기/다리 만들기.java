import java.io.*;
import java.util.*;

public class Main {
    static int n, cnt;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        // 지도 입력 받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 각 섬에 번호 붙이기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, ++cnt);
                }
            }
        }

        // 각 섬들의 거리 구하기
        int ans = Integer.MAX_VALUE;
        for (int k = 1; k < cnt; k++) {
            Queue<Node> q = new LinkedList<>();
            int[][] dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], -1);
            }

            // k번 섬의 위치를 큐에 넣고 dist 배열 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == k) {
                        q.add(new Node(i, j));
                        dist[i][j] = 0;
                    }
                }
            }

            // k번 섬과 다른 섬을 연결하는 다리의 길이 구하기
            while (!q.isEmpty()) {
                Node node = q.poll();
                int x = node.x;
                int y = node.y;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (dist[nx][ny] != -1) continue;
                    if (map[nx][ny] != 0 && map[nx][ny] != k) {
                        ans = Math.min(ans, dist[x][y] + dist[nx][ny]);
                        break;
                    }
                    dist[nx][ny] = dist[x][y] + 1;
                    q.add(new Node(nx, ny));
                }
            }
        }

        // 최단 다리의 길이 출력
        System.out.println(ans + 1);
    }

    public static void dfs(int x, int y, int num) {
        visited[x][y] = true;
        map[x][y] = num;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (map[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny, num);
            }
        }
    }
}

