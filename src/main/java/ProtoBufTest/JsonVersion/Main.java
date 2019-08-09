package ProtoBufTest.JsonVersion;

import ProtoBufTest.Teacher;
import com.google.gson.Gson;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> hobbies = new ArrayList<>();
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("James");
        hobbies.add("Books");
        hobbies.add("Movies");
        teacher.setHobbies(hobbies);
        byte[] data = serialisze(teacher);
        showData(data);
        Teacher teacher1 = (Teacher) (deserialize(data));
        System.out.println(teacher1);

    }

    private static byte[] serialisze(Teacher teacher) {
        Gson gson = new Gson();
        String data = gson.toJson(teacher);
        return data.getBytes();
    }

    private static void showData(byte[] data) {
        System.out.println("data length: " + data.length);
        System.out.println(Arrays.toString(data));
    }

    private static Teacher deserialize(byte[] data) {
        Gson gson = new Gson();
        Teacher obj = gson.fromJson(new String(data), Teacher.class);
        return obj;
    }
}
