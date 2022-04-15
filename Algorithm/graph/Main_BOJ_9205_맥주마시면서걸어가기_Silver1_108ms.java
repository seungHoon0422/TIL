import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 
 *  category : 그래프탐색, BFS, 맨해튼 거리
 * 
 *
 * 맥주 1박스에 20병
 * 20병 이상으로는 담을 수 없고 1병으로 50m 전진 가능!!
 * 편의점에서 맥주를 살 수 있다
 * 
 * 1박스로 이동 가능한 최대 거리 => 50M * 20병 = 1000m
 * 맨해튼 거리로 이동 => 현재 좌표와 목적지 좌표의 x,y 차이만큼 계산
 * 
 * 
 * 
 * 
 *  markets배열에 시작위치부터, 편의점위치, 도착위치 모두 저장
	시작위치부터 BFS탐색 시작
	사정거리 안에 페스티벌이 있으면 happy출력하고 다음 testcase 실행
	방문안한 편의점이 있으면 바로 q에 들어간다.

 * 
 * 
 * 
 * @author SeongHoon
 *
 */
public class Main_BOJ_9205_맥주마시면서걸어가기_Silver1_108ms {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	private static int t;
	private static Node[] markets;
	private static int marketCount;
	private static Node position;
	private static Node festival;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		t = Integer.parseInt(br.readLine());
		
		
test:	for(int test=0; test<t; test++) {
	
			marketCount = Integer.parseInt(br.readLine());
			markets = new Node[marketCount+2];
			
			st = new StringTokenizer(br.readLine());
			position = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			markets[0] = position;
			
			
			for(int i=1; i<=marketCount; i++) {
				st = new StringTokenizer(br.readLine());
				markets[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			st = new StringTokenizer(br.readLine());
			festival = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			markets[marketCount+1] = festival;
			
			
			// bfs 시작
			boolean[] visited = new boolean[marketCount+2];
			Queue<Node> q = new LinkedList<>();
			
			visited[0] = true;
			q.offer(position);
			
			
			// 큐에 편의점이 들어있는 동안 계속 bfs진행
			while(!q.isEmpty()) {
				
				Node front = q.poll();
				
				// 모든 편의점을 확인하면서 진행
				for(int i=1; i<=marketCount+1; i++) {
					Node next = markets[i];
					
					// festival에 도착하면 happy 출력 후 종료
					if(next.x==festival.x && next.y==festival.y && Math.abs(front.x-next.x) + Math.abs(front.y-next.y) <= 1000) {
						System.out.println("happy");
						continue test;
					}
					
					
					// 방문한 적이 없는 편의점
					if(!visited[i]) {
						
						// 사정거리 안에 있는지 체크!!
						if(Math.abs(front.x-next.x) + Math.abs(front.y-next.y) > 1000) continue;
						visited[i] = true;
						q.offer(markets[i]);
					}
				} // for of market
			} // end of while
			
			
			// while문을 탈출하면 festival에 도착하지 못한것이므로 sad 출력
			System.out.println("sad");
			
			
		}
		
		
		
		
	} // end of main
	
	
	static class Node{
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	} // end of node
	
	
} // end of class









