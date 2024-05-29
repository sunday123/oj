package com.ij34.oj.huawei.two;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 加密算法、特殊的加密算法
 * https://hydro.ac/d/HWOD2023/p/OD424
 * @Author: ij34
 * @Date: 2024-05-29
 */

public class CustomCipherAlgorithm {

    private static boolean[][] allow;
    private static List<List<int[]>> resList =new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());
        int[] data = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.valueOf(sc.nextLine());
        int[][] book = new int[M][M];
        for (int i=0;i<M;i++){
            book[i]=Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        allow = new boolean[M][M];
        for(int i=0;i<M;i++){
            Arrays.fill(allow[i],true);
        }

        for (int i=0;i<book.length;i++){
            for (int j=0;j<book[0].length;j++){
                if (book[i][j]==data[0]){
                    allow[i][j]=false;
                    LinkedList<int[]> list = new LinkedList<>();
                    list.addLast(new int[]{i,j});
                    backtrack(book,i,j,data,1,list);
                    allow[i][j]=true;
                }
            }
        }

        if (resList.isEmpty()){
            System.out.println("error");
            return;
        }
        List<String> otherList = new ArrayList<>();
        for (List<int[]> list :resList){
            otherList.add(list.stream().map(m->""+m[0]+" "+m[1]).collect(Collectors.joining(" ")));
        }
        otherList.sort(String::compareTo);
        System.out.println(otherList.get(0));

    }

    private static void backtrack(int[][] book, int i, int j, int[] data, int index, LinkedList<int[]> list) {
        if (index==data.length){
            resList.add(new ArrayList<>(list));
            return;
        }

        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] d : dir){
            int x=i+d[0],y=j+d[1];
            if (x>=0 && y>=0 && x<book.length && y< book.length && allow[x][y] && book[x][y]==data[index]){
                list.addLast(new int[]{x,y});
                allow[x][y]=false;
                backtrack(book,x,y,data,index+1,list);
                allow[x][y]=true;
                list.removeLast();

            }
        }
    }
}
