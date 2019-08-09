package Car_Fleet;

import org.junit.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

// ac
public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position == null || position.length == 0) return 0;
        int fleets = 0;
        TreeMap<Integer, Integer> relation = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < position.length; i++) {
            relation.put(position[i], speed[i]);
        }

        int pre_position = -1, pre_speed = -1;

        for (Map.Entry<Integer, Integer> entry : relation.entrySet()) {

            int current_position = entry.getKey();
            int current_speed = entry.getValue();
            if (pre_position == -1) {

                pre_position = current_position;
                pre_speed = current_speed;
            } else {

                if (pre_speed >= current_speed) {//默认position不一样，追不上
                    //System.out.println(current_speed + " 追不上 " + pre_speed);

                    fleets++;
                    pre_position = current_position;
                    pre_speed = current_speed;

                } else {

                    if ((pre_position - current_position) / (float) (current_speed - pre_speed) <= (target - pre_position) / (float) pre_speed) {//能追上

                        //System.out.println(current_speed + " 能追上 " + pre_speed);


                    } else {
                       // System.out.println(current_speed + " 追不上 " + pre_speed);
                        fleets++;
                        pre_position = current_position;
                        pre_speed = current_speed;

                    }


                }


            }


        }


        return ++fleets;

    }


    @Test
    public void test() {

         System.out.println(carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
     //   System.out.println(carFleet(10, new int[]{6, 2, 17}, new int[]{3, 9, 2}));
    }

}
