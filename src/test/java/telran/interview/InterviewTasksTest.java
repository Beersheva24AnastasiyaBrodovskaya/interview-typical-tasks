package telran.interview;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import static telran.interview.InterviewTasks.*;
import static org.junit.jupiter.api.Assertions.*;

public class InterviewTasksTest {
    @Test
    void hasSumTwoTest() {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {10, 10, 20, 20, 30};
                      
        assertTrue(hasSumTwo(array1, 9));
        assertFalse(hasSumTwo(array1, 11));
        assertTrue(hasSumTwo(array2, 50));
        assertFalse(hasSumTwo(array2, 15));

    }
}