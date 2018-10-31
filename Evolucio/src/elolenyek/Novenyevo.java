package elolenyek;

import fajok.AllatFaj;

public class Novenyevo extends Allat {

	public Novenyevo(AllatFaj faj, boolean nosteny) {
		super(faj, nosteny);
	}

	@Override
	public boolean eheto(Eloleny masikEloleny) {
		return masikEloleny instanceof Noveny;
	}

}
