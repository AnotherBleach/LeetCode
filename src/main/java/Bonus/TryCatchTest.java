package Bonus;

public class TryCatchTest {
    public static void main(String[] args) {
//
//        try {
//            int a = 3 / 0;
//
//        } catch (NullPointerException e) {
//
//
//        } catch (ArithmeticException e) {
//            System.out.println("/0");
//
//        } finally {
//
//            System.out.println("finally done");
//        }
//        System.out.println("out done");

        System.out.println(test().toString());
    }

    public static StringBuffer test() {


        StringBuffer a = new StringBuffer();
        a.append("1");

        try {

            a.append("2");
            throw new NullPointerException();

        } catch (NullPointerException e) {

            return a;

        } finally {

            a.append("3");

        }

    }

}


