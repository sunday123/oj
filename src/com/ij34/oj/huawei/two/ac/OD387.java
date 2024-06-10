package com.ij34.oj.huawei.two.ac;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 数据单元的变化替换
 * https://hydro.ac/d/HWOD2023/p/OD387
 *
 * @Author: ij34
 * @Date: 2024-06-08
 */

public class OD387 {

    public static void main(String[] args) {
        String[] s = new Scanner(System.in).nextLine().split(",");
        if (check(s)==false){
            System.out.println(-1);
            return;
        }
        boolean flag = false;
        Set<Integer> set = new HashSet<>();//判断循环依赖
        int pre=-1;
        for (int i=0;i<s.length;){
            String str = s[i];
            boolean isSwap=false;
            if (i!=pre){
                set.clear();
                set.add(i);
            }
            for (int j=0;j+2<str.length();j++){


                if (str.charAt(j)=='<' && str.charAt(j+2)=='>' && str.charAt(j+1)>='A' && str.charAt(j+1)<='Z'){
                    int index = (str.charAt(j+1) - 'A');
                    if (set.contains(index)){
                        System.out.println(-1);
                        return;
                    }
                    set.add(index);
                    String temp = s[index];
                    s[i]=str.substring(0,j) +temp+str.substring(j+3);
                    flag=true;
                    isSwap=true;
                    break;
                }
            }
            if (isSwap==false){
                i++;
            }
        }

        if (flag){
            System.out.println(Arrays.stream(s).collect(Collectors.joining(",")));
        }else {
            System.out.println(-1);
        }

    }

    private static boolean check(String[] s) {
        for (String str:s){
            Stack<Character> stack = new Stack<>();
            for (int i=0;i<str.length();i++){
                char c = str.charAt(i);
                if (c=='<'){
                    if (stack.isEmpty()){
                        stack.push(c);
                        continue;
                    }
                    return false;
                }

                if (c>='A' && c<='Z'){
                    if (stack.size()>0 && stack.peek()!='<'){
                        return false;
                    }
                    stack.push(c);
                    continue;
                }

                if (c=='>'){
                    if ((stack.size()>0 && stack.peek()>='A' && stack.peek()<='Z')==false){
                        return false;
                    }
                    int index=stack.pop()-'A';
                    if (index>=s.length){
                        return false;
                    }
                    stack.pop();
                }



            }
        }
        return true;
    }
}
