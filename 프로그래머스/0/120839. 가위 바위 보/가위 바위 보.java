class Solution {
    public String solution(String rsp) {
       StringBuilder strBuilder = new StringBuilder();

        for(int i=0;i<rsp.length();i++){
            int ch = Integer.parseInt(rsp.charAt(i)+"");

            if(ch==2)
                strBuilder.append("0");
            else if(ch==0)
                strBuilder.append("5");
            else
                strBuilder.append("2");
        }

        return strBuilder.toString();
    }
}