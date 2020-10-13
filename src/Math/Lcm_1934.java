package Math;

import java.util.Scanner;

public class Lcm_1934 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0;i<num; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int max = gcd(a,b);
            int min = a * b / max;
            System.out.println(min);
        }
    }
    public static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        else{
            return gcd(b, a%b);
        }
    }
}
