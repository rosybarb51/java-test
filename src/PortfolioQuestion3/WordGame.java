package PortfolioQuestion3;

import java.util.Scanner;

public class WordGame {
	private Scanner sc; // 사용자 입력
	private String startWord = "겨울한파"; // 시작단어 
	private Player[] players; // 게임 참가자 
	
	public WordGame() {
		sc = new Scanner(System.in);
	}
	
	private void createPlayers() {
		System.out.print("게임에 참가하는 인원은 몇명입니까?");
		
//		게임 참가자 숫자 입력 받음
		int nPlayers = sc.nextInt();
//		playres : Player 배열 타입의 변수 
//		클래스의 배열 : players =  new Player[nPlayer]; 이렇게 하면 배열만 생성됨
//		해당 배열의 요소인 클래스 타입의 객체는 생성되지 않음
//		실제 객체를 만들려면 객체 실행하는 부분이 for문으로 한 번 더 들어가야한다. 
		players = new Player[nPlayers];
		
		for (int i = 0; i < nPlayers; i++) {
			System.out.println("참가자의 이름을 입력하세요.");
			String name = sc.next();

//			배열 요소의 클래스 타입일 경우 각 요소마다 new 키워드를 이용하여 해당 클래스 타입의 객체를 생성함
			players[i] = new Player(name);
		}
	}
	
	public void run() {
		System.out.println("끝말잇기 게임을 시작합니다.");
		createPlayers(); // 끝말잇기 참가자 생성
		
//		시작 단어 여러 개 렌덤으로 하는 방법
//		String[] arrStartWord = {
//			"북극한파", "코로나19", "확진자", "호빵"
//		};
//		
//		Random r = new Rendom();
//		int index = r.nextInt(4);
//		
//		String lastWord = arrStartWord[index];
		String lastWord = startWord;
		
		
		System.out.println("시작하는 단어는 " + lastWord + "입니다.");
		int next = 0; // 게임 참가자 순서 
		
		while (true) { // 무한루프
//			새로운 단어 가져오기
			String newWord = players[next].getWordFromUser(); // 새 단어 만들기
			if (!players[next].checkSuccess(lastWord)) {
				System.out.print(players[next].getName() + "이 졌습니다.");
				break;
			}
			next++; // 위의 if문(실패)이 아닐 때 실행, 게임 참가자 순서 카운트
//			next = next % players.length; 나눈 나머지 값을 next에 다시 넣어준다. 
//			위의 것을 실행하면 0부터 넣어주면 나머지가 0, 1, 2 또 0, 1, 2 ... 이런 식으로 나와서 참가자들이 순서대로 게임을 진행할 수 있다. 
			next %= players.length; 
			lastWord = newWord;
		}
	}


}














