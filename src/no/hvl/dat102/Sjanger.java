package no.hvl.dat102;

public enum Sjanger{
	POP(1), ROCK(2), JAZZ(3), BLUES(4),COUNTRY(5),OPERA(6),RNB(7),HIPHOP(8),KLASSISK(9);
	
	private int n;
	
	private Sjanger(int n) {
		this.n = n;
	}
	
	public static Sjanger finnSjanger(String navn) {
		Sjanger sjanger = null;
		for(Sjanger sj: Sjanger.values()) {
			if(navn.toUpperCase().equals(sj.toString())) {
				sjanger = sj;
			}
		}
		return sjanger;
	}
}