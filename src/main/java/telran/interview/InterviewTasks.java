package telran.interview;

import java.util.HashSet;
import java.util.Set;

public class InterviewTasks {
    /**
     * 
     * @param array
     * @param sum
     * @return true if a given array comprises of two number,
     *  summing of which gives the value equaled to a given "sum" value
     */
    static public boolean hasSumTwo(int [] array, int sum) {
        boolean res = false;
        int i = 0;
        Set<Integer> map = new HashSet<>();
        
        while (!res && i < array.length) {
            int diff = sum - array[i];
            if(map.contains(diff)) {
                res = true;
            }
            map.add(array[i]);
            i++;
        }
        return res;
    }
}