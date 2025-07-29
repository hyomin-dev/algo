import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t>0){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            String result = bfs(a,b);
            bw.write(result);
            bw.newLine();
            t--;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static String bfs(int a, int b){
        String result = "";

        boolean[] visited = new boolean[10000];
        visited[a] = true;

        Queue<Data9019> queue = new ArrayDeque<>();
        queue.offer(new Data9019(a,0,""));

        while(!queue.isEmpty()){

            Data9019 data = queue.poll();

            if(data.num==b){
                return data.oper;
            }

            //D
            int operD = data.num*2 %10000;
            if(!visited[operD]) {
                queue.offer(new Data9019(operD, data.count + 1,data.oper+"D" ));
                visited[operD] = true;
            }

            //S
            int operS = data.num==0 ? 9999 : data.num-1;
            if(!visited[operS]) {
                queue.offer(new Data9019(operS, data.count + 1, data.oper+"S"));
                visited[operS] = true;
            }

            // L과 S를 위해 data.num을 String으로 변경

            String numStr = "";

            if(data.num>=1000){
                numStr = String.valueOf(data.num);

            }else if(data.num>=100){
                numStr = "0"+data.num;

            }else if(data.num>=10){
                numStr = "00"+data.num;
            }else
                numStr = "000"+data.num;

            //L

            int operL = Integer.parseInt(numStr.substring(1,4) + numStr.substring(0,1));
            if(!visited[operL]) {
                queue.offer(new Data9019(operL, data.count + 1, data.oper+"L"));
                visited[operL] = true;
            }

            //R

            int operR = Integer.parseInt(numStr.substring(3,4)+numStr.substring(0,3) );
            if(!visited[operR]) {
                queue.offer(new Data9019(operR, data.count + 1, data.oper+"R"));
                visited[operR] = true;
            }
        }
        return result;

    }
}

class Data9019{
    int num;
    int count;
    String oper;

    public Data9019(int num, int count, String oper){
        this.num = num;
        this.count = count;
        this.oper = oper;
    }
}
