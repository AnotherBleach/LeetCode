package MySQLTest.Simple;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");//去加载类
            connection =  DriverManager.getConnection("jdbc:mysql://192.168.99.100:33333/test?useUnicode=true&characterEncoding=utf-8","root","123456");
            connection.setAutoCommit(false);
            System.out.println("1111");
            ps1 = connection.prepareStatement("insert into test_user(username,pwd) values (?,?)");
            ps1.setObject(1,"张三");
            ps1.setObject(2,"666666");
            ps1.execute();
            System.out.println("2222");
            System.out.println("插入一个用户张三");
            try{
                TimeUnit.SECONDS.sleep(3);


            }catch (InterruptedException e){

                e.printStackTrace();

            }
            ps2 = connection.prepareStatement("insert into test_user(username,pwd) valus (?,?)");
            ps2.setObject(1,"李四");
            ps2.setObject(2,"123456");
            ps2.execute();
            System.out.println("插入一个用户李四");
            connection.commit();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            try{
                connection.rollback();

            } catch (SQLException e1) {
                e1.printStackTrace();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            System.out.println("closing....");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(ps1!=null)ps1.close();
            if(ps2!=null)ps2.close();
            if(connection!=null)connection.close();
        }


    }
}
