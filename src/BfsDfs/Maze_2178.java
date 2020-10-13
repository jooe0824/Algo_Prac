package BfsDfs;

import java.util.*;

//📌📌bfs 이용하는 문제, Pair를 사용

class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}

class Maze {
    public static final int[] dx = {0,0,1,-1};
    public static final int[] dy = {1,-1,0,0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];

        //중요!
        sc.nextLine();

        for(int i=0;i<n;i++){
            String line = sc.nextLine();
            for(int j=0; j<m;j++){
                a[i][j] = line.charAt(j) - '0';
            }
        }

        boolean[][] check = new boolean[n][m];
        int[][] dist = new int[n][m];
        dfs(check, dist, a, n, m);
    }
    public static void dfs(boolean check[][], int dist[][], int a[][], int n, int m){
        int x, y, nx, ny;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0,0));
        check[0][0] = true;
        dist[0][0] = 1;

        while(!q.isEmpty()){
            Pair p = q.remove();
            x = p.x;
            y = p.y;
            System.out.println("x : "+x+", y : "+y);
            for(int k=0; k<4; k++){
                nx = x + dx[k];
                ny = y + dy[k];
                if( nx>=0 && ny>=0 && nx<n && ny<m) {
                    if (!check[nx][ny] && a[nx][ny] == 1) {
                        dist[nx][ny] = dist[x][y] + 1;
                        check[nx][ny] = true;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
        System.out.println(dist[n-1][m-1]); //도착점 distance
    }
}
