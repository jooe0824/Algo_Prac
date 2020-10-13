package Permutation;

import java.util.*;
//1을 아예 고정시켜주어도 된다

public class TSPprac {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int[][] weight = new int[n][n];
        int ans = Integer.MAX_VALUE; //min을 구해야 되므로 max로 초기ㅣ화

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                weight[i][j] = sc.nextInt();
            }
            num[i] = i;
        }

        Arrays.sort(num); //정렬하고 시작


        while(nxt_permutation(n,num)){ //다음 순열 있는 동안 진행, true인 동안
            int sum = TSP(n,num,weight);
            ans = Math.min(ans, sum); //이전 값과 비교하여 최솟값 도출
//            for(int i =0; i<n;i++){
//                System.out.print(num[i]+", ");
//            }
//            System.out.println("sum = "+sum);
        }
        System.out.println(ans);
    }

    public static int TSP(int n, int[] num, int[][] weight){ //외판원
        int sum = 0;

        for(int i=0;i<n-1;i++){
            if(weight[num[i]][num[i+1]] == 0){ //가는 길이 없다면 sum 구하면 안된다
                return Integer.MAX_VALUE;
            }
            sum += weight[num[i]][num[i+1]];
//            System.out.println(i+", "+weight[num[i]][num[i+1]]);
        }
        if(weight[num[n-1]][num[0]] == 0){ //다시 나에게로 가는 길이 없다면 sum 구하면 안된다
            return Integer.MAX_VALUE;
        }
        sum += weight[num[n-1]][num[0]];
//        System.out.println(weight[num[n-1]][0]);
        return sum;
    }

    public static boolean nxt_permutation(int n, int[] num){
        int i = n-1;
        int temp;
        for(;i>0;i--){
            if(num[i-1]<num[i]){ //뒤에서 내려오면서 확인
                break;
            }
        }

        if(i<=0){
            return false; //마지막까지 돌았을 때도 i-1보다 i값이 큰 위치가 없다면 이건 마지막 순열
        }

        for(int j=n-1;j>=0;j--){ //다음 순열로 바꿔주기 위해 swap
            if(num[j]>num[i-1]){
                temp = num[i-1];
                num[i-1] = num[j];
                num[j] = temp;
                break;
            }
        }

        for(int j=n-1;j>i;j--){ //바꿔준 후 i뒤는 다시 오름차순이 되어야 함
            temp = num[j];
            num[j] = num[i];
            num[i] = temp;
            i++;
            j--;
        }
        //nxt 순열 도출되었음
        return true;
    }

}
