package elolenyek;

import fajok.AllatFaj;

public abstract class Allat extends Eloleny {

	private boolean nosteny;
	
	public Allat(AllatFaj faj, boolean nosteny){
		super(faj);
		this.nosteny=nosteny;
	}
	
	public abstract boolean eheto(Eloleny masikEloleny);
	
	@Override
	public boolean szaporodhat(Eloleny masikEloleny){
		if(masikEloleny instanceof Allat){
			return super.szaporodhat(masikEloleny) &&
					this.nosteny!=((Allat)masikEloleny).nosteny; 
		}
		return false;
	}
	
	public static void elrejtozik(){
		System.out.println("Állat elrejtõzött!");
	}

	
	
}
