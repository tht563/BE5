import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("The length of array: ");
		int length = scan.nextInt();
		
		ArrayList<Integer> a = new ArrayList<>();
		for (int i=0; i<length; i++) {
			a.add(scan.nextInt());
		}
		
		System.out.println(minimumGap(a));

	}
	
	public static int minimumGap(ArrayList<Integer>a) {
		int minGap = Integer.MAX_VALUE; 
		for (int i=0;i< a.size()-1; i++) {
			for (int j=i+1;j<a.size(); j++) {
				if (a.get(i)==a.get(j)) {
					if (minGap>j-i) {
						minGap = j-i;
					}
				}
			}
		}
		if (minGap == Integer.MAX_VALUE) {
			return -1;
		}
		return minGap;
	}

}
