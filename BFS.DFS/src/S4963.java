//백준 DFS Q4963 섬의 개수 (실버2)
// https://www.acmicpc.net/problem/4963

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S4963 {
    public static int w, h, result;
    public static int[][] map;
    public static boolean[][] visited;
    //대각선까지 확인하기 위해 4가지 방향 추가
    public static int[] dx = {1, 0, -1, 0, -1, 1, -1, 1};
    public static int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        //테스트 케이스 개수가 주어지지 않으므로 반복
        while(true){
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            result = 0;

            //종료코드
            if(w == 0 && h == 0) break;
            else {
                map = new int[w][h];
                visited = new boolean[w][h];

                //섬 정보 얻기
                for (int i = 0; i < w; i++) {
                    st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < h; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                //bfs 실행
                for (int i = 0; i < w; i++) {
                    for (int j = 0; j < h; j++) {
                        if (!visited[i][j] && map[i][j] == 1) {
                            bfs(i, j);
                            result++;
                        }
                    }
                }
                sb.append(result).append('\n');
            }
        }
        System.out.print(sb.toString());
    }

    public static void bfs(int a, int b){
        Queue<Integer> xy = new LinkedList<>();
        xy.offer(a);
        xy.offer(b);
        while(!xy.isEmpty()){
            int x = xy.poll();
            int y = xy.poll();
            for(int d = 0; d < 8; d++){
                int mx = x + dx[d];
                int my = y + dy[d];

                if(mx < w && mx >= 0 && my >= 0 && my < h){
                    if(!visited[mx][my] && map[x][y] == 1){
                        xy.offer(mx);
                        xy.offer(my);
                        visited[mx][my] = true;
                    }
                }
            }
        }
    }
}
