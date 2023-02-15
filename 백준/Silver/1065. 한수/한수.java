import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(han(sc.nextInt()));
	}
	
	public static int han(int num) {
		int cnt = 0;
		
		if(num < 100) {
			return num;
		} else {
			cnt = 99;
			
			for(int i = 100; i <= num; i++){
				int hun = i / 100;
				int ten = (i / 10) % 10;
				int one = i % 10;
	            
				if((hun - ten) == (ten - one)){
					cnt++;
				}
			}
		}
		
		return cnt;
	}
}
