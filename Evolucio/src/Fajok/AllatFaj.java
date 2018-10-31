package fajok;

import elolenyek.Eloleny;

//Faj => Õsosztály, ÁllatFaj => Leszármaztatott osztály
public abstract class AllatFaj extends Faj {
	
	private int ero;
	public AllatFaj(String nev, int ero){
		super(nev);
		this.ero=ero;
	}
	
	public int getEro(){
		return ero;
	}

}
