//백준 정렬 Q1377 버블소트 (골드3)
//https://www.acmicpc.net/problem/1377

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Point implements Comparable<Point> {
    int num;
    int index;

    Point(int num, int index) {
        this.num = num;
        this.index = index;
    }

    @Override
    public int compareTo(Point o) {
        return num - o.num;
    }

}

public class G1377 {
    public static int[] arr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N + 1];

        for (int i = 1; i <= N; i++) {
            int temp = Integer.parseInt(br.readLine());
            points[i] = new Point(temp, i);
        }
        Arrays.sort(points, 1, N + 1);

        int max = 0;
        //해당 숫자의 인덱스가 몇 칸 움직였는지 계산(출처:https://steady-coding.tistory.com/41)
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, points[i].index - i);
        }
        System.out.print(max+1);
    }
}
