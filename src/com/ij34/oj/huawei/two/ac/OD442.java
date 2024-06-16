package com.ij34.oj.huawei.two.ac;

import java.util.*;
import java.util.regex.Pattern;

/**
 * 模拟数据序列化传输
 * https://hydro.ac/d/HWOD2023/p/OD442
 * @Author: ij34
 * @Date: 2024-06-15
 */

public class OD442{
    static class Cell{
        private int index;
        private String type;
        private String content;
        public Cell(int index, String type, String content) {
            this.index = index;
            this.type = type;
            this.content = content;
        }

        @Override
        public String toString() {
            return "["+index+","+type+","+content+"]";
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=Integer.valueOf(sc.nextLine());
        String str =sc.nextLine();
        if (n==1){
          try {
              String res =encode(str);
              System.out.println(res);
          }catch (Exception e){
              System.out.println("ENCODE_ERROR");
          }
        }else {
            try {
                String res =decode(str);
                System.out.println(res);
            }catch (Exception e){
                System.out.println("DECODE_ERROR");
            }
        }


    }

    private static String decode(String str) {
        List<Cell> list = getDecodeCellList(str);
        if (list.isEmpty()){
            throw new IllegalArgumentException("");
        }
        StringJoiner sb = new StringJoiner(",");
        for (Cell cell :list){
            if ("Integer".equals(cell.type)){
                if (!Pattern.compile("[0-9]+").matcher(cell.content).matches()){
                    continue;
                }
                sb.add(cell.toString());

            }else if ("String".equals(cell.type)){
                if (!Pattern.compile("[0-9a-zA-z ]+").matcher(cell.content).matches()){
                    continue;
                }
                sb.add(cell.toString());
            }else {
                sb.add("["+cell.index+","+cell.type+","+decode(cell.content)+"]");
            }

        }

      return sb.toString();

    }

    private static List<Cell> getDecodeCellList(String str) {
        List<Cell> list = new ArrayList<>();
        while (str.isEmpty()==false){
            int index =str.indexOf('#');
            if (index<0){
                break;
            }
            String indexStr =str.substring(0,index);
            index =str.indexOf('#');
            if (index<0){
                break;
            }
            str=str.substring(index+1);
            String typeStr =str.substring(0,index);
            str=str.substring(index+1);
            index = str.indexOf('#');
            if (index<0){
                break;
            }
            String lenStr =str.substring(0,index);
            str=str.substring(index+1);
            String content =str.substring(0,Integer.valueOf(lenStr));
            str=str.substring(content.length());
            if (!Pattern.compile("[0-9]+").matcher(indexStr).matches()){
                continue;
            }
            if (!List.of("0","1","2").contains(typeStr)){
                continue;
            }
            if (typeStr.equals("0")){
                if (!Pattern.compile("[0-9]+").matcher(content).matches()){
                    continue;
                }
            }
            if (typeStr.equals("1")){
                if (!Pattern.compile("[0-9a-zA-z ]+").matcher(content).matches()){
                    continue;
                }

            }
            list.add(new Cell(Integer.valueOf(indexStr),getType(typeStr),content));

        }

        return list;
    }

    private static String getType(String type) {
        if ("0".equals(type)){
            return "Integer";
        }else if ("1".contains(type)){
            return "String";
        }else {
            return "Compose";
        }

    }

    private static String encode(String input) {
        List<Cell> list = getCellList(input);
        StringBuilder res = new StringBuilder();
        for (Cell cell :list){
            if (cell.type.equals("Integer")){
                if (!Pattern.compile("[0-9]+").matcher(cell.content).matches()){
                    continue;
                }
                res.append(cell.index+"#"+0+"#"+cell.content.length()+"#"+cell.content);
            }else if ( cell.type.equals("String")){
                if (!Pattern.compile("[0-9a-zA-z ]+").matcher(cell.content).matches()){
                    continue;
                }
                res.append(cell.index+"#"+1+"#"+cell.content.length()+"#"+cell.content);
            }else if (cell.type.equals("Compose")){
                res.append(getCompose(cell));
            }


        }
        return res.toString();
    }

    private static String getCompose(Cell input) {
        StringBuilder res = new StringBuilder();

        String content =encode(input.content);
        res.append(input.index+"#2#"+content.length()+"#"+content);
       return res.toString();
    }

    private static List<Cell> getCellList(String input) {
        List<String> typeList = List.of("Integer","String","Compose");
        List<Cell> list = new ArrayList<>();
        int left=0,start = 0;
        boolean preIsDot=false;
        for (int i=0;i<input.length();i++){
            char c=input.charAt(i);
            if (left==0){
                if (c==','){
                    if (preIsDot||(i==input.length()-1)){
                        throw new IllegalArgumentException("error");
                    }
                    preIsDot=true;
                    continue;
                }


                if (c=='['){
                    start=i;
                    left++;
                }else {
                    throw new IllegalArgumentException("error");
                }
                continue;
            }
            if (c==']'){
                if(left==1){
                    preIsDot=false;
                    String[] temp= input.substring(start+1,i).split(",",3);
                    if (typeList.contains(temp[1])){
                        list.add(new Cell(Integer.valueOf(temp[0]),temp[1],temp[2]));
                    }
                }
                left--;
                continue;
            }

            if (c=='['){
                left++;
            }
        }
        if (left!=0){
            throw new IllegalArgumentException("error");
        }
        return list;
    }
}
