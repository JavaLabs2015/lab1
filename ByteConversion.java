import java.util.Scanner;

public class ByteConversion {
	public static void main(String[] args) {		

		System.out.println("Enter the amount of bytes: ");
		Scanner input = new Scanner (System.in);
		double n = input.nextInt();
		ByteConversion a = new ByteConversion ();
		a.convert(n);;
		input.close();
	}

	final String[] UNITS = { "B", "KB", "MB", "GB" };

	public void convert(double a) {
		double [] numbers = new double [4];
		numbers [0] = a;
		
		for (int i = 1; i < numbers.length; i++) {
			numbers[i] = (double) (numbers[i - 1] / Math.pow(2, 10));
		}
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i] + UNITS [i]);
		}
		
	}
}
