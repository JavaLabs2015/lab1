import java.util.Arrays;

public class ArraysEx {

	public static void main(String[] args) {
		double numbers[] = new double[20];
		numbers[0] = 1;
		double array[] = new double [20];

		for (int i = 1; i < numbers.length; i++) {
			numbers[i] = numbers[i - 1] * 2;
		}

		array[19] = numbers[19];
		array[0] = numbers[0];

		for (int i = 1; i < numbers.length - 1; i ++) {
			array[i] = (numbers[i - 1] + numbers[i + 1]) / 2;
		}

		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(array));
	}

}
