// 내부 클래스
// 종류					구현 위치									사용할 수 있는 외부 클래스 변수			생성 방법
// 인스턴스 내부 클래스		외부 클래스의 멤버 변수와 동일					외부 인스턴스 변수, 외부 전역 변수		외부 클래스를 먼저 만든 후 내부 클래스 생성
// 정적 내부 클래스			외부 클래스의 멤버 변수와 동일					외부 전역 변수						외부 클래스와 무관하게 생성
// 지역 내부 클래스 		메서드 내부에 구현							외부 인스턴스 변수, 외부 전역 변수		메서드를 호출할 때 생성
// 익명 내부 클래스			메서드 내부에 구현, 변수에 대입하여 직접 구현		외부 인스턴스 변수, 외부 전역 변수		메서드를 호출할 때 생성되거나, 인터페이스 타입 변수에
//																								대입할 때 new 예약어를 사용하여 생성
//
// 보통 익명 내부 클래스를 많이 사용하는데, 안드로이드 프로그래밍시 버튼을 누르거나, 화면을 터치하는 등 위젯의 이벤트를 처리할 때 사용되는 이벤트 핸들러를 익명 내부 클래스로 구현한다.

package innerclass;

class OutClass { // 외부 클래스
	
	private int num = 10;
	private static int sNum = 20;
	private InClass inClass; // 인스턴스 내부 클래스의 타입으로 변수 선언 가능. 이때 private으로 선언 시, 외부 클래스 내에서만 사용 및 생성 가능.
	// InClass inClass; 보통 내부 클래스는 의미상 외부 클래스의 내부에서만 접근하고 사용하므로 다른 곳에서 접근하지 못하도록 private 으로 막아둔다.
	
	public OutClass() {
		inClass = new InClass(); // 인스턴스 내부 클래스의 경우에는 보통 외부 클래스가 생성될 때 외부 클래스의 생성자 안에서 내부 클래스를 생성하는 방식으로 생성되곤 한다.
		// 인스턴스 내부 클래스 뿐만 아니라 외부의 클래스에서 참조 자료형으로 가져다 쓰는 경우 (ex, ArrayList 등) 에도 보통 생성자 안에서 주로 생성하곤 한다.
	}
	
	private class InClass { // 인스턴스 내부 클래스. (멤버 변수와 동일한 위치에 선언되어 있다.) private 을 안붙여도 되지만, 보통 내부 클래스의 경우 의미상
		// 외부 클래스의 내부에서만 접근하고 사용할 수 있다는 의미를 가지기에 private 키워드를 붙여 다른 곳에서 접근하지 못하게끔 한다.
		int inNum = 200;
		// static int sInNum = 100; // static 변수나 메서드는 인스턴스 생성과 상관없이 사용되고 호출될 수 있는데 인스턴스 내부 클래스의 경우 외부 클래스에 의해 생성되어야
		// 사용가능하므로 static 변수나 메서드는 인스턴스 내부 클래스에서 선언이 불가능하다.
		
		/*
		static void sTest() {
			
		}
		*/
		
		void inTest() {
			System.out.println(num); // 인스턴스 내부 클래스는 외부 클래스의 인스턴스 및 정적, 전역 변수를 사용할 수 있다.
			System.out.println(sNum);
		}
	}
	
	public void usingInTest() { // 내부 클래스의 메서드는 외부에서 접근하지 못하므로 외부 클래스에서 public 메서드를 따로 선언하여 내부 클래스의 메서드를 호출해 사용한다.
		inClass.inTest();
	}
	
	static class InStaticClass { // 정적 내부 클래스. 인스턴스 내부 클래스처럼 외부 클래스의 생성자에서 인스턴스 생성이 가능하지만, 외부 클래스와 무관하게 인스턴스 생성 없이
		// 사용 가능하다.
		
		int iNum = 100;
		static int sInNum = 200;
		
		void inTest() {
			// num += 10; 정적 내부 클래스는 외부 클래스의 생성과 무관하게 사용 가능하므로, 외부 클래스의 멤버 변수가 생성되지 않았는데 해당 변수를 사용하는 문제가 발생할 수 있다.
			// 따라서 외부 인스턴스 변수는 사용하지 못하고, 외부 전역 변수만 사용 가능하다.
			sNum += 10; // 외부 정적 변수는 사용 가능.
			System.out.println(sNum);
			System.out.println(iNum);
			System.out.println(sInNum);
		}
		
		static void sTest() {
			System.out.println(sNum);
			// System.out.println(iNum); 정적 메서드는 클래스의 생성과 상관없이 호출될 수 있는데, 여기서 iNum은 정적 클래스의 일반 멤버 변수이므로 정적 메서드에서
			// 사용 불가능하다.
			System.out.println(sInNum);
		}
	}
}

public class InnerTest {

	public static void main(String[] args) {
		OutClass outClass = new OutClass();
		
		/* 인스턴스 내부 클래스가 private 이 아닌 경우에는 이러한 식으로 직접 인스턴스 내부 클래스에 접근하여 내부 클래스의 메서드를 호출하거나, 생성자를 호출하여 내부 클래스의
		 * 인스턴스를 생성할 수 있지만, 의미상 이렇게 사용하지 않는다.

		outClass.inClass.inTest();
		
		OutClass.InClass inClass = outClass.new InClass(); // 인스턴스 내부 클래스가 private이 아닌 경우, 이러한 방식으로 인스턴스 내부 클래스를 생성할 수 있다.
		inClass.inTest();
		*/
		outClass.usingInTest();
		
		OutClass.InStaticClass sInClass = new OutClass.InStaticClass(); // 정적 내부 클래스는 외부 클래스의 생성과 무관하게 바로 사용가능하다.
		sInClass.inTest();
		OutClass.InStaticClass.sTest(); // sTest() 는 정적 메서드이므로 클래스의 생성과 무관하게 바로 사용가능하다.
	}

}
