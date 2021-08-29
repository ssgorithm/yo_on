//백준 구현 Q2947 나무조각 (실버5)
//https://www.acmicpc.net/problem/2947

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2947 {
    public static int[] arr = new int[5];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 5; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        while(true){
            sorting();
            if(check()) break;
        }
    }
    public static void sorting(){
        for(int i = 0; i < 4; i++){
            if(arr[i] > arr[i+1]){
                swap(arr[i], arr[i+1], i);
                print();
                if(check()) break;
            }
        }
    }

    public static void swap(int a, int b, int i){
        //int temp = a;
        arr[i] = b;
        arr[i+1] = a;
    }

    public static void print(){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static boolean check(){
        String temp = "";
        for(int i : arr){
            temp += i;
        }
        if(temp.equals("12345")) return true;
        else return false;
    }
}
