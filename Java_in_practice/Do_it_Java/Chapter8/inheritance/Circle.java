package inheritance;

public class Circle {
	// 상속의 기능 중 하나는 코드의 재사용이 있다.
	// 이때 자바에서 코드의 재사용을 지원하는 객체 지향 프로그래밍 개념에는 상속과 합성이 있는데,
	// 상속은 두 클래스의 관계가 일반적인 개념 - 구체적인 개념일때 사용하는 것으로
	// 만약 좌표 평면 x, y의 정보를 가지는 Point 클래스의 정보를 Circle 클래스에서 쓰고싶다 하더라도
	// Point와 Circle은 일반 - 구체적 관계가 아니기 때문에 상속을 사용하지 않는다. 이때 Point의 정보를 사용하고 싶은 경우에는
	// Point 클래스를 Circle 클래스에서 Point 클래스의 인스턴스를 생성해서 사용하면 된다. 이를 합성이라 한다.
	// 여기서 합성을 사용한 Point 클래스와 Circle 클래스 간의 관계는 일반 - 구체적 관계가 아닌 has - a 관계라고 한다.
	// 즉, 재사용을 한다고 해서 무조건 상속은 아니다. 상속은 클래스 간의 관계가 일반 - 구체적 관계여야 한다.
	
	// private int x;
	// private int y;
	
	Point point;
	
	private int radius;
	
	public Circle() {
		point = new Point();
	}
}
