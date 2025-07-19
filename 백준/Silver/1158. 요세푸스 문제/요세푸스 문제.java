import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=n;i++)
            q.offer(i);

        bw.write("<");
        int count = 0;
        while(!q.isEmpty()){

            int x = q.poll();
            count++;
            if(q.isEmpty()){
                bw.write(x+">");
            } else if(count==k){
                bw.write(x+", ");
                count = 0;
            }else{
                q.offer(x);
            }

        }

        bw.flush();
        bw.close();
        br.close();

    }
}
