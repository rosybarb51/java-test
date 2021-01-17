package PortfolioQuestion5;

public class Game {
//	상수 사용 : final static 붙이고 대문자로 이름 붙이면 됨
	public final static int MAX_X = 20; // 가로축 최대값
	public final static int MAX_Y = 10; // 세로축 최대값
	
//	화면에 출력될 실제 맵 - char[][] :char 타입의 2차원 배열 생성
//	cf) 1차원 배열은 선형
//		2차원 배열은 면 형태(엑셀, 지도 등)
//	10줄에 20칸 짜리 배열 만들어짐
	private char[][] map = new char[MAX_Y][MAX_X]; 
//	Bear, Fish의 객체가 저장될 배열
	private GameObject[] m = new GameObject[2]; // 현재는 배열만 만들어져있음. 그저 배열일 뿐.
	
	public Game() {
//		맵에 대한 초기값을 넣어줌. 화면에 나타나진 않고 각 위치에 값만 저장함
//		클래스 타입을을 배열로 만들면 배열 변수만 생성이 됨
//		그래서 아래와 같이 각 요소 부분에 배열을 초기화해서 넣어준다. 
		for (int i = 0; i < MAX_Y; i++) {
			for (int j = 0; j < MAX_X; j++) {
				map[i][j] = '-'; // 2차원 배열 전체에 '-' 모양을 넣어줌.
			}
		}
		
//		Bear와 Fish의 초기값을 넣어줌
		m[0] = new Bear(0, 0, 1);
		m[1] = new Fish(5, 5, 2);
	}
	
	public void run() {
		System.out.println("** Bear의 Fish 먹기 게임을 시작합니다.**");
	
		update(); // 맵 위에 Bear와 Fish의 위치를 그려줌
		draw();
		
		while(!doseEnd()) {
			clear(); // 처음에 클리어 해서 한 번 다 지워주고,
			
//			위에서 m에 Fish와 Bear 넣어줌
			for (int i = 0; i < m.length; i++) {
				m[i].move(); // Bear, Fish의 위치 이동
			}
			
			update(); // 위치 이동하고 다시 업데이트하고
			draw(); // 다시 화면에 그려주고
		}
		
		System.out.println("Bear Wins!!");
		
	}
	
//	Bear와 Fish를 차례대로 그려서 만약 겹칠 경우 먼저 그려진 것을 덮어씌우기 위한 것
	private void update() {
//		카운트 부분에서 i--; 인 이유는 Bear과 Fish가 저장되어 있는 배열 m의 저장 차례가 Bear가 먼저이고, Fish 가 나중이기 때문
//		Bear와 Fish가 같은 위치에 있을 경우 Fish가 먼저 그려지고 나중에 Bear가 그려지는 형태가 되어야 하기 때문
//		-- 해서 뒤에서부터 돌린 것.. 그래서 for문이 뒤에서부터 앞으로 돈다...
//		이해 해보기..
		for (int i = m.length - 1; i >= 0; i--) {
			map[m[i].getY()][m[i].getX()] = m[i].getShape();
		}
	}
	
//	Bear와 Fish가 이전에 있던 위치를 원래 맵 모양으로 다시 변경
	private void clear() {
		for (int i = 0; i < m.length; i++) {
			map[m[i].getY()][m[i].getX()] = '-';
		}
	}
	
//	맵 그리기 처음에는 맵이 비어져있는데 draw를 해야지만 맵 화면에 그려진다. 위에서는 그 위치에 -나 B나 @를 그 위치에 저장만 했었을 뿐이다.
	private void draw() {
		System.out.println();
		
		for (int i = 0; i <MAX_Y; i++) {
			for (int j = 0; j < MAX_X; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
//	Bear와 Fish가 같은 위치에 있는지 확인
//	배열 m은 다형성을 통해서 Bear와 Fish를 저장하고 있음
//	m[0] : Bear 저장
//	m[1] : Fish 저장
	private boolean doseEnd() {
//		Bear를 기준으로 해서 Fish를 매개변수로 사용
		if (m[0].collide(m[1])) {
			return true;
		}
		
		return false;
	}
	
}
























