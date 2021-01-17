package PortfolioQuestion5;

import java.util.Scanner;

public class Bear extends GameObject {
	
	private Scanner sc; // 사용자의 키보드 입력 받기
	
//	distance 한 번에 몇 칸 씩 이동할지
	public Bear (int x, int y, int distance) {
		super(x, y, distance);
		sc = new Scanner(System.in);
	}
//	GameObject의 추상메서드는 반드시 입력해줘야함
//	이동한 후의 새로운 위치로 x, y 변경
	@Override
	protected void move() {
		System.out.println("왼쪽(a), 오른쪽(d), 위(w), 아래(s) : ");
		String str = sc.next(); // next는 기본적으로 사용자의 문자열을 입력
		char input = str.charAt(0); //우리는 입력된 문자열 중 (해당 문자열의 첫 번째 문자)첫 글자 하나만 받을 거기때문에 이렇게 표현. 0 넣어서
		
		switch (input) {
//		컴퓨터의 좌표 체계 : 왼쪽 상단을 기준으로 (0,0)임, 일반 수학에서는 (0,0)은 왼쪽 하단인데, 컴퓨터는 왼쪽 상단을 기준으로 한다. 그래서 x의 +는 오른쪽, y의 +는 아래로 이동함. -는 각각 그 반대로 이동함.
		case 'a': // 왼쪽
			x--;
			
//			기준을 (0,0)으로 두고 바깥으로 못 나가게 설정
//			화면 왼쪽 끝에서 더 이상 움직일 수 없음
			if (x < 0) {
				x = 0;
			}
			break;
		
		case 's': // 아래
			y++;
			
//			MAX 값은 Game 클래스에 설정해둠
			if (y >= Game.MAX_Y) {
//				맵의 위치가 0부터 시작이기 때문에 -1을 함
				y = Game.MAX_Y - 1;
			}
			break;
		
		case 'd': // 오른쪽
			x ++;
			
			if (x >= Game.MAX_X) {
//				맵의 위치가 0부터 시작이기 때문에 -1을 함
				x = Game.MAX_X - 1;
			}
			break;
			
		case 'w': // 위
			y--;
			
//			범위를 벗어나지 못 하도록 확인 후 값 변경
			if(y < 0) {
				y = 0;
			}
			break;
			
		default:
			System.out.println("잘 못 입력 하셨습니다.");
			System.out.println("왼쪽(a), 오른쪽(d), 위(w), 아래(s) : ");
		}
	}
	
//	Bear를 나타내는 문자 리턴
	@Override
	protected char getShape() {
		return 'B';
	}
}
