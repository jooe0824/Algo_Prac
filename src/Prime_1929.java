import java.util.Scanner;

public class Prime_1929 {

    public static boolean is_prime(int n){
        if(n<=1){
            return false;
        }
        else if(n==2){
            return true;
        }
        for(int i = 2; i*i <=n; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        boolean[] prime = new boolean[n+1];

        for(int i=m ; i<=n; i++){
            if(is_prime(i)){
                prime[i] = is_prime(i);
            }
        }
        for(int i=m; i<=n; i++){
            if(prime[i] == true){
                System.out.println(i);
            }
        }
    }
}

