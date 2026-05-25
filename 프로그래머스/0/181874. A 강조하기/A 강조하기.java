class Solution {
    public String solution(String myString) {
        // a->A
        // A가아닌 대문자 -> 소문자

        StringBuilder stringBuilder = new StringBuilder(myString);

        for(int i=0;i<myString.length();i++){
            char ch = myString.charAt(i);

            if(ch=='a')
                stringBuilder.replace(i,i+1,"A");
            else if(ch>=66 && ch<=90)
                stringBuilder.replace(i,i+1,String.valueOf(ch).toLowerCase());

        }

        return stringBuilder.toString();
    }
}