package DP;

import java.util.*;
/*n을 1로 만드는 최소 연산 D[n]
나누기 3 : D[n/3] + 1 번
나누기 2 : D[n/2] + 1 번
-1 : D[n-1] + 1 번
D[n] = min(D[n/3], D[n/2], D[n-1]) + 1 */
//점화식 만들어라 ..
public class Makeone_1463 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];

        int cnt = makeone(n, d);

        System.out.println(cnt);
    }
    public static int makeone(int n, int[] d){ //top-down 방식
        if( n == 1 ) {
            return 0;
        }
        if(d[n] > 0){
            return d[n];
        }

        d[n] = makeone(n-1, d) + 1;

        if (n % 3 == 0) {
            int temp = makeone(n/3, d) + 1;
            System.out.println(n);
            if(temp < d[n]) {
                d[n] = temp;
            }
        }
        if (n % 2 == 0) {
            int temp = makeone(n/2, d) + 1;
            System.out.println(n);
            if(temp < d[n]) {
                d[n] = temp;
            }
        }

        return d[n];
    }
}
