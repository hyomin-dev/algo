import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] strArr = myString.split("x");
        
        ArrayList<String> list = new ArrayList<>();
        
        for(String str: strArr){
            if(!str.equals(""))
                list.add(str);
        }
        
        strArr = list.toArray(new String[0]);
        
        Arrays.sort(strArr);
        
        return strArr;
        
    }
}