// 제네릭 메서드 활용하기
// 메서드의 매개변수를 자료형 매개변수로 사용하는 경우이다.
// 자료형 매개변수가 하나 이상일 수 있다.

// 제네릭 메서드의 일반 형식
// public <자료형 매개변수> 반환형 메서드 이름(자료형 매개변수) {}

package genericsex;

public class Point <T, V> { // 자료형의 매개변수가 2개일 수도 있다.
	T x;
	V y;
	
	Point(T x, V y) {
		this.x = x;
		this.y = y;
	}
	
	public T getX() {
		return x;
	}
	
	public V getY() {
		return y;
	}
}
