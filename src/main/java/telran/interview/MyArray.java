package telran.interview;

import java.util.HashMap;

//all methods must have complexity O[1]
public class MyArray<T> {
	
		T defaultValue = null;
    	HashMap<Integer, T> arr;
    	int size;

 //TODO


 	public void setAll(T value) {
        //TODO
		//all array's elements should be set with a given value
		this.defaultValue = value;
        arr = new HashMap<>();
		
	}
	public void set(int index, T value) {
        //TODO
		//set new value at a given index
		//throws ArrayIndexOutOfBoundsException for incorrect index
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
		arr.put(index, value);
		
	}
	
	public T get(int index) {
		//returns a value at a given index
		//throws ArrayIndexOutOfBoundsException for incorrect index
		if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
		return arr.getOrDefault(index, defaultValue);
		
	}
	public MyArray(int size) {
		//creates the Array object for a given size
		//with setting null's at each element
		this.size = size;
        arr = new HashMap<>();
	}
}