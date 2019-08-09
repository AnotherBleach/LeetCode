package 通配符;
import javax.xml.ws.FaultAction;
import java.io.ObjectOutputStream;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 水果名称注解
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
@interface FruitName {
    String value() default "";

}
public class Annotation {


    HashMap s;

    Hashtable b;
    @FruitName("Apple")
    String name;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        String x="2";
        ObjectOutputStream objectOutputStream;
        new ArrayList<>().add(2);
        Integer[] testint = new Integer[]{2,3};
        int[] testint2 = new int[]{4,5};
//        List y = Arrays.asList(testint);

//        x.hashCode();
//
//        Annotation  annotation = new Annotation();
//
//        //注解如何使用
//        String value = annotation.getClass().getDeclaredField("name").getAnnotation(FruitName.class).value();
//        annotation.getClass().getDeclaredField("name").set(annotation,value);
//        //注解如何使用
//
//        System.out.println(annotation.name);

        List list = Arrays.asList(testint2);
        for(Iterator i = list.iterator();i.hasNext();){
            int[] data = (int[])i.next();
            System.out.println(data[0]+" "+data[1]);
        }
    }


}
