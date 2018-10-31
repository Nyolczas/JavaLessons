import java.util.ArrayList;

public class Asztal {
    private ArrayList<Jatekos> jatekosok; // dinamikus tömb
    private int korok;
    private double pot;
    private double aktualTet;

    // konstruktor
    public Asztal(){
        korok=0;
        pot=0;
        aktualTet=1.0;
        jatekosok= new ArrayList<>();
        jatekosok.add(new Robot());
    }
}
