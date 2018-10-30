
public class Main {

	public static void main(String[] args) {
		System.out.println("1+2= "+(1+2));

		Calculator calc = new Calculator();
		System.out.println("1+2= "+ calc.osszead(1 ,2));
		System.out.println("1+2+3 = "+calc.osszead(new int[]{1,2,3}));

    }


}
