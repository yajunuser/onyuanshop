package cn.javasoso.oneyuanpurchase.Start;
import java.sql.*;
public class AddMySql {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动器加载成功");
        }catch(ClassNotFoundException e){
            System.out.println("驱动器没找到");
            e.printStackTrace();

        }
        addCommodity("的开始",100);

    }

    public static boolean addUser(String name, String password) {

        Connection conn = null;
        try{
            conn = DriverManager.getConnection(Constant.URL, Constant.user, Constant.user);
            System.out.println("链接数据库成功");
            //先在数据库中搜索
            String searchUser = "select * from users where name = ?";
            PreparedStatement stem = conn.prepareStatement(searchUser);
            stem.setString(1,name);
            ResultSet rs = stem.executeQuery();
            while(rs.next()) {
                System.out.println("用户以存在");
                return false;
            }
            String adduser = "insert into users (name,password) values(?,?)";
            PreparedStatement stem1 = conn.prepareStatement(adduser);
            stem1.setString(1,name);
            stem1.setString(2,password);
            int n = stem1.executeUpdate();
            if(n>0){
                System.out.println("添加成功");
                return true;
            }else{
                System.out.println("用户添加失败");
                return false;
            }



        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }finally {
            try {
                if (conn != null) {
                    conn.close();
//                    System.out.println("资源释放成功");
                }
            }catch (Exception e){
                System.out.println("资源释放失败");
            }
        }
    }
    public static boolean addCommodity(String name,Integer price) {
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(Constant.URL, Constant.user, Constant.user);
//            System.out.println("链接数据库成功");
            //先在数据库中搜索
            String searchUser = "select * from Commodity where name = ?";
            PreparedStatement stem = conn.prepareStatement(searchUser);
            stem.setString(1,name);
            ResultSet rs = stem.executeQuery();
            while(rs.next()) {
                System.out.print(rs.getInt(1));
                System.out.print(rs.getString(2));
                System.out.println(rs.getInt(3));
                System.out.println("商品以存在");
                return false;
            }
            String adduser = "insert into Commodity (name,price) values(?,?)";
            PreparedStatement stem1 = conn.prepareStatement(adduser);
            stem1.setString(1,name);
            stem1.setInt(2,price);
            int n = stem1.executeUpdate();
            if(n>0){
                System.out.println("添加成功");
                return true;
            }else{
                System.out.println("商品添加失败");
                return false;
            }



        }catch (SQLException se){
//            se.printStackTrace();
            System.out.println("添加失败");
            return false;
        }finally {
            try {
                if (conn != null) {
                    conn.close();
//                    System.out.println("资源释放成功");
                }
            }catch (Exception e){
                System.out.println("资源释放失败");
            }
        }
    }

}
