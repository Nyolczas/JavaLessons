package elolenyek;

import fajok.Faj;

public abstract class Eloleny {
	
	//Ctrl+Shift+O => Importok
	//Ctrl+1
	private Faj faj;
	private final int id;
	private boolean el=true;
	public static int nextID=0;
	
	
	public Eloleny(Faj faj){
		this.setFaj(faj);
		id=nextID++;
	}
	
	public void meghal(){
		el=false;
	}
	
	public boolean el(){
		return el;
	}
	
	public void elelmetKeres(Eloleny[] elolenyek){
		for (Eloleny eloleny : elolenyek) {
			if(eheto(eloleny)){
				eves(eloleny);
			}
		}
	}
	
	private void eves(Eloleny eloleny) {
		eloleny.meghal();		
	}

	public abstract boolean eheto(Eloleny eloleny);

	public boolean szaporodhat(Eloleny masikEloleny){
		return getFaj()==masikEloleny.getFaj();
	}
	
	public Eloleny szaporodik(Eloleny[] elolenyek){
		for (int i = 0; i < elolenyek.length; i++) {
			if(szaporodhat(elolenyek[i])){
				return getFaj().ujEgyed();
			}
		}
		return null;
	}

	public Faj getFaj() {
		return faj;
	}

	public void setFaj(Faj faj) {
		this.faj = faj;
	}
	
	@Override
	public String toString() {
		return faj.getNev()+"["+id+"]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((faj == null) ? 0 : faj.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eloleny other = (Eloleny) obj;
		if (faj == null) {
			if (other.faj != null)
				return false;
		} else if (!faj.equals(other.faj))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	
//	@Override
//	public int hashCode() {
//		//hastáblában
//		//int -2^16->2^16-1 
//		return super.hashCode();
//	}
	

}
