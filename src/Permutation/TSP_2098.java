package Permutation;
//답이 이상하게 나옴
import java.util.*;

public class TSP_2098 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] w = new int[n][n];
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w[i][j] = sc.nextInt();
            }
            num[i] = i;
        }

        Arrays.sort(num);

        int ans = 0;

        while (nxt_permutation(num, n)) {
            ans = TSP(num, n, w);
        }
        System.out.println(ans);

    }

    public static int TSP(int[] num, int n, int[][] w) {
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int i = 0;
        for (; i < n-1; i++) {
            if (w[num[i]][num[i + 1]] == 0){
                return Integer.MAX_VALUE;
            }
            else {
                sum += w[num[i]][num[i + 1]];
            }
        }
        if (w[num[i]][num[0]] == 0){
            return Integer.MAX_VALUE;
        }
        else{
            sum += w[num[i]][num[0]];
        }

        ans = Math.min(ans, sum);
        return ans;
    }

    public static boolean nxt_permutation(int[] num, int n) {
        int temp;
        int i = n - 1;
        for(; i>0; i--){ //뒤에서부터 내려오면서 i-1보다 i 값이 큰 위치 찾기
            if(num[i-1]<num[i]){
                break;
            }
        }
        if (i <= 0) {
            return false; //마지막까지 돌았을 때도 i-1보다 i값이 큰 위치가 없다면 이건 마지막 순열
        }
        for (int j=n-1; j >= i; j--) {
            if (num[j] > num[i - 1]) {
                temp = num[j];
                num[j] = num[i - 1];
                num[i - 1] = temp;
                break;
            }
        }

        for (int j = n - 1; j > i; j--) {
            temp = num[j];
            num[j] = num[i];
            num[i] = temp;
            i++;
        }
        return true;
    }

}


