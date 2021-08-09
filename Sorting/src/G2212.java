//백준 정렬 Q2212 센서 (골드5)
//https://www.acmicpc.net/problem/2212

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        if(k >= n) {
            System.out.print(0);
            return;
        }

        int sum = 0;

        int[] sensor = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            sensor[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(sensor);

        Integer[] distance = new Integer[n-1];
        for(int i = 0; i < n-1; i++)
            distance[i] = sensor[i+1] - sensor[i];

        Arrays.sort(distance, Collections.reverseOrder());

        for(int i = k-1; i < n-1; i++) {
            sum += distance[i];
        }
        System.out.println(sum);
    }
}

