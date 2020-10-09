import java.util.Scanner;

public class pvs_permutation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] per = new int[num];
        for(int a=0;a<num;a++){
            per[a] = sc.nextInt(); //순열 원소 정리
        }
        if(pvs_permutation(per, num)){
            for (int a = 0; a < num; a++) {
                System.out.print(per[a]); //다음 순열 출력
                System.out.print(" ");
            }
        }else{
            System.out.println("Last permutation!");
        }
    }
    public static boolean pvs_permutation(int per[], int num){
        int temp;
        int i = num-1;
        for(;i>0;i--){
            if(per[i-1]>per[i]){
                break;
            }
        }
        if(i<=0){
            return false;
        }
        int j = num-1;
        for(;j>=i;j--){
            if(per[j]<per[i-1]){
                temp = per[j];
                per[j] = per[i-1];
                per[i-1] = temp;
                break;
            }
        }
        j=num-1;
        while(i<j) {
                temp = per[i];
                per[i] = per[j];
                per[j] = temp;
                i++;
                j--;
            }
        return true;
    }
}
