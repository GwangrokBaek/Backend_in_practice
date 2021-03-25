import team1.Circle; // 패키지를 하나만 사용하는 경우, import 를 통해 클래스 사용 시 패키지명을 안적어도 사용할 수 있게
// 할 수 있다.

public class B_ImportCircle {

	public static void main(String[] args) {
		Circle c1 = new Circle();
		c1.setRad(3.5);
		System.out.println("반지름 3.5 원 넓이: " + c1.getArea());
		
		Circle c2 = new Circle();
		c2.setRad(5.5);
		System.out.println("반지름 5.5 원 넓이: " + c2.getArea());
	}
}
