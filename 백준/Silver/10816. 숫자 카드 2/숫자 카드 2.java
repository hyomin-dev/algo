import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] array = new int[20000000+1]; // -10000000 --> index는 0

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        while(n>0){
            array[Integer.parseInt(st.nextToken())+10000000]++;
            n--;
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while(m>0){
            bw.write(array[Integer.parseInt(st.nextToken())+10000000]+" ");
            m--;
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
