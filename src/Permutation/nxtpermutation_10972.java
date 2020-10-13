package Permutation;

import java.util.Scanner;


public class nxtpermutation_10972 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] per = new int[num];
        for(int a=0;a<num;a++){
            per[a] = sc.nextInt(); //순열 원소 정리
        }
        if(nxt_permutation(per, num)){
            for (int a = 0; a < num; a++) {
                System.out.print(per[a]); //다음 순열 출력
                System.out.print(" ");
            }
        }else{
            System.out.println("Last permutation!");
        }
    }
    public static boolean nxt_permutation(int per[], int num){
        int i= num-1;
        int temp; //swap 위해서
        for(; i>0; i--){ //뒤에서부터 내려오면서 i-1보다 i 값이 큰 위치 찾기
            if(per[i-1]<per[i]){
                break;
            }
        }
        if(i<=0){
            return false; //마지막까지 돌았을 때도 i-1보다 i값이 큰 위치가 없다면 이건 마지막 순열
        }
        for(int j=num-1; j>=i; j--){
            if(per[i-1]<per[j]){//i부터 내림차순으로 되어 있으니 맨 오른쪽부터 올라오며 i-1보다 작은 값 찾기
                temp = per[i-1];
                per[i-1] = per[j];
                per[j] = temp;
                break; //i와 j swqp
            }
        }
        int j = num-1;
        while(i<j){
            temp = per[i];
            per[i] = per[j];
            per[j] = temp;
            i++;
            j--; //i부터 맨 뒤까지 뒤집어주기 => 올림 차순이 되어야 하므로
        }
        return true;
    }
}
