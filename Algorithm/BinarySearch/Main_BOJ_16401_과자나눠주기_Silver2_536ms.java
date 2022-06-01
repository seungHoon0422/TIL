import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [이분탐색]
 * 
 * 조카 1명에게 줄 막대과자의 길이를 기준으로 이분탐색 진행
 * 나눠줄 조카가 1명일 경우도 있으므로 최대값은 막대과자의 최대길이, 최소는 0으로 설정
 * 
 * 
 * @author SeongHoon
 *
 */
public class Main_BOJ_16401_과자나눠주기_Silver2_536ms {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int M;
	private static int[] cookies;
	private static int left;
	private static int right;

	public static void main(String[] args) throws Exception {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cookies = new int[M];
		st = new StringTokenizer(br.readLine());
		left=1;
		right=Integer.MIN_VALUE;
		int answer = 0;
		for(int i=0; i<M; i++) {
			cookies[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, cookies[i]);
		}
		
		
		while(left<=right) {
			int mid = (left+right) >> 1;
			boolean possible = isPossible(mid);
			if(possible) {
				answer = Math.max(answer, mid);
				left = mid+1;
			} else {
				right = mid-1;
			}
		}
		
		System.out.println(answer);
		
		
	} // end of main

	private static boolean isPossible(int mid) {
		
		int count = 0;
		for(int i=0; i<M; i++) {
			count += cookies[i]/mid;
		}
		if(count >= N) return true;
		else return false;
	}
	
	
	
	
	
} // end of class








