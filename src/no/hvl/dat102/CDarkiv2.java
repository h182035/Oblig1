package no.hvl.dat102;

import no.hvl.dat102.adt.CDarkivADT;

public class CDarkiv2 implements CDarkivADT {
	private LinearNode<CD> firstNode;
	private int antall;

	public CDarkiv2() {
		firstNode = null;

	}

	public CDarkiv2(CD[] tab) {
		CDarkiv2 cdArkiv = new CDarkiv2();
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] != null) {
				cdArkiv.leggTilCd(tab[i]);
			}
		}
		this.firstNode = cdArkiv.firstNode;

	}

	public boolean isEmpty() {
		return (firstNode == null);
	}

	public void leggTilCd(CD cd) {
		LinearNode<CD> newNode = new LinearNode<CD>(cd);
		newNode.neste = firstNode;
		firstNode = newNode;
		antall++;

	}

	public LinearNode<CD> fjernForsteNode() {

		LinearNode<CD> nodeReference = firstNode;
		if (!isEmpty()) {
			firstNode = firstNode.getNeste();
			antall--;
		} else {
			System.out.println("Tom kjedet liste");
		}

		return nodeReference;
	}

	public void display() {
		LinearNode<CD> noden = firstNode;

		while (noden != null) {

			System.out.println("elementet i denne noden:\n" + "navn: " + noden.getElement().getNavn() + "\n"
					+ "cd nummer:" + noden.getElement().getNummer() + "\n");
			if (noden.neste != null) {
				System.out.println("elementet i neste node er:\n" + "navn: " + (noden.getNeste()).getElement().getNavn()
						+ "\n" + "cd nummer: " + noden.getNeste().getElement().getNummer() + "\n");
			} else {
				System.out.println("elementet i neste node er : null");
			}
			noden = noden.getNeste();

			System.out.println();
		}
	}

	public LinearNode<CD> finnCd(int CDnummer) {

		LinearNode<CD> noden = firstNode;

		if (!isEmpty()) {
			while (noden.getElement().getNummer() != CDnummer) {
				if (noden.getNeste() == null) {
					return null;
				} else {
					noden = noden.getNeste();

				}
			}

		} else {
			System.out.println("Tom kjedet liste");
		}

		return noden;

	}

	public boolean slettCd(int CDnummer) {
		boolean slettet = false;
		LinearNode<CD> currentNode = firstNode;
		LinearNode<CD> previousNode = firstNode;

		while (currentNode.getElement().getNummer() != CDnummer) {
			if (currentNode.getNeste() == null) {
				return slettet;
			}

			else {
				previousNode = currentNode;
				currentNode = currentNode.neste;
				antall--;
			}
		}
		if (currentNode == firstNode) {
			firstNode = firstNode.neste;
		}

		else {
			previousNode.neste = currentNode.neste;

		}

		return slettet;
	}

	public CD[] hentCdTabell() {
		LinearNode<CD> noden = firstNode;
		CD[] tab = new CD[antall];
		int i = 0;
		while (noden != null && i < antall) {

			tab[i] = (noden.getElement());
			i++;
			noden = noden.getNeste();
		}
		return tab;
	}

	public CD[] sokTittel(String delstreng) {// Søker og henter CD-er med en gitt delstreng
		LinearNode<CD> node = firstNode;
		CD[] titler = new CD[antall];
		while (node != null) {
			for (int i = 0; i < antall; i++) {
				if (node.getElement().getTittel().contains(delstreng)) {
					titler[i] = node.getElement();
				}
				node = node.neste;
			}
		}
		return titler;
	}

	public CD[] sokArtist(String delstreng) {
		LinearNode<CD> node = firstNode;
		CD[] artister = new CD[antall];
		while (node != null) {
			for (int i = 0; i < antall; i++) {
				if (node.getElement().getNavn().contains(delstreng)) {
					artister[i] = node.getElement();
				}
				node = node.neste;
			}
		}
		return artister;
	}

	public int hentAntall() {
		return antall;
	}

	public int hentAntall(Sjanger sjanger) { // Henter antall CD-er for en gitt sjanger
		int tempAntall = 0;
		LinearNode<CD> node = firstNode;
		CD[] tabsjanger = new CD[antall];
		for (int i = 0; i < antall; i++) {
			if ((node.getElement().getSjanger()).toString() == sjanger.toString()) {
				tabsjanger[i] = node.getElement();
				tempAntall++;
			}
			node = node.neste;
		}

		return tempAntall;
	}

	public String toString() {
		String tilString = "";
		LinearNode<CD> node = firstNode;
		while (node != null) {
			tilString += node.getElement().toString();
			node = node.neste;
		}
		return tilString;
	}

	public LinearNode<CD> getFirstNode() {
		return firstNode;
	}

	public void setFirstNode(LinearNode<CD> firstNode) {
		this.firstNode = firstNode;
	}

}
