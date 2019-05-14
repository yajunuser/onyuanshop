package cn.javasoso.oneyuanpurchase.impl;

import cn.javasoso.oneyuanpurchase.Lottery.StratLottery;
import cn.javasoso.oneyuanpurchase.Start.AddMySql;

import java.util.Scanner;

public class Adminiimpl {
    public static void Administration() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("**************************");
            System.out.println();
            System.out.println("\t\t\t" + "1.添 加 用 户");
            System.out.println();
            System.out.println("\t\t\t" + "2.添 加 商 品");
            System.out.println();
            System.out.println("\t\t\t" + "3.开 奖");
            System.out.println();
            System.out.println("\t\t\t"+"4.返 回");
            System.out.println("**************************");
            System.out.println("请输入你的选择：");
            Integer key = 0;
            try {
                key = Integer.valueOf(in.nextLine());
            } catch (Exception e) {
                System.out.println("请输入对应的选择！");
            }
            switch (key) {
                case 1:
                    System.out.println("请输入账号：");
                    String name = in.nextLine();
                    System.out.println("请输入密码：");
                    String password = in.nextLine();
                    AddMySql.addUser(name,password);
                    break;
                case 2:
                    System.out.println("请输入商品名字：");
                    String good = in.nextLine();
                    System.out.println("请输入商品价格：");
                    Integer goodprice = 0;
                    try{
                        goodprice = Integer.valueOf(in.nextLine());
                    }catch(Exception e){
                        System.out.println("请输入正确的价格");
                        break;
                    }
                    AddMySql.addCommodity(good,goodprice);
                    break;
                case 3:
                    System.out.println("输入开奖商品");
                   Integer n = 0;
                    try{
                       n = Integer.valueOf(in.nextLine());
                    }catch(Exception e){
                        System.out.println("请输入正确商品id");
                        break;
                    }
                    StratLottery.goLottery(n);
                    break;
                case 4:
                     return;
                default:
            }
            System.out.println("返回上一层输入n：");
            String ss = in.nextLine();
            if ("N".equalsIgnoreCase(ss)) {
                continue;
            } else {
                System.out.println("谢谢光临");
                break;
            }
        }
    }
}