//백준 이분 탐색 Q2417 정수 제곱근 (실버5)
//https://www.acmicpc.net/problem/2417

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2417 {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        System.out.print(binarySearch(n));
    }

    public static long binarySearch(long n){
        if((long)Math.sqrt(n) >= n)
            return (long)Math.sqrt(n);
        else
            return (long)Math.sqrt(n)+1;
    }
}