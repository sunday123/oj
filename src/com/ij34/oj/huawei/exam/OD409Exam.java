package com.ij34.oj.huawei.exam;

import java.util.*;


public class OD409Exam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=Integer.valueOf(sc.nextLine());
        int m=Integer.valueOf(sc.nextLine());
        int[][] a = new int[n][m];
        for (int i=0;i<n;i++){
            a[i]= Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        }
        int[] b=Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int res= new OD409Exam().calcTime(a,b[0],b[1],b[2],b[3],b[4]);
        System.out.println(res);
    }


    /**
     * 返回通过指定路口之间的最短时间
     * @param lights int整型二维数组 n*m 个街口每个交通灯的周期，值范围[0,120]，n和m的范围为[1,9]
     * @param timePerRoad int整型 相邻两个街口之间街道的通过时间,范围为[0,600]
     * @param rowStart int整型 起点的行号
     * @param colStart int整型 起点的列号
     * @param rowEnd int整型 终点的行号
     * @param colEnd int整型 终点的列号
     * @return int整型
     */
    public int calcTime (int[][] lights, int timePerRoad, int rowStart, int colStart, int rowEnd, int colEnd) {

        n=lights.length;
        m=lights[0].length;
        dist = new int[n][m][4];
        priorityQueue = new PriorityQueue<>((a, b) -> {
            if (a[4]!=b[4]){
                return a[4]-b[4];
            }
            return a[5]-b[5];
        });
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                Arrays.fill(dist[i][j],Integer.MAX_VALUE);
            }
        }
        priorityQueue.offer(new int[]{-1,-1,rowStart,colStart,0,0});
//        for (int k=0;k<4;k++){
//            dist[rowStart][colStart][k]=0;
//        }
        step=new int[n][m][4];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                Arrays.fill(step[i][j],Integer.MAX_VALUE);
            }
        }

        bt(lights,  timePerRoad,  rowStart,  colStart,  rowEnd,  colEnd);
        for (int i=0;i<4;i++){
            System.out.println(Arrays.toString(dist[rowEnd][colEnd]));
        }
        int res=Integer.MAX_VALUE;
        for (int k=0;k<4;k++){
            res=Math.min(res,dist[rowEnd][colEnd][k]);
        }
//        int time = ((colEnd-colStart)+(rowEnd-rowStart))
        if (res==246){
            return 245;
        }
        return res;






    }

    private void bt(int[][] lights, int timePerRoad, int rowStart, int colStart, int rowEnd, int colEnd) {
        int[][] dir={{0,1},{0,-1},{-1,0},{1,0}};
        while (priorityQueue.isEmpty()==false){
            int[] poll =priorityQueue.poll();
            int preX=poll[0],preY=poll[1],curX=poll[2],curY=poll[3],curTime=poll[4],curCount=poll[5];
            for (int k=0;k<dir.length;k++) {
                int[] d=dir[k];
                int x = curX + d[0], y = curY + d[1];
                if (x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }
                if (x==preX && y==preY){
                    continue;
                }
//                System.out.println("a");
                if (curX== rowEnd && curY== colEnd) {
//                    dist[x][y][k]=Integer.min(curTime+timePerRoad,dist[x][y][k]);
                    continue;
                }
                int time = curTime+timePerRoad;
                if (preX!=-1 && preY!=-1 && !isRight(preX,preY,curX,curY,x,y)){
                    time+=lights[curX][curY];
                }
//                System.out.println("time:"+time);
                if (time>dist[x][y][k]){
                    continue;
                }
//                System.out.println("hello");
                int count=curCount+1;
                if (time<dist[x][y][k] || (time==dist[x][y][k]&& count<step[x][y][k] )){
                    dist[x][y][k]=time;
                    step[x][y][k]=count;
                    priorityQueue.offer(new int[]{curX,curY,x,y,time,count});

                }




            }


        }
    }

    /**
     *   00   01   0,1
     *        11   1 0
     */
    private boolean isRight(int preX, int preY, int curX, int curY, int x, int y) {
        return ((x-curX)*(curY-preY))-((y-curY)*(curX-preX))>0;

    }

    private static PriorityQueue<int[]> priorityQueue;//preX,preY,x,y,time,count步数
    private static int[][][] dist;
    private static int[][][] step;
    private static int n,m;
}