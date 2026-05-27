class Solution {
    public int solution(int[] num_list) {
        StringBuilder strBuilder1 = new StringBuilder();
        StringBuilder strBuilder2 = new StringBuilder();
        int evenNumber, oddNumber;
        
        for(int i=0;i<num_list.length;i++){
            int num = num_list[i];
            
            if(num%2==0)
                strBuilder1.append(String.valueOf(num));
            else
                strBuilder2.append(String.valueOf(num));
        }
        
        evenNumber = Integer.parseInt(strBuilder1.toString());
        oddNumber = Integer.parseInt(strBuilder2.toString());
        
        return evenNumber + oddNumber;
    }
}