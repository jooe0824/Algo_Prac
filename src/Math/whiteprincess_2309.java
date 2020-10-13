package Math;

import java.util.*;

public class whiteprincess_2309 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = 9;
        int[] a = new int[n];
        int sum = 0;

        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        } //전체 키의 합

        Arrays.sort(a);//키 오름차순 정렬

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (sum - a[i] - a[j] == 100) { //2명 빼서 100이 되는 경우
                    a[i] = -1;
                    a[j] = -1;
                    for(int k =0; k<n; k++){
                        if(a[k] > 0){
                            System.out.println(a[k]);
                        }
                    }
                    System.exit(0);
                }
            }
        }
    }
}