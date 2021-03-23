package genericsex;

public class GenericMethodTest {

	public static void main(String[] args) {
		Point<Integer, Double> p1 = new Point<Integer, Double>(0, 0.0);
		Point<Integer, Double> p2 = new Point<>(10, 10.0);
		
		double rect = GenericMethod.<Integer, Double>makeRectangle(p1, p2); // 제네릭 메서드를 사용할때에는 메서드 이름 앞에 자료형 매개변수의 타입을
		// 명시해주어야 하며, 인자 값이 자료형 매개변수의 타입과 일치해야 한다.
		System.out.println("두 점으로 만들어진 사각형의 넓이는 " + rect + "입니다.");
	}
}
