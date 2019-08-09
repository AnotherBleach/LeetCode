package Bonus;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ok{
    private void test(){
        System.out.println("oh!");
    }
    static {
        System.out.println("第一静态块");

    }
    {
        System.out.println("第一普通块");

    }
    ok(){

        System.out.println("构造函数");
    }
    {
        System.out.println("第二普通块");

    }
    static {
        System.out.println("第二静态块");

    }

}
class notok extends ok{

    static {
        System.out.println("子类第一静态块");

    }
    {
        System.out.println("子类第一普通块");

    }
    notok(){

        System.out.println("子类构造函数");
    }
    {
        System.out.println("子类第二普通块");

    }
    static {
        System.out.println("子类第二静态块");

    }
}
public class StaticTest {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {

        int[] data = new int[]{100,23,567,1500,700};
        for (int i:data
             ) {

            new Thread(()->{
                try {

                    Thread.sleep(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);

            }).start();
        }
//          notok not = notok.class.getDeclaredConstructor().newInstance();
//          Method method = notok.class.getSuperclass().getDeclaredMethod("test");
//          method.setAccessible(true);
//          method.invoke(not);

//        System.out.println(notok.class.getConstructors().length);
//        notok ok = (notok) notok.class.getDeclaredConstructor().newInstance();
//
//        Method method = notok.class.getDeclaredMethod("test");
//        method.setAccessible(true);
//        method.invoke(ok);
//        new notok();
//        System.out.println("---------");
//        new notok();
    }



}
