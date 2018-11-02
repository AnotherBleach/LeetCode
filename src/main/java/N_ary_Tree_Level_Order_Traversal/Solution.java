package N_ary_Tree_Level_Order_Traversal;

import org.junit.Test;

import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        calc(root, result);
        return result;

    }

    public void calc(Node root, List<List<Integer>> result) {
        if (root != null) {

            Queue<Node> left = new LinkedList<>();
            Queue<Node> right = new LinkedList<>();
            left.add(root);
            while (left.size() != 0 || right.size() != 0) {
                List<Integer> temp = new ArrayList<>();
                if (left.size() != 0) {

                    while (left.size() != 0) {
                        Node now = left.poll();
                        temp.add(now.val);
                        List<Node> child = now.children;
                        for (int i = 0; i < child.size(); i++)
                            right.add(child.get(i));


                    }


                } else {
                    while (!(right.size() == 0)) {
                        Node now = right.poll();
                        temp.add(now.val);
                        List<Node> child = now.children;
                        for (int i = 0; i < child.size(); i++)
                            left.add(child.get(i));


                    }


                }
                result.add(temp);

            }

        }

    }
    @Test
    public void test2()
    {
        List<Integer>result = new ArrayList<>();
        result.add(2);
        result.add(3);
        //with index
//        for(int i=0;i<result.size();i++)
//        {
//            System.out.println(
//                    result.get(i)
//            );
//            result.add(0);
//
//
//        }
        //with iterator
        for(Iterator<Integer>it = result.iterator();it.hasNext();)
        {
            System.out.println(it.next());
            result.add(0);


        }



    }


}
