import elolenyek.Eloleny;
import fajok.Faj;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static final Random RAND = new Random();
    public static final int KEZDETI_ELOLENYEK = 100;
    private static final int KOROK_SZAMA = 3;
    private static ArrayList<Eloleny> elolenyek;

    public static void main(String[] args) {
        elolenyek = new ArrayList<>();
        for (int i = 0; i < KEZDETI_ELOLENYEK; i++) {
            elolenyek.add(Faj.FAJOK[RAND.nextInt(Faj.FAJOK.length)].ujEgyed());
        }
        System.out.println("Kezdetben:");
        kiiratas();

        for (int i = 0; i < KOROK_SZAMA; i++) {
            eves();
            halottakEltavolitasa();
            szaporodas();
        }

        System.out.println("Végül:");
        kiiratas();
    }


    private static void szaporodas() {
        ArrayList<Eloleny> ujEgyedek = new ArrayList<>();
        for (int i = 0; i < elolenyek.size(); i++) {
            Eloleny eloleny = elolenyek.get(i);
            if (!eloleny.el()) continue;
            Eloleny ujEgyed = eloleny.szaporodik(kozelben(eloleny, i));
            if (ujEgyed != null)
                ujEgyedek.add(ujEgyed);
        }
        elolenyek.addAll(ujEgyedek);
    }


    private static Eloleny[] kozelben(Eloleny eloleny, int index) {
        int kozelsegAlso = index - 3;
        int kozelsegFelso = index + 3;
        //anomália lép fel ha nem klónozzuk:
        List<Eloleny> kozelben = new ArrayList<>(elolenyek.subList(kozelsegAlso < 0 ? 0 : kozelsegAlso, kozelsegFelso >= elolenyek.size() ? elolenyek.size() - 1 : kozelsegFelso));
        kozelben.remove(eloleny);
        return kozelben.toArray(new Eloleny[]{null});
    }


    private static void halottakEltavolitasa() {
        ArrayList<Eloleny> halottak = new ArrayList<>();
        for (Eloleny eloleny : elolenyek) {
            if (!eloleny.el()) halottak.add(eloleny);
        }
        elolenyek.removeAll(halottak);

    }


    private static void eves() {
        for (int i = 0; i < elolenyek.size(); i++) {
            Eloleny eloleny = elolenyek.get(i);
            if (!eloleny.el()) continue;
            eloleny.elelmetKeres(kozelben(eloleny, i));
        }
    }


    private static void kiiratas() {
        ArrayList<Faj> indexek = new ArrayList<>();
        for (Faj faj : Faj.FAJOK) {
            indexek.add(faj);
        }
        int[] szamossag = new int[indexek.size()];
        for (Eloleny eloleny : elolenyek) {
            szamossag[indexek.indexOf(eloleny.getFaj())]++;
        }
        for (int i = 0; i < szamossag.length; i++) {
            System.out.println(szamossag[i] + " db " + indexek.get(i).getNev());
        }

    }
}
