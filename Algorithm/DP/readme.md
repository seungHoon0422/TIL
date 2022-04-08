### LIS( 최장 증가 부분 수열)

---

</br>

📌 최장 증가 부분 수열(LIS, Longest Increasing Subsequence)란?

원소가 n개인 배열의 일부 원소를 골라내서 만든 부분 수열 중, 각 원소가 이전 원소보다 크다는 조건을 만족하고, 그 길이가 최대인 부분 수열을 최장 증가 부분 수열이라고 합니다.

---

<br>

#### 🔍 DP를 사용한 기본적인 LIS 구현

시간복잡도 : O(n^2)

```java
for(int i=1; i<n; i++) {
  dp[i] = 1;
  for(int j=0; j<i; j++) {
    if(arr[i] > arr[j]) {
      dp[i] = Math.max(dp[i], dp[j]+1);
    }
  }
}
```

주어진 배열에서 인덱스를 한 칸씩(k+=1) 늘려가면서 확인합니다. 그리고 내부 반복문으로 k보다 작은 인덱스들을 하나씩 살펴 보면서 arr[i] < arr[k]인 것이 있을 경우, length[k] 를 업데이트합니다.

---

<br>

#### 🔍 이분탐색을 활용한 LIS 구현

시간복잡도를 개선하기 위하여 LIS를 구성할 때 이분탐색을 활용합니다.
시간복잡도 : O(nlogn)

즉, LIS의 형태를 유지하기 위해 주어진 배열의 인덱스를 하나씩 살펴보면서 그 숫자가 들어갈 위치를 이분탐색으로 탐색해서 넣습니다.

매 탐색마다 길이가 len인 LIS들의 마지막 값중 최솟값

여기까지의 불완전한 수열([5,6,7,1,2])까지만 봤을 때도 확실한 것들이 있다.

- 길이가 1인 증가 부분수열들의([5],[6],...[2]) 마지막 값(5,6,7,1,2) 중 최소의 값은 1이고,
- 길이가 2인 증가 부분수열들의([5,6],[1,2]) 마지막 값(6,2) 중 최소의 값은 2이다.
- 길이가 3인 증가 부분수열의([5,6,7]) 마지막 값(7) 중 최소의 값은 7이다.

→ 매번 탐색을 해나갈 때 마다 증가 부분수열의 길이가 같다면 이때 마지막 값의 크기가 작은 것의 정보를 유지하면서 탐색을 이어나가야 된다.

```java
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static int[] memo;
	static int INF = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		memo = new int[n+1];
		int len=0;
		int idx=0;
		for(int i=0; i<n; i++) {
			if(arr[i] > memo[len]) {
				len +=1;
				memo[len] = arr[i];
			}else {
				idx = binarySearch(0,len, arr[i]);
				memo[idx] = arr[i];
			}
		}
		System.out.println(len);
	}

	static int binarySearch(int left, int right, int key) {
		int mid =0;
		while(left<right) {
			mid = (left+right)/2;
			if(memo[mid] < key) {
				left = mid+1;
			}else {
				right = mid;
			}
		}
		return right;
	}
}

```
