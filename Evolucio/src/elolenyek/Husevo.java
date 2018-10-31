package elolenyek;

import fajok.AllatFaj;

public class Husevo extends Allat {
	
	public Husevo(AllatFaj faj, boolean nosteny) {
		super(faj, nosteny);
	}

	@Override
	public boolean eheto(Eloleny masikEloleny) {
		if(masikEloleny instanceof Allat){
			Allat allat=(Allat)masikEloleny;
			return ((AllatFaj)getFaj()).getEro()>((AllatFaj)allat.getFaj()).getEro();
		}else return false;
	}
	
	
	public static void elrejtozik(){
		System.out.println("Húsevõ elrejtõzött!");
	}

}
