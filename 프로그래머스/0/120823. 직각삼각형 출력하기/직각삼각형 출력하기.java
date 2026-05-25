import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = 0;

        if(st.hasMoreTokens()){
            n = Integer.parseInt(st.nextToken());
        }

        int width = 1;
        for(int h=1;h<=n;h++){
            for(int w = 1;w<=width;w++){
                bw.write("*");
            }
            width++;
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}