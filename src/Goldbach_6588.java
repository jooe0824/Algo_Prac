import java.util.ArrayList;
import java.util.Scanner;

public class Goldbach_6588 {
    public static final int MAX = 100000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean[] check = new boolean[MAX+1];
        ArrayList<Integer> prime = new ArrayList<Integer>();
        check[0] = check[1] = true; //소수면 false, 소수가 아니면 true
        for(int i=2; i*i <= MAX ; i++){
            if(check[i] == true){
                continue;
            }
            prime.add(i); //check[] == false 면 추가
            for (int j=i+i; j<=MAX; j+=i) {
                check[j] = true;
            }
        }
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break; //0입력하면 끝
            }
            for (int i = 1; i < prime.size(); i++) {
                int p = prime.get(i);
                if (check[n - p] == false) {
                    System.out.println(n + " = " + p + " + " + (n - p));
                    break;
                }
            }
        }
    }
}
