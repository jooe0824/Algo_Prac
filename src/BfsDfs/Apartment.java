package BfsDfs;

import java.util.*;

class coup{
    int x;
    int y;
    coup(int x,int y){
        this.x = x;
        this.y = y;
    }
}
public class Apartment {
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] apart = new int[n][n];
        int[][] group = new int[n][n];

        sc.nextLine();

        for(int i=0;i<n;i++){
            String s = sc.nextLine();
            for(int j=0;j<n;j++){
                apart[i][j] = s.charAt(j) - '0'; //string 쪼개서 배열에 저장
            }
        }
        int cnt = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               if( group[i][j]==0 && apart[i][j]==1 ){ //방문 이력 없고 그룹에 속하지 않은 경우
                   //bfs(apart, group, i, j, ++cnt, n); //bfs 넓이 우선 탐색 시작
                   //cnt++ 해주면서 다른 그룹일 경우 cnt 다르게 설정
                   dfs(apart, group, i, j, ++cnt, n);
                   //cnt++ 이면 안된
               }
            }
        }

        int[] house = new int[cnt]; //단지 내 집의 수 저장

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(group[i][j]!=0){
                    house[group[i][j]-1] += 1; //단지 내 집의 수 세기
                }
            }
        }

        Arrays.sort(house); //오름차순

        System.out.println(cnt); //단지 갯수
        for(int i=0;i<cnt;i++){
            System.out.println(house[i]); //단지 내 집의 수
        }

        //결과 출력
    }

    //깊이 우선 탐색
    public static void dfs(int[][] apart, int[][]group, int x, int y, int cnt, int n){
        group[x][y] = cnt;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (0 <= nx && 0 <= ny && nx < n && ny < n) {
                if (apart[nx][ny] == 1 && group[nx][ny] == 0) {
                    dfs(apart, group, nx, ny, cnt, n); //재귀방법
                    }
                }
            }
        }

    //넓이 우선 탐색
    public static void bfs(int[][] apart, int[][] group, int x, int y, int cnt, int n){
        Queue<coup> a = new LinkedList<coup>();

        group[x][y] = cnt;
        a.add(new coup(x,y));

        while(!a.isEmpty()){
            coup pick = a.remove();
            int locx = pick.x;
            int locy = pick.y;
            for(int k=0; k<4; k++){ //네방향으로 진행
                int nx = locx + dx[k];
                int ny = locy + dy[k];
                if(nx>=0 && ny>=0 && nx<n && ny<n){ //범위 내에서 진행
                    if(apart[nx][ny] == 1 && group[nx][ny]==0 ){ //집이 있고 아무 그룹에 속하지 않을 경우
                        group[nx][ny]=cnt;
                        a.add(new coup(nx,ny));
                    }
                }
            }
        }
    }
}
