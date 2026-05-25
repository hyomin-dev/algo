class Solution {
    public int[] solution(String myString) {
        String[] strArray = myString.split("x", -1);

        int[] result = new int[strArray.length];

        for(int i=0;i<strArray.length;i++){
            result[i] = strArray[i].length();
        }

        return result;
    }
}