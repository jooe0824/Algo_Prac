package Search;

import java.util.Scanner;

public class Sequential {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pos = 0;
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        pos = seq_search(num, key, n);
        if(pos == -1){
            System.out.println("There's no key!");
        }
        else {
            System.out.println(pos);
        }
    }
    public static int seq_search(int num[], int key, int n){
        int i;
        for (i=0; i<n; i++){
            if(key == num[i]){
                return i;
            }
        }
        return -1;
    }
}
