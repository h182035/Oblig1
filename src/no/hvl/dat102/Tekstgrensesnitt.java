package no.hvl.dat102;
import java.util.Scanner;

import no.hvl.dat102.adt.CDarkivADT;

public class Tekstgrensesnitt {

	 public static CD lesCD() {// lese opplysningene om en CD fra tastatur
		 CD cd = new CD();
		 Scanner leser = new Scanner(System.in);
		 System.out.println("CD-nummer: ");
		 int n = leser.nextInt();
		 cd.setNummer(n);
		 leser.nextLine();
		 System.out.println("navn på artist:");
		 String s = leser.nextLine();
		 cd.setNavn(s);
		 System.out.println("tittel: ");
		 s = leser.nextLine();
		 cd.setTittel(s);
		 System.out.println("utgivelsesår: ");
		 n = leser.nextInt();
		 cd.setLansering(n);
		 leser.nextLine();
		 System.out.println("sjanger: ");
		 Sjanger sj = Sjanger.valueOf((leser.next()).toUpperCase());
		 cd.setSjanger(sj);
		 leser.nextLine();
		 System.out.println("plateselskap: ");
		 s=leser.nextLine();
		 cd.setPlateselskap(s);
		 return cd;
		 
		 
		 
		 
	 }
	 public static void visCD(CD cd){// vise en CD med alle opplysninger på skjerm
		 System.out.println(cd.toString());
	 }
	 public void skrivUtCdDelstrengITittel(CDarkivADT cda, String delstreng){// Skrive ut alle CD-er med en spesiell delstreng i tittelen
		 System.out.println((cda.sokTittel(delstreng)).toString());
	 }
	 public void skrivUtCdArtist(CDarkivADT cda, String delstreng) { // Skriver ut alle CD-er av en artist / en gruppe
		 System.out.println((cda.sokArtist(delstreng)).toString());
	 }
	 public void skrivUtStatistikk(CDarkivADT cda){ // Skrive ut en enkel statistikk som inneholder antall CD-er totalt og hvor mange det er i hver sjanger
		System.out.println("antall CD-er totalt: " + cda.hentAntall());
		System.out.println("Antall POP: " + cda.hentAntall(Sjanger.POP) + "\n" + "Antall ROCK: " + cda.hentAntall(Sjanger.ROCK) + 
				"\n" + "Antall JAZZ: " + cda.hentAntall(Sjanger.JAZZ) + "\n" + "Antall BLUES: " +  cda.hentAntall(Sjanger.BLUES)
				+ "\n" );
	 }
	}//class