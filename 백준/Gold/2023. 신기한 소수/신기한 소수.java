import java.io.*;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	    interestPrime(0, n);
	    System.out.println(sb);
	}
	
    public static void interestPrime(int depth, int n) {
        if (n == 0) {
            if (isPrime(depth)) {
            	sb.append(depth).append("\n");
            }
            return;
        }
        
        for (int i = 0; i < 10; i++) { // 가장 하위 단계인 맨 앞 1번재 자리부터 소수인지 판별한다.
            int next = (depth * 10) + i;  // output을 재귀로 받아와 앞번에 계산했던 수의 자릿수를 하나씩 더해준다
            if (isPrime(next)) {  // 계산된 수가 소수면 다음 자릿수로 또 진행
            	interestPrime(next, n - 1);	// 자릿수를 하나 추가해준 뒤 다시 재귀
            }
        }
    }

    // 소수 구하는 알고리즘 Link : https://st-lab.tistory.com/81
    public static boolean isPrime(int num) {
        if (num < 2) {
        	return false;
        }
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
            	return false;
            }
        }
        return true;
    }
}