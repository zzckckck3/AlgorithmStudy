import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());  // N, r, c 입력받기
		
		int size = (int) Math.pow(2, N);  // 2의 N승을 size(사각형의 길이)로 선언
		
		Z(size, r, c);  // 재귀 넣어주기
		System.out.println(cnt);
	}
	
	public static void Z(int size, int r, int c) {
		if(size == 1) {  // size가 1이 된다 / 더이상 쪼갤 사각형이 없을 때 리턴
			return;
		}

		if(r < size/2 && c < size/2) {
			Z(size/2, r, c);
		} else if (r < size/2 && c >= size/2) {
			cnt += size * size/4;
			Z(size/2, r, c - size/2);
		} else if (r >= size/2 && c < size/2) {
			cnt += (size*size/4) * 2;
			Z(size/2, r - size/2, c);
		} else {
			cnt += (size*size/4) * 3;
			Z(size/2, r - size/2, c - size/2);
		}
	}
}
