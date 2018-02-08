package no.hvl.dat102.adt;

public interface KoeADT<T> {

	public void settIkoe(T el);
	
	public void expandCapacity();
	
	public T taUtAvKoe();
	
	public boolean isEmpty();
	
	public int getCount();
	
	public T peek();
	
	public int size();
	
}
