package PortfolioQuestion5;

import java.util.Scanner;

public class Bear extends GameObject {
	
	private Scanner sc;
	
	public Bear (int x, int y, int distance) {
		super(x, y, distance);
		sc = new Scanner(System.in);
	}
//	이동한 후의 새로운 위치로 x, y 변경
	@Override
	protected void move() {
		System.out.println("왼쪽(a), 오른쪽(d), 위(w), 아래(s)");
		char input = sc.next() 
		char input = str.charAt(0); //우리는 첫 글자 하나만 받을 거기때문에 이렇게 표현. 0 넣어서
		
		switch (input) {
		case 'a': // 왼쪽
			x--;
			
			if (x < 0) {
				x = 0;
			}
			break;
		
		case 's': // 아래
			y++;
			
			if (y >= Game.MAX_Y) {
				y = Game.MAX_Y - 1;
			}
			break;
		
		case 'd': // 오른쪽
			x ++;
			
			if (x >= Game.MAX_X) {
				x = Game.MAX_X - 1;
			}
			break;
			
		case 'w': // 위
			y--;
			
			if(y < 0) {
				y = 0;
			}
			break;
		
		}
	}
	
//	Bear를 나타내는 문자 리턴
	@Override
	protected char getShape() {
		return 'B';
	}
}
