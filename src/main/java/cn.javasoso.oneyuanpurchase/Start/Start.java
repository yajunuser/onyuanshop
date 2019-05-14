package cn.javasoso.oneyuanpurchase.Start;

import cn.javasoso.oneyuanpurchase.Lottery.StratLottery;
import cn.javasoso.oneyuanpurchase.impl.Adminiimpl;

import java.util.Scanner;

public class Start {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (true) {
        System.out.println("**************************");
        System.out.println();
        System.out.println("1. 用 户 登 录");
        System.out.println();
        System.out.println("2. 用 户 注 册");
        System.out.println();
        System.out.println("3.管 理 登 录 ");
            System.out.println();
        System.out.println("**************************");

            System.out.println("输入你的选择：");
            Integer key = 0;
            try {
                key = Integer.valueOf(in.nextLine());
            } catch (Exception e) {
                System.out.println("请输入正确的数字");
            }
            switch (key) {
                case 1:
                    System.out.println("请输入账号：");
                    String name = in.nextLine();
                    System.out.println("请输入密码：");
                    String password = in.nextLine();
                    if (SignInMySQL.signIn(name,password)) {
                        System.out.println("******************************");
                        SeeMySQL.show();
                        System.out.println("******************************");
                        System.out.println("输入你要投注的商品");
                        Integer id = 0;
                        try{
                            id = Integer.valueOf(in.nextLine());
                        }catch(Exception e){
                            System.out.println("输入正确的数字");
                        }
                        System.out.println("输入您的会员名字：");
                        String username = in.nextLine();
                        System.out.println("输入你要投注的数目：");
                        Integer bet = 0;
                        try{
                            bet = Integer.valueOf(in.nextLine());
                        }catch(Exception e){
                            System.out.println("请输入数字");
                            break;
                        }
                        StratLottery.gobetting(id,username,bet);
                    }

                    break;
                case 2:
                    System.out.println("请输入您要注册的账号：");
                    String newname = in.nextLine();
                    System.out.println("请输入您的密码：");
                    String newpassword = in.nextLine();
                    AddMySql.addUser(newname,newpassword);
                    break;
                case 3:
                    Adminiimpl.Administration();
                    continue;
                default:
                    System.out.println("你输入的选项不存在！");
            }
            System.out.println("返回上一层输入n：");
            String ss = in.nextLine();
            if("N".equalsIgnoreCase(ss)){
                continue;
            }else{
                System.out.println("谢谢光临");
                break;
            }
        }
    }
}