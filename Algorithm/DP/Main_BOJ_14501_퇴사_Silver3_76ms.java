import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14501_퇴사_Silver3_76ms {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		
		int n = Integer.parseInt(br.readLine());
		Node[] days = new Node[n+1];
		
		
		int[] dp = new int[n+1];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			days[i] = new Node(t,v);
		}

		
		for(int i=0; i<n; i++) {
			int end = i+days[i].time;
			if(end <= n) dp[end] = Math.max(dp[end], dp[i]+days[i].pay);
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
		System.out.println(dp[n]);
		
		
		
	} // end of main
	
	
	
	static class Node{
		int time;
		int pay;
		public Node(int time, int pay) {
			super();
			this.time = time;
			this.pay = pay;
		}
		@Override
		public String toString() {
			return "Node [time=" + time + ", pay=" + pay + "]";
		}
		
	}
	
} // end of class






/*
 * 
 * 7
3 10
5 20
1 10
1 20
2 15
4 40
2 200

1	2	3	4	5	6	7
3	5	1	1	2	4	2
10	20	10	20	15	40	200

0	0	0	10	10	10	10 	: 1
0	0	0	10	10	10	20	: 1 2
0	0	0	10	10	10	20	: 1 2 3
0	0	0	10	20	20	20	: 1 2 3 4
0	0	0	10	20	20	35	: 1 2 3 4 5
0	0	0	10	20	

 * 
 * 
 * 
 */

