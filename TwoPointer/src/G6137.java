//백준 투포인터 Q6137 문자열 생성 (골드4)
// https://www.acmicpc.net/problem/6137

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class G6137 {
    public static int N;
    public static List<Character> list = new ArrayList<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //개수 입력받기
        N = Integer.parseInt(br.readLine());
        char[] arr = new char[N];

        //단어 입력받기
        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine().charAt(0);
        }

        //문자열 생성
        stringCreate(arr);
        //80글자마다 개행 추가
        for(int i = 0; i < list.size(); i++){
            if (i != 0 && i % 80 == 0) System.out.println();
            System.out.print(list.get(i));
        }

    }

    public static void stringCreate(char[] arr) {
        int start = 0;
        int end = N - 1;

        //글자가 사전순으로 작은거 부터 붙이기
        while (start <= end) {
            if (arr[start] > arr[end]) {
                list.add(arr[end--]);
            } else if (arr[start] < arr[end]) {
                list.add(arr[start++]);
            //만약 같다면 각각 앞의 단어를 보고 결정
            } else {
                int start1 = start + 1;
                int end1 = end - 1;
                int size = list.size();
                //그 전의 단어도 같을 수 있으니 while문으로 다시 확인
                while (start1 <= end1) {
                    if (arr[start1] < arr[end1]) {
                        list.add(arr[start++]);
                        break;
                    } else if (arr[start1] > arr[end1]) {
                        list.add(arr[end--]);
                        break;
                    } else start1++;
                    end1--;
                }
                //만약 계속 같다면 start 추가
                if (size == list.size()) list.add(arr[start++]);
            }
        }
    }
}

