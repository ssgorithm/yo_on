//백준 BFS Q2178 미로 탐색 (실버1)
//https://www.acmicpc.net/problem/2178

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    private int x;
    private int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() { return this.x; }

    public int getY() { return this.y; }
}

public class S2178{
    //미로 크기 n x m
    public static int n, m;
    //미로
    public static int[][] maze = new int[101][101];

    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));

        //큐가 빌 때까지 반복
        while(!q.isEmpty()){
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            //상하좌우 확인
            for(int d = 0; d < 4; d++){
                int mx = x + dx[d];
                int my = y + dy[d];
                // 미로 벗어난 경우 무시
                if (mx < 0 || mx >= n || my < 0 || my >= m) continue;
                // 벽인 경우 무시
                if (maze[mx][my] == 0) continue;
                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if (maze[mx][my] == 1) {
                    maze[mx][my] = maze[x][y] + 1;
                    q.offer(new Node(mx, my));
                }
            }

        }
        return maze[n - 1][m - 1];
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //n, m 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        //크기 입력 받은 후 개행 제거 (버퍼 지우기)
        sc.nextLine();

        //미로 정보 입력 받기
        for(int i = 0; i < n; i++){
            String str = sc.nextLine();
            for(int j = 0; j < m; j++){
                maze[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.print(bfs(0,0));
    }
}