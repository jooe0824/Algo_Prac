import java.util.Scanner;

public class Prime_1978 {
    public static boolean prime(int n){
        if(n<=1){
            return false;
        }
        else if(n==2){
            return true;
        }
        for (int i=2; i*i <=n; i++){
            if ((n%i)==0){
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;
        while(num-- >0){
            if(prime(sc.nextInt())){
                sum += 1;
            }
        }
        System.out.println(sum);
    }


}
