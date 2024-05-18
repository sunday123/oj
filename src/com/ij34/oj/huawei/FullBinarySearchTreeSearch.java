package com.ij34.oj.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * OCR034. 满二叉搜索树查找
 * https://hydro.ac/d/HWOCR/p/OCR034
 * @Author: ij34
 * @Date: 2024-05-18
 */

public class FullBinarySearchTreeSearch  {
    static String res ="S";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = Arrays.stream(sc.nextLine().split(" ")).map(f->Integer.valueOf(f)).mapToInt(Integer::intValue).toArray();
        int k =Integer.valueOf(sc.nextLine());
        Arrays.sort(a);
        findTreeNode(a,k,0,a.length-1,(0+a.length-1)/2);
        if (res.endsWith("Y")==false){
            res+="N";
        }
        System.out.println("res:"+res);

    }

    private static void findTreeNode(int[] a, int k, int start, int end,int mid) {
        if (end<start || mid<0 || mid>=a.length){
            return;
        }
        if (a[mid]==k){
            res+= "Y";
        }else if (k<a[mid] && (start+mid-1)/2>=0 && mid-1>=0){
            res+="L";
            findTreeNode(a,k,start,mid-1,(start+mid-1)/2);
        }else if (k>a[mid] && (end+mid+1)/2<a.length && mid+1<a.length){
            res+="R";
            findTreeNode(a,k,mid+1,end,(end+mid+1)/2);
        }
    }
}
