package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * https://hydro.ac/d/HWOD2023/p/OD350
 */
public class OD350 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] one = sc.nextLine().split(" ");
        int m= Integer.valueOf(one[0]), n= Integer.valueOf(one[1]);
        int[][] a = new int[m][n];
        for (int i=0;i<m;i++){
            a[i]= Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[0].length;j++){
                 if (a[i][j]>=1 && a[i][j]<=500){
                     List<int[]> list = map.containsKey(a[i][j])?map.get(a[i][j]):new ArrayList<>();
                     list.add(new int[]{i,j});
                     map.put(a[i][j],list);
                 }
            }
        }

        int maxSize = 0;
        for (List<int[]> list :map.values()){
            int[] upL=new int[]{list.get(0)[0],list.get(0)[1]},downR=new int[]{list.get(0)[0],list.get(0)[1]};
            for (int j=1;j<list.size();j++){
                int x=list.get(j)[0],y=list.get(j)[1];
                upL[0]=upL[0]<x?upL[0]:x;
                upL[1]=upL[1]<y?upL[1]:y;

                downR[0]=downR[0]>x?downR[0]:x;
                downR[1]=downR[1]>y?downR[1]:y;
            }
            int size = (downR[0]-upL[0]+1)*(downR[1]-upL[1]+1);
            maxSize=maxSize>size?maxSize:size;

        }

        System.out.println(maxSize);

    }
}
