
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_14890_경사로_Gold3_80ms {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int X;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		
		
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0, index=0; j<N; j++, index+=2) {
					map[i][j] = str.charAt(index)-'0';
				}
			}
			
			int answer = 0;
			for(int i=0; i<N; i++) {
				int[] vertical = new int[N];
				for(int j=0; j<N; j++) vertical[j] = map[j][i];
				
				if(isPossible(map[i])) {
					answer++;	// 가로
				}
				if(isPossible(vertical)) {
					answer++;	// 세로
				}
			}
			
			System.out.println(answer);
			
	} // end of main
	
	
	
	private static boolean isPossible(int[] line) {
		
		boolean[] made = new boolean[line.length];
		
		for(int i=1; i<line.length; i++) {
			
			
			// 1. 같은 높이는 통과
			if(line[i-1] == line[i]) continue;
			// 2. 높이차이가 1보다 커지면 경사로 건설 불가
			else if(Math.abs(line[i-1]-line[i])>1) return false;
			// 3. 오르막 경사를 지어야 하는 경우
			else if(line[i-1]<line[i]) {
				// 3-1. 경사로 건설 가능 체크
				if(i-X>=0) {
					int height = line[i-1];
					for(int j=i-1; j>=i-X; j--) 
						if(made[j] || line[j]!=height) return false;
					for(int j=i-1; j>=i-X; j--) 
						made[j] = true;
					
					continue;
				}
				return false;
			} 
			
			// 4. 내리막 경사를 지어야 하는 경우
			else {
				// 4-1. 경사로 건설 가능 체크
				if(i+X-1<N) {
					int height = line[i];
					for(int j=i; j<i+X; j++) 
						if(made[j] || line[j] != height) return false;
						
					for(int j=i; j<i+X; j++) 
						made[j] = true;
					continue;
				}
				return false;
			}
		

		}
		
		return true;
	}
} // end of class








