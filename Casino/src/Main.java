public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot();
        FelhasznaloiJatekos user = new FelhasznaloiJatekos("Béla");
        Asztal asztal = new Asztal();
        leptet(robot);
        leptet(user);


    }

    public static void leptet(Jatekos j) {
        j.lep();
    }
}
