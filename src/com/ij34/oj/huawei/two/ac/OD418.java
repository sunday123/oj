package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * 最大社交距离
 * https://hydro.ac/d/HWOD2023/p/OD418
 *
 * @Author: ij34
 * @Date: 2024-06-13
 */

public class OD418 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int seatNum = Integer.valueOf(sc.nextLine());
        int maxSeat = seatNum-1;
        String temp =sc.nextLine();
        int[] a= Arrays.stream(temp.substring(1,temp.length()-1).split(", ")).mapToInt(Integer::valueOf).toArray();
        int r=a.length-1;
        while (r>=0 && a[r]<1){
           r--;
        }
        a=Arrays.copyOfRange(a,0,r+1);
        List<Integer> list = new ArrayList<>();
        int lastIndex=0;
        for (int i:a){

            if (i==0){
                continue;
            }
            if (i<0){
                Integer removeI=-i;
                list.remove(removeI);
                continue;
            }


            if (list.isEmpty()){
                list.add(0);
                continue;
            }

            Collections.sort(list);
            int dif=0,currrentIndex=0;
            for (int j=0;j<list.size();j++){
                if (j==0){
                    if (list.get(j)/2>dif){
                        dif=list.get(j)/2;
                        currrentIndex=0;
                    }
                }


                if (j>0 && j<list.size()){
                    if ((list.get(j)-list.get(j-1))/2>dif){
                        dif=(list.get(j)-list.get(j-1))/2;
                        currrentIndex=list.get(j-1);
                    }
                }

                if (j==list.size()-1){
                    if (maxSeat-list.get(j)>dif){
                        dif=maxSeat-list.get(j);
                        currrentIndex=list.get(j);
                    }
                }

            }
            currrentIndex+=dif;
            if (list.contains(currrentIndex)){
                System.out.println(-1);
                return;
            }
            list.add(currrentIndex);
            lastIndex=currrentIndex;


        }
        System.out.println(lastIndex);


    }
}
