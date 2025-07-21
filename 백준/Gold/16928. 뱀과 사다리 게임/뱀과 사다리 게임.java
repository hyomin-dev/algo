import java.io.*;
import java.util.*;

public class Main {

    static Map<Integer, Integer> map = new HashMap<>();
    static boolean[] visited = new boolean[100+1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());

            map.put(x,y); // 출발지, 도착지
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map.put(u,y); // 출발지, 도착지
        }

        int count = bfs();

        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();

    }

    static int bfs(){
        Queue<int[]> queue = new ArrayDeque<>(); // 위치, 주사위 횟수
        queue.offer(new int[]{1,0});
        visited[1] = true;
        while(!queue.isEmpty()){
            int[] node = queue.poll();

            if(node[0]==100)
                return node[1];

           for(int i=1;i<=6;i++){
               int moving = node[0]+i;
               if(moving>100)
                   continue;
               if(visited[moving])
                   continue;
               int dest = map.getOrDefault(moving, 0);

               if(dest==0){
                   queue.offer(new int[]{moving,node[1]+1});
                   visited[moving] = true;
               }else{
                   visited[moving] = true; // 뱀 또는 사다리 위치로 이동한 경우는 무조건 도착지로 가야 하므로 moving은 queue에 넣지 않음
                   queue.offer(new int[]{dest,node[1]+1});
                   visited[dest] = true;

               }
           }
        }

        return -1;
    }
}
