import java.util.Arrays;
import java.util.Scanner;

public class Tsp_10971 {
    private static boolean check = true;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] W = new int[n][n];
        int[] per = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                W[i][j] = sc.nextInt(); //비용 저장
            }
            per[i] = i;
        }
        Arrays.sort(per); //sort해놓고 시작

        int ans = Integer.MAX_VALUE; //가장 큰 값 저장 해놓기

        while (nxt_permutation(per, n)) { //다음 순열 있을 때 동안 진행
            int sum = TSP(W, per, n);
            if(check){
                ans = Math.min(ans, sum);
                for(int i =0; i<n;i++){
                    System.out.print(per[i]+", ");
                }
                System.out.println("sum = "+sum);
            }
        }

        System.out.println(ans);
    }

    public static int TSP(int W[][], int per[], int n){
        int sum = 0;
        int i = 0;
        for(; i<n-1 ;i++) {
            if(W[per[i]][per[i+1]]==0){ //W[i][i+1]이 아니라 W[per[i]][per[i+1]!!
                check = false;
                return Integer.MAX_VALUE;
            }else {
                sum += W[per[i]][per[i + 1]];
            }
        }
        if(W[per[i]][per[0]]==0){
            check = false;
        }else{
            sum+=W[per[i]][per[0]];
        }
        return sum; //거리 비용 더한 다시 본래 도시로 돌아오는 것까지 더해주기
    }

    public static boolean nxt_permutation(int per[], int num){
//        if(per[0]!=1){
//            return false;
//        } //첫 도시를 1로 fix를 해버려도 된다. 시간이 훨씬 덜 걸린
        int i= num-1;
        int temp; //swap 위해서
        for(; i>0; i--){ //뒤에서부터 내려오면서 i-1보다 i 값이 큰 위치 찾기
            if(per[i-1]<per[i]){
                break;
            }
        }
        if(i<=0){
            return false; //마지막까지 돌았을 때도 i-1보다 i값이 큰 위치가 없다면 이건 마지막 순열
        }
        for(int j=num-1; j>=i; j--){
            if(per[i-1]<per[j]){//i부터 내림차순으로 되어 있으니 맨 오른쪽부터 올라오며 i-1보다 작은 값 찾기
                temp = per[i-1];
                per[i-1] = per[j];
                per[j] = temp;
                break; //i와 j swqp
            }
        }
        int j = num-1;
        while(i<j){
            temp = per[i];
            per[i] = per[j];
            per[j] = temp;
            i++;
            j--; //i부터 맨 뒤까지 뒤집어주기 => 올림 차순이 되어야 하므로
        }
        return true;
    }
}
