package Course_Schedule;

import org.junit.Test;

import java.util.*;
//Accepted ,but too slow

public class Solution2 {


    public boolean canFinish(int numCourses, int[][] prerequisites) throws InterruptedException {

        Map<Integer, List<Integer>> connection = new HashMap<>();
        Set<Integer> ok = new HashSet<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (connection.containsKey(prerequisites[i][1])) {
                connection.get(prerequisites[i][1]).add(prerequisites[i][0]);

            } else {

                List<Integer> tmp = new ArrayList<>();
                tmp.add(prerequisites[i][0]);
                connection.put(prerequisites[i][1], tmp);
            }


        }//initializing....
        int task = connection.size();
        final int size = connection.size();
        Set<Integer>courses = connection.keySet();
        boolean learn = true;
        int pre=0;
        while (task != 0) {
            System.out.println(task);
            pre=task;
            for (Map.Entry<Integer, List<Integer>> obj : connection.entrySet()) {

                learn = true;

                Integer key = obj.getKey();//课程 key
                if(ok.contains(key))continue;
                List<Integer> value = obj.getValue();//课程的先修课程

                for (int i = 0; i < value.size(); i++) {
                   // System.out.println(value.get(i));
                    if (!ok.contains(value.get(i))&& (courses.contains(value.get(i))))//存在未修习的课程，则放弃当前课程，选择其他的。
                    {
                        learn = false;
                        break;
                    }
                }

               // TimeUnit.SECONDS.sleep(1);
                if (learn) {
                    System.out.println(key);
                    ok.add(key);
                   if(task!=0) task--;
                }

            }
            if(task == pre)return false;
        }

        return true;
    }
    @Test
    public void test() throws InterruptedException {

        System.out.println(canFinish(8, new int[][]{{1,0},{2,6},{1,7},{5,1},{6,4},{7,0},{0,5}}));

    }




}
