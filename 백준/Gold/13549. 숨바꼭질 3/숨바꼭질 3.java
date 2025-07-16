import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int k;
    static int[] distArray = new int[100000+1];
    static ArrayList<ArrayList<Node13549>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        final int INF = (int)1e9;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 0 <= n,k <= 100000
        n = Integer.parseInt(st.nextToken()); // 수빈 위치
        k = Integer.parseInt(st.nextToken()); // 동생 위치

        Arrays.fill(distArray,INF);

        for(int i=0;i<=100000;i++)
            graph.add(new ArrayList<>());

       for(int i=0;i<=100000;i++){

           if(i+1<=100000)
               graph.get(i).add(new Node13549(i+1,1)); // i 노드에서 i+1 노드는 1초가 걸림, 이를 반영

           if(i-1>=0)
               graph.get(i).add(new Node13549(i-1,1)); // i 노드에서 i-1 노드는 1초가 걸림, 이를 반영

           if(2*i<=100000)
               graph.get(i).add(new Node13549(2*i,0)); // i노드에서 2*i 노드는 0초가 걸림, 이를 반영

       }

        dijkstra(n);

        bw.write(String.valueOf(distArray[k]));

        bw.flush();
        bw.close();
        br.close();

    }

    static void dijkstra(int start){

        PriorityQueue<Node13549> pq = new PriorityQueue<>();
        pq.offer(new Node13549(start,0));
        distArray[start] = 0;

        while(!pq.isEmpty()){

            Node13549 node = pq.poll();

            int now = node.getIndex();
            int time = node.getTime();
            
            if(now==k)
                break;

            if(distArray[now]<time) // 이미 최단 시간을 구한 경우
                continue;

            for(int i=0;i<graph.get(now).size();i++){

                int index = graph.get(now).get(i).getIndex();
                int cost = distArray[now]+graph.get(now).get(i).getTime();
                if(cost<distArray[index]){
                    distArray[index] = cost;
                    pq.offer(new Node13549(index, cost));
                }

            }

        }
    }


}

class Node13549 implements Comparable<Node13549>{
    int index;
    int time;

    public Node13549(int index, int distance){
        this.index = index;
        this.time = distance;
    }

    int getIndex(){
        return this.index;
    }

    int getTime(){
        return this.time;
    }

    @Override
    public int compareTo(Node13549 o){
        if(this.time!=o.time)
            return this.time - o.time;

        return 0;
    }
}

/*
현재 위치: X
순간이동: 2*X
1초 후: X-1 또는 X+1

* */
