//백준 정렬 Q1427 소트인사이드 (실버5)
//https://www.acmicpc.net/problem/1427

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class S1427 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] temp = br.readLine().toCharArray();
        int size = temp.length;
        Integer[] arr = new Integer[size];
        for(int i = 0; i < temp.length; i++){
            arr[i] = temp[i] - '0';
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for(int i : arr){
            System.out.print(i);
        }
    }
}
