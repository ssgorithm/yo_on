//백준 정렬 Q10825 국영수 (실버 4)
//https://www.acmicpc.net/problem/10825

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//학생 이름, 국, 영, 수 점수
class Students implements Comparable<Students>{
    String name;
    int korean;
    int english;
    int math;

    public Students(String name, int korean, int english, int math){
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    @Override
    public int compareTo(Students o) {
        //모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로
        if(this.english == o.english && this.math == o.math && this.korean == o.korean) return this.name.compareTo(o.name);
            //국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
        else if(this.korean == o.korean && this.english == o.english) return this.math > o.math ? -1 : 1;
            //국어 점수가 같으면 영어 점수가 증가하는 순서로
        else if(this.korean == o.korean) return this.english > o.english ? 1 : -1;
            //국어 점수가 감소하는 순서로
        else return this.korean > o.korean ? -1 : 1;
    }
}
public class S10825 {
    public static void main(String args[]) throws IOException {
        ArrayList<Students> students = new ArrayList<Students>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students.add(new Students(name,korean,english,math));
        }
        Collections.sort(students);
        for(Students s : students){
            sb.append(s.name).append('\n');
        }
        System.out.print(sb.toString());
    }
}