package PortfolioQuestion3;

import java.util.Scanner;

public class Player {
	private Scanner sc; // 사용자 입력
	private String name; // 게임 참가자 이름
	private String word; // 게임 참가자의 단어
	
	public Player(String name) {
		this.name = name;
		sc = new Scanner(System.in);
	}
	
//	게임 참가자 이름 출력
	public String getName() {
		return name;
	}
	
	public String getWordFromUser() {
		System.out.println(name + " >> ");
		word = sc.next(); // 게임 참가자의 단어를 사용자 입력으로 받아옴, 멤버 변수 word에 저장
		return word; // 메서드를 호출한 곳으로 사용자 입력 단어를 출력함
	}
	
//	매개변수로 이전 참가자의 단어를 받아옴
	public boolean checkSuccess(String lastWord) {
//		문자열은 문자의 배열로 표시할 수 있음
//		문자열도 index는 0부터 시작, 가장 마지막 index 번호는 length - 1
//		length는 글자 길이를 나타 내고, index는 0부터 시작하기 때문에 length보다 1 작다. 
		int lastIndex =  lastWord.length() -1;
		
//		charAt : 지정한 index의 문자 1개를 가져옴
//		데이터 타입이 char이기 때문에 == 비교 연산자로 비교가 가능함.
//		char 데이터 타입 : 문자 1개를 저장하기 위한 데이터 타입, 정수형 데이터 타입, 저장 데이터는 유니코드 문자 1개 
//		정수형 데이터 타입이기 때문에 ==  비교 연산자 가능
//		문자열 String 같은 경우에는 참조 타입이기 때문에 == 비교 연산자 사용 불가능 하고, equlas라는 명령어를 사용해서 비교해야 한다. 
		if (lastWord.charAt(lastIndex) == word.charAt(0)) {
			return true;
		}
		else { 
			return false;
		}
	}
}


























