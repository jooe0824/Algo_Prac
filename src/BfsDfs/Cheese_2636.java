package BfsDfs;

import java.io.*;
import java.util.*;

//📌📌bfs를 사용하는 문제, 동시에 bfs 실행됨

class Cheese{
    int x,y;
    Cheese(int x, int y){
        this.x = x;
        this.y = y;
    }
} //bfs 이용

class Cheese_2636  {
    public static int remainCheese = 0;
    public static final int[] dx = {0, 0, -1, 1};
    public static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] cheese = new int[n][m];
        //0: 방문하지 않은 공기, 1: 치즈, 2: 이제 곧 녹을 치즈 c, -1: 방문 안한 공기
        // 1=>2=>0=>-1 순서로 진행
        int[][] day = new int[n][m]; //bfs 이용시 이용해볼려고 저장

        //input
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //가장자리 빼고 다시 정렬해주기 -> 더 복잡함
//        for(int i=0; i<n-2; i++) {
//            for (int j = 0; j < m-2; j++) {
//                cheese[i][j] = cheese[i+1][j+1];
//            }
//        }

        int time = 0;

        //공기랑 cheese[][]숫자 바꿔주고 한번 싹 cheesecheck하면서 치즈 녹일 애들 녹인다.
        do {
            dfs(0,0,cheese,n,m);
            time++;
        }while(Checkcheese(n,m,cheese)); //치즈가 남아있을 동안 dfs 진행

       // bfs(n, m, cheese, day);
        System.out.println(time - 1);
        System.out.println(remainCheese);

    }

    private static void dfs(int x, int y, int[][] cheese, int n, int m) {
        cheese[x][y] = -1;	//공기에 대한 방문 처리
        int nx, ny;
        // 공기를 중심으로 사방에 치즈가 있는지 검사
        for (int k = 0; k < 4; k++) {
            nx = x + dx[k];
            ny = y + dy[k];
            if(ny >= 0 && nx < n && nx >=0 && ny < m) {
                if(cheese[nx][ny] == 1) { //치즈 1 => 녹을 치즈 2
                    cheese[nx][ny] = 2;
                    k=0;
                } else if(cheese[nx][ny] == 0) {	// 공기(0)면 -> 계속 탐색
                    dfs(nx,ny,cheese,n,m);                    // 재귀함수
                }
            }
        }
    }

    public static void bfs( int n, int m, int cheese[][], int day[][]){
        Queue<Cheese> c = new LinkedList<Cheese>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //System.out.print(tomato[i][j]);
                if (cheese[i][j] == 1) {
                    c.add(new Cheese(i,j));
                    day[i][j] = 1;
                    cheese[i][j] = 2;
                }
            }
        }

        c.add(new Cheese(0,0)); //0,0은 무조건 0 이다
        cheese[0][0] = -1; //방문한 공기로 처리


        int ans=0;
        int remain=0; //남아있는 치즈의 개수

        while(!c.isEmpty()){
            Cheese pick = c.remove();
            int x = pick.x;
            int y = pick.y;

            for(int k=0;k<4;k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(nx>=0 && ny>=0 && nx<n && ny<m && cheese[nx][ny] != -1) {
                    if ( cheese[nx][ny] == 1 ) { //가본적 없는 곳이고 1이면

                        cheese[nx][ny] = 2; //녹을 치즈가 되어버림
                        day[nx][ny] = day[x][y] + 1;

                        /*ans = day[nx][ny];*/
                    }
                    else if ( cheese[nx][ny] == 2 ){ //녹을 치즈라면
                        cheese[nx][ny] = 0; //치즈 녹고 공기 미방문
                    }
                    else if ( cheese[nx][ny] == 0 ){ //치즈가 없는 곳이라면
                        cheese[nx][ny] = -1; //공기가 방문하였다고 표시
                    }
                    c.add(new Cheese(nx, ny));
                }

            }
            remain = cheesenum(n,m,cheese);
            System.out.println(remain);

        }
//        System.out.println(ans-1);
    }

    public static boolean Checkcheese(int n, int m, int[][] cheese){
        int count = 0; //남은 치즈 갯수
        for(int i=0; i<n; i++) {
            for (int j = 0; j < m ; j++) {
                if (cheese[i][j] == 1) {
                    count++;
                    continue;
                }
                if (cheese[i][j] == 2) { //녹을 치즈이다
                    count++; //치즈 녹일거니까 cnt 세주고 녹이기
                }
                cheese[i][j] = 0; //녹을 치즈 => 방문 안한 공기로 바꿔주기
            }
        }
        if(count == 0) {
            return false; //치즈 남은게 없다
        }
        else{
            remainCheese = count;
            return true; //아직 치즈가 남아 있다
        }


    }

    public static int cheesenum(int n, int m, int[][] cheese){
        int[] count = new int[100]; //남은 치즈 갯수
        int chz = 0;
        for(int i=0; i<n-2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (cheese[i][j] == 1) {
                    chz++;
                }
            }
        }
        return chz;
    }
}
