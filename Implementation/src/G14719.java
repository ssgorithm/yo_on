//백준 구현 Q14719 빗물 (골드5)
//https://www.acmicpc.net/problem/14719

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class G14719{
    public static void main(String args[]) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String HW = reader.readLine();
        int W = Integer.parseInt(HW.split(" ")[1]);
        int sum = 0;
        int i = 0;


        String wall = reader.readLine();
        int walls[] = new int[W];
        for(i = 0; i < W; i++) {
            walls[i] = Integer.parseInt(wall.split(" ")[i]);
        }

        for(i = 1; i < W-1; i++){
            if(Math.min(leftMax(walls, i), rightMax(walls, i)) >= walls[i] ){
                sum += Math.min(leftMax(walls, i), rightMax(walls, i)) - walls[i];
            }
        }

        System.out.println(sum);
    }

    public static int leftMax(int[] walls,int num){
        int max = 0;
        for(int i = 0; i < num; i++){
            if(max < walls[i]){
                max = walls[i];
            }
        }
        return max;
    }

    public static int rightMax(int[] walls, int num){
        int max = 0;
        for(int i = num+1; i < walls.length; i++){
            if(max < walls[i]){
                max = walls[i];
            }
        }
        return max;
    }
}