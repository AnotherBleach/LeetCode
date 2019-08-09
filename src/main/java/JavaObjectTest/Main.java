package JavaObjectTest;

import com.javamex.classmexer.MemoryUtil;

import java.util.Arrays;

class People
{

    int id;
    int id2;
}
public class Main {
    public static void main(String[] args) {


        System.out.println(MemoryUtil.deepMemoryUsageOf(new People()));
    }
}
