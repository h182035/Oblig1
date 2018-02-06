package no.hvl.dat102;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat102.adt.*;
public class Fil {
	
	private static String MAPPE = System.getProperty("user.dir");

	final String SKILLE = "#"; // Eventuelt ha som parameter i
	// metodene.
	// Lese et CDarkiv fra tekstfil

	public static CDarkivADT lesFraFil(CDarkivADT cdarkiv, String filnavn) {

		File fileToRead = new File(MAPPE + "/" + filnavn);

		try {
			BufferedReader getFileInfo = new BufferedReader(new FileReader(fileToRead));
			String fileInfoStr = getFileInfo.readLine();

			while (fileInfoStr != null) {

				String[] individuellInfo = fileInfoStr.split("#"); // Nr#Artist#Tittel#år#Sjanger#Plateselskap
				CD cd = new CD();
				int i = 0;
				cd.setNummer(Integer.parseInt(individuellInfo[i]));
				cd.setNavn(individuellInfo[i + 1]);
				cd.setTittel(individuellInfo[i + 2]);
				cd.setLansering(Integer.parseInt(individuellInfo[i + 3]));
				cd.setSjanger(Sjanger.valueOf(individuellInfo[i + 4]));
				cd.setPlateselskap(individuellInfo[i + 5]);
				cdarkiv.leggTilCd(cd);
				i = i + 6;
				fileInfoStr = getFileInfo.readLine();

			}
			getFileInfo.close();
			return cdarkiv;
		}

		catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		} catch (Exception e) {
			System.out.println("an error occured");
			e.getMessage();
			System.exit(0);
		}
		cdarkiv = null;
		return cdarkiv;

	}

	// Lagre et CDarkiv til tekstfil
	public static void skrivTilFil(CDarkivADT cdarkiv, String filnavn) {

		CD[] cdsamling = cdarkiv.hentCdTabell();
		PrintWriter samlingOutput = createFile(MAPPE + "/" + filnavn);

		for (CD cd : cdsamling) {
			{
				if (cd == null) {
					samlingOutput.close();
					continue;
				}
				lagCD(cd, samlingOutput);
			}
		}
	}

	private static PrintWriter createFile(String filename) {

		try {
			File personSamling = new File(filename);

			PrintWriter infoToWrite = new PrintWriter(new BufferedWriter(new FileWriter(personSamling)));
			return infoToWrite;

		}

		catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return null;

	}

	private static void lagCD(CD cd, PrintWriter samlingOutput) {// Nr#Artist#Tittel#år#Sjanger#Plateselskap

		String cdInfo = Integer.toString(cd.getNummer()) + "#" + cd.getNavn() + "#" + cd.getTittel() + "#"
				+ cd.getLansering() + "#" + cd.getSjanger().toString() + "#" + cd.getPlateselskap();
		;
		samlingOutput.println(cdInfo);

	}
}// class



	