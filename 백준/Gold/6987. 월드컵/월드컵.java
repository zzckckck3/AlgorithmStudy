import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int sum = 0;
	static int winSum = 0;
	static int loseSum = 0;
	static int drawSum = 0;
	static int[] win;
	static int[] draw;
	static int[] lose;
	static boolean canCup = false;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int testCase = 1; testCase <= 4; testCase++) {
			
			win = new int[6];
			draw = new int[6];
			lose = new int[6];
			
			st = new StringTokenizer(br.readLine());
			sum = 0;
			winSum = 0;
			loseSum = 0;
			drawSum = 0;
			for (int i = 0; i < 6; i++) {
				winSum += win[i] = Integer.parseInt(st.nextToken());
                drawSum += draw[i] = Integer.parseInt(st.nextToken());
                loseSum += lose[i] = Integer.parseInt(st.nextToken()); 
				sum += win[i] + draw[i] + lose[i]; 
			}
			canCup = false;
			if (sum == 30) { // 경기 수 총 합이 15가 아니라면 break;
				dfs(0, 0, 1); 
			} 
//			else if(winSum != loseSum) {
//				System.out.print("0 ");
//				break;
//			} else if((drawSum % 2) != 0) {
//				System.out.print("0 ");
//				break;
//			}
			
			if(canCup) {
				System.out.print("1 ");
			} else {
				System.out.print("0 ");
			}
		}
		
	}
	
	
	public static void dfs(int team, int cnt, int index) {
		// 0팀부터 A, B, C, D, E, F
		// cnt는 깊이를 비교해 주기 위함
		// index는 매개변수 team과 싸울 상대를 지정해주기 위함
		if(canCup) {
			return;
		}
		if(win[team] < 0 || lose[team] < 0 || draw[team] < 0 || win[team+index-1] < 0 || 
				lose[team+index-1] <0 || draw[team+index-1] < 0) {
			return;
		}
        if(cnt == 15) // 15게임까지가면 == 위의 조건을 통과 했다면
        {
            canCup = true;
            return;
        }
        //==============================================================
		// A -> B C D E F	5
        // B -> C D E F		9
        // C -> D E F		12
        // D -> E F			14
        // E -> F			15
        
        if(cnt == 5)  
        {
            team++;
            index = 1;
        }
        else if(cnt == 9)
        {
            team++;
            index = 1;
        }
        else if(cnt == 12)
        {
            team++;
            index = 1;
        }
        else if(cnt == 14)
        {
            team++;
            index = 1;
        }
        
		// A승 B패
		win[team]--; // A의 승리수에서 하나를 뺴고 >> 뺀다 라는 것은 입력 받은 수에서 하나를 제거하는것
        lose[team + index]--; // A의 다음팀에서 패배를 하나 뺸다
        dfs(team, cnt+1, index+1); // A를 그대로 넘기고 C와 비교한다
        win[team]++;  // 초기화
        lose[team + index]++;  // 초기화
        
		// A패 B승
        win[team + index]--;
        lose[team]--;
        dfs(team, cnt+1, index+1);
        win[team + index]++;
        lose[team]++;
        
		// 무승부
        draw[team]--;
        draw[team + index]--;
        dfs(team, cnt+1, index+1);
        draw[team]++;
        draw[team + index]++;
	}
}
