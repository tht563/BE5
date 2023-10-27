import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Length of array: ");
		int length = scan.nextInt();
		
		int[] array = new int [length];
		
		System.out.print("Array number: ");
		for (int i=0; i<length; i++) {
			array[i] = scan.nextInt();
		}
		
		findOddTimesAppearNum(array);
	}
	
	public static void findOddTimesAppearNum(int[] arr) {
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i=0; i<arr.length; i++) {
			if (arr[i]<min) {
				min = arr[i];
			}
			if (arr[i]>max) {
				max = arr[i];
			}
		}
		
		int[] count = new int[max-min+1];
		for (int i=0; i<arr.length; i++) {
			count[arr[i]-min]++;
		}
		
		for (int i=0; i<count.length; i++) {
			if (count[i]%2==1) {
				System.out.print(i+min+" ");
			}
		}
	}

}
