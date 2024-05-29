package com.ij34.oj.huawei.two.wa;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 没完成
 * 启动多任务排序
 * @Author: ij34
 * @Date: 2024-05-06
 */

public class MultiTaskScheduler {
    public static void main(String[] args) {
        //C->D C->B A->B
        String[] s = new Scanner(System.in).nextLine().split(" ");
        Map<String, List<String>> map = new HashMap<>();
        for (String a : s){
           String[] b= a.split("->");
           if (map.containsKey(b[1])){
               List<String> list =map.get(b[1]);
               list.add(b[0]);
               map.put(b[1],list);
           }else {
               List<String> list = new ArrayList<>();
               list.add(b[0]);
               map.put(b[1],list);
           }
        }
        List<String> l = new ArrayList<>();
        for (String key : map.keySet()){
            boolean isInclude= false;
            for (List<String> list : map.values()){
                if (list.contains(key)){
                    isInclude=true;
                    break;
                }
            }
            if (isInclude==false){
                l.add(key);
            }
        }
        LinkedList<String> deque = new LinkedList<>();
        l.sort(Comparator.naturalOrder());
        for (int i=0;i<l.size();i++){
            deque.addLast(l.get(i));
        }
        List<String> res = new ArrayList<>();
        while (deque.isEmpty()==false){
            String key =null;
            for (int i=0;i<deque.size();i++){
                boolean isInclude =false;
                for (List<String> list : map.values()){
                    if (list.contains(deque.get(i))){
                        isInclude=true;
                        break;
                    }
                }
                if (isInclude==false){
                    key=deque.get(i);
                    break;
                }
            }


            if (res.contains(key)==false){
                res.add(key);
            }
            deque.removeFirst();

            List<String> list =map.get(key);
            map.remove(key);

            if (list==null){
                continue;
            }

            list.sort(Comparator.naturalOrder());
            for (int i=0;i<list.size();i++){
                deque.addLast(list.get(i));
            }
        }
        System.out.println(res.stream().collect(Collectors.joining(" ")));
    }
}
