//백준 DFS Q1012 유기농 배추 (실버2)
// https://www.acmicpc.net/problem/1012

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1012 {
    //밭 크기(N x M), 배추 개수 K
    public static int N, M, K;
    //밭
    public static int[][] map;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //테스트 케이스 입력
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        //테스트 케이스 만큼 반복
        for(int t = 0; t < T; t++){
            //밭 크기, 배추 개수 입력받기
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];

            //각 배추의 위치 입력받아서 1 할당해주기
            for(int k = 0; k < K; k++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            //밭을 돌며 dfs 진행
            //true가 나오면 지렁이 개수 + 1
            int result = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(dfs(i,j) == true) result += 1;
                }
            }
            sb.append(result).append('\n');
        }
        System.out.print(sb.toString());
    }

    public static boolean dfs(int x, int y){
        //밭 범위를 벗어난다면 false
        if(x <= -1 || x >= N || y <= -1 || y >= M) return false;
        //배추가 있다면, 방문완료로 0으로 변경 후
        //상하좌우 dfs진행하고 true 반환
        if(map[x][y] == 1){
            map[x][y] = 0;
            dfs(x-1, y);
            dfs(x, y-1);
            dfs(x+1, y);
            dfs(x, y+1);
            return true;
        }
        return false;
    }

}
