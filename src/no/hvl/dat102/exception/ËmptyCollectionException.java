package no.hvl.dat102.exception;

public class ËmptyCollectionException extends RuntimeException {

	  public ËmptyCollectionException (String samling) {
	      super ("" + samling + " er tom.");
}
}
