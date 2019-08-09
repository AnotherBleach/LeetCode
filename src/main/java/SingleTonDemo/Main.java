package SingleTonDemo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        while (i != 1) {
            if (i == 0) test.show();
            else test.getInstance();
            i = sc.nextInt();
        }
    }

}

enum Mood {

    HAPPY, ANGRY, SAD;

    public void say() {

        System.out.println("Hello Mood");
    }
}

class test {


    private static class testHolder {
        private static test test = new test();
    }
    private  class testHolder2{
      //  private static test test = new test();
      //  private static void show(){

        //}
    }

    private test() {

        System.out.println("test instance init...");
    }


    public static test getInstance() {
        return testHolder.test;
    }

    public static void show() {
        System.out.println("test loaded!");
    }

}