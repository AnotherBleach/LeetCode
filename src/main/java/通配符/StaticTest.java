package 通配符;
import  java.lang.*;
class test2{
    int method() {return n; }

    int n = 1;
    int m = method();
}

public class StaticTest {
    public static void main(String[] args) {
        System.out.println(new test2().m);


    }

}
