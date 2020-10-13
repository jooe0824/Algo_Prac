package Math;

import java.util.Scanner;

public class sumGcd_9613 {
    public static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        else{
            return gcd(b, a%b);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(num);
        //테스트 케이스 수
        while(num-- >0){
            int n = sc.nextInt();
            int[] a = new int[n];
            System.out.println(n);
            //수의 갯수
            for(int j=0; j<n; j++){
                a[j] = sc.nextInt();
               //수 배열에 넣기
            }
            long sum = 0;
            for(int i =0; i<n-1;i++){
                for(int j=i+1;j<n;j++){
                    sum += gcd(a[i],a[j]);
                }
            }
            System.out.println(sum);
        }
    }
}
