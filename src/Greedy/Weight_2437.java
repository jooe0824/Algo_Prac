package Greedy;

import java.util.*;

//Greedy algorithm 이용

public class Weight_2437 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];
        int seq = 1;
        int ans;

        for(int i=0;i<N;i++) {
            num[i] = sc.nextInt();
            //System.out.println(num[i]);
        }

        Arrays.sort(num); //정렬해주기

        while( seq <= num[N-1] *2 ){ //답 나오지 않을 동안 반복

            ans = seq; //seq를 저장해놓기 위함
            for(int j=N-1; j>=0; j--){ //배열 돌 동안에, 큰 수부터 담아야 하니까

                if(num[j]<=ans) { //수보다 작으면
                    ans -= num[j]; //그 숫자만큼 ans에서 제외
                    if (ans == 0) {
                        break; //바로빠져나가야 무의미한 탐색 안하게 됨
                    }
                }
            }
            if(ans !=0){
                break;
            }
            seq++;
        }
        System.out.println(seq);
    }
}
/*누적합 개념 사용
        int sum = 0;
        for (int i = 1; i < list.length; ++i) {
            if (sum + 1 < list[i]) {
                break;
            }
            sum += list[i];
        }
        System.out.println(sum + 1);
 */
