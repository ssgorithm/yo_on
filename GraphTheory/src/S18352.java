//백준 그래프이론 Q18352 특정거리의 도시찾기 (실버2)
// https://www.acmicpc.net/problem/18352

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S18352 {
    //노드 개수 n, 간선 개수 m, 특정 거리 k, 시작 도시 x
    public static int n,m,k,x;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static int[] d = new int[300001];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Integer>());
            d[i] = -1;
        }
        //그래프 정보 입력 받기
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        d[x] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i = 0; i < graph.get(now).size(); i++){
                int next = graph.get(now).get(i);
                if(d[next] == -1){
                    d[next] = d[now] + 1;
                    q.offer(next);
                }
            }
        }

        boolean flag = false;
        for(int i = 1; i < n + 1; i++){
            if(d[i] == k){
                System.out.println(i);
                flag = true;
            }
        }

        if(!flag) System.out.print(-1);
    }
}
