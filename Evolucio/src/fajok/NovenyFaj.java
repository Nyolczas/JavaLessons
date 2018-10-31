package fajok;

import elolenyek.Eloleny;
import elolenyek.Noveny;

public class NovenyFaj extends Faj {

	public NovenyFaj(String nev) {
		super(nev);
	}

	@Override
	public Eloleny ujEgyed() {
		return new Noveny(this);
	}

}
