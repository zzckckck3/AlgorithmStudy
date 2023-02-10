import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
	
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 괄호라는건 결국 맨 안에있는 괄호는 수식을 제외하고 연속적으로 나와야한다  >  () / {} / ...
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();						// 문자열로 받아와 charat으로 하나씩 빼오기 위함
			Stack<Character> stack = new Stack<>();			// 스택 선언
			
			int ans = 0;
			// 정답 출력 변수 선언
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);						// String으로 받아온 문자열의 i번째 추출
				
				if(c == ')' && stack.peek() == '(') {		// 현재 스택의 가장 위의 요소가 (이고 받아온놈이 )라면 짝이 맞으니 pop 
					stack.pop();							// 이 아래로도 모두 동일
				}
				else if(c == ']' && stack.peek() == '[') {	// 조건문의 앞뒤를 바꾸게 되면 에러 발생 > stack에 한개도 없기 떄문...
					stack.pop();
				}
				else if(c == '}' && stack.peek() == '{') {
					stack.pop();
				}
				else if(c == '>' && stack.peek() == '<') {
					stack.pop();
				}
				else {
					stack.push(c);							// 짝이 맞지 않으면 일단 스택에 넣어두기
				}
			}
			if(stack.isEmpty()) {
				ans = 1;
			}
			else ans = 0;
			System.out.println("#" + test_case + " " + ans);
		}
	}
}