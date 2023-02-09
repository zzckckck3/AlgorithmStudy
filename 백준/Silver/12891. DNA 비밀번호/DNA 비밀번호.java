import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int S;
	public static int P;
	public static char[] dna;
	public static int[] acgt = new int[4];
	public static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		dna = new char[S];
		String tempDna = br.readLine();
		for (int i = 0; i < S; i++) {
			dna[i] = tempDna.charAt(i);
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < acgt.length; i++) {
			acgt[i] = Integer.parseInt(st.nextToken());
		}
		
		int a = 0;
		int c = 0;
		int g = 0;
		int t = 0;
		for (int i = 0; i < P; i++) {
			if(dna[i] == 'A') {
				a++;
			} else if (dna[i] == 'C') {
				c++;
			} else if (dna[i] == 'G') {
				g++;
			} else if (dna[i] == 'T') {
				t++;
			}
		}
		//System.out.println(a + " " + c + " " + g + " " + t);

		
		if (a >= acgt[0] && c >= acgt[1] && g >= acgt[2] && t >= acgt[3]) {
			ans++;
		}
		
		for (int i = 0; i < S - P; i++) {
			if (dna[i] == 'A') {
				a--;
			} else if (dna[i] == 'C') {
				c--;
			} else if (dna[i] == 'G') {
				g--;
			} else if (dna[i] == 'T') {
				t--;
			} 
			
			if (dna[i + P] == 'A') {
				a++;
			} else if (dna[i + P] == 'C') {
				c++;
			} else if (dna[i + P] == 'G') {
				g++;
			} else if (dna[i + P] == 'T') {
				t++;
			}
			
			if (a >= acgt[0] && c >= acgt[1] && g >= acgt[2] && t >= acgt[3]) {
				ans++;
			}
			//System.out.println(a + " " + c + " " + g + " " + t + " " + ans);
		}
		
		System.out.println(ans);
	}
}
