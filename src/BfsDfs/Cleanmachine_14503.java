package BfsDfs;
import java.util.*;

//📌📌 문제 속에 답이 있다, bfs, dfs 이지만 네 방향 다 하는건 아니다
//📌📌 작동 법이 있다면 작동법에 맞게만 코딩 해줘라!
//bfs, dfs 모두 시도

class Machine{
    int x;
    int y;
    int d;
    Machine(int x,int y, int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
public class Cleanmachine_14503 {
    //static으로 빼놓으면 param으로 다 안넘겨도 된다
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1}; //북, 동, 남, 서
    static int[][] map;
    static int[][] clean;
    static int n,m,cnt;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m]; //map 빈 공간, 벽 공간
        cnt = 0;
        clean = new int[n][m]; //청소했는지 유무 확인
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j] = sc.nextInt();
            }
        }
        bfs(r,c,d);
        //dfs(r,c,d);
        System.out.println(cnt);
    }

    public static void bfs(int r, int c, int d) {
        int nr, nc;
        Queue<Machine> p = new LinkedList<>();
        p.add(new Machine(r, c, d));
        //첫 로봇의 위치는 무조건 청소 안 했고 빈 공간
        clean[r][c] = 1;
        cnt++;
        int flag; //후진위한 변수

        while (!p.isEmpty()) {

            Machine pick = p.remove();
            r = pick.x;
            c = pick.y;
            d = pick.d;
            flag = 0; //깃발은 0으로 계속 초기화
            for (int k = 0; k < 4; k++) { //방향
                //이전엔 k로 했지만 이건 자신의 방향을 기준으로 해야 되기 때문에 d로 계산.
                d = d - 1; //자기 기준 왼쪽방향으로
                if (d < 0) {
                    d = 3; //북쪽은 서쪽으로
                }
                nr = r + dx[d];
                nc = c + dy[d]; //방향대로
                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    if (map[nr][nc] == 0 && clean[nr][nc] == 0) { //빈 공간이고 청소 한 적 없다면
                        flag = 1;
                        clean[nr][nc] = 1;
                        cnt++;
                        p.add(new Machine(nr, nc, d)); //작동 a
                        break; //네 방향 다 해주는게 아니라 왼쪽 한번 하면 끝이니까
                    } //else면 방향 change 작동 b
                }//네 방향 다 청소했는지 확인하고 청소
            }

            //후진
            if(flag == 0){ //방향을 다 둘러봐도 빈 공간이 아니었고 이미 청소가 되어 있었을 시
//                System.out.println("flag0");
                nr = r - dx[d];
                nc = c - dy[d];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    if (map[nr][nc] == 0 ){
                        if(clean[nr][nc] == 0) {
                            clean[nr][nc] = 1;
                            cnt++;
                        }
                        p.add(new Machine(nr, nc, d));
                    }
                }
            }
        }
    }

    public static void dfs(int r, int c, int d){
        int nr,nc;
        if(clean[r][c] == 0){ //이전에 청소를 하지 않았다면
            cnt++; //count++
            clean[r][c] = 1; //청소 했다고 표시
        }
        int flag = 0; //네 방향 다 청소 되었는지 확인 하기 위함
        for (int k = 0; k < 4; k++) { //방향
            //이전엔 k로 했지만 이건 자신의 방향을 기준으로 해야 되기 때문에 d로 계산.
            d = d - 1; //자기 기준 왼쪽방향으로
            if (d < 0) {
                d = 3; //북쪽은 서쪽으로
            }
            nr = r + dx[d];
            nc = c + dy[d]; //방향대로
            if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                if (map[nr][nc] == 0 && clean[nr][nc] == 0) { //빈 공간이고 청소 한 적 없다면
                    flag = 1;
                    dfs(nr, nc, d); //작동 a
                    break; //네 방향 다 해주는게 아니라 왼쪽 한번 하면 끝이니까
                } //else면 방향 change 작동 b
            }//네 방향 다 청소했는지 확인하고 청소
        }
        if( flag == 0) { //네 방향 다 돌아도 flag = 0이라는건 네 방향 다 청소가 이미 되어있거나 벽이다
            nr = r - dx[d];
            nc = c - dy[d]; //후진
            if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                if (map[nr][nc] == 0) { //후진 가능한 공간이라면
                    dfs(nr, nc, d);
                }
            } //작동 c
        }
    }
}
