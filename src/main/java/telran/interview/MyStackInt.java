package telran.interview;

import java.util.EmptyStackException;
import java.util.LinkedList;

//All methods should have complexity O[1]
public class MyStackInt {
   	LinkedList<Integer> list = new LinkedList<>();
	LinkedList<Integer> listMax = new LinkedList<>();

	public void push(int num) {
        //TODO
		//adds num into top of stack (last element)
		list.push(num);

		Integer prevMax = listMax.peek();
		if (prevMax == null || prevMax <= num) {
			listMax.push(num);
		}
		
	}
	public int pop() {
        //TODO
		//removes element from top of stack (last element)
		//returns being removed number
		//throws exception if the stack is empty
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		if (listMax.peek().equals(list.peek())) {
			listMax.pop();
		}
		return list.pop();
	}
	public int peek() {
        //TODO
		//returns last number
		//throws exception if the stack is empty
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		return list.peek();
	}
	public boolean isEmpty() {
        //TODO
		//returns true if the stack is empty, otherwise false
		return list.isEmpty();

	}
	public int getMaxElement() {
        //TODO
		//returns the max number from the stack
		//throws exception if the stack is empty
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		return listMax.peek();
	}
}