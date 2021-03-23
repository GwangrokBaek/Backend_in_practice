// 추상 클래스와 템플릿 메서드
// 템플릿 메서드 : 추상 메서드나 구현된 메서드를 활용하여 전체 기능의 흐름 (시나리오) 을 정의하는 메서드이다. 이때 final로 선언하면 하위 클래스에서
// 재정의할 수 없다.
// 프레임 워크에서 많이 사용되는 설계 패턴이다.
// 추상 클래스로 선언된 상위 클래스에서 템플릿 메서드를 활용하여 전체적인 흐름을 정의하고 하위 클래스에서 다르게 구현되어야하는 부분은 추상 메서드로
// 선언해서 하위 클래스가 구현하도록 한다.

package template;

public abstract class Car {
	public abstract void drive(); // 차종에 따라 운행 방법 및 멈추는 방법이 다를 것이므로 이를 하위 클래스에서 구현하기 위해 추상 메서드로 선언.
	public abstract void stop();
	
	public abstract void wiper();
	public void washCar() {} // {} 부분을 통해 구현을 해주었으므로 추상 클래스는 아니다. 따라서 하위 클래스에서 무조건 오버라이드 해줄필요는 없으며,
	// 필요에 따라 재정의해서 사용하면 됨. 이를 훅 메서드라고도 부른다. 여기서는 기본 시나리오에는 washCar() 메서드를 넣어주고, 이를 AICar 클래스에서만
	// 재정의 해줌으로써 ManualCar에서는 동작되지 않고, AICar에서만 해당 메서드의 재정의된 구현부가 동작된다.
	
	public void startCar() {
		System.out.println("시동을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("시동을 끕니다.");
	}
	
	public final void run() {
		// 차가 주행하는 전체적인 시나리오는 항상 똑같을 것이다. 따라서 전체적인 시나리오를 정의하되 각각 구현해줘야하는 부분은 추상 메서드로 선언해주어
		// 각각의 하위 클래스에서 전체적으로는 동일하지만 세부적인 내용은 다른 시나리오를 수행하게끔 한다.
		// 이때 전체적인 시나리오는 변경되어서는 안되므로 이를 위해 final 키워드를 붙여준다. (final 메서드는 오버라이드 불가능.)
		// 이렇게 전체적인 시나리오를 기술해놓고, 시나리오를 변경하지 못하게끔 final 메서드로 구현한 뒤, 변경되어야할 세부적인 내용은 추상 메서드로
		// 제공하는 것을 템플릿 메서드라고 한다. 보통 프레임워크에서 템플릿 메서드를 제공하여 기본적인 틀 위에서 상속을 통해 세부적인 내용을 변경하게끔 한다.
		
		startCar();
		drive();
		wiper();
		stop();
		washCar();
		turnOff();
	}
	// final 예약어
	// final 변수는 값이 변경될 수 없는 상수이다.
	// ex) public static final double PI = 3.14;
	// final 변수는 오직 한 번만 값을 할당할 수 있다.
	// final 메서드는 하위 클래스에서 재정의 (overriding) 할 수 없다.
	// final 클래스는 더 이상 상속되지 않는다.
	// ex) java의 String 클래스.
	
	// 여러 자바 파일에서 공유하는 상수 값 정의하기
	// 프로젝트 구현 시 여러 파일에서 공유해야 하는 상수 값은 하나의 파일에 선언하여 사용하면 편리하다.
	
	/*
	public class Define {
		public static final int MIN = 1;
		public static final int MAX = 99999;
		public static final int ENG = 1001;
		public static final int MATH = 2001;
		public static final double PI = 3.14;
		public static final String GOOD_MORNING = "Good Morning!";
	}
	
	public class UsingDefine {
		public static void main(String[] args) {
			System.out.println(Define.GOOD_MORNING); // static으로 선언했으므로 인스턴스를 생성하지 않고, 클래스 이름으로 창조 가능.
			System.out.println("최솟값은 " + Define.MIN + "입니다.");
			System.out.println("최댓값은 " + Define.MAX + "입니다.");
			System.out.println("수학 과목 코드 값은 " + Define.MATH + "입니다.");
			System.out.println("영어 과목 코드 값은 " + Define.ENG + "입니다.");
		}
	}
	*/
}
