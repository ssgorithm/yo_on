//백준 이분 탐색 Q10815 숫자카드 (실버4)
//https://www.acmicpc.net/problem/10815

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S10815 {
    static int n, m;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 이분 탐색을 해서 해당 숫자가 있는 경우
            if(binarySearch(num)) sb.append("1 ");
                // 이분 탐색을 해서 해당 숫자가 없는 경우
            else sb.append("0 ");
        }
        System.out.print(sb.toString());
    }
    private static boolean binarySearch(int num) { 
        int leftIndex = 0;
        int rightIndex = n - 1;

        while(leftIndex <= rightIndex){
            int midIndex = (leftIndex + rightIndex) / 2;
            int mid = arr[midIndex];

            if(num < mid) rightIndex = midIndex - 1;
            else if(num > mid) leftIndex = midIndex + 1;
            else return true;
        }
        return false;
    }
}