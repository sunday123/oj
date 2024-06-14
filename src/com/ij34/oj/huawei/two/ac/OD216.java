package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * 连续出牌数量、最长连续手牌
 * https://hydro.ac/d/HWOD2023/p/OD216
 *
 * @Author: ij34
 * @Date: 2024-06-13
 */

public class OD216 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] b = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] s = Arrays.stream(sc.nextLine().split(" ")).mapToInt(m->m.charAt(0)-'a').toArray();
        List<int[]> list = new ArrayList<>();
        for (int i=0;i<b.length;i++){
            list.add(new int[]{b[i],s[i]});
        }
        int max=0;
        for (int i=0;i<list.size();i++){
            LinkedList<Integer> temp = new LinkedList<Integer>();
            temp.add(i);
            dfsRes=0;
            dfs(list,i,temp);

            max=Math.max(max,dfsRes);
        }
        System.out.println(max);

    }
    private static int dfsRes=0;
    private static void dfs(List<int[]> aList, int index, LinkedList<Integer> list) {
        dfsRes=Math.max(list.size(),dfsRes);

        int[] a =aList.get(index);
        for (int i=0;i<aList.size();i++){
            if (list.contains(i)){
                continue;
            }
            int[] b = aList.get(i);
            if (b[0]==a[0] || a[1]==b[1]){
                list.addLast(i);
                dfs(aList,i,list);
                list.removeLast();
            }

        }
    }
}
