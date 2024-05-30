package com.ij34.oj.huawei.two.ac;

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
//            System.out.println(key+"=>"+map.get(key));
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
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.naturalOrder());
        //   System.out.println("l:"+l);
        for (int i=0;i<l.size();i++){
            queue.offer(l.get(i));
        }

        List<String> res = new ArrayList<>();
        List<String> inList = new ArrayList<>();//包含

        while (queue.isEmpty()==false || inList.isEmpty()==false){
            if (queue.isEmpty()) {
                // 这里改变为检查inList中的任务是否可以移入queue
                List<String> readyToQueue = new ArrayList<>();
                for (String task : inList) {
                    boolean isInclude = true;
                    for (List<String> list : map.values()) {
                        if (list.contains(task)) {
                            isInclude = false;
                            break;
                        }
                    }
                    if (isInclude) {
                        readyToQueue.add(task);
                    }
                }
                inList.removeAll(readyToQueue);
                queue.addAll(readyToQueue);

                if (queue.isEmpty() && inList.isEmpty()) {
                    break;  // 防止死循环
                }
            }

            String key = queue.poll();
            boolean isInclude =false;
            for (List<String> list : map.values()){
                if (list.contains(key)){
                    isInclude=true;
                    break;
                }
            }
            if (isInclude){
                inList.add(key);
                continue;
            }

            if (res.contains(key)==false){
                res.add(key);
            }

            List<String> list =map.get(key);
            map.remove(key);

            if (list==null){
                continue;
            }

            for (int i=0;i<list.size();i++){
                inList.add(list.get(i));
            }
        }
        System.out.println(res.stream().collect(Collectors.joining(" ")));
    }
}
