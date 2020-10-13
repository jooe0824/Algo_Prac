package BfsDfs;

import java.util.*;

//📌📌 가중치가 0 또는 1로 나눠질 때는 큐를 두개 이상 사용하거나 Deque를 사용해라 (Deque 추천)

public class HideandSeekwithDeque_13549 {
    public static final int MAX = 1000000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] seek = new int[MAX]; //배열 생성
        for(int i=0; i<MAX; i++){
            seek[i] = -1; //-1로 time 초기화
        }
        seek[n] = 0;

        //Queue대신 DEQ를 이용
        ArrayDeque<Integer> subin = new ArrayDeque<Integer>();
        subin.add(n); //수빈 초기 위치 덱에 넣어주기

        while(!subin.isEmpty()){
            int pos = subin.poll(); //poll이란 가장 먼저 넣은 원소 빼기
            for(int next : new int[]{pos*2, pos-1, pos+1}){ //3가지 경우 돌림
                if(next >=0 && next<MAX){ //배열 넘어가면 안됨
                    if(seek[next] == -1){ //방문 이력 없는 곳
                        if( next == pos*2 ){ //순간이동
                            seek[next] = seek[pos]; //0초니까 시간 추가 없다
                            subin.addFirst(next);
                        }else{ //걷기
                            seek[next] = seek[pos] + 1; //1초 걸림
                            subin.addLast(next);
                        }
                    }
                }
            }
        }
        System.out.println(seek[k]);
    }
}
