package BfsDfs;

import java.util.*;

//📌📌bfs를 사용하는 문제, 동시에 bfs 실행됨

class Tom{
    int x,y;
    Tom(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Tomato {
    public static final int[] dx = {0, 0, -1, 1};
    public static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); //가로
        int n = sc.nextInt(); //세로

        int[][] tomato = new int[n][m];
        boolean[][] check = new boolean[n][m];
        int[][] day = new int[n][m];
        int initial = 0 ;

        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                tomato[i][j] = sc.nextInt();
                if(tomato[i][j]==0){
                    initial++;
                }
            }
        }

        if(initial == 0){
            System.out.println("0"); //모두 익은 상태
            return;
        }

        bfs( n, m, check, tomato, day);

    }

    public static void bfs( int n, int m, boolean check[][], int tomato[][], int day[][]){
        Queue<Tom> t = new LinkedList<Tom>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //System.out.print(tomato[i][j]);
                if (tomato[i][j] == 1) {
                    t.add(new Tom(i,j));
                    day[i][j] = 1;
                    check[i][j] = true;
                }
            }
        }
        int ans=0;

        while(!t.isEmpty()){
            Tom pick = t.remove();
            int x = pick.x;
            int y = pick.y;

            for(int k=0;k<4;k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(nx>=0 && ny>=0 && nx<n && ny<m) {
                    if (!check[nx][ny] && tomato[nx][ny] == 0) {
                        check[nx][ny] = true;
                        tomato[nx][ny] = 1;
                        day[nx][ny] = day[x][y] + 1;
                        t.add(new Tom(nx, ny));
                        ans = day[nx][ny];
                    }
                }
            }
        }

        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                //System.out.print(tomato[i][j]);
                if(tomato[i][j] == 0){
                    System.out.println("-1"); //최종적으로 다 못익는 상태
                    return;
                }
            }
        }

        System.out.println(ans-1);
    }
}
