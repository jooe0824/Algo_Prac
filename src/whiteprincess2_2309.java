import java.util.*;
public class whiteprincess2_2309 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = 9;
        int[] a = new int[n];
        int sum = 0;
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }
        Arrays.sort(a);
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (sum - a[i] - a[j] == 100) {
                    a[i] = 0;
                    a[j] = 0;
                }
            }
        }
        for(int k =0; k<n; k++){
            if(a[k] != 0){
            System.out.println(a[k]);
            }
        }
    }
}