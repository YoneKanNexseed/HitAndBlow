import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * 1. 敵側の3桁数字を生成（かぶらない数）
 * 2. ユーザーが数字を入力
 * 3. 入力された数字の判定（回数記録）
 * 
 */
public class Main {
	
private static final int DIGIT_NUMBER = 3;
	
	public static void main(String[] args) {
		
		List<Integer> numbers = generateNumbers();
		
		int turnNum = 0;
		
		while (true) {
			turnNum++;
			
			List<Integer> userNumbers = inputNumbers();
			
			if (judge(numbers, userNumbers)) {
				displayResult(turnNum);
				break;
			} else {
				displayResult(numbers, userNumbers);
			}
		}
	}

	private static void displayResult(int turnNum) {
		System.out.println("！！！！！Game Clear！！！！！");
		System.out.println("Completed in " + turnNum + " turns");
	}
	
	private static List<Integer> generateNumbers() {
      List<Integer> numbers = new ArrayList<>();

      Random rand = new Random();
 
      while (numbers.size() < DIGIT_NUMBER) {
    	  int randomNumber = rand.nextInt(10);
    	  if (!numbers.contains(randomNumber)) {
    		  numbers.add(randomNumber);
    	  }
      }
      
      return numbers;
    }
	
	private static List<Integer> inputNumbers() {
		List<Integer> userNumbers = new ArrayList<>();
		
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 1; i <= DIGIT_NUMBER; i++) {
			String ordinal = convertIntToOrdinal(i);
			System.out.print("Please enter the " + ordinal + " digit：");
			
			int num = scanner.nextInt();
			
			userNumbers.add(num);
		}
		
		return userNumbers;
	}
	
	private static String convertIntToOrdinal(int number) {
		String ordinal = "";
		
		switch (number) {
		case 1:
			ordinal = "First";
			break;
			
		case 2:
			ordinal = "Second";
			break;
			
		case 3:
			ordinal = "Third";
			break;

		default:
			break;
		}
		
		return ordinal;
	}
	
	private static boolean judge(List<Integer> array1, List<Integer> array2) {
		return array1.equals(array2);
	}
	
	private static void displayResult(List<Integer> numbers, List<Integer> userNumbers) {
		int hit = countHit(numbers, userNumbers);
		int blow = countBlow(numbers, userNumbers);
		
		System.out.println("===Result===");
		System.out.println(hit + "HIT, " + blow + "BLOW");
		System.out.println("============");
	}
	
	private static int countHit(List<Integer> numbers, List<Integer> userNumbers) {
		int count = 0;
		
		for (int i = 0; i < DIGIT_NUMBER; i++) {
			if (numbers.get(i) == userNumbers.get(i)) {
				count++;
			}
		}
		
		return count;
	}
	
	private static int countBlow(List<Integer> numbers, List<Integer> userNumbers) {
		int count = 0;
		
		for (int i = 0; i < DIGIT_NUMBER; i++) {
			if (numbers.get(i) != userNumbers.get(i) && userNumbers.contains(numbers.get(i))) {
				count++;
			}
		}
		
		return count;
	}
	
}
