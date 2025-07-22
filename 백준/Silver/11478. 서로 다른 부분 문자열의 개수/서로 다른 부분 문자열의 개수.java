import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int l = str.length();
        Set<String> set = new HashSet<>();
        for(int k=1;k<=l;k++){
            for(int i=0;i<l-k+1;i++){
                String sub = str.substring(i,i+k);
                set.add(sub);
            }
        }

        bw.write(set.size()+"");

        bw.flush();
        bw.close();
        br.close();

    }
}
