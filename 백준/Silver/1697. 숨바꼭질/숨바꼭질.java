import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main
{
	static int a;
	static int b;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static int visited[] = new int[1000000];
	
	// X-1, X+1	// X*2
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(a));
	}

	private static int bfs(int num)
	{
		queue.offer(num);
		int firstIndex = num;
		int n = 0;
		visited[firstIndex] = 1;
		while (!queue.isEmpty())
		{
			n = queue.remove();
			
			if (n == b)
			{
				return visited[n]-1;
			}
			
			if (n - 1 >= 0 && visited[n-1] == 0)
			{
				visited[n - 1] = visited[n] + 1;
				queue.add(n - 1);
			}
			if (n + 1 <= 100000 && visited[n + 1] == 0)
			{
				visited[n + 1] = visited[n] + 1;
				queue.add(n+1);
			}
			if (n * 2 <= 100000 && visited[n * 2] == 0)
			{
				visited[n * 2] = visited[n] + 1;
				queue.add(n * 2);
			}
		}
		return -1;
	}
}