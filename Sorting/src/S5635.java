//백준 정렬 Q5635 생일 (실버5)
//https://www.acmicpc.net/problem/5635

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S5635 {
    static class Student{
        String name;
        int birth;

        public Student(String name, int birth){
            this.name = name;
            this.birth = birth;
        }
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Student> students = new ArrayList<Student>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String dd = st.nextToken();
            String mm = st.nextToken();
            String yyyy = st.nextToken();
            if(dd.length() == 1) dd = '0' + dd;
            if(mm.length() == 1) mm = '0' + mm;
            students.add(new Student(name, Integer.parseInt(yyyy+mm+dd)));
        }

        Collections.sort(students, (a, b) -> b.birth - a.birth);
        System.out.println(students.get(0).name);
        System.out.print(students.get(n-1).name);
    }
}
