package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 符号运算
 * https://hydro.ac/d/HWOD2023/p/OD392
 * @Author: ij34
 * @Date: 2024-06-14
 */

public class OD392 {


    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();
        for (char c :new Scanner(System.in).nextLine().replaceAll(" ","").toCharArray()){
            list.addLast(c);
        }
        try {
            FenNum res = process(list);
            System.out.println(res.toString());
        }catch (Exception e){
            System.out.println("ERROR");
        }
    }

    private static FenNum process(LinkedList<Character> list) {
        FenNum head =  process2(list);
        while (list.isEmpty()==false && List.of('+','-').contains(list.peek())){
            char ch = list.poll();
            FenNum next =  process2(list);
            if (ch=='+'){
                head= head.add(next);
            }else {
                head= head.sub(next);
            }
        }
        return head;
    }

    private static FenNum process2(LinkedList<Character> list) {
        FenNum head =  processFactor(list);
        while (list.isEmpty()==false && List.of('*','/').contains(list.peek())){
            char ch = list.poll();
            FenNum next =  processFactor(list);
            if (ch=='*'){
                head= head.mul(next);
            }else {
                head= head.div(next);
            }
        }
        return head;


    }

    private static FenNum processFactor(LinkedList<Character> list) {
        if (list.peek()=='('){
            list.poll();
            FenNum fenNum = process(list);
            if (list.isEmpty() || list.poll()!=')'){
                throw new IllegalArgumentException("error");
            }
            return fenNum;

        }else {
            return parseNum(list);
        }

    }

    private static FenNum parseNum(LinkedList<Character> list) {
        StringBuilder sb= new StringBuilder();
        while (list.isEmpty()==false && list.peek()>='0' && list.peek()<='9'){
            sb.append(list.poll());
        }
        return new FenNum(Integer.valueOf(sb.toString()),1);
    }

    static class FenNum{
        private int son;
        private int mom;

        public FenNum(int son, int mom) {
            if (mom==0){
                throw new IllegalArgumentException("error");
            }

            if (mom<0){
                son=-son;
                mom=-mom;
            }

            int gcd=gcd(Math.abs(son),Math.abs(mom));
            this.son = son/gcd;
            this.mom = mom/gcd;
        }

        private FenNum add(FenNum other){
            return new FenNum(this.son*other.mom+other.son*this.mom,this.mom*other.mom);
        }
        private FenNum sub(FenNum other){
            return new FenNum(this.son*other.mom-other.son*this.mom,this.mom*other.mom);
        }
        private FenNum mul(FenNum other){
            return new FenNum(this.son*other.son,this.mom*other.mom);
        }
        private FenNum div(FenNum other){
            if (other.mom==0){
                throw new IllegalArgumentException("error");
            }
            return new FenNum(this.son*other.mom,other.son*this.mom);
        }

        @Override
        public String toString() {
            if (this.mom==1){
                return Integer.toString(son);
            }
            return son+"/"+mom;
        }

        private int gcd(int a, int b) {
            while (b!=0){
                int c=b;
                b=a%b;
                a=c;

            }
            return a;
        }
    }
}
