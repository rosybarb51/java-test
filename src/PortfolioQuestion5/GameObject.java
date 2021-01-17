package PortfolioQuestion5;

public abstract class GameObject {
	protected int distance; // 한 번 이동 거리
	protected int x; //Bear와 Fish의 현재 위치
	protected int y; // 화면 맵 상의 거리
	
//	이 클래스를 상속받아서 사용할 수 있도록 설정
//	초기 위치와 이동거리 설정
	public GameObject(int startX, int startY, int distance) {
		this.x = startX;
		this.y = startY;
		this.distance = distance;
	}
	
//	위에 보면 protected로 x 랑 y가 설정 되어있어서, 외부에서 사용 못 할수도 있으니까 아래의 설정을 둠
//	현재 x의 위치 좌표를 가져옴
	public int getX() {
		return x;
	}
	
//	현재 y의 위치 좌표를 가져옴
	public int getY() {
		return y;
	}
	
//	Bear와 Fish가 충돌하는지 확인하는 메서드
//	충돌 시 true, 아니면 false 출력
//	Bear를 기준으로 매개변수를 Fish로 받음
//	이 클래스를 상속받으면 다형성으로 사용할 수 있다. 부모 타입의 변수를 넣을 수 있으니까, 만약에 bear가 상속받아서 사용하면 b.collide(); 에서 괄호 안에 자식이 부모처럼 할 수 있는데, 괄호 안에 Fish를 넣으면 아래의 this.x는 bear의 x위치고, p.getX()는 Fish의 x위치가 된다. .. 좀 더 확실히 이해해 보자 .
	public boolean collide(GameObject p) {
//		&& 둘 다 true 가 되어야 함
//		this는 Bear를 의미, 매개변수 p는 Fish를 의미
		if (this.x == p.getX() && this.y == p.getY()) {
			return true;
		}
		else {
			return false;
		}
	}
	
//	이동한 후의 새로운 위치로 x, y 변경
	protected abstract void move();
//	객체의 모양을 나타내는 문자 리턴
	protected abstract char getShape();
}


























