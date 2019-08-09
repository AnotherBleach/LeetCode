package ProtoBufTest.JavaVersion;

import ProtoBufTest.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public   class Main {
    public static void main(String[] args) throws Exception{

        List<String> hobbies = new ArrayList<>();
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("James");
        hobbies.add("Books");
        hobbies.add("Movies");
        teacher.setHobbies(hobbies);
        byte[] data = serialisze(teacher);
        showData(data);
        Teacher teacher1 = (Teacher)(deserialize(data));
        System.out.println(teacher1);


    }

    static byte[] serialisze(Teacher teacher) throws IOException {
        AtomicInteger atomicInteger;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(teacher);
        String str;
        return bos.toByteArray();
    }

    static void showData(byte[] data) {
        ReentrantLock re = new ReentrantLock();
        CountDownLatch countDownLatch;
        re.lock();
        System.out.println("data length: " + data.length);
        System.out.println(Arrays.toString(data));

    }

    static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        return ois.readObject();
    }

}
