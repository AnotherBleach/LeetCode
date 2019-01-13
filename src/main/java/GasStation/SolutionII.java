package GasStation;

import org.junit.Test;

import java.util.Arrays;

public class SolutionII {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int[] data = new int[gas.length];
        int result = 0;
        for (int i = 0; i < gas.length; i++) {
            data[i] = gas[i] - cost[i];
            result = result + data[i];
        }

        if (result < 0) return -1;

        for (int i = 0; i < data.length; i++) {
            boolean ok = true;
            int temp = data[i];
            if (temp < 0) continue;

            for (int j = (i + 1) % data.length; j != i; j = (j + 1) % data.length) {
                temp = temp + data[j];
                if (temp < 0) {
                    ok = false;
                    break;
                }
            }
            if (ok)
                return i;

        }

        return -1;
    }

    @Test
    public void test() {
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(canCompleteCircuit(new int[]{2,3,4},new int[]{3,4,3}));
    }
}
