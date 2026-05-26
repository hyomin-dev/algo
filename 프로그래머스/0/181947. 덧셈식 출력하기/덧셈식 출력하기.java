import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer sToken = new StringTokenizer(br.readLine());
        
        int a = Integer.valueOf(sToken.nextToken());
        int b = Integer.valueOf(sToken.nextToken());
        
        bw.write(a +" + "+b+" = "+(a+b));
        bw.flush();
        br.close();
        
        
    }
}