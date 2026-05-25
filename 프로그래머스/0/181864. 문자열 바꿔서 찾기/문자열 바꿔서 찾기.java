class Solution {
    public int solution(String myString, String pat) {
        StringBuilder strBuilder = new StringBuilder();

        for(int i=0;i<myString.length();i++){
            char ch = myString.charAt(i);

            if(ch=='A')
                strBuilder.append("B");
            else
                strBuilder.append("A");
        }

        String str = strBuilder.toString();

        if(str.contains(pat))
            return 1;
        else
            return 0;
    }
}