package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * 根据IP查找城市
 * https://hydro.ac/d/HWOD2023/p/OD393
 * @Author: ij34
 * @Date: 2024-06-16
 */

public class OD393 {
    static class CityDto{
        private String name;
        private long start;
        private long end;

        public CityDto(String name, long start, long end) {
            this.name = name;
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String one = sc.nextLine(),two=sc.nextLine();
        List<CityDto> cityList= new ArrayList<>();
        for (String c : one.split(";")){
            String[] s = c.split("=");
            long index = s[0].hashCode();
            String[] ss =s[1].split(",");
            cityList.add(new CityDto(s[0],parseIp(ss[0]),parseIp(ss[1])));
        }
        StringJoiner sj = new StringJoiner(",");
        for (String str :two.split(",")){
            long current = parseIp(str);
            long dif=Long.MAX_VALUE;
            String selectCity="";
            for (CityDto city: cityList){
                if (current>=city.start && current<=city.end){
                    long len = city.end-city.start;
                    if (len<dif || (len==dif && selectCity.compareTo(city.name)<0)){
                        selectCity=city.name;
                        dif=city.end-city.start;
                    }

                }
            }

            sj.add(selectCity);
        }
        System.out.println(sj);



    }


    private static long parseIp(String str) {
        String[] s = str.split("\\.");
        long res=0;
        for (int i=0;i<s.length;i++){
            res+=Long.valueOf(s[i]);
            if (i<s.length-1){
                res=res<<8;
            }
        }
        return res;
    }

}
