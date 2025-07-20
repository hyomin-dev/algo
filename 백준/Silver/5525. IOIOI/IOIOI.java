import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<2*n+1;i++){
            if(i%2==0)
                sb.append("I");
            else
                sb.append("O");
        }

        String findStr = sb.toString();
        int findStrLength = findStr.length();
        int count = 0;
        for(int i=0;i<=m-findStrLength;i++){
            if(findStr.equals(s.substring(i,i+findStrLength)))
                count++;
        }

        bw.write(count+"");

        bw.flush();
        bw.close();
        br.close();
    }
}
