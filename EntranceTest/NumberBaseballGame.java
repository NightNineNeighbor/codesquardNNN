import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NumberBaseballGame {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 1; i <=9; i++) {
			list.add(i);
		}
		
		Collections.shuffle(list);
		
		String answer = "" + list.get(0) + list.get(1) + list.get(2);
		answer = "713"; //debug
		System.out.println("[debug] answer : " + answer);
		
		boolean isSolved = false;
		Scanner sc = new Scanner(System.in);
		while(!isSolved) {
			System.out.println("숫자를 입력해 주세요 ex)123 : ");
			String input = sc.nextLine();
			System.out.println(input);
			
			int ball = 0;
			int strike = 0;
			
			for(int i =0; i < 3 ; i++) {
				int index = answer.indexOf(input.substring(i, i+1));
				if(index == i)
					strike++;
				else if(index != -1)
					ball++;
			}
			
			if(strike != 0)
				System.out.print(strike + " 스트라이크");
			if(ball != 0)
				System.out.print(ball + " 볼");
			if(strike == 0 && ball == 0)
				System.out.println("낫싱");
			System.out.println();
			if(strike == 3) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				isSolved = true;
			}
			
		}
		sc.close();
	}
}
