package com.ij34.oj.leetcode.array;

/**
 * 6. Z 字形变换
 * https://leetcode.cn/problems/zigzag-conversion
 *
 * @Author: ij34
 * @Date: 2024-07-10
 */

public class LC6 {

    public String convert(String s, int numRows) {
         if (numRows>=s.length() || numRows==1){
             return s;
         }

         StringBuilder[] array = new StringBuilder[numRows];
         for (int i=0;i<array.length;i++){
             array[i]=new StringBuilder();
         }
         int i=0,len=s.length(),index=0;
         boolean isDown=true;
         while (i<len){
             if (isDown){
                 if (index==numRows){
                     isDown=false;
                     index-=2;
                 }else {
                     array[index].append(s.charAt(i));
                     index++;
                     i++;
                 }
//                 continue;
             }else {
                 if (index==-1){
                     isDown=true;
                     index+=2;
                 }else {
                     array[index].append(s.charAt(i));
                     index--;
                     i++;
                 }

             }

         }
         StringBuilder sb =new StringBuilder();
         for (StringBuilder ss : array){
             System.out.println(ss.toString());
             sb.append(ss);
         }
         return sb.toString();
    }


}
