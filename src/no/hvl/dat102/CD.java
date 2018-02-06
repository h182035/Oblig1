package no.hvl.dat102;

public class CD {
	private int nummer;
	private String navn;
	private String tittel;
	private int lansering;
	//private enum sjanger {POP, ROCK, OPERA, KLASSISK};
	private Sjanger sjanger;
	private String plateselskap;
	
	
	public CD() {
		
	}
	public CD(int nummer, String navn, String tittel, int lansering, Sjanger sjanger, String plateselskap) {
		this.nummer = nummer;
		this.navn = navn;
		this.tittel = tittel;
		this.lansering = lansering;
		this.sjanger = sjanger;
		this.plateselskap = plateselskap;
	}
	
	public String getTittel() {
		return tittel;
	}
	
	public String getNavn() {
		return navn;
	}
	public int getNummer() {
		return nummer;
	}
	public void setNummer(int nummer) {
		this.nummer = nummer;
	}
	public int getLansering() {
		return lansering;
	}
	public void setLansering(int lansering) {
		this.lansering = lansering;
	}
	public Sjanger getSjanger() {
		return sjanger;
	}
	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}
	public String getPlateselskap() {
		return plateselskap;
	}
	public void setPlateselskap(String plateselskap) {
		this.plateselskap = plateselskap;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public void setTittel(String tittel) {
		this.tittel = tittel;
	}
	@Override
	public String toString() {
		return "Nummer: " + nummer + "\n navn: " + navn + "\n tittel: " + tittel + "\n lansering: " + lansering
				+ "\n sjanger: " + sjanger + "\n plateselskap: " + plateselskap + "\n";
	}
}
