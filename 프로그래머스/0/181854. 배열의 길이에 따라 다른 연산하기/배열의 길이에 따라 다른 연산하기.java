class Solution {
    public int[] solution(int[] arr, int n) {
        // arr.length 홀수 -> 짝수 인덱스위치에 n을 더함
        // arr.length 짝수 -> 홀수 인덱스 위치에 n을 더함
        int startIdx;
        if(arr.length % 2 ==0){
            startIdx = 1;
        }else{
            startIdx = 0;
        }

        for(int idx=startIdx;idx<arr.length;idx+=2){
            arr[idx] +=n;
        }

        return arr;
    }
}