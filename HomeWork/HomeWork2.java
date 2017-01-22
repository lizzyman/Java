import java.util.Scanner;

public class HomeWork2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int input;
		String message;

		while(true){

			System.out.println("1: SUM/AVG 2: Fah->Cel 3: BMI 4: EXIT");

			input = scan.nextInt();

			if (input == 1) {
				System.out.println("점수 5개를 입력하시오.");
				int[] scores = new int[5];
				int sum = 0;

				for (int i:scores) {
					scores[i] = scan.nextInt();
					sum += scores[i];
				}

				int avg = sum / scores.length;

				System.out.println("SUM : " + sum + " AVG : "+ avg);

			}
			else if (input == 2) {
				System.out.println("Fah 입력하시오.");
				double fah = scan.nextDouble();
				double cel = (fah - 32) / 1.8;

				message = String.format("Fah = %.2f -> Cel = %.2f", fah, cel);
				System.out.println(message);
			}
			else if ( input == 3 ) {
				System.out.println("키와 몸무게를 차례대로 입력하시오.");
				double height = scan.nextDouble();
				double weight = scan.nextDouble();

				double bmi = weight / ((0.01 * height) * (0.01 * height));

				message = String.format("Height = %.2fcm Weight = %.2fkg BMI = %.4f", height, weight, bmi);
				System.out.println(message);
			}
			else if (input == 4) {
				System.out.println("시스템을 종료합니다.");
				return;
			}
			else {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}

		}

	}

}

