import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		List<Integer> a = new ArrayList<Integer>();
		
		for (int i=0; i<n; i++) {
			a.add(scan.nextInt());
		}
		System.out.println( minimumGap(a));
	}
	
	public static int minimumGap(List<Integer> a) {
		
		int min = Integer.MAX_VALUE;
		int index = -1;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i: a) {
			index++;
			if (map.containsKey(i)) {	
				if(min>index - map.get(i)) {
					min = index - map.get(i);
				}
				map.put(i, index);
			}
			if (!map.containsKey(i)) {
				map.put(i, index);
			}
			
		}
		return min;
	}

}
