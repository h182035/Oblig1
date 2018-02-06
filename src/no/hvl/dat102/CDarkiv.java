package no.hvl.dat102;
import no.hvl.dat102.adt.CDarkivADT;

public class CDarkiv implements CDarkivADT{
	private int antall;
	private CD[] tab;
	
	public CDarkiv() {
	 this.tab = new CD[10];
	}
	
	public CDarkiv(int storrelse) {
		tab = new CD[storrelse];
	}
	
	public CDarkiv(CD[] tab) {
		this.tab = tab;
		antall = tab.length;
	}
	
	
	 public CD[] hentCdTabell() {
		 return tab;
		  }
	 
	 public void leggTilCd(CD nyCd) { //legger til en CD og utvider om det ikke er plass
		 if (antall == tab.length){
			 utvidKapasitet();
			 System.out.println("det var ikke plass i tabellen, \n"
			 		+ " tabellen ble utvidet");
			 }
			 tab[antall] = nyCd;
			 antall++;
			 System.out.println("CD-en ble lagt til i tabellen");
			}
	 
	 private void utvidKapasitet(){ // utvider tabellen om det ikke er plass til nytt element
		 CD[] hjelpetabell = new CD[(int)Math.ceil(1.1 * tab.length)];
		 for (int i = 0; i < tab.length; i++){
		 hjelpetabell[i] = tab[i];
		 }
		 tab = hjelpetabell;
		}
	 public boolean slettCd(int cdNr){ // Sletter en CD hvis den fins
		 boolean slettet = false;
		 if(finnCd(cdNr) > 0) {
			 tab[finnCd(cdNr)] = tab[antall-1];
			 tab[antall-1]= null;
			 antall--;
			 slettet = true;
			 System.out.println("CD-en ble slettet fra tabellen");
			 
		 }
		 return slettet;
			 }
	 public int finnCd(int cdNr){ // finner en CD ved søk av cdNr
		 int funnetindex = -1;
		 for(int i = 0; i<antall; i++) {
			 if(cdNr == tab[i].getNummer()) {
				 funnetindex = i;
			 }
		 }
			 return funnetindex;
	 }
	 public CD[] sokTittel(String delstreng) { // Søker og henter CD-er med en gitt delstreng
		 CD[] titler = new CD[antall];
		 for(int i = 0; i < antall; i++) {
			 if(tab[i].getTittel().contains(delstreng)) {
				 titler[i] = tab[i];
			 }
		 }
		 return titler;
		 
	 }
	 public CD[] sokArtist(String delstreng) { // Søker og henter artister med en gitt delstreng
		 CD[] artister = new CD[antall];
		 for(int i = 0; i < antall; i++) {
			 if(tab[i].getNavn().contains(delstreng)) {
				 artister[i] = tab[i];
			 }
		 }
		 return artister;
	 }
	 
	 public int hentAntall() { // Henter antall CD-er for en gitt sjanger
		 return antall;
	 }
	 public int hentAntall(Sjanger sjanger) { // Henter antall CD-er for en gitt sjanger
		 int tempAntall = 0;
		 CD[] tabsjanger = new CD[antall];
		 for(int i = 0; i < antall; i++) {
			 if((tab[i].getSjanger()).toString() == sjanger.toString()) {
				 tabsjanger[i] = tab[i];
				 tempAntall ++; 
			 }
		 }
		 return tempAntall;
	 }
	 
	 public String toString() {
		 
		 String toString = "";
		 
		 for(CD cd:tab) {
			 if(cd != null) {
			 toString += cd.toString();
			 toString += "\n";
			 }
		 }
			 return toString;
	 }


	public int getAntall() {
		return antall;
	}


	public void setAntall(int antall) {
		this.antall = antall;
	}


	public CD[] getTab() {
		return tab;
	}


	public void setTab(CD[] tab) {
		this.tab = tab;
	}
	 
	 

}
