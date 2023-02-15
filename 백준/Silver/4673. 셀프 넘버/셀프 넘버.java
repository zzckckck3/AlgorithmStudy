import java.util.*;
import java.io.*;

public class Main {
	public static boolean[] arr = new boolean[10001];
	
	public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 10001; i++) {
            if (!arr[i]) {
            	d(i);
            }
        }

        
        for (int i = 1; i < 10001; i++) {
            if (!arr[i]) {
            	sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
	
    static int d(int n) {
        int sum = n;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        if (sum < 10001) {
            arr[sum] = true;
            d(sum);
        }
        return sum;
    }
}
