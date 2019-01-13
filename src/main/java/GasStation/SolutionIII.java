package GasStation;

public class SolutionIII {
    public int canCompleteCircuit(int[] gas, int[] cost) {


        int start = 0;
        int total = 0;
        int i = 0;
        int flag=0;
        while (flag<gas.length){
            total = total + gas[i] - cost[i];
            if (total < 0) {
                start = (i + 1) % gas.length;
                total = 0;
                int t=i-start+1;
                if(t<=0)
                    t=t+gas.length;
                flag = flag+t;
                i = start;

            } else {

                i = (i + 1) % gas.length;
                flag=flag+1;

            }
            if (i >= start)
                break;
        }
            return 0;

    }
}
 