package telran.interview;

import org.junit.jupiter.api.Test;

import static telran.interview.InterviewTasks.*;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InterviewTasksTest {
    private static final LocalDate DATE1 = LocalDate.of(2019, 12, 31);
	private static final LocalDate DATE2 = LocalDate.of(2021, 10, 30);
	private static final LocalDate DATE3 = LocalDate.of(2021, 12, 31);
	private static final LocalDate DATE4 = LocalDate.of(2024, 1, 1);
	private static final String ROLE1 = "Developer";
	private static final String ROLE2 = "Senior Developer";
	private static final String ROLE3 = "Manager";
    @Test
    void hasSumTwoTest() {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {10, 10, 20, 20, 30};
                      
        assertTrue(hasSumTwo(array1, 9));
        assertFalse(hasSumTwo(array1, 11));
        assertTrue(hasSumTwo(array2, 50));
        assertFalse(hasSumTwo(array2, 15));

    }
     @Test
	void getMaxWithNegativePresentation() {
		int[] array1 = {200, 10, -10, 1, 2, 3, -3, -200};
		int [] array2 = {-200, -200, 100, 10, 10};
		int[] array3 = {-200, 10, -10, 1, 2, 3, -3, 200};
		assertEquals(200, InterviewTasks.getMaxWithNegativePresentation(array1));
		assertEquals(-1, InterviewTasks.getMaxWithNegativePresentation(array2));
		assertEquals(200, InterviewTasks.getMaxWithNegativePresentation(array3));
	}
    @Test
	void assignRoleDatesTest() {
		List<DateRole> history =
				List.of(new DateRole(LocalDate.of(2020, 1, 1), ROLE1),
						new DateRole(LocalDate.of(2021, 1, 1), ROLE2),
						new DateRole(LocalDate.of(2022, 1, 1), ROLE3));
		List<LocalDate> dates = List.of(DATE1,
				DATE2, DATE3,
				DATE4);
		List<DateRole> expected =
				List.of(new DateRole(DATE1, null), 
						new DateRole(DATE2,ROLE2),
						new DateRole(DATE3, ROLE2),
						new DateRole(DATE4, ROLE3));
		assertIterableEquals(expected, InterviewTasks.assignRoleDates(history, dates));
	}
    @Test
	void isAnagrmaTest() {
		String word = "hello";
		assertTrue(InterviewTasks.isAnagram(word, "olleh"));
		assertTrue(InterviewTasks.isAnagram(word, "elloh"));
		assertTrue(InterviewTasks.isAnagram(word, "hleol"));
		assertFalse(InterviewTasks.isAnagram(word, word));
		assertFalse(InterviewTasks.isAnagram(word, "olle"));
		assertFalse(InterviewTasks.isAnagram(word, "ollhh"));
		assertFalse(InterviewTasks.isAnagram(word, "olehd"));
	}
}