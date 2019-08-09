package 通配符;

import java.util.concurrent.ConcurrentHashMap;

public class Util<K,V> {
    static Box<String,Integer>[] data ;

    public static void main(String[] args) {

        data = (Box<String,Integer>[])(new Box[2]);
        data[0] = new Box<String,Integer>();
        data[0].setName("James");
        System.out.println(data[0].getName());
      //  ConcurrentHashMap
    }
}
