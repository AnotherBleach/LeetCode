package MySQLTest.ReadRepeatedable;

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
        //connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);允许脏读
        connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);//第二级别，阻止了脏读

        PreparedStatement ps1 = connection.prepareStatement("select count(*) from test_user");



        System.out.println("开始读取");
        ps1.execute();
        System.out.println("读取完了");
        ResultSet rs = ps1.getResultSet();
        while(rs.next())
        {
            System.out.println(rs.getInt(1));
        }

        TimeUnit.SECONDS.sleep(5);


        System.out.println("再次读取");
        ps1.execute();
        System.out.println("读取完了");
        rs = ps1.getResultSet();
        while(rs.next())
        {
            System.out.println(rs.getInt(1));
        }


    }
    public static void tx2() throws SQLException, InterruptedException {

        Connection connection =  DriverManager.getConnection("jdbc:mysql://192.168.99.100:33333/test?useUnicode=true&characterEncoding=utf-8","root","123456");
        connection.setAutoCommit(false);
        connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        PreparedStatement ps1 = connection.prepareStatement("insert into test_user(username,pwd) values (?,?)");

        TimeUnit.SECONDS.sleep(2);
        ps1.setObject(1,"李四");
        ps1.setObject(2,"23333");
        System.out.println("开始写入");
        ps1.execute();
        connection.commit();
        System.out.println("修改完了");



    }

}
