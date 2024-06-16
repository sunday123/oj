package com.ij34.oj.huawei.two.wa;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 没ac
 * 音乐小说内容重复识别
 * https://hydro.ac/d/HWOD2023/p/OD441
 * @Author: ij34
 * @Date: 2024-06-15
 */

public class OD441 {
    static class DsUnion{
        private Map<String,String> parent = new HashMap<>();

        private DsUnion(List<String> list){
            for (String str:list){
                String[] s = str.split(" ");
                if (s.length<2){
                    union(str,"");
                }
                for (int i=1;i<s.length;i++){
                    parent.put(s[i],s[0]);
                    union(s[i],s[0]);
                }
            }

        }

        private String find(String key){
            if (parent.values().contains(key)){
                return key;
            }
            if (parent.containsKey(key)){
                return find(parent.get(key));
            }
            return key;
        }
        private void union(String x,String y){
            String xx =find(x);
            String yy =find(y);
            if (xx.equals(yy)==false){
                parent.put(xx,yy);
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1= sc.nextLine();
        String s2=sc.nextLine();
        List<String> list = new ArrayList<>();
        Map<String,String> regexMap = new HashMap<>();
        while (sc.hasNextLine()){
            String str = sc.nextLine().trim();
            if (str.isEmpty()){
                sc.close();
                break;
            }
            list.add(str);
            String[] ss =str.split(" ");
            for (String str2 :ss){
                String regex =str2.replace("***",".*").replace("(","\\(").replace(")","\\)")
                        .replace("[","\\[").replace("]","\\]");
                regexMap.put(str2,str2.contains("***")?regex:str2);
            }
            if (ss.length<2){
                regexMap.put("","");
            }

        }
        dsUnion = new DsUnion(list);

        process(s1,s2,regexMap);

        if (unSameList.isEmpty()){
            System.out.println("True");
            sameList.forEach(System.out::println);
        }else {
            System.out.println("False");
            unSameList.forEach(System.out::println);
        }


    }
    private static DsUnion dsUnion;
    private static void process(String s1, String s2,Map<String,String> regexMap) {
        if (s1.isEmpty() && s2.isEmpty()){
            return;
        }
        for (Map.Entry<String,String> entry : regexMap.entrySet()){
            Matcher matcher = Pattern.compile(entry.getValue()).matcher(s1);
            if (matcher.find()==false || matcher.start()!=0){
                continue;
            }
            for (Map.Entry<String,String> entry2 : regexMap.entrySet()){
                Matcher matcher2 = Pattern.compile(entry2.getValue()).matcher(s2);
                boolean find2=matcher2.find();
                if (find2==false || matcher2.start()!=0){
                    continue;
                }
                if (entry.getValue().isEmpty() && entry2.getValue().isEmpty()){
                    continue;
                }

                if (dsUnion.find(entry.getKey()).equals(dsUnion.find(entry2.getKey()))){
                    if (entry.getKey().equals(entry2.getKey())==false){
                        sameList.add((entry.getKey()+" "+entry2.getKey()).trim());
                    }
                    process(s1.substring(matcher.group().length()),s2.substring(matcher2.group().length()),regexMap);
                    return;


                }
            }
        }

        if (s1.length()>0 && s2.length()>0 && s1.charAt(0)==s2.charAt(0)){
            process(s1.substring(1),s2.substring(1),regexMap);
        }else {
            unSameList.add(s1+" " +s2);
        }

    }


    private static Set<String> sameList = new HashSet<>(),unSameList = new HashSet<>();

}
