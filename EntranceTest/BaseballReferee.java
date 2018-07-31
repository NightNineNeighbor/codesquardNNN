import java.util.ArrayList;
import java.util.Collections;

public class BaseballReferee {
	private static final String STRIKE_ZONE_POOL = "1234567890";
	private static final int STRIKE_ZONE_SIZE = 3;
	private String strikeZone;
	private int strike;
	private int ball;
	
	public BaseballReferee() {
		super();
		this.strikeZone = makeRandomStrikeZone();
		//System.out.println("[DEBUG] : " + strikeZone);
	}
	
	private String makeRandomStrikeZone() {
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0; i < STRIKE_ZONE_POOL.length(); i++) {
			list.add(STRIKE_ZONE_POOL.substring(i,i+1));
		}
		Collections.shuffle(list);
		String ret = "";
		for(int i = 0; i < STRIKE_ZONE_SIZE; i++) {
			ret += list.get(i);
		}
		return ret;
	}
	
	public boolean isValidInput(String input) {
		if(!isLengthValid(input) || !isContentValid(input)) {
			return false;
		}else
			return true;
	}
	
	private boolean isLengthValid(String input) {
		if(input.length() != STRIKE_ZONE_SIZE) {
			System.out.println("길이가 알맞지 않습니다.");
			return false;
		}
		return true;
	}
	
	private boolean isContentValid(String input) {
		for(int i = 0; i < STRIKE_ZONE_SIZE; i++) {
			if(STRIKE_ZONE_POOL.indexOf(input.substring(i,i+1)) == -1) {
				System.out.println("숫자를 입력하세요. 잘못된 입력입니다.");
				return false;
			}
		}
		return true;
	}
	
	public void judgement(String input) {
		strike = ball = 0;
		for(int Nth =0; Nth < STRIKE_ZONE_SIZE ; Nth++) {
			judgeNthBall(Nth, input.substring(Nth, Nth+1));
		}
	}
	
	public void judgeNthBall(int Nth, String NthBall) {
		int hitIndex = strikeZone.indexOf(NthBall);
		if(hitIndex == Nth)
			strike++;
		else if(hitIndex != -1)
			ball++;
	}
	
	public void declaration() {
		if(strike != 0)
			System.out.print(strike + " 스트라이크");
		if(ball != 0)
			System.out.print(ball + "볼");
		if(strike == 0 && ball == 0)
			System.out.print("낫싱");
		System.out.println();
	}
	
	public boolean isOut() {
		if(strike == 3) {
			return true;
		}
		else
			return false;
	}
}
