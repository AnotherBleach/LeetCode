package 通配符;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class People {
    //人
}
class Man extends People {
    //男人
}
class Woman extends People {
    //女人
}
class Boy extends Man {
    //男孩
}
class test<T extends String>{
    T a;
    public T show(T a)
    {
        return a;
    }

}
public class BoundTest {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        List<Integer>sb = new ArrayList<>();
        sb.add(12);
        //sb.add("hello");
        Method method = sb.getClass().getDeclaredMethod("add",Object.class);
        method.invoke(sb,"hello");
        Method method1 = sb.getClass().getDeclaredMethod("get",int.class);
        String test = (String)((method1.invoke(sb,1)));

        System.out.println(test);



//       test<String> a = new test();
//       String name = a.getClass().getDeclaredField("a").getName();
//       String clazz = a.getClass().getDeclaredField("a").getType().getName();
//        System.out.println(name+" "+clazz);
//        Method[] methods = a.getClass().getDeclaredMethods();
//        for(Method method:methods)
//            System.out.println(method.toString());


       // System.out.println(new ArrayList<Integer>().getClass());
        //System.out.println(new ArrayList<String>().getClass());
//        test<Integer> a = new test<>();
//        a.show();
////        List<? extends Man> list1= new ArrayList<Boy>();
//        //list1.add(new Man());//error,list1里面确实是people的子类，但不能确定是哪一种.添加元素很有可能不匹配。
//        People people = list1.get(0);//fine
//
//        List<People>list = new ArrayList<>();
//        list.add(new Man());


        ///////////////////////////////////////////////////
       // List<? super Man>list2 = new ArrayList<People>();
        // 里面存储的是man的基类。
        // 比如动物,所以可以往里面方男孩，但是不能放people。

//        list2.add(new Woman());//error ,显然
      //  list2.add(new People());//???
   //     list2.add(new Man());//
        //list2.add(new Boy());//
       // list2.get(0);

    }

}
