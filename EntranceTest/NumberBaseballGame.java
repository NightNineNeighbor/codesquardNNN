import java.util.Scanner;

public class NumberBaseballGame {
	private BaseballReferee referee;
	private Scanner sc;
	
	public static void main(String[] args) {
		NumberBaseballGame game = new NumberBaseballGame();
		game.gameBoot();
		do{
			String input = game.getCheckedInput();
			game.referee.judgement(input);
			game.referee.declaration();
		}while(!game.isGameClear());
		game.gameFinalize();
	}
	
	public NumberBaseballGame() {
		sc = new Scanner(System.in);
	}
	
	private void gameBoot() {
		referee = new BaseballReferee();
	}
	
	private String getCheckedInput() {
		String input = "";
		do {
			input = getInput();
		}
		while(!referee.isValidInput(input));
		return input;
	}
	
	private String getInput() {
		System.out.print("숫자를 입력해 주세요 ex)123 : ");
		return sc.nextLine();
	}
	
	private boolean isGameClear() {
		if(referee.isOut()) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다!");
			return !isContinue();
		}else {
			return false;
		}
	}
	
	private boolean isContinue() {
		System.out.println("게임을 계속하겠습니까? Yes or No");
		String userResponse = sc.nextLine();
		if( userResponse.equals("No")) {
			System.out.println("게임 종료");
			return false;
		}else if(userResponse.equals("Yes")) {
			System.out.println("새 게임");
			referee = new BaseballReferee();
			return true;
		}else {
			System.out.println("잘못 입력했습니다. 다시 입력해 주세요.");
			return isContinue();
		}
	}
	
	private void gameFinalize() {
		sc.close();
	}
}
