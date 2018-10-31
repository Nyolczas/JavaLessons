package fajok;

import rgb.RGB;
import elolenyek.Eloleny;

public abstract class Faj {
	
	public static final Faj[] FAJOK=new Faj[]{
		new HusevoFaj("Tigris", 10),
		new HusevoFaj("Róka", 5),
		new HusevoFaj("Farkas", 7),
		new NovenyevoFaj("Tehén", 5),
		new NovenyevoFaj("Elefánt", 10),
		new NovenyevoFaj("Csirke", 1), 
		new NovenyFaj("Kukorica"),
		new NovenyFaj("Burgonya"),
		new NovenyFaj("Csipkebogyó")
	};
	
	private String nev;
	public static int classInt;
	public int instanceInt;

	//RGB
	
	private int piros, zold, kek;
	
	private Faj(){
		this("ANONYMUS Faj", 0,0,0);
	}
	
	public Faj(String nev, int piros, int zold, int kek){
		this.nev=nev;
		this.piros=piros;
		this.zold=zold;
		this.kek=kek;
	}
	
	public Faj(String nev){
		this();
		this.nev=nev;
	}
	
	public String getNev(){
		return nev;
	}
	
	public void setNev(String ujNev){
		nev=ujNev;
	}
	
	public void setRGB(int piros, int ujZold, int ujKek){
		this.piros=piros;
		zold=ujZold;
		kek=ujKek;
	}
	
	public void getRGB(RGB rgb){
		rgb.r=this.piros;
		rgb.g=this.zold;
		rgb.b=this.kek;
	}
	
	public static int classMethod(){
		return classInt;
	}
	
	public int instanceMethod(){
		return instanceInt;
	}
	
	@Override
	public boolean equals(Object obj) {
		return nev.equals(((Faj)obj).nev);
	}
	
	@Override
	public String toString() {
		return nev;
	}
	
	public abstract Eloleny ujEgyed();

}
