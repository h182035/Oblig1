package no.hvl.dat102;

public class LinearNode <T> {
	private LinearNode<T> neste;
	private T element;
	public LinearNode() {
		neste = null;
		element = null;
	}
	public LinearNode(T elem) {
		neste = null;
		element = elem;
	}
	public LinearNode<T> getNext() {
		return neste;
	}
	public void setNext(LinearNode<T> elem) {
		neste = elem;
	}
	public T getElement() {
		return element;
	}
	public void setElement(T elem) {
		element = elem;
	}
}
