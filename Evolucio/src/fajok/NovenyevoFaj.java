package fajok;

import elolenyek.Eloleny;
import elolenyek.Novenyevo;
import evolucio.Evolucio;

public class NovenyevoFaj extends AllatFaj {

	public NovenyevoFaj(String nev, int ero) {
		super(nev, ero);
	}

	@Override
	public Eloleny ujEgyed() {
		return new Novenyevo(this, Evolucio.RAND.nextBoolean());
	}

}
