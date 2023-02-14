import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		String arr[] = new String[T];
 
		for (int i = 0; i < T; i++) {
			arr[i] = br.readLine();
		}
 
		
		for (int i = 0; i < T; i++) {
			int cnt = 0;
			int sum = 0;
			
			for (int j = 0; j < arr[i].length(); j++) {
				
				if (arr[i].charAt(j) == 'O') {
					cnt++;
				} else {
					cnt = 0;
				}
				sum += cnt;
			}
			sb.append(sum).append('\n');
		}
		System.out.print(sb);
	}
}