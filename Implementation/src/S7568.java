//백준 구현 Q7568 덩치 (실버5)
//https://www.acmicpc.net/problem/7568

import java.io.*;
import java.util.*;

class Person{
    int w;
    int h;
    int r;

    public Person(int w, int h){
        this.w = w;
        this.h = h;
        this.r = 1;
    }
}

public class S7568 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Person> people = new ArrayList<Person>();
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            people.add(new Person(w, h));
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            Person p1 = people.get(i);
            for(int j = 0; j < n; j++){
                Person p2 = people.get(j);

                if(p1.w < p2.w && p1.h < p2.h){
                    p1.r+=1;
                }
            }
            sb.append(p1.r).append(" ");
        }
        System.out.print(sb.toString());
    }
}