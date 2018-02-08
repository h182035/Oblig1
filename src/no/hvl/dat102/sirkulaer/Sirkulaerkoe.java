package no.hvl.dat102.sirkulaer;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.ËmptyCollectionException;

public class Sirkulaerkoe<T> implements KoeADT<T> {
	private final static int DEFAULT_CAPACITY = 100;
	private int front,rear,count;
	private T[] koe;
	
	
	public Sirkulaerkoe(){
		this(DEFAULT_CAPACITY);
	}
	public Sirkulaerkoe(int initialCapacity){
		front = rear = count = 0;
		koe = (T[]) (new Object[initialCapacity]);
	}
	@Override
	public void settIkoe(T element) {
		if(count == koe.length)
			expandCapacity();
		koe[rear] = element;
		rear = (rear + 1)% koe.length;
		count ++;
	}
	@Override
	public void expandCapacity() {
		T[] larger = (T[]) (new Object[size() * 2]);
		for(int scan = 0; scan < count; scan ++ ) {
			larger[scan] = koe[front];
			front = (front + 1) % koe.length;
		}
		
		front = 0;
		rear = count;
		koe = larger;
	}
	@Override
	public T taUtAvKoe() throws ËmptyCollectionException
	{
		if(isEmpty()) {
			throw new ËmptyCollectionException("koe");
		}
		T result = koe[front];
		koe[front] = null;
		front = (front + 1) % koe.length;
		count--;
		return result;
	}
	
	public T peek() throws ËmptyCollectionException{
		if(isEmpty()) {
			throw new ËmptyCollectionException("koe");
		}
		return koe[front];
	}
	
	public int size() {
		return koe.length;
	}
	
	public boolean isEmpty() {
		if(count == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public int getFront() {
		return front;
	}
	public void setFront(int front) {
		this.front = front;
	}
	public int getRear() {
		return rear;
	}
	public void setRear(int rear) {
		this.rear = rear;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public T[] getKoe() {
		return koe;
	}
	public void setKoe(T[] koe) {
		this.koe = koe;
	}
	
	

}
