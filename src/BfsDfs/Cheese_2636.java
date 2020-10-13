package BfsDfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//📌📌bfs를 사용하는 문제, 동시에 bfs 실행됨

class Cheese{
    int x,y;
    Cheese(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Cheese_2636  {
    public static final int[] dx = {0, 0, -1, 1};
    public static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); //가로
        int n = sc.nextInt(); //세로

        int[][] cheese = new int[n][m];
        boolean[][] check = new boolean[n-2][m-2];
        int[][] day = new int[n][m];

        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                cheese[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<n-2; i++) {
            for (int j = 0; j < m-2; j++) {
                cheese[i][j] = cheese[i+1][j+1];
            }
        }

        bfs( n, m, check, cheese, day);

    }

    public static void bfs( int n, int m, boolean check[][], int cheese[][], int day[][]){
        Queue<Cheese> c = new LinkedList<Cheese>();
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < m-2; j++) {
                //System.out.print(tomato[i][j]);
                if (cheese[i][j] == 1) {
                    c.add(new Cheese(i,j));
                    day[i][j] = 1;
//                    cheese[i][j] = 0;
                    check[i][j] = true;
                }
            }
        }
        int ans=0;

        while(!c.isEmpty()){
            Cheese pick = c.remove();
            int x = pick.x;
            int y = pick.y;

            for(int k=0;k<4;k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(nx>=0 && ny>=0 && nx<n-2 && ny<m-2) {
                    if (!check[nx][ny] && cheese[nx][ny] == 1) { //가본적 없는 곳이고 1이면
                        check[nx][ny] = true;
                        cheese[nx][ny] = 0; //녹아버림
                        day[nx][ny] = day[x][y] + 1;
                        c.add(new Cheese(nx, ny));
                        /*ans = day[nx][ny];*/
                    }
                }
            }
//            if(x,y){
//                while(x<n-2){
//                    x++;
//                }
//                if(x==n-2) air;
//                else air not

        }

//        for(int i=0; i<n; i++) {
//            for (int j = 0; j < m; j++) {
//                //System.out.print(tomato[i][j]);
//                if(cheese[i][j] == 0){
//                    System.out.println("-1"); //최종적으로 다 못익는 상태
//                    return;
//                }
//            }
//        }

        System.out.println(ans-1);
    }
}
