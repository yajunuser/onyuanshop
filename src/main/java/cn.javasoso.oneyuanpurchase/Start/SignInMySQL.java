package cn.javasoso.oneyuanpurchase.Start;
import java.sql.*;
public class SignInMySQL {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动器加载成功");
        }catch(ClassNotFoundException e){
            System.out.println("驱动器没找到");
            e.printStackTrace();

        }
//        addUser("admin","admin");
    }
    public static boolean signIn(String name,String password) {
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
                if(rs.getString(2).equals(name) && rs.getString(3).equals(password)){
                    System.out.println("登录成功");
                    return true;
                }else{
                    System.out.println("用户账号密码不正确");
                }
            }
            System.out.println("用户不存在，请注册");
         return false;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("资源释放成功");
                }
            }catch (Exception e){
                System.out.println("资源释放失败");
            }
        }
    }
}
