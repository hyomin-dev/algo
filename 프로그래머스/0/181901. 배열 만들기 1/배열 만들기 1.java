class Solution {
    public int[] solution(int n, int k) {
        int[] arr = new int[n/k];
        
        int idx = 0;
        for(int i=k;i<=n;i++){
            if(i%k==0)
                arr[idx++] = i;
        }
        
        return arr;
    }
}