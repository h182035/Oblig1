package no.hvl.dat102.exception;

public class �mptyCollectionException extends RuntimeException {

	  public �mptyCollectionException (String samling) {
	      super ("" + samling + " er tom.");
}
}
