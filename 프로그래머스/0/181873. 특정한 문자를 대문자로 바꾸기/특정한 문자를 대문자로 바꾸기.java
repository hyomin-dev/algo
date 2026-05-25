class Solution {
    public String solution(String my_string, String alp) {
        StringBuilder stringBuilder = new StringBuilder(my_string);
        String upperAlp = alp.toUpperCase();

        for(int i=0;i<my_string.length();i++){
            String str = String.valueOf(my_string.charAt(i));
            if(alp.equals(str))
                stringBuilder.replace(i,i+1,upperAlp);
        }

        return stringBuilder.toString();
    }
}