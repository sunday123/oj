package com.ij34.oj.huawei.two.reuse;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 约瑟夫问题
 * https://hydro.ac/d/HWOD2023/p/OD294
 *
 * @Author: ij34
 * @Date: 2024-05-05
 */

public class JosephusProblemSolver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).boxed().toList();
        LinkedList<Integer> res = new LinkedList<>();
        sc.nextInt();
        int k = sc.nextInt();
        doIt(new ArrayList<>(list),0,k,res);
        System.out.println(res.stream().map(Object::toString).collect(Collectors.joining(",")));
    }

    private static void doIt(List<Integer> list, int index, int k, LinkedList<Integer> res) {
        if (list.isEmpty()){
            return;
        }
        if (list.size()==1){
            res.addLast(list.get(0));
            return;
        }
        k=k%list.size();
        int tempIndex =(index+k-1)%list.size();
        Integer a = list.get(tempIndex);
        res.addLast(a);
        list.remove(tempIndex);
        if (tempIndex>=list.size()){
            index=0;
        }else {
            index=tempIndex;
        }
        doIt(list,index,a,res);

    }


}
