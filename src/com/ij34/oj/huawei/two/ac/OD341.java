package com.ij34.oj.huawei.two.ac;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 模拟目录管理功能
 * https://hydro.ac/d/HWOD2023/p/OD341
 * 有多个pwd输出最后一个，如果没有pwd也要输出“/”
 * @Author: ij34
 * @Date: 2024-06-09
 */

public class OD341 {
    static class DirNode{
        private String name;
        private DirNode parent;
        private List<DirNode>  childList;

        public DirNode(String name, DirNode parent, List<DirNode> childList) {
            this.name = name;
            this.parent = parent;
            this.childList = childList;
        }
    }

    public static void main(String[] args) {
        head = new DirNode("/",null,new ArrayList<>());
        current=head;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            process(str);

        }
        System.out.println(output==null?"/":output);

    }
    private static String output = null;
    private static DirNode current,head;
    private static void process(String str) {
        if ("pwd".equals(str)){
            pwd();
            return;
        }
        String[] s = str.split(" ");
        if (s.length!=2){
            return;
        }
        if (s[0].equals("mkdir")==false && s[0].equals("cd")==false){
            return;
        }
        String path = s[1];
        for (int i=0;i<path.length();i++){
            if (path.charAt(i)=='/'){
                return;
            }
        }

        if (s[0].equals("mkdir")){
            mkdir(s[1]);
            return;
        }

        if (s[0].equals("cd")){
            cd(s[1]);
            return;
        }

    }

    private static void cd(String str) {
        if ("..".equals(str)){
            if (current.parent!=null){
                current=current.parent;
            }
            return;
        }


        for (DirNode node : current.childList){
            if (str.equals(node.name)){
                current=node;
                return;
            }
        }

    }

    private static void mkdir(String path) {
        for (DirNode node : current.childList) {
            if (node.name.equals(path)) {
                return;
            }
        }
        current.childList.add(new DirNode(path,current,new ArrayList<>()));

    }

    private static void pwd() {
        ArrayDeque<String> deque = new ArrayDeque<>();
        DirNode parent= current;
        while (parent!=null){
            deque.addFirst(parent.name);
            parent=parent.parent;
        }
       String str=deque.stream().toList().stream().collect(Collectors.joining("/"));
        if (str.length()>1 && str.charAt(0)=='/' && str.charAt(1)=='/'){
            str=str.substring(1);
        }

        if (str.length()>1){
            str=str+"/";
        }
        output=str;
    }
}
