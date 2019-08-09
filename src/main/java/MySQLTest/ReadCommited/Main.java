package MySQLTest.ReadCommited;

import java.sql.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        new Thread(()->{
            try {
                tx1();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(()->{
            try {
                tx2();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
    public static void tx1() throws SQLException, InterruptedException {
        Connection connection =  DriverManager.getConnection("jdbc:mysql://192.168.99.100:33333/test?useUnicode=true&characterEncoding=utf-8","root","123456");
        connection.setAutoCommit(false);

        connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);


        PreparedStatement ps1 = connection.prepareStatement("select * from test_user where username = ?");
        ps1.setObject(1,"张三");
        ps1.execute();
        ResultSet rs = ps1.getResultSet();
        rs.next();
        System.out.println("开始读取");
        System.out.println("张三密码 "+rs.getString("pwd"));
        TimeUnit.SECONDS.sleep(3);
        ps1.execute();
        rs = ps1.getResultSet();
        rs.next();
        System.out.println("张三密码 "+rs.getString("pwd"));
        System.out.println("读取结束");
        connection.commit();


    }
    public static  void tx2() throws SQLException, InterruptedException {

        Connection connection =  DriverManager.getConnection("jdbc:mysql://192.168.99.100:33333/test?useUnicode=true&characterEncoding=utf-8","root","123456");
        connection.setAutoCommit(false);
        connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        TimeUnit.SECONDS.sleep(1);
       System.out.println("开始修改");
        PreparedStatement ps1 = connection.prepareStatement("update test_user set pwd=? where username=?");
        ps1.setObject(1,"niubi");
        ps1.setObject(2,"张三");
        ps1.execute();
        connection.commit();
        System.out.println("修改结束");
    }



}
