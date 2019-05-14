package cn.javasoso.oneyuanpurchase.Lottery;

import cn.javasoso.oneyuanpurchase.Start.SeeMySQL;
import cn.javasoso.oneyuanpurchase.dao.Betting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StratLottery {
    //吧用户数据和 商品数据导入该方法

    private static ArrayList<Betting> userbet = new ArrayList<Betting>();


    //创建一个投注方法 需要输入 投注的商品 投注这 和投注的数目
    //投注时 判断总投注是否大于商品价格 如果大于则投注失败 并告诉投注者最大的投注数
    public static void gobetting(Integer id, String name, Integer bet) {
        int price = SeeMySQL.getPrice(id);
        if(price<0){ return;}
        int allsetcount = 0;
        System.out.println("**");
            for (int x = 0; x < userbet.size(); x++) {
                allsetcount = allsetcount + userbet.get(x).getBettingcount();
            }

        if (allsetcount+bet > price) {
            System.out.println("投注超过价格本身:"+(allsetcount+bet-price));
            return;
        }

        if(!SeeMySQL.Seeuser(name)){
            System.out.println("会员名不存在");
            return;
        }
        userbet.add(new Betting(name, bet));
        System.out.println("投注成功");


    }

    //创建一个开奖的方法  如果投注未满 提示不能开奖
    //投注正好等于商品的价格 则开始随机的抽取中将的用户
    public static void goLottery(int id) {
        int price = SeeMySQL.getPrice(id);
        if(price<0){ return;}
        int allsetcount = 0;
        for (Betting b : userbet) {
            allsetcount += b.getBettingcount();
        }
        //投注数等于商品价格
        if (allsetcount < price) {
            System.out.println("投注未满不能开奖");
            return;
        }

        List<Double> arr = new ArrayList<Double>();
        double x = 0;
        for (Betting b : userbet) {
            x+= b.getBettingcount();
            arr.add(x);
        }
//        double random = Math.random()*price+1;
         int r = random(1,price);
//        arr.add(random);
//        Collections.sort(arr);
//        System.out.println(r);
        for (Double d : arr) {
            if(r <= d){
                System.out.println("恭喜中奖的是："+userbet.get(arr.indexOf(d)).getUser());
                break;
            }else {
                System.out.println("--");
            }
        }
    }

    public static int random(int begin,int end){
        Random r = new Random(System.currentTimeMillis());
        return r.nextInt(end-begin + 1)+begin;
    }

}


