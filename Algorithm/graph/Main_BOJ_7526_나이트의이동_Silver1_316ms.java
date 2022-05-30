import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_7526_나이트의이동_Silver1_316ms {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	private static int tc;
	private static int N;
	private static boolean[][] visited;
	private static int r;
	private static int c;
	private static int[] dr = {-2,-1,1,2,2,1,-1,-2};
	private static int[] dc = {1,2,2,1,-1,-2,-2,-1};
	private static int destr;
	private static int destc;
	private static int answer;
			

	public static void main(String[] args) throws Exception {
		
		tc = Integer.parseInt(br.readLine());
		
		for(int test=0; test<tc; test++) {
			N = Integer.parseInt(br.readLine());
			
			visited = new boolean[N][N];
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			destr = Integer.parseInt(st.nextToken());
			destc = Integer.parseInt(st.nextToken());
			answer = Integer.MAX_VALUE;
			
			Queue<int[]> q = new LinkedList<int[]>();
			visited[r][c] = true;
			q.offer(new int[] {r,c});
			answer = 0;
loop1: 		while(!q.isEmpty()) {
	
				int size = q.size();
				
				while(size-- > 0) {
					
					r = q.peek()[0];
					c = q.peek()[1];
					q.poll();
					if(r==destr && c == destc) {
						break loop1; 
					}
					for(int i=0; i<8; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if(0<=nr && nr<N && 0<=nc && nc<N && !visited[nr][nc]) {
							visited[nr][nc] = true;
							q.offer(new int[] {nr,nc});
						}
					}
				}
				answer++;
			}

			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
		
		
		
	} // end of main


	
	
	
	
} // end of class








