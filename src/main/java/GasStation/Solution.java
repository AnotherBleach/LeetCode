package GasStation;

//ac ,but slow....
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        for (int i = 0; i < gas.length; i++) {
            if (calc(i, 0, gas, cost, i) != -1)
                return i;
        }

        return -1;
    }

    public int calc(int i, int gas_tank, int[] gas, int[] cost, int des) {

        if (gas[i] + gas_tank - cost[i] >= 0) {

            if ((i + 1) % gas.length == des)
                return i;
            else
                return calc((i + 1) % gas.length, gas_tank + gas[i] - cost[i], gas, cost, des);

        }


        return -1;
    }
}
