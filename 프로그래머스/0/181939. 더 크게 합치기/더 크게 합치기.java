class Solution {
    public int solution(int a, int b) {
        String strA = String.valueOf(a);
        String strB = String.valueOf(b);

        int result1 = Integer.parseInt(strA + strB);
        int result2 = Integer.parseInt(strB + strA);

        return result1>result2 ? result1 : result2;
    }
}