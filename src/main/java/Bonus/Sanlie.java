package Bonus;

public class Sanlie {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sanlie sanlie = new Sanlie();

        System.out.println(Integer.toHexString(sanlie.hashCode()));
        System.out.println(sanlie);
        Sanlie sanlie1 =(Sanlie) sanlie.clone();

    }
    protected void test2(){

    }
}
class test {
    public void show()
    {
        Sanlie sanlie = new Sanlie();
        sanlie.test2();

    }
}
