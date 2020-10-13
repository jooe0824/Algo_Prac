package BfsDfs;

import java.util.*;

class Set{
    int x;
    int y;
    Set(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class apart_2667 {
    public static final int[] dx = {0,0,1,-1};
    public static final int[] dy = {1,-1,0,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        int[][] a = new int[num][num];
        for (int i=0; i<num; i++) {
            String s = sc.nextLine();
            for (int j=0; j<num; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

//        int[][] group = new int[num][num]; //집이 어느 그룹에 속할지
//        int cnt = 0;
//        for (int i = 0; i < num; i++) {
//            for (int j = 0; j < num; j++) {
//                if (a[i][j] == 1 && group[i][j] == 0) { //1이고 아무 그룹에도 속하지 않은 경우
//                    bfs(a, group, i, j, ++cnt, num);
//                }
//            }
//        }

        int[][] group = new int[num][num]; //집이 어느 그룹에 속할지
        int cnt = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (a[i][j] == 1 && group[i][j] == 0) { //1이고 아무 그룹에도 속하지 않은 경우
//                    System.out.println("dfs");
                    dfs(a, group, i, j, ++cnt, num);
                }
            }
        }
        int[] house = new int[cnt]; //단지 내 집의 수를 저장할 배열
        for(int i=0; i<num; i++){
            for (int j=0;j<num;j++){
                if(group[i][j] != 0){
                    house[group[i][j]-1] += 1;
                }
            }
        }
        Arrays.sort(house); //단지 내 집의 수 저장한 배열 오름 차순으로 정리
        System.out.println("count : " + cnt);
        for (int i=0; i<cnt; i++) {
            System.out.println(house[i]); //단지 내 집의 수 출력
        }
    }

    public static void dfs(int[][] a,int[][] group, int x, int y, int cnt, int n) {
        group[x][y] = cnt;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (0 <= nx && 0 <= ny && nx < n && ny < n) {
                if (a[nx][ny] == 1 && group[nx][ny] == 0) {
                    dfs(a, group, nx, ny, cnt, n);
                }
            }
        }
    }
    public static void bfs(int[][] a,int[][] group, int x, int y, int cnt, int n){
        Queue<Set> q = new LinkedList<Set>();
        q.add(new Set(x,y));
        group[x][y] = cnt;
        while(!q.isEmpty()){
            Set p = q.remove(); //ex.Set(0,1)
            x = p.x; //x = 0
            y = p.y; //x = 1
            for (int k=0; k<4; k++) {
                int nx = x+dx[k]; //k=0이면 0+dx[0], 0+0, nx=0
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (a[nx][ny] == 1 && group[nx][ny] == 0) {
                        //집이 있고 그룹이 아직 어느곳에도 속하지 않았다면
                        q.add(new Set(nx, ny));
                        group[nx][ny] = cnt;
                        //cnt 그룹을 넣어준다                        group[nx][ny] = cnt;
                    }
                }
            }
        }
    }
}
