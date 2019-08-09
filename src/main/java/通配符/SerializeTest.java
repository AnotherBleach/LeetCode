package 通配符;

import java.io.*;
import java.util.List;

class Person implements Serializable{

    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        //inputStream.defaultReadObject();
        System.out.println("here");

    }
    List<Integer>[] s;

}
public class SerializeTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {



        //writePerson();
        readPerson();
        System.out.println("done");

    }
    public static void writePerson() throws IOException
    {

        FileOutputStream fos = new FileOutputStream("D:/person.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Person person  = new Person();
        person.setAge(23);
        person.setName("niubi");
        oos.writeObject(person);
    }
    public static void readPerson() throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("D:/person.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object person = (Object) (ois.readObject());
       // System.out.println(person.getName()+" "+person.getAge());
       // System.out.println(((Person)(person)).getName());

    }
}
