class Solution {
    public int[] solution(int[] arr) {
        // 2 4 8 16 
        int length = 1;
        
        while(true){
            if(length>=arr.length)
                break;
            length*=2;
        }
        
        int[] answer = new int[length];
        
        for(int i=0;i<arr.length;i++)
            answer[i] = arr[i];
        
        for(int i=arr.length;i<length;i++)
            answer[i] = 0;
        
        return answer;
    }
}