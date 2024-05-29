package com.ij34.oj.huawei.campus;

import java.util.*;

/**
 * OCR033. 计算云服务DI值
 * https://hydro.ac/d/HWOCR/p/OCR033
 * @Author: ij34
 * @Date: 2024-05-19
 */

public class CloudServiceDIAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ones = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M=ones[0],N=ones[1];
        String[][] a = new String[N][4];
        Set<String> hash = new HashSet<>();
        for (int i=0;i<N;i++){
            a[i]= sc.nextLine().split(" ");
            if ("*".equals(a[i][1])){
                hash.add(a[i][0]);
            }
        }
        List<List<String>> tree= new ArrayList<>();
        for (String s : hash){
            tree.add(new ArrayList<>(List.of(s)));
        }
        int[][] score = new int[hash.size()][2];
        List<Integer> list = new ArrayList<>();
        while (list.size()<N){
            for (int i=0;i<N;i++){
                if (list.contains(i)){
                    continue;
                }

                for (int j=0;j<tree.size();j++){
                    if (tree.get(j).contains(a[i][1]) || tree.get(j).contains(a[i][0])){
                        list.add(i);
                        if (a[i][1].equals("*")==false){
                            tree.get(j).add(a[i][0]);
                        }
                        if (a[i][2].equals("0")){
                            score[j][0]=score[j][0]+Integer.valueOf(a[i][3]);
                        }else if (a[i][2].equals("1")){
                            score[j][1]=score[j][1]+Integer.valueOf(a[i][3]);
                        }
                        break;
                    }
                }
            }
        }
        int res=0;
        for (int i=0;i<score.length;i++){
            if (score[i][0]*5+score[i][1]*2>M){
                res++;
            }
        }
        System.out.println(res);
    }
}
