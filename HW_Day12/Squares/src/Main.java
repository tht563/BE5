import java.util.*;
import java.math.*;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		for (int i=0; i<q; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			System.out.println((int)squares(a, b));
		}
	}
	
	public static double squares(int a, int b) {
		
		return( Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);
	}

}
