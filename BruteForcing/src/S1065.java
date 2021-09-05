//백준 정렬 Q1065 한수 (실버4)
//https://www.acmicpc.net/problem/1065

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class S1065 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int answer;
        if(X < 100){
            answer = X;
        }else{
            answer = 99;
            for(int i = 100; i <= X; i++){
                if(check(i)) answer++;
            }
        }
        System.out.print(answer);
    }
    public static boolean check(int i){
        ArrayList<Integer> num = new ArrayList<Integer>();
        while(i > 0){
            num.add(i%10);
            i = i / 10;
        }
        int diff = num.get(0)-num.get(1);
        for(int n = 0; n < num.size()-1; n++){
            if(num.get(n)-num.get(n+1)!=diff) return false;
        }
        return true;
    }
}
