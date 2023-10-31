import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		for (int i=0; i<number; i++) {
			int n = scan.nextInt();
			int c = scan.nextInt();
			int m = scan.nextInt();
			System.out.println(theFeast(n,c,m));
		}
	}
	
	public static int theFeast(int n, int c, int m) {
		int result = n/c;
		int count = result;
		while (count>=m) {
			result += 1;
			count = count -m +1;
		}
		return result;
	}

}
