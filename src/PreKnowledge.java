import java.util.Random;
import java.util.Scanner;

public class PreKnowledge {

	public static void main(String[] args) {
		
		// const
		final double PI = 3.14;
		
		// User Input
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Please input text：");
		String text = scanner.nextLine();
		System.out.println(text);
		
		System.out.print("Please input number：");
		int number = scanner.nextInt();
		System.out.println(number);
		
		// Random Number
		Random rand = new Random();
		
		// 0 〜 2
		int randomNumber = rand.nextInt(3);
		
		// 0 〜 4
		randomNumber = rand.nextInt(5);
	}
	
}
