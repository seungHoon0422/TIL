import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 그래프이론, 플로이드-와샬
 * 
 * 가중치가 없는, 방향 그래프가 주어졌을 때 각 노드별 연결 상태를 출력
 * 
 * 1. 가중치가 필요없긴 하지만, 각 노드별 연결 상태를 구하기위해서는 플로이드 와샬 알고리즘을 적용하거나,
 * 각 노드별로 다익스트라 알고리즘을 적용시켜 경로를 추척해야한다??
 * 
 * 2. 가중치가 필요 없으므로 각 노드에서 모든 노드까지 그래프 탐색 진행!!
 * => 
 * 
 * 
 * @author SeongHoon
 *
 */
public class Main_BOJ_11403_경로찾기_Silver1_252ms {


	private static final int INF = 987654321;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int[][] graph;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		floyd();
		
	} // end of main

	private static void floyd() throws NumberFormatException, IOException {
		
		N  = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		for(int i=0; i<N; i++) { 
			String str = br.readLine();
			for(int j=0, index=0; j<N; j++, index+=2) {
				graph[i][j] = str.charAt(index)-'0';
				if(graph[i][j] == 0) graph[i][j] = INF;
			}
		}
	
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
//				if(k==i) continue;
				for(int j=0; j<N; j++) {
//					if(i==j || k==j) continue;
					if(graph[i][j] > graph[i][k] + graph[k][j])
						graph[i][j] = graph[i][k] + graph[k][j];
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
//				if(i==j) System.out.print("0 ");
				if(graph[i][j] == INF) System.out.print("0 ");
				else System.out.print("1 ");
			}
			System.out.println();
		}
	
	}
	
	
} // end of class








