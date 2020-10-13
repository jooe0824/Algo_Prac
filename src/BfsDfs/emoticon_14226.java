package BfsDfs;

import java.util.*;

//📌📌 이모티콘, bfs 이용한 문제, 조건이 3개고 뭐가 일어날지 모른다? => if 문 3개로 나눠라!
public class emoticon_14226 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int ans = -1;

        Queue<Integer> emo = new LinkedList<Integer>();
        int[][] time = new int[S+1][S+1];

        for(int i=0; i<=S; i++){ //i<S가 아니고 i<=S
            Arrays.fill(time[i],-1); //time은 모두 -1로 초기화
        }

        emo.add(1);
        emo.add(0); //첫 시작 큐에 넣기
        time[1][0] = 0;

        while(!emo.isEmpty()){
            int s = emo.remove(); //화면
            int c = emo.remove(); //클립보드

            //복사
            if( s<=S && time[s][s] == -1 ){ //s<=S라는 조건이 앞으로 가야된다
                time[s][s] = time[s][c] + 1;
                emo.add(s);
                emo.add(s);
            }

            //붙여넣기
            if( s+c<=S && time[s+c][c] == -1 ){ //s+c<=S 조건이 앞으로
                time[s+c][c] = time[s][c] + 1;
                emo.add(s+c);
                emo.add(c);
            }

            //삭제
            if( s-1>=0 && time[s-1][c] == -1 ){ //s-1>=0 조건이 앞으로
                //조건이 앞으로 가야지 뒤에가 성립된다. 조건이 뒤로 가버리면 time[-1]음수인덱스가 들어가버린다.
                time[s-1][c] = time[s][c] + 1;
                emo.add(s-1);
                emo.add(c);
            }
        }

        for(int i=0; i<=S; i++){ //i<S가 아니고 i<=S
            if(time[S][i] != -1) {
                if (ans == -1 || ans > time[S][i]) {
                    ans = time[S][i];
                }
            }
        }

        System.out.println(ans);
    }
}
