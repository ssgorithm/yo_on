//백준 그래프이론 Q1753 최단경로 (골드5)
//https://www.acmicpc.net/problem/1753

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int index;
    int distance;

    public Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {return index;}
    public int getDistance() {return distance;}

    @Override
    public int compareTo(Node o){
        if(this.distance < o.distance) return -1;
        return 1;
    }
}

public class G1753 {
    //정점 v, 간선 e, 시작점 k
    public static int v, e, k;
    //무한을 의미하는 10억 값 설정
    public static final int INF = (int) 1e9;
    //그래프 정보 담을 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    //최단 거리 테이블
    public static int[] dist = new int[20001];

    //다익스트라 함수
    public static void dijkstra(int start){
        //우선순위 큐 사용
       PriorityQueue<Node> pq = new PriorityQueue<Node>();
       //시작점 거리 0으로 설정하여 offer
       pq.offer(new Node(start, 0));
       //자기 자신까지의 거리 0으로 설정
       dist[start] = 0;

       while(!pq.isEmpty()){
           //거리가 가장 짧은 노드 poll
           Node node = pq.poll();

           //poll한 노드의 인덱스와 거리 저장
           int d = node.getDistance();
           int now = node.getIndex();

           //현재 최단거리 테이블에 저장된 값이 현재 노드의 거리보다 작다면 continue
           if(dist[now] < d) continue;

           //graph에서 현재 노드와 연결되어 있는 노드들 탐색
           for(int i = 0; i < graph.get(now).size(); i++){
               //최단거리 테이블의 현재 노드가지의 거리 + 현재노드의 인접노드(get(i))까지의 거리
               int cost = dist[now] + graph.get(now).get(i).getDistance();

               //만약 출발 노드에서 인접노드(graph.get(now).get(i)까지의 거리가 cost보다 크다면
               //현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
               if(cost < dist[graph.get(now).get(i).getIndex()]){
                   //최단 거리를 cost로 갱신
                   dist[graph.get(now).get(i).getIndex()] = cost;
                   //갱신된 값을 큐에 넣음
                   pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
               }
           }
       }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        //정점개수, 간선개수, 시작 노드 입력받기
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        //그래프 초기화
        for(int i = 0; i <= v; i++){
            graph.add(new ArrayList<Node>());
        }

        //입력 받아 그래프에 저장
        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }

        //최단거리 테이블 INF로 초기화
        Arrays.fill(dist, INF);

        //다익스트라 수행
        dijkstra(k);

        //INF값이면 INF출력 아니라면 최단거리 테이블 값 출력
        for(int i = 1; i <= v; i++){
            sb.append(dist[i] == INF ? "INF " : dist[i] + "\n");
        }

        System.out.print(sb.toString());
    }
}
