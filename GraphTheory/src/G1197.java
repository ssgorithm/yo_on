//백준 그래프이론 Q1197 최소 스패닝 트리 (골드4)
//https://www.acmicpc.net/problem/1197

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//간선 클래스 생성
//a, b : 간선 끝의 노드 두 개
//cost : 가중치
class Edge implements Comparable<Edge>{
    int a;
    int b;
    int cost;

    public Edge(int a, int b, int cost){
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    public int getA() {return a;}
    public int getB() {return b;}
    public int getCost() {return cost;}

    @Override
    public int compareTo(Edge o){
        if(this.cost < o.cost) return -1;
        return 1;
    }
}

public class G1197 {
    public static int V, E;
    public static int[] parent = new int[10001];
    public static ArrayList<Edge> edges = new ArrayList<>();

    //루트 노드 찾아주는 함수
    //경로 압축 코드를 통해 부모 테이블에 각 노드의 루트 노드를 저장
    public static int findParent(int x){
        if(parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }

    //두 접점이 속한 집합 합치는 연산
    public static void union(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String args[]) throws IOException{
        boolean cycle = false;
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();

        //부모 테이블 초기화
        for(int i = 1; i <= V; i++) parent[i] = i;

        //노드와 비용 입력 받기
        for(int i = 0; i < E; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges.add(new Edge(a,b,c));
        }

        //간선 가중치 순으로 정렬
        Collections.sort(edges);

        int result = 0;

        for(Edge edge : edges){
            int cost = edge.getCost();
            int a = edge.getA();
            int b = edge.getB();

            //사이클이 발생하지 않는 경우 union을 통해 최소신장트리에 포함
            if(findParent(a) != findParent(b)){
                union(a,b);
                result += cost;
            }
        }
        System.out.print(result);
    }
}
