package PortFolioQuestion2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Answer2 {

	public static void main(String[] args) {
		int card; // 카드에 적힌 번호값(난수 발생, 컴퓨터가 가지고 있는 값)
		int low; // 입력 시 최소값, 사용자 입력에 의해서 변경될 최소 값
		int high; // 입력 시 최대값, 사용자 입력에 의해서 변경될 최대 값
		
//		Math.random() * 100 해도 됨. 아래 대신. 동일하게 나옴
//		ㄴ 0.0 ~ 0.9까지의 임의의 수 발생
		Random r = new Random(); // 임의의 수를 입력받기 위한 객체 생성
		Scanner sc = new Scanner(System.in); // 사용자 입력 받기
		
		while (true) {
			int i = 0; // 사용자의 입력 횟수
			low = 0; // 초기 최소값 및 사용자 입력에 따른 최소값 
			high = 99; // 초기 최대값 및 사용자 입력에 따른 최대값
//			(int)Math.random() * 100 와 동일
			card = r.nextInt(100); // 1에서 99까지의 수가 렌덤으로 만들어짐. 임의의값 생성
			System.out.println("수를 결정하였습니다. 맞추어보세요.");
			
//			사용자의 입력을 받는 부분
			while (true) {
				System.out.println(low + " - " + high);
//				몇 번 째 도전인지 연산
				System.out.println((i + 1) + " >> ");
				int n = 0; // 사용자가 입력한 숫자
				
//				사용자의 실수를 최소화하기 위한 예외처리
				try {
//					사용자 숫자 입력
					n = sc.nextInt();
				}
//				사용자 입력으로 들어온 부분에 대해서 검색
				catch (InputMismatchException e) {
					System.out.println("정수만 입력하세요.");
//					nextLine() : 줄바꿈이 있을 때까지 문자의 입력을 받는 명령어, 한 줄 전체 읽음
//					한 줄 전체를 읽은 후 버림, 잘 못 된 입력을 없애기 위해 사용
					sc.nextLine();
					continue; // 아래의 소스를 실행하지 않고, 다음 루프로 이동. 다시 처음부터 .. 
				}
				
//				입력된 사용자의 숫자가 범위 내에 있는지 검사
				if (n > high || n < low) {
					System.out.println("범위를 벗어났습니다.");
				}
//				정상 범위 내에 입력된 경우
//				매번 low, high의 범위를 좁혀감
				else {
//					정답일 경우 break를 사용하여 내부 while문 탈출
					if (n == card) {
						System.out.println("맞았습니다.");
						break;
					}
//					지정된 숫자보다 높을 경우
					else if (n > card) {
						System.out.println("더 낮게");
//						기존의 최대값을 낮춤
						high = n;
					}
//					지정된 숫자보다 낮을 경우
					else {
						System.out.println("더 높게");
//						기존의 최소값을 높임
						low = n;
					}
				}
				
				i++; // 사용자 입력 횟수 카운트
			} // 내부 while 문 종료
			
			System.out.println("다시 하시겠습니까?(y/n");
			if (sc.next().equals("n")) {
				break; // 외부 while 문 종료
			}
		} // 외부 while 문 종료
		
		sc.close(); // 사용자 입력을 위한 Scanner 닫기
	}

}



























