package com.ij34.oj.huawei.test;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Author: ij34
 * @Date: 2024-05-28
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] one = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int productCount=one[0],moneyTotal = one[1],maxRisk=one[2];
        int[] returnArray = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] riskArray = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] allowArray = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] res = new int[productCount];
        int max =0,tempRisk=Integer.MAX_VALUE;
        for (int i=0;i<productCount;i++){
            for (int j=i;j<productCount;j++){
                for (int allowI=0;allowI<=allowArray[i];allowI++){
                    for (int allowJ=0;allowJ<=allowArray[j];allowJ++){
                        if (i==j && allowI+allowJ>allowArray[i]){
                            continue;
                        }
                        int totalAllow = allowI+allowJ;
                        int riskAllow=riskArray[i]+(i==j?0:riskArray[j]);
                        if (riskAllow>maxRisk || totalAllow>moneyTotal){
                            continue;
                        }
                        int totalReturn = allowI*returnArray[i]+allowJ*returnArray[j];
                        if (totalReturn>max){
                            res = new int[productCount];
                            res[i]=allowI;
                            res[j]=allowJ;
                            max=totalReturn;
                        }else if (totalReturn==max && riskAllow<tempRisk){
                            res = new int[productCount];
                            res[i]=allowI;
                            res[j]=allowJ;
                            max=totalReturn;
                            tempRisk=riskAllow;
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.stream(res).boxed().map(Objects::toString).collect(Collectors.joining(" ")));
    }
}
