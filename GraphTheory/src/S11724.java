//백준 그래프이론 Q11724 연결 요소의 개수 (실버2)
// https://www.acmicpc.net/problem/11724

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S11724 {
    public static int[] parent;
    public static int findParent(int x){
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void union(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a > b) parent[a] = b;
        else parent[b] = a;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int u, v;

        parent = new int[n+1];

        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }


        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            if(findParent(u) != findParent(v)) {
                union(u, v);
            }
        }

        int result = 1;
        // 2부터 n까지 부모를 새로 업데이트 하여, 부모가 1인 것 count
        for(int i = 1; i <= n; i++){
            findParent(i);
        }

        Arrays.sort(parent);

        for(int i = 1; i < n; i++){
            if(parent[i] != parent[i+1]){
                result++;
            }
        }
        System.out.print(result);

    }
}