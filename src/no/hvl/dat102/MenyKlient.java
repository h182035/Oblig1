package no.hvl.dat102;

public class MenyKlient {

	public static void main(String[] args) {
		CDarkiv cda1 = new CDarkiv();
		Meny meny = new Meny(cda1);
		
		
		meny.start();
		// TODO Auto-generated method stub

	}

}
