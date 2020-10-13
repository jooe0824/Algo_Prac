package Math;

import java.util.Scanner;

public class Gcd_2609 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int max = gcd(a,b);
        int min = a * b / max;
        System.out.println(max);
        System.out.println(min);
    }

    public static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        else{
            return gcd(b,a%b);
        }
    }
}
