package cn.javasoso.oneyuanpurchase.Start;
import java.sql.*;
public class MysqlTest {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载驱动器！");
        }catch(ClassNotFoundException e){
            System.out.println("驱动器没找到");
            e.printStackTrace();
        }

        // -------
        // -------
        String n1 = "user2";
        Integer p1 = 1000;
        if (addUser(n1,p1)){
            System.out.println("注册成功");
        }else {
            System.out.println("注册失败");
        }



    }

    /**
     * 新增用户
     * @param name 用户姓名
     * @param price 价格
     * @return
     */
    public static boolean addUser(String name,Integer price){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(Constant.URL, Constant.user, Constant.user);
            System.out.println("成功链接到数据库！");


            // 拼装 SQL语句
            String addSql = "insert into users ( name,price) values (?,?)";
            PreparedStatement stem = conn.prepareStatement(addSql);
            stem.setString(1,name);
            stem.setInt(2,price);

            // 执行SQL
            int n = stem.executeUpdate();//开始执行SQL 返回的是多少行被改变了
            System.out.println("成功插入"+ n + "行");
            return n > 0;

/*
            // --- 搜索例子
            String sql = "select * from users where name = ?";
            PreparedStatement stem2 = conn.prepareStatement(sql);
            stem2.setString(1,"qqqq");
            //开始搜索 ResultSet 意思是多少行被改变了！
            ResultSet rs = stem2.executeQuery();
            System.out.println("编号"+"\t"+"姓名"+"\t"+"年龄");
            while (rs.next()){
                System.out.print(rs.getInt(1)+"\t"); //目标的第一纵列；
                System.out.print(rs.getString(2)+"\t");//目标的第二纵列；
                System.out.print(rs.getString(3)+"\t");//目标的第三纵列；
                System.out.println("---");
            }
            try{
            if(stem2 != null){
              stem2 = null;
              stem2.close();
              System.out.println("释放资源成功");
            }
             }catch(SQLException se){
             System.out.println("资源释放失败");
             }
            // ----
 */
        }catch(SQLException e){
            System.out.println("连接不成功");
            e.printStackTrace();
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
