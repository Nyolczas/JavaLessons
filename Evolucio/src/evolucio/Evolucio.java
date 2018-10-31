package evolucio;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import elolenyek.Eloleny;
import fajok.Faj;


public class Evolucio {

	public static final Random RAND=new Random();
	public static final int KEZDETI_ELOLENYEK=100;
	private static final int KOROK_SZAMA = 3;
	private static ArrayList<Eloleny> elolenyek;
	public static void main(String[] args) {
		elolenyek=  new ArrayList<>();
		for(int i=0; i<KEZDETI_ELOLENYEK; i++){
			elolenyek.add(Faj.FAJOK[RAND.nextInt(Faj.FAJOK.length)].ujEgyed());
		}
		System.out.println("Kezdetben:");
		kiiratas();
		
		for(int i=0; i<KOROK_SZAMA; i++){
			eves();
			halottakEltavolitasa();
			szaporodas();
		}
		
		System.out.println("Végül:");
		kiiratas();
		
		
		
//		//Ctrl+Shift+O
//		AllatFaj f1=null;
//		f1=new AllatFaj("Tigris");
//		
//		AllatFaj f2=new AllatFaj("Elefánt");
//		
//		System.out.println("Faj 1=" + f1.getNev());
//		System.out.println("Faj 2="+f2.getNev());
//		
//		//egyszerû típus
//		RGB rgb= new RGB();
//		f2.getRGB(rgb);
//		//syso + Ctrl+Space
//		System.out.println("r="+rgb.r + " g=" +rgb.g +" b= "+rgb.b);
//		
//		f1.instanceInt=1;
//		f2.instanceInt=2;
//		System.out.println("f1.instanceInt="+f1.instanceMethod());
//		System.out.println("f2.instanceInt="+f2.instanceMethod());
//		
//		f1.classInt=5;
//		f2.classInt=6;
//		Faj.classInt=7;
//		System.out.println("Faj.classInt="+Faj.classMethod());
//		System.out.println("f1.classInt="+f1.classMethod());
//		System.out.println("f2.classInt="+f2.classMethod());
//		
//		Faj f3=new Faj("Kukorica");
//		Eloleny kukorica1= new Eloleny(f3);
//		Eloleny kukorica2= new Eloleny(f3);
//		Husevo tigris1= new Husevo(f1, true);
//		Eloleny tigris2= new Husevo(f1, true);
//		Allat himtigris= new Husevo(f1, false);
//
//		System.out.println("himtigris megeheti tigris1-et? : "+himtigris.eheto(tigris1));
//		System.out.println("himtigris megeheti kukorica1-et? : "+himtigris.eheto(kukorica1));
//		System.out.println("k1 és k2 = "+kukorica1.szaporodhat(kukorica2));
//		System.out.println("k1 és t1= "+kukorica1.szaporodhat(tigris1));
//		System.out.println("t1 és t2=" + tigris1.szaporodhat(tigris2));
//		System.out.println("t1 és ht= "+ tigris1.szaporodhat(himtigris));
//		
//		Husevo.elrejtozik();
//		Allat tigris1Allat=tigris1;
//		Allat.elrejtozik();
//		
		
//		Faj roka2=new AllatFaj("Róka");
//		System.out.println(roka1.equals(roka2));
//		System.out.println(roka1==roka2);
//		valami();
//		System.out.println(tigris1.toString());
//		System.out.println(roka1);
//		System.out.println(kukorica1);
//		
//		Faj roka1=new HusevoFaj("Róka");
//		Class c=roka1.getClass();
//		Field[] fields=c.getDeclaredFields();
//		for (int i = 0; i < fields.length; i++) {
//			try {
//				fields[i].setAccessible(true);
//				System.out.println(fields[i].getName() + " : " +fields[i].get(roka1));
//			} catch (IllegalArgumentException | IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		

	}
	
	
	private static void szaporodas() {
		ArrayList<Eloleny> ujEgyedek= new ArrayList<>();
		for (int i = 0; i < elolenyek.size(); i++) {
			Eloleny eloleny= elolenyek.get(i);
			if(!eloleny.el()) continue;
			Eloleny ujEgyed= eloleny.szaporodik(kozelben(eloleny, i));
			if(ujEgyed!=null)
				ujEgyedek.add(ujEgyed);
		}
		elolenyek.addAll(ujEgyedek);
	}


	private static Eloleny[] kozelben(Eloleny eloleny, int index) {
		int kozelsegAlso = index-3;
		int kozelsegFelso = index+3;
		//anomália lép fel ha nem klónozzuk: 
		List<Eloleny> kozelben= new ArrayList<>(elolenyek.subList(kozelsegAlso <0 ? 0: kozelsegAlso, kozelsegFelso >= elolenyek.size() ? elolenyek.size()-1 : kozelsegFelso));
		kozelben.remove(eloleny);
		return kozelben.toArray(new Eloleny[]{null});
	}


	private static void halottakEltavolitasa() {
		ArrayList<Eloleny> halottak= new ArrayList<>();
		for (Eloleny eloleny : elolenyek) {
			if(!eloleny.el()) halottak.add(eloleny);
		}
		elolenyek.removeAll(halottak);
		
	}


	private static void eves() {
		for(int i=0; i<elolenyek.size(); i++){
			Eloleny eloleny=elolenyek.get(i);
			if(!eloleny.el()) continue;
			eloleny.elelmetKeres(kozelben(eloleny, i));
		}
	}


	private static void kiiratas() {
		ArrayList<Faj> indexek=new ArrayList<>();
		for (Faj faj: Faj.FAJOK) {
			indexek.add(faj);
		}
		int[] szamossag=new int[indexek.size()];
		for(Eloleny eloleny: elolenyek){
			szamossag[indexek.indexOf(eloleny.getFaj())]++;
		}
		for(int i=0; i< szamossag.length; i++){
			System.out.println(szamossag[i]+" db "+indexek.get(i).getNev());
		}
		
	}

}
