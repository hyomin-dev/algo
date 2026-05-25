import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer s = new StringTokenizer(br.readLine());
        
        String str = s.nextToken();
        
        for(int i=0;i<str.length();i++){
            bw.write(str.charAt(i));
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
        br.close();
        
    }
}