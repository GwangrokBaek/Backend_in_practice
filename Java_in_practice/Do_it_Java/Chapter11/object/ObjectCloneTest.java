// clone() 메서드
// 객체의 원본을 복제하는데 사용하는 메서드이다.
// 원본을 유지해 놓고 복사본을 사용할때 이용한다.
// 기본 틀 (prototype) 을 두고 복잡한 생성과정을 반복하지 않고 복제한다.
// clone() 메서드를 사용하면 객체의 정보 (멤버변수 값) 가 같은 인스턴스가 또 생성되는 것이므로 객체 지향 프로그래밍의
// 정보은닉, 객체 보호의 관점에서 위배될 수 있다.
// 객체의 clone() 메서드 사용을 허용한다는 의미로 Cloneable 인터페이스를 명시해 줘야한다.

package object;

class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "x=" + x + "," + "y=" + y;
	}
}

class Circle implements Cloneable {
	// implements Cloneable 을 명시해주지 않으면 아래에서 circle 객체의 clone이 불가능하다.
	
	Point point;
	private int radius;
	
	public Circle(int x, int y, int radius) {
		point = new Point(x, y);
		this.radius = radius;
	}
	
	public String toString() {
		return "원점은 " + this.point + "이고, 반지름은 " + radius + "입니다";
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class ObjectCloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		// clone이 허용되지 않는데 clone을 수행할때 발생하는 에러를 throw 처리.
		
		Circle circle = new Circle(10, 20, 5);
		Circle cloneCircle = (Circle)circle.clone();
		Circle copyCircle = circle;
		
		System.out.println(System.identityHashCode(circle));
		System.out.println(System.identityHashCode(cloneCircle)); // clone 메서드를 사용하였으므로 새로운 인스턴스가
		// 생성되어 서로 다른 힙 메모리 주소를 반환한다.
		System.out.println(System.identityHashCode(copyCircle)); // 얕은 복사이므로 동일한 힙 메모리 주소를 반환한다.
		
		System.out.println(circle);
		System.out.println(cloneCircle);
	}

}
