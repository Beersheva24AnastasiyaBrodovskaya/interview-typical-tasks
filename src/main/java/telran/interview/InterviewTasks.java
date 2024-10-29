package telran.interview;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

     static public int getMaxWithNegativePresentation(int [] array) {
        //TODO
        //returns maximal positive value for which exists negative one with the same abs value
        //if no pair of positive and negative values with the same abs value the method returns -1
        //complexity O[N] only one pass over the elements
        HashSet<Integer> values = new HashSet<>();
        int max = -1;
        for (int num : array) {
            int absNum = Math.abs(num);
            if (values.contains(-num)) {
                max = Math.max(max, absNum);
            }
            values.add(num);
            }
        return max;
    }
    public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory,
		List<LocalDate> dates) {
	//TODO
    //rolesHistory is the list containg dates and roles assigned to the employees at the appropriate dates
    //for example, date => 2019-01-01, role => Developer means that some employee (no matter who) was taken
    //role Developer at 2019-01-01
	//create List<DateRole> with roles matching with the given dates
	//most effective data structure
     List<DateRole> result = new ArrayList<>();
    int roleIndex = 0;
    for (LocalDate date : dates) {
        while (roleIndex < rolesHistory.size() - 1 && rolesHistory.get(roleIndex + 1).date().isBefore(date)) {
            roleIndex++;
        }
        String role = (rolesHistory.get(roleIndex).date().isBefore(date) || rolesHistory.get(roleIndex).date().isEqual(date))
                ? rolesHistory.get(roleIndex).role()
                : null;
        result.add(new DateRole(date, role));
    }
    return result;
}
public static boolean isAnagram(String word, String anagram) {
	//TODO
	//returns true if "anagram" string contains all
	// letters from "word" in another order (case sensitive)
	//O[N] (sorting is disallowed)
     boolean isAnagram = true;
    if (word.length() != anagram.length() || word == anagram) {
        isAnagram = false;
    } else {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : word.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (char c : anagram.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                isAnagram = false;
                break;
            }
            charCount.put(c, charCount.get(c) - 1);
        }
    }
    return isAnagram;
}
}