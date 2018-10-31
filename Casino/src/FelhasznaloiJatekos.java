public class FelhasznaloiJatekos extends Jatekos {

    private String nev;

    public FelhasznaloiJatekos(String jatekosNeve) {
        nev = jatekosNeve;
    }

    @Override
    public void lep() {
        System.out.println(nev + " lép");
    }
}
