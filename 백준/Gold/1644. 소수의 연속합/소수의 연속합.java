import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean[] array;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        if(n==1){
            bw.write("0");
        }else{
            array = new boolean[n+1];
            Arrays.fill(array, true);

            setPrimeNumber();

            int end = 2;
            int sum = 0;
            int count = 0;
            for(int start=2;start<=n;start++){
                if(!array[start])
                    continue;

                while(sum<n&&end<=n){
                    if(array[end]){ // end가 소수라면
                        sum+=end;
                    }
                    end++;
                }

                if(sum==n)
                    count++;

                sum -=start;

            }

            bw.write(count+"");

        }
        bw.flush();
        bw.close();
        br.close();

    }

    static void setPrimeNumber(){

        array[0] = false;
        array[1] = false;
        for(int i=2;i*i<=n;i++){
            if(!array[i])
                continue;
            for(int j=2;j*i<=n;j++)
                array[i*j] = false;
        }
    }
}
