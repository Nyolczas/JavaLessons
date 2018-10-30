
public class Calculator {

    public int osszead(int a, int b) {
        return a + b;
    }

    public int osszead(int[] szamok) {
        int temp = 0;
        for (int i : szamok) {
            temp += i;
        }
        return temp;
    }

}
