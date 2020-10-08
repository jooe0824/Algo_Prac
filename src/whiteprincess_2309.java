import java.util.*;

public class whiteprincess_2309 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int n = 9;
        int[] nan = new int[n];
        for(int i=0; i<n; i++){
            nan[i] = sc.nextInt();
            sum += nan[i];
        }//난쟁이 키 더하기
        Arrays.sort(nan);
        //System.out.println("nan");
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (sum - nan[i] - nan[j] == 100) {
//                    for (int k=0; k<n; k++) {
//                        if (i == k || j == k) continue;
//                        System.out.println(nan[k]);
//                    }
//                    System.exit(0);
                    nan[i] = 0;
                    System.out.println("nan[i]"+nan[i]);
                    nan[j] = 0;
                }
            }
        }
        for(int k =0; k<n; k++){
//            if(nan[k] != 0){
                System.out.println(nan[k]);
//            }
        }
    }
}
