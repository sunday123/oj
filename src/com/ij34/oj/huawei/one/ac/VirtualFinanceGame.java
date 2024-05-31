package com.ij34.oj.huawei.one.ac;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *  虚拟理财游戏
 *  https://hydro.ac/d/HWOD2023/p/OD372
 *
 * @Author: ij34
 * @Date: 2024-05-31
 */

public class VirtualFinanceGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] one = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int productCount = one[0], limitMoney = one[1], limitRisk = one[2];
        int[] returnArray = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] riskArray = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] investArray = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] res = new int[productCount];
        int maxReturn = 0,minRisk=Integer.MAX_VALUE; //在风险内的最大回报
        for (int i = 0; i < productCount; i++) {
            for (int j = i; j < productCount; j++) {
                if (i==j){//只投一个产品
                    if (riskArray[i]>limitRisk){
                        continue;
                    }
                    int invest = Math.min(investArray[i],limitMoney);
                    int totalReturn = invest * returnArray[i];
                    if (totalReturn>maxReturn ||(totalReturn==maxReturn && riskArray[i]<minRisk)){
                        res=new int[productCount];
                        res[i]=invest;
                        maxReturn=invest*returnArray[i];
                        minRisk=riskArray[i];
                    }
                    continue;
                }

                int investI=0,investJ=0;
                if (returnArray[i]>returnArray[j] || (returnArray[i]==returnArray[j] && riskArray[i]<=riskArray[j])){//比较回报和风险
                    investI=Math.min(limitMoney,investArray[i]);
                    investJ=Math.min(limitMoney-investI>0?limitMoney-investI:0,investArray[j]);
                }else if (returnArray[i]<returnArray[j] || (returnArray[i]==returnArray[j] && riskArray[i]>riskArray[j])){
                    investJ=Math.min(limitMoney,investArray[j]);
                    investI=Math.min(limitMoney-investJ>0?limitMoney-investJ:0,investArray[i]);
                }
                if (investI==0&&investJ==0){
                    continue;
                }

                int totalReturn = investI * returnArray[i] + investJ * returnArray[j];
                int risk =(investI>0?riskArray[i]:0)+(investJ>0?riskArray[j]:0);
                if (risk>limitRisk){
                    continue;
                }

                if (totalReturn > maxReturn ||(totalReturn==maxReturn && risk<minRisk)) {
                    res=new int[productCount];
                    res[i]=investI;
                    res[j]=investJ;
                    maxReturn=totalReturn;
                    minRisk=risk;
                }
            }
        }
        System.out.println(Arrays.stream(res).boxed().map(Objects::toString).collect(Collectors.joining(" ")));
    }
}
