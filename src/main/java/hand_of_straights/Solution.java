package hand_of_straights;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    boolean[] used = new boolean[10001];


    public boolean handle(int[] hand, int W,int counter) {
        System.out.println("\n--"+counter+"--");
        if (counter <= 0)
            return true;

        //special
        int oldW = W;

        int before = -1;
        for (int i = 0; i < hand.length; i++) {
            if(W == 0)
                break;
            if (used[i] == false) {

                if (before == -1) {
                    before = hand[i];
                    used[i] = true;
                    System.out.print(" " + hand[i]);
                    W--;
                } else {

                    if (before + 1 == hand[i]) {
                        used[i] = true;
                        before = hand[i];
                        W--;
                        System.out.print(" " + hand[i]);
                    }


                }


            }


        }
       // System.out.println();
        if (handle(hand, oldW ,counter-1) && W == 0)
            return true;
        return false;


    }

    public boolean isNStraightHand(int[] hand, int W) {
        //special
        if(hand.length%W!=0)return false;
        Arrays.sort(hand);
//        Arrays.stream(hand).forEach((x) -> {
//            System.out.print(" " + x);
//        });
//        System.out.println();
        return handle(hand, W,hand.length/W);

    }

    @Test
    public void test() {

        System.out.println(isNStraightHand(new int[]{2,1 }, 2));

    }
}
