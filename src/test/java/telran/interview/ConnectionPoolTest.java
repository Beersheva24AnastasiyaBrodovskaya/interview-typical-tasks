package telran.interview;

import static org.junit.jupiter.api.Assertions.*;


import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ConnectionPoolTest {

    String[] array = { "123", "abc", "456", "def" };
    ConnectionPool pool;

    @BeforeEach
    private void setUpConnectionPool() {
        pool = new ConnectionPool(5);
        pool.addConnection(new Connection("123"));
        pool.addConnection(new Connection("abc"));
        pool.addConnection(new Connection("456"));
        pool.addConnection(new Connection("def"));
    
    }

    
    @Test
    void getConnectionTest() {
        setUpConnectionPool();
        assertEquals(new Connection("123").connectionId(), pool.getConnection("123").connectionId());
        assertThrowsExactly(NoSuchElementException.class, () -> pool.getConnection("789"));    
    }

    @Test
    void ConnectPoolTest() {
        setUpConnectionPool();
        assertArrayEquals(array, pool.map.keySet().toArray());       
    }

    @Test
    void addConnectionTest() {
        setUpConnectionPool();

        assertThrowsExactly(IllegalStateException.class, () -> pool.addConnection(new Connection("def")));

        String[] array1 = {"123", "abc", "456", "def", "789"};
        pool.addConnection(new Connection("789"));
        assertArrayEquals(array1, pool.map.keySet().toArray());

        String[] array2 = {"abc", "456", "def", "789", "ghi"};
        pool.addConnection(new Connection("ghi"));
        assertArrayEquals(array2, pool.map.keySet().toArray());

        String[] array3 = {"def", "789", "ghi", "abc", "jkl"};
        pool.getConnection("abc");
        pool.addConnection(new Connection("jkl"));
        assertArrayEquals(array3, pool.map.keySet().toArray());
    }

   
}