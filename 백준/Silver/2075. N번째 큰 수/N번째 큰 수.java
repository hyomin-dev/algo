import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int y=0;y<n;y++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x=0;x<n;x++){

                pq.offer(Integer.parseInt(st.nextToken()));
                if(pq.size()>n)
                    pq.poll();
            }
        }

        bw.write(pq.poll()+"");

        bw.flush();
        bw.close();
        br.close();

    }
}
