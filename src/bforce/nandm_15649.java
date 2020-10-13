package bforce;

import java.util.*;

public class nandm_15649 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int M = sc.nextInt();

        int[]num = new int[M];

        nandm(0, num, 1, N, M);

    }
    public static void nandm(int location, int num[], int index, int n, int m){
        boolean[] check = new boolean[n];
        for(int i=index; i<=n; i++){
            for(int j=0;j<m;j++){
                if(!check[index-1] ) {
                    check[index - 1] = true;
                    num[location] = i;
                    System.out.print(num[location]);
                    location++;
                    nandm(location, num, num[location - 1] + 1, n,m); //재귀 이용
                    System.out.println();
                }
            }
        }
    }
}
