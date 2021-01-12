package PortfolioQuestion4;

public class StringStack implements PortfolioQuestion4.Stack {
//	자바에서는 스택 자료구조가 존재하지 않음
//	배열을 가지고 스택 자료구조를 만들어서 사용해야 함
//	스택 자료구조를 배열 가지고 만들어서 사용할 수 있음

	private String[] arrStack; // 스택을 구현할 배열
	private int top; // 데이터가 저장될 위치
	
	public StringStack(int capacity) {
		arrStack = new String[capacity];
		top = -1; // top을 출력 시 -1이면 스택이 비어있음
	}
	
//	스택에 저장된 데이터의 갯수
	@Override
	public int length() {
		return top + 1; // 맨 처음 초기 값을 -1을 줬으니까 하나도 없으면 0개라고 출력해줘야해서 +1을 해줬다. 
	}

//	스택에 저장할 수 있는 데이터의 갯수
	@Override
	public int capacity() {
		return arrStack.length;
	}

//	스택에 저장된 데이터를 출력
	@Override
	public String pop() {
		if (top == -1) {
			return null;
		}
		
		String item = arrStack[top];
		top--;
		return item;
	}

//	스택에 데이터를 저장
	@Override
	public boolean push(String value) {
//		배열크기 -1 = 배열의 마지막 인덱스
//		top이랑 마지막이 같다는 것은 꽉 찼다는 뜻. 그래서 false 출력함
		if (top == arrStack.length -1) {
			return false;
		}
		else {
			top++; 
			arrStack[top] = value;
			return true;
		}
	}

}













