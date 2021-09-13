//백준 그래프이론 Q9372 상근이의 여행 (실버4)
// https://www.acmicpc.net/problem/9372

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S9372{
    static int N,M,result;
    static int[][] map;
    static boolean[] visit;
    public static void main(String args[]) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(reader.readLine());
        for(int i = 0; i < testcase; i++){
            StringTokenizer temp = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(temp.nextToken());
            M = Integer.parseInt(temp.nextToken());

            result = 0;
            map = new int[N][N];
            visit = new boolean[N];

            for(int j = 0; j < M; j++){
                temp = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(temp.nextToken()) - 1;
                int y = Integer.parseInt(temp.nextToken()) - 1;
                map[x][y] = 1;
                map[y][x] = 1;
            }
            System.out.println(N-1);
        }
    }
}
