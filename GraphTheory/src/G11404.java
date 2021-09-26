//백준 그래프이론 Q11404 플로이드 (골드4)
// https://www.acmicpc.net/problem/11404

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G11404 {
    public static final int INF = (int)1e9;
    //도시 개수와 버스 개수
    public static int n, m;
    //노선 정보 입력할 그래프
    public static int[][] graph = new int[101][101];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        Arrays.stream(graph).forEach((int[] line) -> Arrays.fill(line, INF));

        for(int i  = 1; i <= n; i++){
            for(int j  = 1; j <= n; j++){
                if(i==j) graph[i][j] = 0;
            }
        }

        for(int i  = 0 ; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            //노선이 하나가 아닐 수 있으므로 최소 값을 입력 받기
            if(graph[a][b] > c) graph[a][b] = c;
        }

        //플로이드 워셜 알고리즘 사용
        //a->b 비용과 a->k->b 비용 비교하여 최소 비용 구하기
        for(int k = 1; k <= n; k++){
            for(int a = 1; a <= n; a++){
                for(int b = 1; b <=n; b++){
                    graph[a][b] = Math.min(graph[a][b] , graph[a][k] + graph[k][b]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                sb.append(graph[i][j] == INF ? 0 : graph[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());

    }
}
