package Subsets;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Subsets implements  Cloneable{

    //method 2

    public List<List<Integer>> subsets2(int[] nums) {

        List<List<Integer>>results =  fromIndex(nums, 0);

        return  results;

    }

    public List<List<Integer>> fromIndex(int[] nums, int index) {

        List<List<Integer>> now = new ArrayList<>();
        if (index == nums.length - 1) {
            List<Integer> exclude_next = new ArrayList<>();
            List<Integer> include_next = new ArrayList();
            include_next.add(nums[index]);

            now.add(exclude_next);
            now.add(include_next);
            return now;

        }

        List<List<Integer>> exclude_next = fromIndex(nums, index + 1);
        //System.out.println(index+"(exclude):"+Arrays.deepToString(exclude_next.toArray()));/////////////////

        List<List<Integer>> include_next = new ArrayList<>();

        for (Iterator<List<Integer>> it = exclude_next.iterator(); it.hasNext(); ) {
             List<Integer>temp = new ArrayList<>(it.next());
             temp.add(nums[index]);
             include_next.add(temp);
        }
        //System.out.println(index+"(include):"+Arrays.deepToString(include_next.toArray()));



        //System.out.println(index+"(exlude):"+Arrays.deepToString(exclude_next.toArray()));//////////////

        now.addAll(exclude_next);
        now.addAll(include_next);

        return now;


    }

    //method 1
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        int size = (int) Math.pow(2, nums.length) - 1;
        for (int i = 0; i <= size; i++) {
            String temp = Integer.toBinaryString(i);
            temp = String.format("%" + nums.length + "s", temp);
            List<Integer> now = new ArrayList<>();
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '1')
                    now.add(nums[j]);


            }
            results.add(now);


        }


        return results;
    }

    @Test
    public void test() {
        int[] nums = {1,2,3};
        List<List<Integer>> results = subsets2(nums);
        System.out.println(Arrays.deepToString(results.toArray()));
    }

    @Test
    public void testAddAll() {

        List<Integer>i1 = new ArrayList<>();
        i1.add(1);
        List<List<Integer>>i1_list = new ArrayList<>();
        i1_list.add(i1);



        List<List<Integer>>i2 = new ArrayList<>();
        i2.addAll(i1_list);



        System.out.println(Arrays.deepToString(i2.toArray()));

        i1_list.get(0).add(10);



        System.out.println(Arrays.deepToString(i2.toArray()));
    }

    private class Student
    {
        String name;

        public Student(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    @Test
    public void testList()
    {

//        List<Integer>l1 = new ArrayList<>();
//        l1.add(1);
//        l1.add(2);
//        l1.add(3);
//        List<Integer>l2 = new ArrayList<>(l1);
//        l1.remove(1);
//        System.out.println(Arrays.deepToString(l2.toArray()));





        List<Student>l1 = new ArrayList<>();
        l1.add(new Student("james"));
        l1.add(new Student("kobe"));
        l1.add(new Student("jordan"));
        List<Integer>l2 = new ArrayList(l1);
        l1.remove(1);
        l1.get(1).name="null pointer";
        System.out.println(Arrays.deepToString(l2.toArray()));

    }

    @Test
    public void test1()
    {

        List<Integer>l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        List<List<Integer>>l1_list = new ArrayList<>();
        l1_list.add(l1);

        List<List<Integer>>l2_list = new ArrayList<>();
        l2_list.addAll(l1_list);

        l1_list.get(0).add(3);
        System.out.println(Arrays.deepToString(l2_list.toArray()));

    }



}
