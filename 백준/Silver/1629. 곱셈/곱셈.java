import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long result = multiply(a,b,c);

        bw.write(result+"");

        bw.flush();
        bw.close();
        br.close();

    }

    static long multiply(long num, long index, long rest){
        if(index==1)
            return num%rest;
        else if(index%2==0){
            long half = index/2;
            long result1 = multiply(num,half,rest);
            return (result1*result1)%rest;
        }else{
            long half = index/2;
            long result1 = multiply(num,half,rest);
            return (result1%rest*result1%rest*num%rest)%rest;
        }
    }
}
