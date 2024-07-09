package com.ij34.oj.leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

/**
 *
 * 93. 复原 IP 地址
 * https://leetcode.cn/problems/restore-ip-addresses
 *
 * @Author: ij34
 * @Date: 2024-06-25
 */

public class LC93 {

    public List<String> restoreIpAddresses(String s) {
        if (s.length()<4 || s.length()>12){
            return List.of();
        }
        //1 1 1 1
        List<String> resList=new ArrayList<>();
        len=s.length();
        this.s=s;
        dfs(0,0,new LinkedList<Integer>(),resList);
        return resList;



    }
    private String s;
    private int[] a=new int[]{1,2,3};
    private int len;

    private void dfs(int sum,int start, LinkedList<Integer> list, List<String> resList) {
        if (list.size()==4){
            if (sum==len){
                String str=getResult(list);
                if (str!=null){
                    resList.add(str);
                }
            }
            return;
        }

        for (int i=start;i<a.length;i++){
            list.addLast(a[i]);
            dfs(sum+a[i],start,list,resList);
            list.removeLast();
        }



    }

    private String getResult(LinkedList<Integer> list) {
        StringJoiner sj= new StringJoiner(".");
        int start=0;
        for (int len:list){
            int next=start+len;
            String str=s.substring(start,next);
            if (str.length()>1 && str.charAt(0)=='0'){
                return null;
            }
            if (str.length()==3 ){
                int num=Integer.valueOf(str);
                if (num>255){
                    return null;
                }
            }
            sj.add(str);
            start=next;

        }
        return sj.toString();
    }


}
