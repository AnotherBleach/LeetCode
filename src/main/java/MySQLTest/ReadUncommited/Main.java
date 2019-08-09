package MySQLTest.ReadUncommited;

import java.sql.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");//去加载类


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
        connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);//第二级别，阻止了脏读
        TimeUnit.SECONDS.sleep(3);
        PreparedStatement ps1 = connection.prepareStatement("select * from test_user where  username=?");


        ps1.setObject(1,"张三");
        System.out.println("开始读取");
        ps1.execute();
        connection.commit();

        System.out.println("读取完了");
        ResultSet rs = ps1.getResultSet();

        while(rs.next())
        {
            String pwd = rs.getString("pwd");
            System.out.println("张三的密码是 "+pwd);

        }


    }
    public static void tx2() throws SQLException, InterruptedException {

        Connection connection =  DriverManager.getConnection("jdbc:mysql://192.168.99.100:33333/test?useUnicode=true&characterEncoding=utf-8","root","123456");
        connection.setAutoCommit(false);
        connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
        PreparedStatement ps1 = connection.prepareStatement("update test_user set pwd = ? where  username=?");


        ps1.setObject(1,"You_Should_Not_Read_This");
        ps1.setObject(2,"张三");
        System.out.println("开始写入");
        ps1.execute();
        System.out.println("以为修改完了");
        TimeUnit.SECONDS.sleep(10);
        System.out.println("取消修改");
        connection.rollback();


    }



}
