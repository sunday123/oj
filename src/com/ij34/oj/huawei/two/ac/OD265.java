package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * 没完成
 * 最长的指定瑕疵度的元音子串
 * https://hydro.ac/d/HWOD2023/p/OD265
 * @Author: ij34
 * @Date: 2024-06-08
 */

public class OD265 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Character> list = Arrays.stream("aeiou".split("")).map(m->m.charAt(0)).toList();
        int flaw = Integer.valueOf(sc.nextLine());
        String str =sc.nextLine().toLowerCase();
        if (flaw==0 && str.length()==1 && list.contains(str.charAt(0))){
            System.out.println(1);
            return;
        }
        if (flaw>=str.length()-1){
            System.out.println(0);
            return;
        }
        List<Integer> indexList = new ArrayList<>();
        for (int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if (list.contains(c)){
                indexList.add(i);
            }
        }
        int res=0;
        int l=0,r=0;
        while (l<indexList.size()){
            if (r>=indexList.size()){
                l++;
                r=l;
                continue;
            }
            int dif =0;
            for (int j=l+1;j<=r;j++){
                dif+= indexList.get(j)-indexList.get(j-1)-1;
            }
            if (dif>flaw){
                l++;
                if (r<l){
                    r=l;
                }
                continue;
            }
            if (dif==flaw){
                res=Math.max(res,indexList.get(r)-indexList.get(l)+1);

            }

            r++;





        }
        System.out.println(res);
    }
}
