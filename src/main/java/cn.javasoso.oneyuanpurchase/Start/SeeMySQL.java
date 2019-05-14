package cn.javasoso.oneyuanpurchase.Start;
import java.sql.*;
public class SeeMySQL {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("驱动器加载成功");
        }catch(ClassNotFoundException e){
            System.out.println("驱动器没找到");
            e.printStackTrace();

        }
        show();
    }
    //创建一个类 判断会员是否存在
    public  static boolean Seeuser(String name){
        String url =  "jdbc:mysql://db.javasoso.com/yajun_test";//JDBC 的 URL
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(Constant.URL, Constant.user, Constant.user);
//            System.out.println("链接数据库成功");
            //先在数据库中搜索
            String searchUser = "select * from users where name = ?";
            PreparedStatement stem = conn.prepareStatement(searchUser);
            stem.setString(1,name);
            ResultSet rs = stem.executeQuery();
            while(rs.next()) {
                return true;
              }
             return false;
            }catch (SQLException se){
            System.out.println("查询失败");
                return false;
            }finally {
                try {
                    if (conn != null) {
                        conn.close();
//                        System.out.println("资源释放成功");
                    }
                }catch (Exception e){
                    System.out.println("资源释放失败");
                }
            }
    }
    //得到 对应商品的价格
    public static int getPrice(int id){
        String url =  "jdbc:mysql://db.javasoso.com/yajun_test";//JDBC 的 URL
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(Constant.URL, Constant.user, Constant.user);
//           System.out.println("链接数据库成功");
            //先在数据库中搜索
            String searchUser = "select * from Commodity where id= ?";
            PreparedStatement stem = conn.prepareStatement(searchUser);
            stem.setInt(1,id);
            ResultSet rs = stem.executeQuery();
            while(rs.next()){
                return rs.getInt(3);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            try {
                if (conn != null) {
                    conn.close();
//                   System.out.println("资源释放成功");
                }
            }catch (Exception e){
                System.out.println("资源释放失败");
            }
        }
        return -1;
    }
    //根据名字找 价格
    public static int getPrice(String name){
        String url =  "jdbc:mysql://db.javasoso.com/yajun_test";//JDBC 的 URL
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(Constant.URL, Constant.user, Constant.user);
//           System.out.println("链接数据库成功");
            //先在数据库中搜索
            String searchUser = "select * from Commodity where name= ?";
            PreparedStatement stem = conn.prepareStatement(searchUser);
            stem.setString(1,name);
            ResultSet rs = stem.executeQuery();
            while(rs.next()){
                return rs.getInt(3);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            try {
                if (conn != null) {
                    conn.close();
//                   System.out.println("资源释放成功");
                }
            }catch (Exception e){
                System.out.println("资源释放失败");
            }
        }
        return -1;
    }


   public static void show(){
      Connection conn = null;
       try{
           conn = DriverManager.getConnection(Constant.URL, Constant.user, Constant.user);
//           System.out.println("链接数据库成功");
           //先在数据库中搜索
           String searchUser = "select id,name,price from Commodity";
           PreparedStatement stem = conn.prepareStatement(searchUser);
           ResultSet rs = stem.executeQuery();
           while(rs.next()){
               System.out.print(rs.getInt(1)+"\t\t");
               System.out.print(rs.getString(2)+"\t\t");
               System.out.println(rs.getInt(3)+"\t");
           }
       }catch (SQLException se){
           se.printStackTrace();
       }finally {
           try {
               if (conn != null) {
                   conn.close();
//                   System.out.println("资源释放成功");
               }
           }catch (Exception e){
               System.out.println("资源释放失败");
           }
       }
   }
//   public static void showAll(){
//        int count =1;
//        while(show(count)){
//            System.out.println();
//         count++;
//        }
//   }
}
