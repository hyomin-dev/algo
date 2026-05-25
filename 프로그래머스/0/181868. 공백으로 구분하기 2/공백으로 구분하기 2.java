import java.util.*;

class Solution {
    public String[] solution(String my_string) {
         String[] strArray = my_string.split(" ");

        ArrayList<String> list = new ArrayList<>();

        for(String str: strArray){
            if(str.equals(""))
                continue;

            list.add(str);
        }

        return list.toArray(new String[0]);
    }
}