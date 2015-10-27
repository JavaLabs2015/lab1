import java.util.Scanner;

public class Methods {

	public static void main(String[] args) {
		System.out.println("Simple calculator. Please choose an operation:");
		System.out.println("1. Add");
		System.out.println("2. Substract");
		System.out.println("3. Multiply");
		System.out.println("4. Divide");
		System.out.println("5. Factorial");
		System.out.println("6. Exit");

		Scanner input = new Scanner(System.in);
		int a = input.nextInt();

		switch (a) {
		case 1:
			System.out.println("Input first integer: ");
			int b = input.nextInt();
			System.out.println("Input second integer: ");
			int c = input.nextInt();
			System.out.println(add(b, c));
			exit();
		case 2:
			System.out.println("Input first ninteger: ");
			int d = input.nextInt();
			System.out.println("Input second integer: ");
			int e = input.nextInt();
			System.out.println(substract(d, e));
			exit();
		case 3:
			System.out.println("Input first integer: ");
			int f = input.nextInt();
			System.out.println("Input second integer: ");
			int g = input.nextInt();
			System.out.println(multiply(f, g));
			exit();
		case 4:
			System.out.println("Input dividend: ");
			double h = input.nextInt();
			System.out.println("Input divisor: ");
			double i = input.nextInt();
			System.out.println(divide(h, i));
			exit();
		case 5:
			System.out.println("Input integer:");
			int j = input.nextInt();
			System.out.println(factorial(j));
			exit();
		case 6:
			exit();
		}
		input.close();
	}

	public static int add(int a, int b) {
		int result = a + b;
		return result;
	}

	public static int substract(int a, int b) {
		int result = a - b;
		return result;
	}

	public static int multiply(int a, int b) {
		int result = a * b;
		return result;
	}

	public static double divide(double a, double b) {
		double result = a / b;
		return result;
	}

	public static long factorial(int a) {
		if (a < 2)
			return 1;
		else
			return factorial(a - 1) * a;
	}

	public static void exit() {
		System.exit(0);
	}

}
