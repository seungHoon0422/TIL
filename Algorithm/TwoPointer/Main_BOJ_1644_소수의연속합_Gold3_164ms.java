import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 * [에라토스 테네스의 체, 투포인터]
 * 
 * 소수 관련된 문제는 엥간하면 에라토스 문제
 * 연속된 소수를 더하므로 투포인터 사용
 * 주어진 자연수에 대해서 저장되어 있는 소수배열에 투포인트 사용
 * 하나씩 더해가며 주어진 수를 만들 수 있는 경우를 체크한다.
 * 
 * 
 * @author SeongHoon
 *
 */
public class Main_BOJ_1644_소수의연속합_Gold3_164ms {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	private static int N;
	private static boolean[] isPrime;
	private static ArrayList<Integer> prime;

	public static void main(String[] args) throws Exception {
		
		N = Integer.parseInt(br.readLine());
		isPrime = new boolean[N+1];
		isPrime[0] = isPrime[1] = true;
		prime = new ArrayList<Integer>();
		for(int i=2; i*i<=N; i++) {
			// 소수가 아니라면
			if(!isPrime[i]) {
				for(int j=i*i; j<=N; j+=i) isPrime[j] = true;
			}
		}
		for(int i=1; i<=N; i++) if(!isPrime[i]) prime.add(i);
		
		int left = 0;
		int right = 0;
		int sum = 0;
		int answer = 0;
		
		while(true) {
			if(sum < N) {
				if(right == prime.size()) break;
				sum += prime.get(right++);
			}
			else if(sum == N) {
				answer++;
				if(right == prime.size()) break;
				sum += prime.get(right++);
			} else 
				sum -= prime.get(left++);
		}
		System.out.println(answer);
		
	} // end of main
	
	
	
	
	
} // end of class








