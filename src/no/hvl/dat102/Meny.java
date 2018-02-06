package no.hvl.dat102;
import java.util.Scanner;

import no.hvl.dat102.adt.*;

public class Meny {
	private static String MAPPE = System.getProperty("user.dir");
		 private Tekstgrensesnitt tekstgr;
		 private CDarkivADT cda;
		 static Scanner leser = new Scanner(System.in);
		 
		 public Meny(CDarkivADT cda){
		 tekstgr = new Tekstgrensesnitt();
		 this.cda = cda;}
		 public Meny() {
			 
		 }
			 
		 public void avslutt() {
			 System.exit(0);
		 }
		 
		 public void start(){
			 hovedMeny();
			 }
		 public void hovedMeny() {
			 System.out.println("velg et av tre alternativer "
			 		+ "ved å taste inn korresponderende nummer og enter. \n");
			 System.out.println("1) Eksisterende CDarkiv");
			 System.out.println("2) Lag nytt CDarkiv");
			 System.out.println("3) Avslutt");
			 
			 int input = leser.nextInt();
			 switch(input) {
			 case 1: eksisterendeArkiv();
			 break;
			 case 2: lagNyttArkivMeny();
			 break;
			 case 3: avslutt();
			 }
		 }
		 public void eksisterendeArkiv() {
			 System.out.println("skriv inn filnavnet cd arkivet har:");
			 String input = leser.next();
			 Fil.lesFraFil(cda,input +".txt");
			 arkivMeny();
			 
			 }
		 public void arkivMeny() {
			 System.out.println("valgalternativer for CD-arkiv \n");
			 System.out.println("1) Vis Arkiv");
			 System.out.println("2) Modifiser arkiv");
			 System.out.println("3) søk i arkiv");
			 System.out.println("4) skriv CD-arkiv til fil");
			 System.out.println("5) tilbake");
			 System.out.println("6) avslutt");
			 int input = leser.nextInt();
			 switch(input){
				 case 1: visMeny();
				 break;
				 case 2: modifiserMeny();
				 break;
				 case 3: sokMeny();
				 break;
				 case 4: skrivTilFilMeny();
				 break;
				 case 5: hovedMeny();
				 break;
				 case 6: avslutt();
				 break;
				
			 } 
		 }
		public void visMeny(){
			System.out.println("velg hva du ønsker å vise fra CD arkivet \n");
			System.out.println("1) Antall CD-er i arkivet");
			System.out.println("2) Antall CD-er med en spesifisert sjanger");
			System.out.println("3) Hele CD arkivet");
			System.out.println("\n 4) Tilbake");
			System.out.println("5) Avslutt");

			 int input = leser.nextInt();
			 switch(input){
				 case 1: System.out.println(cda.hentAntall());
				 visMeny();
				 break;
				 case 2: hvilkenSjanger();
				 break;
				 case 3: System.out.println(cda.toString());
				 visMeny();
				 break;
				 case 4: arkivMeny();
				 break;
				 case 5: avslutt();
				 break;
				 }
			 
		 }
			 public void hvilkenSjanger() {
				 System.out.println("Skriv inn den sjangeren du ønsker å vite antallet av \n");
				 String input = (leser.next()).toUpperCase();
				 System.out.println(cda.hentAntall(Sjanger.valueOf(input)));
				 visMeny();
				 
			 }
			 
			 public void sokMeny(){
				 System.out.println("Velg hva du vil søke på \n");
				 
					System.out.println("1) sok etter artist");
					System.out.println("2) sok etter tittel");
					System.out.println("\n 3) Tilbake");
					System.out.println("4) Avslutt");
				 int input = leser.nextInt();
				 switch(input){
					 case 1: sokArtistMeny();
					 break;
					 case 2: sokTittelMeny();
					 break;
					 case 3: arkivMeny();
					 break;
					 case 4: avslutt();}
				 
			 }
				public void sokArtistMeny(){
					System.out.println("skriv inn Artistnavn, eller deler av "
							+ " navnet");
					 String input = leser.next();
					 if(cda.sokArtist(input) != null) {
						 CD[] cdtab = cda.sokArtist(input);
						 CDarkiv cdark = new CDarkiv(cdtab);
						 int antall = 0;
						 for(int i = 0; i < cdtab.length; i++) {
							 if(cdtab[i] != null) {
								 antall ++;
							 }
						 }
						 System.out.println("\"" + input + "\"" + " ga " + antall + " treff \n\n"
						 		+  (cdark.toString()));}
						 else {System.out.println("fant ingen tittler som inneholdt"
						 		+ " søkeordet");
						 }
					 sokMeny();
				 }
				
				public void sokTittelMeny(){
					System.out.println("skriv inn tittelen, eller deler av tittelen");
					 String input = leser.next();
					 if(cda.sokTittel(input) != null) {
						 CD[] cdtab = cda.sokTittel(input);
						 CDarkiv cdark = new CDarkiv(cdtab);
						 int antall = 0;
						 for(int i = 0; i < cdtab.length; i++) {
							 if(cdtab[i] != null) {
								 antall ++;}
						 }
						 System.out.println("\"" + input + "\"" + " ga " + antall + " treff \n\n"
						 		+  cdark.toString());}
						 else {System.out.println("fant ingen tittler som inneholdt"
						 		+ " søkeordet");
						 }
					 
					 sokMeny();}
				
				public void modifiserMeny() {
					System.out.println("velg hva du ønsker å gjøre");
					System.out.println("1) Legg til CD i arkivet");
					System.out.println("2) Slett CD fra arkivet");
					System.out.println("\n 3) Tilbake");
					System.out.println("4) Avslutt");
					 int input = leser.nextInt();
					 switch(input){
						 case 1: leggTilCDMeny();
						 break;
						 case 2: slettCDMeny();
						 break;
						 case 3: arkivMeny();
						 break;
						 case 4: avslutt();
						 break;
						 }
				}
				public void leggTilCDMeny() {
					System.out.println("Skriv inn info om CD-en");
					cda.leggTilCd(Tekstgrensesnitt.lesCD());
					modifiserMeny();
				}
				
				public void slettCDMeny() {
					System.out.println("skriv inn cdnummeret til den "
							+ " CD-en du ønsker å slette");
					 int input = leser.nextInt();
					
				cda.slettCd(input);
				modifiserMeny();
					
				}
				public void lagNyttArkivMeny() {
					System.out.println("Skriv inn antall CD-er du ønsker å legge til"
							+ " i arkivet");
					 int input = leser.nextInt();
					 for(int i = 0; i < input; i ++) {
						 cda.leggTilCd(Tekstgrensesnitt.lesCD());
					 }
					 arkivMeny();
					
				}
				
				public void skrivTilFilMeny(){
					System.out.println("Skriv inn filnavnet på filen du vil lagre"
							+ " \n CD-arkivet på:");
					Scanner leser = new Scanner(System.in);
					String input = leser.nextLine(); 
					String inputFilType = input + ".txt";
					Fil.skrivTilFil(cda, inputFilType);
					System.out.println("filen ble lagret i " + MAPPE + "/" + inputFilType);
				};
			 
		}//class

