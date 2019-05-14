package cn.javasoso.oneyuanpurchase.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        //把字符串改成 日期格式
        String bir = "1992-10-18";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date date = sdf.parse(bir);
            System.out.println(sdf.format(date));
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
