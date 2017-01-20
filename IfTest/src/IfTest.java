import java.util.*;

public class IfTest {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("세 정수를 입력하시오.");

		int[] number = new int[3];
		for (int i = 0; i < number.length; i++) {
			number[i] = input.nextInt();
		}

		int temp;
		for (int i = 0; i < number.length-1; i++) {

			for (int j = 0; j < number.length-(i+1); j++){
				if ( number[j] >= number[j+1]){
					temp = number[j];
					number[j] = number[j+1];
					number[j+1] = temp;
				}
			}

		}

		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i]+ " ");
		}

		String message = String.format("\n가장 큰 수 : %d \n가장 작은 수 : %d", number[2], number[0]);
		System.out.println(message);

	}

}
