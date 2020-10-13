package BfsDfs;

import java.util.*;

//📌📌 숨바꼭질, bfs 이용한 문제, 조건이 3개고 뭐가 일어날지 모른다? => if 문 3개로 나눠라!

public class HideandSeek_1697 {
    public static final int MAX = 100000;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] seek = new int[MAX]; //배열 생성

        for(int i=0; i<MAX; i++){
            seek[i] = -1; //k까지 처음에 time 초기화
            //k까지 하면 안되고! MAX 까지 모조리 해줘야 한다. 왜냐? 뒤로 갔다 앞으로 오는 경우도 있다
            //System.out.print(seek[i] + " ");
        }

        //bfs 이용하기
        Queue<Integer> subin = new LinkedList<Integer>();
        subin.add(n);
        seek[n] = 0; //수빈이 첫 위치 설정

        /* 1번째 while,if문 이용
        while(!subin.isEmpty()){
            int pos = subin.remove();
            //걷기
            if( pos-1 >=0 && seek[pos-1] == -1 ){
                subin.add(pos-1);
                seek[pos-1] = seek[pos]+1;
            }
            if( pos+1 < MAX && seek[pos+1]==-1){ //pos+1<=MAX 가 되면 런타임 에러
                subin.add(pos+1);
                seek[pos+1] = seek[pos]+1;
            }
            //순간이동
            if( pos*2 < MAX && seek[pos*2]==-1){
                subin.add(pos*2);
                seek[pos*2] = seek[pos]+1;
            }
            if(seek[k] != -1){
                break;
            }
        }

         */
        //2번째 for문 이용 => 메모리 더 많이 사용 되네 왜지?
        while(!subin.isEmpty()) {
            int pos = subin.remove();
            for (int next : new int[]{pos * 2, pos - 1, pos + 1}) {
                if (next >= 0 && next < MAX && seek[next] == -1) {
                    subin.add(next);
                    seek[next] = seek[pos] + 1;
                }
            }
        }

        System.out.println(seek[k]);
    }
}
