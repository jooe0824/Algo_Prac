package DP;
//동적 프로그래밍 이용 10까지니까 그냥 아예 배열 만들어주는게 빠르다

import java.util.Scanner;

public class  Plusonetwothree_9095 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        int[] ans = new int[12];
        ans[0] = 1;
        ans[1] = 1;
        ans[2] = 2;

        for ( int j = 3; j <= 11; j++) {
            ans[j] = ans[j - 1] + ans[j - 2] + ans[j - 3];
        }

        while(test-- > 0) { //testcase 있을 동안
            int input = sc.nextInt();
            System.out.println(ans[input]);
        }
    }
}
