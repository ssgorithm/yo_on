//백준 DFS Q2667 단지번호붙이기 (실버1)
// https://www.acmicpc.net/problem/2667

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class S2667 {
    public static int N, result;
    public static int[][] map;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static boolean[][] visited;
    public static ArrayList<Integer> numList = new ArrayList<Integer>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        result = 0;
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        //bfs 실행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    bfs(i, j);
                    result++;
                }
            }
        }

        Collections.sort(numList);

        System.out.println(result);
        for(int i : numList){
            System.out.println(i);
        }
    }

    public static void bfs(int a, int b){
        int num = 1;
        Queue<Integer> xy = new LinkedList<>();
        xy.offer(a);
        xy.offer(b);
        visited[a][b] = true;
        while(!xy.isEmpty()){
            int x = xy.poll();
            int y = xy.poll();
            for(int d = 0; d < 4; d++){
                int mx = x + dx[d];
                int my = y + dy[d];

                if(mx < N && mx >= 0 && my >= 0 && my < N){
                    if(!visited[mx][my] && map[mx][my] == 1){
                        xy.offer(mx);
                        xy.offer(my);
                        visited[mx][my] = true;
                        num++;
                    }
                }
            }
        }
        numList.add(num);
    }
}
