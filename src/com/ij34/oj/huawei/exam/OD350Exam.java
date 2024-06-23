package com.ij34.oj.huawei.exam;

import java.util.*;

/**
 * @Author: ij34
 * @Date: 2024-06-22
 */

public class OD350Exam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt(),m= sc.nextInt();
        int[][] a= new int[n][m];
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                a[i][j]= sc.nextInt();
                if (a[i][j]>0 && a[i][j]<=500){
                    List<int[]> list = map.getOrDefault(a[i][j],new ArrayList<>());
                    list.add(new int[]{i,j});
                    map.put(a[i][j],list);
                }
            }
        }
        int res=0;
        for (Map.Entry<Integer,List<int[]>> entry:map.entrySet()){
            if (entry.getValue().size()==1){
                res=Math.max(res,1);
                continue;
            }
            res=Math.max(res,process(n,m,entry.getValue()));
        }
        System.out.println(res);




    }

    private static int process(int n, int m, List<int[]> list) {
        int[] lUp = new int[]{list.get(0)[0],list.get(0)[1]};
        int[] rDown= new int[]{list.get(0)[0],list.get(0)[1]};
        for (int i=1;i<list.size();i++){
            int[] a=list.get(i);
            lUp[0]=Math.min(lUp[0],a[0]);
            lUp[1]=Math.min(lUp[1],a[1]);
            rDown[0]=Math.max(rDown[0],a[0]);
            rDown[1]=Math.max(rDown[1],a[1]);
        }
        int res=(rDown[0]-lUp[0]+1)*(rDown[1]-lUp[1]+1);
        return res;


    }


}
