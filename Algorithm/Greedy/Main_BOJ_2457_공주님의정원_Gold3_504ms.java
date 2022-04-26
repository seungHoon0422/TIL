import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 
 * 일단 문제를 보니까 회의실 문제랑 비슷한 느낌 => 그리디적 접근이 필요
 * 꽃이 1가지라도 무조건 피어있어야 하므로, 빈곳이 있으면 안된다.
 * 앞에서부터 종료시간을 기준으로 가면 너무 비교를 많이 해야할거 같음
 * 끝에날부터 비교를 시작하는데 비교하기 위해서 정렬기준을 잡아야 한다.
 * 
 * 꽃이 지는날짜가 늦은 꽃을 우선순위에 두자!!
 * 가장 늦게 지는 꽃을 기준으로 동일한 꽃이 있다면 가장 일찍피느 꽃을 선택
 * 1) 시작일 낮은 순
 * 2) 종료일 높은 순
 * 
 * 이제 날짜를 어떻게 표현할까
 * 월, 일로 되어있는 입력을 모두 일로 변환해서 생각하면 비교하기 편할거같다.
 * <<<<< 이거보다 편한방식 >>>>>
 * 그냥 3월 10일이면 0310으로 표현한다!! 유리케
 * 
 * 
 * @author SeongHoon
 *
 */
public class Main_BOJ_2457_공주님의정원_Gold3_504ms {


	static int n;
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		StringTokenizer st;
		Flower[] flowers = new Flower[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int startMonth = Integer.valueOf(st.nextToken());
			int startDay = Integer.valueOf(st.nextToken());
			int endMonth = Integer.valueOf(st.nextToken());
			int endDay = Integer.valueOf(st.nextToken());
			
			int start = startMonth * 100 + startDay;
			int end = endMonth * 100 + endDay;
			flowers[i] = new Flower(start, end);
		}
		
		Arrays.parallelSort(flowers);	// 조건에 맞게 정렬
		
		int endDay = 1201;
		int start = 301;
		int count = 0;
		int max = 0;
		int index = 0;
		
		// 현재 종료일이 12월 1일보다 적은 경우만 가능(12월 1일 초과면 이미 조건 만족했기 때문에)
		while(start < endDay) {
			boolean isFinded = false;	// 새 꽃 찾은지 여부 확인
			
			for(int i = index; i < n; i++) {
				if(flowers[i].start > start) {	// 종료일보다 시작일이 이후면 의미없음. 종료일에는 시작해야 이어지기 때문에
					break;
				}
				
				if(max < flowers[i].end) {
					isFinded = true;
					max = flowers[i].end;
					index = i + 1;
				}
			}
			
			if(isFinded) {
				start = max;
				count++;
			}
			else {
				break;
			}
		}
				
		if(max < endDay) {
			System.out.println(0);
		}
		else {
			System.out.println(count);
		}
	}
}

class Flower implements Comparable<Flower> {
	int start;
	int end;
	
	Flower(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	// 1) 시작일 낮은 순
	// 2) 종료일 높은 순
	@Override
	public int compareTo(Flower f) {
		if(this.start < f.start) {
			return -1;
		}
		else if(this.start == f.start) {
			if(this.end > f.end) {
				return -1;
			}
			else if(this.end == f.end) {
				return 0;
			}
			return 1;
		}
		else {
			return 1;
		}
	}
}








