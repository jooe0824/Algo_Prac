package BfsDfs;

import java.util.*;

class Pair2{
    int xb,yb,xr,yr;
    Pair2(int xb,int yb,int xr, int yr){ //blue와 red 둘다 x,y 좌표
        this.xb = xb;
        this.yb = yb;
        this.xr = xr;
        this.yr = yr;
    }
}

public class Biz_13460 {
    public static int xr,yr,xb,yb; //red 구슬의 xy값과 blue 구슬의 xy값
    public static int[] dx = {0,0,1,-1}; //방향은 네개
    public static int[] dy = {1,-1,0,0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[][] biz = new String[n][m];
        int[][] distblue = new int[n][m];
        int[][] distred = new int[n][m];
        int[][] check = new int[n][m];

        //input
        sc.nextLine();
        for(int i=0;i<n;i++){
            String st = sc.nextLine();
            for(int j=0;j<m;j++){
                biz[i][j] = String.valueOf(st.charAt(j));
                if( biz[i][j].equals("B")){
                    xb = i;
                    yb = j;
                    biz[i][j] = ".";
                    check[i][j] = 1; //1이면 blue가 지나간 자리
                }
                else if( biz[i][j].equals("R")){
                    xr = i;
                    yr = j;
                    biz[i][j] = ".";
                    check[i][j] = 0; //0이면 red가 지나간 자리
                }
            }
        }

        bfs(distblue, distred, biz, n, m, check);



    }
    public static void bfs(int[][] distblue, int[][] distred, String[][] biz, int n, int m, int[][] check){
        Queue<Pair2> q = new LinkedList<Pair2>();
        q.add(new Pair2(xb,yb,xr,yr));
        distblue[xb][yb] = 1;
        distred[xr][yr] = 1;
        check[xb][yb] = 1;
        check[xr][yr] = 0;
        int cnt = 0;

        while(!q.isEmpty()){
            Pair2 pick = q.remove();
            int xb = pick.xb;
            int yb = pick.yb;

            int xr = pick.xr;
            int yr = pick.yr;

            for(int k=0;k<4;k++){
                int nxb = xb+dx[k]; //blue 이동한 x좌표
                int nyb = yb+dy[k]; //blue 이동한 y좌표
                int mxr = xr+dx[k]; //red 이동한 x좌표
                int myr = yr+dy[k]; //red 이동한 y좌표

                if(nxb >=0 && nyb >=0 && nxb <n && nyb <m && mxr >=0 && myr >=0 && mxr <n && myr <m){
                    if(biz[nxb][nyb].equals(".") && biz[mxr][myr].equals("#")){ //blu만 이동 가능
                        q.add(new Pair2(nxb,nyb,xr,yr));
                        System.out.println(nxb+nyb+xr+yr);
                        distblue[nxb][nyb] = distblue[xb][yb] + 1; //blue dist ++;
                    }
                    if(biz[mxr][myr].equals(".") && biz[nxb][nyb].equals("#")){ //red만 이동 가능
                        q.add(new Pair2(xb,yb,mxr,myr));
                        distred[mxr][myr] = distred[xr][yr] + 1; //red dist ++;
                    }
                    if(biz[mxr][myr].equals(".") && biz[nxb][nyb].equals(".")){ //red, blue 모두 이동 가능
                        q.add(new Pair2(nxb,nyb,mxr,myr));
                        distred[mxr][myr] = distred[xr][yr] + 1; //red dist ++;
                        distblue[nxb][nyb] = distblue[xb][yb] + 1; //blue dist ++;
                    }
                    if(nxb==mxr && nyb==myr ) { //두개 겹친 경우 둘다 그대로 있어야돼
//                        if(nx==xb && ny == yb){ //파란색이 그대로였던 경우
//                        }
//                        else if(mx==xr && my == yr){ //빨간색이 그대로였던 경우
//                        }
                        nxb=xb;
                        nyb=yb;
                        mxr=xr;
                        myr=yr;
                    }
                    if(biz[nxb][nyb].equals("0") ){ //blue가 구멍에 들어가버리면 원래대로 돌려놓기
                        nxb=xb;
                        nyb=yb;
                        mxr=xr;
                        myr=yr;
                    }
                    if(biz[mxr][myr].equals("0") ) { //red가 구멍
                        if (biz[nxb][nyb].equals("0")) { //blue도 같이 구멍
                            nxb = xb;
                            nyb = yb;
                            mxr = xr;
                            myr = yr; //다시 원 상태로
                        } else { //blue는 구멍 아닐때
                            distred[mxr][myr] = distred[xr][yr]+1; //distance ++;
                            cnt = distred[mxr][myr];
                            //성공
                        }
                    }

                }
            }
            //distance Min으로 맞춰야 함
            //10번 이하
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(distred[i][j]>=10 || distblue[i][j]>=10 ){
                        cnt = 0;
                        break;
                    }
                }
            }


        }
        if(cnt>0) {
            System.out.println(cnt);
        }
        else {
            System.out.println(-1);
        }

    }

}
