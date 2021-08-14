//백준 BFS Q10026 적록색약 (골드5)
// https://www.acmicpc.net/problem/10026

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G10026 {
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static char[][] map;
    public static boolean[][] visited;
    public static int N;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = 0, num2 = 0;
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        //정보 입력받기
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = line.charAt(j);
            }
        }

        //정상 테스트
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    bfs(i, j);
                    num1++;
                }
            }
        }

        //적록색약이 보이는 그림으로 변경
        map = change(map);
        //visited 재 초기화
        visited = new boolean[N][N];

        //색약 테스트
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    bfs(i, j);
                    num2++;
                }
            }
        }

        System.out.print(num1 + " " + num2);

    }

    //Green 색인 것을 Red 색으로 변경
    public static char[][] change(char[][] map){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 'G') map[i][j] = 'R';
            }
        }
        return map;
    }

    //상하좌우를 확인하며 같은 색이고, 방문하지 않은 곳을 추가
    public static void bfs(int x, int y){
        Queue<Integer> xy = new LinkedList<>();
        xy.offer(x);
        xy.offer(y);
        visited[x][y] = true;
        while(!xy.isEmpty()){
            int cx = xy.poll();
            int cy = xy.poll();
            for(int d = 0; d < 4; d++){
                int mx = cx + dx[d];
                int my = cy + dy[d];
                if(mx >= 0 && mx < N && my >= 0 && my < N) {
                    if (map[mx][my] == map[cx][cy] && !visited[mx][my]) {
                        xy.offer(mx);
                        xy.offer(my);
                        visited[mx][my] = true;
                    }
                }
            }

        }
    }
}
