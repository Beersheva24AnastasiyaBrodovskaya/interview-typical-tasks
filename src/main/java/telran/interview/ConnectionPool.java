package telran.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ConnectionPool {
//TODO work out data structure
//Connection pool comprises of some number of connections
//It canot contains more than the predefined number of connection
//You should define some Connection Pool policy so that if number of connections 
//is going to exceed the limit a connection should be removed from the connection
//Policy should take in consideration the order of adding connections in pool
// and using connection

LinkedHashMap<String, Connection> map;
private int sizeConnection;


public ConnectionPool(int size) {
    this.sizeConnection = size;
    map = new LinkedHashMap<String, Connection>(size, 0.75f, true) {
    @Override
            protected boolean removeEldestEntry(Map.Entry<String, Connection> eldestEntry) {
                return size() > sizeConnection;
            }
    };
    
}
public void addConnection(Connection connection) {
    
    if (map.containsKey(connection.connectionId())) {
        throw new IllegalStateException();
    }
    map.put(connection.connectionId(), connection);
}

public Connection getConnection(String connectionId) {
   
    if (!map.containsKey(connectionId)) {
        throw new NoSuchElementException();
    }

    return map.get(connectionId);
    
}
}