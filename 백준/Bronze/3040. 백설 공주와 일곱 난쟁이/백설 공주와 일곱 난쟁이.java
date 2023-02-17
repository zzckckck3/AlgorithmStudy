import java.io.*;
import java.util.*;

public class Main {
	public static int arr[] = new int[9];
	public static int ans[] = new int[7];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		comb(0,0);
	}
	
	static void comb(int cnt,int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int i = 0; i < 7; i++)
				sum += ans[i];
			if(sum == 100) {
				for(int i = 0; i < 7; i++)
					System.out.println(ans[i]);
			}
			return;
		}
		
		for(int i = start; i < 9; i++) {
			ans[cnt] = arr[i];
			comb(cnt + 1, i + 1);
		}
	}
}
