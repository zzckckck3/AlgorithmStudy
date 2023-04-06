import java.util.*;
import java.io.*;

public class Main {
	static int n, d, k, c;
	static int arr[];
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n+k];
        int visited[] = new int[d+1];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int result = 1;
        visited[c]++;
        for (int i = n; i < n+k; i++) {
        	arr[i] = arr[i-n];
			if(visited[arr[i]] == 0) {
				result++;
			}
			visited[arr[i]]++;
		}
        
        int now = result;
        for (int i = k; i < n+k; i++) {
			int del = arr[i-k];
			visited[del]--;
			
			if(visited[del] == 0) {
				now--;
			}
			
			int add = arr[i];
			visited[add]++;
			
			if(visited[add] == 1) {
				now++;
			}
			
			result = Integer.max(result, now);
		}
        System.out.println(result);
	}
}
