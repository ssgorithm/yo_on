//백준 그래프이론 Q1916 최소비용 구하기 (골드5)
//https://www.acmicpc.net/problem/1916

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class City implements Comparable<City>{
    int index;
    int distance;

    public City(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    //거리가 짧은 것이 높은 우선 순위를 가지도록 설정
    @Override
    public int compareTo(City o) {
        return this.distance - o.distance;
    }
}
public class G1916 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    //무한을 의미하는 10억 값 설정
    public static final int INF = (int) 1e9;
    //노드 개수 n, 간선 개수 m, 출발 노드 start
    public static int n, m, start, end;
    //최단 거리 테이블
    public static int[] dist = new int[100001];
    //그래프 정보를 담을 배열
    public static ArrayList<ArrayList<City>> graph = new ArrayList<ArrayList<City>>();

    public static int dijkstra(int start){
        PriorityQueue<City> pq = new PriorityQueue<>();
        //출발 노드 큐에 넣기
        pq.offer(new City(start, 0));
        dist[start] = 0;
        //큐가 빌 때 까지 반복
        while(!pq.isEmpty()){
            //큐에서 거리가 가장 짧은 노드 꺼냄
            City node = pq.poll();
            //그 노드의 거리와 인덱스 저장
            int d = node.getDistance();
            int now = node.getIndex();
            if(now == end) return d;
            //만약 노드의 거리보다 현재 인덱스의 거리 값이 작다면 continue
            if(dist[now] < d) continue;
            //now의 인접 노드들 확인
            for(int i = 0; i < graph.get(now).size(); i++){
                //cost는 출발노드에서 now노드까지의 최단 거리 + now에서 인접노드(get(i))까지의 거리
                int cost = dist[now] + graph.get(now).get(i).getDistance();
                //만약 출발 노드에서 인접노드(graph.get(now).get(i)까지의 거리가 cost보다 크다면
                //현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if(cost < dist[graph.get(now).get(i).getIndex()]){
                    //최단 거리를 cost로 갱신
                    dist[graph.get(now).get(i).getIndex()] = cost;
                    //갱신된 값을 큐에 넣음
                    pq.offer(new City(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) throws IOException {
        //도시 개수, 버스 개수입력받기
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        //그래프 초기화
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<City>());
        }

        //그래프 정보 입력 받기, a에서 b노드의 거리가 c이다.
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new City(b,c));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        //거리 배열 무한대로 초기화
        Arrays.fill(dist, INF);

        //다익스트라 알고리즘 출력
        dijkstra(start);

        //최단 거리 출력
        System.out.print(dist[end]);

    }
}

