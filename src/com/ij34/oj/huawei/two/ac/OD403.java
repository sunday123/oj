package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * 项目排期
 * https://hydro.ac/d/HWOD2023/p/OD403
 * @Author: ij34
 * @Date: 2024-06-05
 */

public class OD403 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] requests = Arrays.stream(sc.nextLine().split(" ")).map(Integer::valueOf)
                .sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

        int people = Integer.valueOf(sc.nextLine());
        int sum = Arrays.stream(requests).sum();
        int left=sum/requests.length,right = sum;
        int res = 0;
        while (left<=right){
            int mid = (left+right)>>1;
            set = new HashSet<>();
            if (isOk(requests,new int[people],0,mid)){
                res=mid;
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        System.out.println(res);

    }


   private static HashSet<Integer> set;

    private static boolean isOk(int[] requests, int[] peoples, int index, int days) {
        if (index==requests.length){
            return true;
        }

        if (set.contains(Arrays.toString(peoples).hashCode())){
            return false;
        }
        set.add(Arrays.toString(peoples).hashCode());

        for (int i=0;i<peoples.length;i++){
            if (i>0 && peoples[i]==peoples[i-1]){
                continue;
            }
            if (peoples[i]+requests[index]<=days){
                peoples[i]+=requests[index];
                if (isOk(requests,peoples,index+1,days)){
                    return true;
                }
                peoples[i]-=requests[index];
            }
        }
       return false;
    }


}
