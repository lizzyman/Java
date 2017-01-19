import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("===== 구구단 프로그램 =====");
		System.out.println("원하시는 구구단을 입력하세요. (입력 범위 : 2 ~ 9)");
		System.out.print("원하는 구구단 : ");

		int number = input.nextInt();

		System.out.println("========================");
		
		int i = 1;

		if ((number >= 2) && (number <= 9)) {
			System.out.println("구구단 " + number + "단을 출력합니다.");
			while ((i < 10)) {
				System.out.println(number + " * " + i + " = " + (number * i));
				i++;
			}
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}

	}

}
