package Bonus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Fruit {}
class Apple extends Fruit {}
class Orange extends Fruit {}

class util{

    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e .compareTo(elem)>0 )  // compiler error
                ++count;
        return count;
    }

    public static <T extends Comparable<T>> int countGreaterThan2(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0)
                ++count;
        return count;
    }
}
public class Fanxin {

//    static List<Apple> apples = Arrays.asList(new Apple());
//    static List<Fruit> fruit = Arrays.asList(new Fruit());
//    static class Reader<T> {
//        T readExact(List<? extends T> list) {
//            return list.get(0);
//        }
//    }
//    static void f1() {
//        Reader<Fruit> fruitReader = new Reader<Fruit>();
//        // Errors: List<Fruit> cannot be applied to List<Apple>.
//         Fruit f = fruitReader.readExact(apples);
//    }
//    public static void main(String[] args) {
//        f1();
//    }
//



    static List<Apple> apples = new ArrayList<Apple>();
    static List<Fruit> fruit = new ArrayList<Fruit>();
    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }
    static void f1() {
        writeExact(apples, new Apple());
        writeExact(fruit, new Apple());
    }
    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }
    static void f2() {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruit, new Apple());
    }
    public static void main(String[] args) {
        //f1(); //f2();

     //Collections.copy()
    }

}
