package level1;


class Solution_로또의최고순위와최저순위_Level1 {
    public int[] solution(int[] lottos, int[] winNums) {
        int[] answer = new int[2];
        int zeroCount = 0;
        int correct = 0;

        for(int i=0; i<6; i++) {
        	if(lottos[i] == 0) {
        		zeroCount++;
        	} else {
        		for (int num : winNums) {
					if(num == lottos[i]) {
						correct++;
						break;
					}
				}
        	}
        }
        
        answer[0] = getRank(zeroCount + correct);
        answer[1] = getRank(correct);
        

        
        
        return answer;
    }
    
    public int getRank(int score) {
    	if(score == 6) return 1;
    	else if(score == 5) return 2;
    	else if(score == 4) return 3;
    	else if(score == 3) return 4;
    	else if(score == 2) return 5;
    	else return 6;
    }
}