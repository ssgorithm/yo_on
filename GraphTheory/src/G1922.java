//백준 그래프이론 Q1922 네트워크 연결 (골드4)
// https://www.acmicpc.net/problem/1922

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class G1922 {
    public static int N, M;
    public static int[] parent = new int[1001];
    public static ArrayList<Dist> dists = new ArrayList<>();

    public static int findParent(int x){
        if(x == parent[x]) return x;
        else return findParent(parent[x]);
    }

    public static void union(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int sum = 0;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        //정보 입력받기
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dists.add(new Dist(a,b,c));
        }

        //부모 테이블 초기화
        for(int i = 0; i < N+1; i++){
            parent[i] = i;
        }

        //거리 낮은 순으로 정렬
        Collections.sort(dists);

        //만약 싸이클을 이룬다면 즉, 이미 연결되어 있다면 skip
        //연결되어 있지 않다면 값에 포함시킨 후 연결처리(union)
        for(Dist d : dists) {
            int a = d.a;
            int b = d.b;
            int c = d.distance;

            if(findParent(a) != findParent(b)){
                union(a, b);
                sum += c;
            }
        }

        System.out.print(sum);
    }
}
