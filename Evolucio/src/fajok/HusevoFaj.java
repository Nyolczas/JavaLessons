package fajok;

import elolenyek.Eloleny;
import elolenyek.Husevo;
import evolucio.Evolucio;

public class HusevoFaj extends AllatFaj {

	public HusevoFaj(String nev, int ero) {
		super(nev, ero);
	}

	@Override
	public Eloleny ujEgyed() {
		return new Husevo(this, Evolucio.RAND.nextBoolean());
	}

}
