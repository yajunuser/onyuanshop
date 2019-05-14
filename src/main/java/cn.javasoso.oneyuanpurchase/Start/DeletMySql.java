package cn.javasoso.oneyuanpurchase.Start;

import java.sql.*;

public class DeletMySql {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("驱动器加载成功");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动器没找到");
            e.printStackTrace();

        }
//        DeleteCommodity(4);
//        Deleteuser("lll");
    }

    public static boolean Deleteuser(String name) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(Constant.URL, Constant.user, Constant.user);
//            System.out.println("链接数据库成功");
            //先在数据库中搜索
            String searchUser = "delete from users where name =?";
            PreparedStatement stem = conn.prepareStatement(searchUser);
            stem.setString(1, name);
            int rs = stem.executeUpdate();
            if (rs > 0) {
                System.out.println("删除成功");
                return true;
            } else {
                System.out.println("删除失败");
                return false;
            }
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
//                    System.out.println("资源释放成功");
                }
            } catch (Exception e) {
                System.out.println("资源释放失败");
            }
        }
    }

    //根据商品id 删除商品
    public static boolean DeleteCommodity(int id) {
        String url = "jdbc:mysql://db.javasoso.com/yajun_test";//JDBC 的 URL
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(Constant.URL, Constant.user, Constant.user);
//            System.out.println("链接数据库成功");
            //先在数据库中搜索
            String searchUser = "delete from Commodity where id =?";
            PreparedStatement stem = conn.prepareStatement(searchUser);
            stem.setInt(1, id);
            int rs = stem.executeUpdate();
            if (rs > 0) {
                System.out.println("删除成功！");
                return true;
            } else {
                System.out.println("删除失败");
                return false;
            }
        } catch (SQLException se) {
            se.printStackTrace();

            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
//                    System.out.println("资源释放成功");
                }
            } catch (Exception e) {
                System.out.println("资源释放失败");
            }
        }
    }
}