class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        
        int idx = 0; // 가장 큰 수가 0번째 인덱스로 가정
        for(int i=1;i<array.length;i++){
            if(array[i]>array[idx])
                idx = i;
        }
        
        answer[0] = array[idx];
        answer[1] = idx;
        
        return answer;
    }
}