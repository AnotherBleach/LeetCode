package Lock.Join;

public class B extends Thread {
    A a;

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        try {

            a.join();


        }catch (InterruptedException e){

        }
        System.out.println("B");

    }
}
