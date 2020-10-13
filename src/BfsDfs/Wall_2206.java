package BfsDfs;

import java.util.*;

//📌📌 벽 한번만 부수고 이동하기 또는 안 부수고 이동하기
//최단 거리 => bfs, 벽을 부수고 이동 했을 때 vs 벽 안 부수고 이동 했을 때 비교가 필요 배열 하나 더 추가해줌

class wall{
    int x,y,z;
    wall(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Wall_2206 {
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        int[][][] dist = new int[n][m][2];  //벽을 부쉈는지 유무 저장 [2]
        sc.nextLine();
        //input
        for(int i=0;i<n;i++){
            String s = sc.nextLine();
            for(int j=0;j<m;j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(map, dist, n, m);

        //마지막 distance 가 벽 부순 경우와 벽 안 부순 경우 둘다 있다면
        if(dist[n-1][m-1][0] != 0 && dist[n-1][m-1][1] != 0){
            System.out.println(Math.min(dist[n-1][m-1][0], dist[n-1][m-1][1]));
        }
        //마지막 distance 가 벽 부순 경우와 벽 안 부순 경우 둘다 없다면
        else if(dist[n-1][m-1][0] == 0 && dist[n-1][m-1][1] == 0){
            System.out.println(-1);
        }
        //둘 중 하나만 있다면 하나는 0일 테니 둘 중 큰 수 출력
        else{
            System.out.println(Math.max(dist[n-1][m-1][0], dist[n-1][m-1][1]));
        }
    }

    //일반적인 bfs와 비슷하나 z가 추가
    public static void bfs(int[][] map, int[][][] dist, int n, int m){
        Queue<wall> w = new LinkedList<wall>();
        w.add(new wall(0,0, 0 ));
        dist[0][0][0] = 1;

        while(!w.isEmpty()){
            wall pick = w.remove();
            int x = pick.x;
            int y = pick.y;
            int z = pick.z;

            for(int k=0;k<4;k++){
                int nx = x+dx[k];
                int ny = y+dy[k];

                if(nx>=0 && ny>=0 && nx<n && ny<m) {
                    if (map[nx][ny] == 0 && dist[nx][ny][z] == 0) { //벽 안 부수고
                        w.add(new wall(nx, ny, z));
                        dist[nx][ny][z] = dist[x][y][z] + 1;
                    }
                    else if ( z==0 && map[nx][ny] == 1 && dist[nx][ny][z+1] == 0 ) { //벽 부수고
                        w.add(new wall(nx, ny, z+1));
                        dist[nx][ny][z+1] = dist[x][y][z] + 1;
                    }
                }
            }
        }
    }
}
