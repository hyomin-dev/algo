import java.io.*;
import java.util.*;

public class Main {
    static int t, n, count;
    static boolean[] visited, done;
    static int[] array;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t= Integer.parseInt(br.readLine());

        while(t>0){

            n = Integer.parseInt(br.readLine());

            count = 0; // 팀에 소속된 인원 수

            visited = new boolean[n+1]; // 노드 방문 여부
            done = new boolean[n+1]; // 노드를 방문하고 사이클에 포함되면 카운트하고 포함되지 않으면 카운트 하지 않는 작업을 했다는 표시임
            array = new int[n+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1;i<=n;i++){
                array[i] = Integer.parseInt(st.nextToken());
                if(array[i]==i){
                    visited[i] = true;
                    done[i] = true;
                    count++;
                }
            }

            for(int i=1;i<=n;i++){
                if(!visited[i]){
                    dfs(i);
                }
            }

            bw.write(n-count+"\n");

            t--;
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int curr){
        visited[curr] = true;
        int next = array[curr];

        if(!visited[next]){ // visited가 true인 시점이 사이클이 존재
            dfs(next);
        }else if(!done[next]){
            count++; // 현재 노드 사이클에 포함
            for(int v = next;v!=curr;v=array[v]) // 현재 노드가 가리키고 있는 다음 노드부터 현재 노드 전까지 노드의 수를 셈 --> 사이클에 포함된 노드의 수
                count++;
        }

        done[curr] = true;
    }
}


/*

자기 자신으로 되돌아올 수 있으면: 팀 구성 가능

자기 자신으로 되돌아 올 수 없으면: 팀 구성 불가능


무조건 하나의 노드는 1개의 단방향 간선을 가진다. --> 이로 인해 그래프내에 사이클이 적어도 하나는 생김

즉, 어떤 노드에서 출발해도 사이클에 도달하게 됨



* */
