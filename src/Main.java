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
		
		// 正解の数字生成
		List<Integer> numbers = generateNumbers();
		
		System.out.println(numbers);
		
		int turnNum = 0;
		
		while (true) {
			
			turnNum++;
			
			// ユーザーがまず入力
			List<Integer> userNumbers = inputNumbers();
			
			// チェック
			if (judge(numbers, userNumbers)) {
				// 正解の場合
				displayGameClear(turnNum);
				return;
			} else {
				displayResult(numbers, userNumbers);
			}
		}
		
	}
	
	private static void displayGameClear(int turnNum) {
		System.out.println("！！！！！Game Clear！！！！！");
		System.out.println("Completed in " + turnNum + " turns");
	}
	
	private static void displayResult(List<Integer> numbers, List<Integer> userNumbers) {
		int hit = countHitNum(numbers, userNumbers);
		int blow = countBlowNum(numbers, userNumbers) - hit;
		
		System.out.println("===Result===");
		System.out.println(hit + "HIT, " + blow + "BLOW");
		System.out.println("============");
	}
	
	private static int countHitNum(List<Integer> numbers, List<Integer> userNumbers) {
		int count = 0;
		for (int i = 0; i < DIGIT_NUMBER; i++) {
			if (numbers.get(i) == userNumbers.get(i)) {
				count++;
			}
		}
		
		return count;
	}
	
	private static int countBlowNum(List<Integer> numbers, List<Integer> userNumbers) {
		int count = 0;
		
		for (int i = 0; i < DIGIT_NUMBER; i++) {
			if (numbers.contains(userNumbers.get(i))) {
				count++;
			}
		}
		
		return count;
	}
	
	private static List<Integer> generateNumbers() {
		
		List<Integer> numbers = new ArrayList<>();
		
		while ( numbers.size() < DIGIT_NUMBER ) {
			
			int num = generateRanNum(numbers);
			numbers.add(num);
			
		}

		return numbers;
	}
	
	private static boolean judge(List<Integer> array1, List<Integer> array2) {
		
		return array1.equals(array2);

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
	
	private static int generateRanNum(List<Integer> numbers) {
		
		while (true) {
			Random rand = new Random();
			// 0 〜 9の乱数生成
			int randomNumber = rand.nextInt(10);
			if (!numbers.contains(randomNumber)) {
				return randomNumber;
			}
		}

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
	
}
