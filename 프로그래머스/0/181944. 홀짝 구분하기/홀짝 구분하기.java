import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int num = Integer.parseInt(st.nextToken());
        
        if(num%2==0){
            bw.write(num+" is even");
        }else{
            bw.write(num+" is odd");
        }
        
        bw.flush();
        bw.close();
        br.close();        
        
    }
}