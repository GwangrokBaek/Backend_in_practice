// 제네릭 메서드 구현하기
// 사각형의 너비를 구하는 메서드
// 두 점의 위치가 여러 자료형으로 사용되는 경우이다.

package genericsex;

public class GenericMethod {
	public static <T, V> double makeRectangle(Point<T, V> p1, Point<T, V> p2) { // 제네릭 메서드. (제네릭 클래스가 아니더라도 제네릭 메서드를 구현할 수 있다.)
		// 이때 T와 V는 지역 변수와 비슷한 성격을 가지며, 여기에 쓰인 T와 V는 메서드 내에서만 유효하며 메서드 외부의 T 또는 V 와 겹치지 않는다. (즉, 지역 변수처럼 생성된다고 생각.)
		// 여기서 제네릭 메서드로 작성된 makeRectangle() 은 정수형 또는 실수형 등 여러 타입의 데이터를 인자로 받을 수 있기 위해 제네릭 메서드로 작성한 것이다.
		
		double left = ((Number)p1.getX()).doubleValue();
		double right = ((Number)p2.getX()).doubleValue();
		double top = ((Number)p1.getY()).doubleValue();
		double bottom = ((Number)p2.getY()).doubleValue();
		
		double width = right - left;
		double height = bottom - top;
		
		return width * height;
	}
}
