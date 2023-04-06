import java.io.*;
import java.util.*;

public class Solution {
	 public static long mod = 1234567891;
	 public static long[] factorial = new long[1000001];

	    public static long pow(long a, long b) {
	        if(b==0) {
	            return 1;
	        }
	        else {
	            long temp = pow(a, b/2);
	            if(b%2 == 0) {
	            	return (temp*temp) % mod;
	            }
	            else return ((temp*temp) % mod * a) % mod;
	        }
	    }

	    public static void main(String[] args) throws IOException {
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	StringTokenizer st;
	        
	        factorial[0] = 1;
	        
	        for (int i = 1; i <= 1000000; i++) {
	            factorial[i] = (factorial[i-1] * i) % mod;
	        }

	        int T = Integer.parseInt(br.readLine());
	        for (int testCase = 1; testCase <= T; testCase++) {
	        	st = new StringTokenizer(br.readLine());
	            long up = 1;
	            long down = 1;
	            int N = Integer.parseInt(st.nextToken());
	            int R = Integer.parseInt(st.nextToken());
	            up = factorial[N];
	            up = up * pow(factorial[N-R], mod-2) % mod;
	            up = up * pow(factorial[R], mod-2) % mod;

	            System.out.println("#" + testCase + " " + up);
	        }
	    }
}