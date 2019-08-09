package ProtoBufTest.ProtoVesion;

import ProtoBufTest.Teacher;
import ProtoBufTest.TeacherSerializer;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InvalidProtocolBufferException {

        TeacherSerializer.Teacher.Builder builder = TeacherSerializer.Teacher.newBuilder();
        TeacherSerializer.Teacher teacher = builder.setId(1).setName("James").addHobbies("Movies").addHobbies("Books").build();

        byte[] data = serialisze(teacher);
        showData(data);
        TeacherSerializer.Teacher teacher1 =  deserialize(data);
        System.out.println(teacher1);

    }

    private static TeacherSerializer.Teacher deserialize(byte[] data) throws InvalidProtocolBufferException {
        return TeacherSerializer.Teacher.parseFrom(data);
    }

    private static void showData(byte[] data) {
        System.out.println("data length: " + data.length);
        System.out.println(Arrays.toString(data));
    }

    private static byte[] serialisze(TeacherSerializer.Teacher teacher) {
        return teacher.toByteArray();

    }

}
