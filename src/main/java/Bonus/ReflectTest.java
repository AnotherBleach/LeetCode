package Bonus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

class grandpa{
    public  int a;
    public void grandpaMethgod(){

    }

}
class pa extends grandpa{
    public int b;
    public void paMethod()
    {


    }

}
class son extends pa{
    public int c;
    private int d;
    private void privateson(){

    }
    public void publicson(int a,int b)
    {
        System.out.println(a+b);
        throw  new NumberFormatException();

    }


}
public class ReflectTest {
    public static void main(String[] args) {
        son s = new son();
        s.publicson(2,3);
        Class clazz = son.class;

//        Method[] methods = clazz.getMethods();
//        System.out.println("Get Method...");
//        for(Method method:methods)
//            System.out.println(method.getName());
//        System.out.println("-----------------------");
//        System.out.println("Get Declared Method...");
//        methods = clazz.getDeclaredMethods();
//        for(Method method:methods)
//            System.out.println(method.getName());

//        Field[] fields = clazz.getFields();
//        for(Field field:fields)
//            System.out.println(field.getName());
//
//        System.out.println("-------------------------");
//
//         fields = clazz.getDeclaredFields();
//        for(Field field:fields)
//            System.out.println(field.getName());


//
//        Object obj = clazz.newInstance();
//        Method method = clazz.getMethod("publicson",int.class,int.class);
//        method.invoke(obj,2,3);
//





    }

}
