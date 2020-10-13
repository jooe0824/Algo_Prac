package Greedy;

import java.util.*;

//문제 이해가 잘 안되었던 ..
public class Sensor_2212 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] sensor = new int[N];
        for(int i=0; i<N; i++){
            sensor[i] = sc.nextInt();
        }

        Arrays.sort(sensor); //오름차순 정렬
        for(int i=0; i<N-1;i++){
            sensor[i] = sensor[i+1]-sensor[i];
            //거리를 전자에다 저장, 따로 배열 만들지 않게 하려고 => 메모리 아끼기
        }

        int ans = 0;
        Arrays.sort(sensor); //오름차순 정렬
        for(int i =0; i<N-K; i++){
            ans += sensor[i];
        }
        System.out.println(ans);
    }
}
